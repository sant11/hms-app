import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { User } from '../user';
import { UserService } from '../user.service';
import { NavLink } from '../navlink';
import { AdminTabLinks } from '../admin-tab-links';
// import { NAVLINKS } from '../admin-tab-links';
import {FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';



@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  @Input() user: User;
  
  // email: FormControl;
  activeLinkIndex: number = -1;
  navLinks: NavLink[] = AdminTabLinks.NAVLINKS;

  
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private location: Location,
    private router: Router
  ) { }
  
  ngOnInit() {
    this.user = new User();

    // this.email = new FormControl('', [Validators.required, Validators.email]);

    this.getUser();

    this.router.events.subscribe((res) => {
      this.activeLinkIndex = AdminTabLinks.NAVLINKS.indexOf(AdminTabLinks.NAVLINKS.find(tab => tab.path === '.' + this.router.url));
    });
  }

  // getErrorMessage() {
  //   return this.email.hasError('required') ? 'You must enter a value' :
  //       this.email.hasError('email') ? 'Not a valid email' :
  //           '';
  // }
  
  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');

    if(id) {
      this.userService.getUser(id)
        .subscribe(user => this.user = user);
    } else {
      this.user = new User();
    }
  }

  goBack(): void {
    this.location.back();
  }
  
  save(): void {
    if(this.user.id) {
      this.userService.updateUser(this.user).subscribe(() => this.goBack());
    } else {
      this.userService.addUser(this.user).subscribe(() => this.goBack());
    }
  }
  
}
