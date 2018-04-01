import { UserFormComponent } from './user-form/user-form.component';
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin/admin.component';
import { UserMainViewComponent } from './user-main-view/user-main-view.component';
import { RolesComponent } from './roles/roles.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: UserMainViewComponent },
  
  { path: 'admin', component: AdminComponent, children:[

    { path: 'users', component: UsersComponent,outlet:'firstChild'},
    { path: 'newUser', component: UserFormComponent,outlet:'firstChild'},
    { path: ':id/edituser', component: UserFormComponent,outlet:'firstChild'},
    { path: 'roles', component: RolesComponent,outlet:'firstChild'}
  ]}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { useHash: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
