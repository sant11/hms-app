import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { NgModule, ViewChild } from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';


import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';

import { MyAngularMaterialModule } from './my-angular.module';
import { UserService } from './user.service';
import { AppRoutingModule } from './/app-routing.module';
import { UsersComponent } from './users/users.component';
import { UserMainViewComponent } from './user-main-view/user-main-view.component';
import { UserFormComponent } from './user-form/user-form.component';
import { AdminComponent } from './admin/admin.component';
import { RolesComponent } from './roles/roles.component';
import { RoleService } from './role.service';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UsersComponent,
    UserMainViewComponent,
    UserFormComponent,
    AdminComponent,
    RolesComponent
  ],
  imports: [
    BrowserModule, 
    BrowserAnimationsModule,
    FormsModule, HttpClientModule, AppRoutingModule
    ,MyAngularMaterialModule
  ],
  providers: [ UserService, RoleService ],
  bootstrap: [AppComponent,UserComponent]
})
export class AppModule { }
