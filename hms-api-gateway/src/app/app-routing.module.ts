import { UserFormComponent } from './user-form/user-form.component';
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsersComponent } from './users/users.component';
import { UserMainViewComponent } from './user-main-view/user-main-view.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: UserMainViewComponent },
  { path: 'users', component: UsersComponent },
  { path: 'users/:id', component: UserFormComponent},
  { path: 'users/new', component: UserFormComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { useHash: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
