package club.javafamily.runner.controller;

import club.javafamily.runner.annotation.Audit;
import club.javafamily.runner.annotation.AuditObject;
import club.javafamily.runner.common.MessageException;
import club.javafamily.runner.common.model.amqp.RegisterUserInfo;
import club.javafamily.runner.common.service.RedisClient;
import club.javafamily.runner.domain.Customer;
import club.javafamily.runner.enums.ActionType;
import club.javafamily.runner.enums.ResourceEnum;
import club.javafamily.runner.service.CustomerService;
import club.javafamily.runner.util.SecurityUtil;
import club.javafamily.runner.vo.EmailCustomerVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static club.javafamily.runner.util.SecurityUtil.API_VERSION;
import static club.javafamily.runner.util.SecurityUtil.REGISTERED_USER_STORE_PREFIX;

@RestController
@RequestMapping(SecurityUtil.CLIENT_API_VERSION)
public class SecurityApiController {

  @Audit(value = ResourceEnum.Customer, actionType = ActionType.Login)
  @PostMapping("/login")
  public String login(@RequestParam @AuditObject String userName,
                      @RequestParam String password,
                      @RequestParam(required = false) boolean rememberMe) {
    Subject currentUser = SecurityUtils.getSubject();

    if (!currentUser.isAuthenticated()) {
      UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

      token.setRememberMe(rememberMe);

      try {
        currentUser.login(token);
      } catch (AuthenticationException e) {
        return e.getMessage();
      }
    }

    return null;
  }

  @PostMapping("/signup")
  public void signup(@Valid @ModelAttribute EmailCustomerVO customerVO,
                     BindingResult bindingResult,
                     HttpServletRequest request)
  {
    List<ObjectError> allErrors = bindingResult.getAllErrors();
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < allErrors.size(); i++) {
      ObjectError error = allErrors.get(i);

      if(error instanceof FieldError) {
        sb.append(((FieldError) error).getField())
           .append(": ")
           .append(error.getDefaultMessage());
      }
      else {
        sb.append(error.getDefaultMessage());
      }

      if(i < allErrors.size() - 1) {
        sb.append("\n");
      }
    }

    if(StringUtils.hasText(sb)) {
      throw new MessageException(sb.toString());
    }

    String account = customerVO.getAccount();
    Customer user = customerService.getCustomerByAccount(account);

    if(user != null) {
      throw new MessageException("The account has been registered: " + account);
    }

    StringBuilder path = SecurityUtil.getBaseUrl(request);
    path.append(API_VERSION);
    path.append("/customer/verify");

    customerService.signup(customerVO, path.toString());
  }

  @Autowired
  public SecurityApiController(CustomerService customerService,
                               RedisClient<RegisterUserInfo> redisClient)
  {
    this.redisClient = redisClient;
    this.customerService = customerService;
  }

  private final CustomerService customerService;
  private final RedisClient<RegisterUserInfo> redisClient;

  private static final Logger LOGGER = LoggerFactory.getLogger(SecurityApiController.class);
}