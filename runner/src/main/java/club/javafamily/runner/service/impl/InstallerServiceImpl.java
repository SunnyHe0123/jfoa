/*
 * Copyright (c) 2020, JavaFamily Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to JavaFamily Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */

package club.javafamily.runner.service.impl;

import club.javafamily.runner.annotation.Audit;
import club.javafamily.runner.annotation.AuditObject;
import club.javafamily.runner.dao.InstallerDao;
import club.javafamily.runner.domain.Installer;
import club.javafamily.commons.enums.Platform;
import club.javafamily.commons.enums.ResourceEnum;
import club.javafamily.runner.service.InstallerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("installerService")
public class InstallerServiceImpl implements InstallerService {

   @Autowired
   public InstallerServiceImpl(InstallerDao installerDao) {
      this.installerDao = installerDao;
   }

   @Audit(ResourceEnum.Upload_Installer)
   @Transactional
   @Override
   public void save(@AuditObject("getPlatform().getLabel() + '.' + getVersion()") Installer installer) {
      Installer client = this.getInstaller(installer.getPlatform(), installer.getVersion());

      if(client != null) {
         this.installerDao.delete(client);
         LOGGER.info("Installer is exist, will override: {}", installer.toString());
      }

      this.installerDao.insert(installer);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Installer> getAll() {
      return this.installerDao.getAll();
   }

   @Transactional(readOnly = true)
   public Installer getInstaller(Platform platform, String version) {
      return this.installerDao.getInstaller(platform, version);
   }

   private final InstallerDao installerDao;
   private static final Logger LOGGER = LoggerFactory.getLogger(InstallerServiceImpl.class);
}
