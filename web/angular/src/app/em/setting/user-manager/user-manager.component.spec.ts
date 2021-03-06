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

import { NO_ERRORS_SCHEMA } from "@angular/core";
import { ComponentFixture, TestBed, waitForAsync } from "@angular/core/testing";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatSnackBar, MatSnackBarModule } from "@angular/material/snack-bar";
import { MatSortModule } from "@angular/material/sort";
import { TranslateService } from "@ngx-translate/core";
import { TestUtils } from "../../../common/test/test-utils";
import { ModelService } from "../../../widget/services/model.service";
import { PrincipalService } from "../../../widget/services/principal-service";

import { UserManagerComponent } from "./user-manager.component";

describe("UserManagerComponent", () => {
  let component: UserManagerComponent;
  let fixture: ComponentFixture<UserManagerComponent>;
  let modelService: any;
  let principalService: any;
  let translate: any;

  beforeEach(waitForAsync(() => {
    modelService = TestUtils.createModelService();
    principalService = TestUtils.createPrincipalService();
    translate = TestUtils.createTranslateService();

    TestBed.configureTestingModule({
      providers: [
        {
          provide: ModelService,
          useValue: modelService
        },
        {
          provide: PrincipalService,
          useValue: principalService
        },
        MatSnackBar,
        {
          provide: TranslateService,
          useValue: translate
        }
      ],
      imports: [
         MatPaginatorModule,
         MatSortModule,
         MatSnackBarModule
      ],
      declarations: [
         UserManagerComponent
      ],
      schemas: [
        NO_ERRORS_SCHEMA
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
