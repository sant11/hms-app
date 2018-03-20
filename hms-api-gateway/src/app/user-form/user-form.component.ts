import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  @Input() user: User;
  
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getUser();
  }
  
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
