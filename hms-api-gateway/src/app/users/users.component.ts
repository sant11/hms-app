/*
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];
  
  
  constructor(private userService: UserService ) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers().subscribe(users => this.users = users);
  }
  
  delete(user: User): void {
    this.users = this.users.filter(u => u !== user);
    this.userService.deleteUser(user).subscribe();
  }
  
}
*/
import {Component, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { User } from '../user';
import { NavLink } from '../navlink';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { AdminTabLinks } from '../admin-tab-links';

/**
 * @title Data table with sorting, pagination, and filtering.
 */
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent {

  displayedColumns = ['id', 'login', 'firstName', 'lastName', 'email', 'edit', 'delete'];

  dataSource: MatTableDataSource<User>;

  users: User[];
  activeLinkIndex: number = 0;

  id: number = 1;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private userService: UserService,
              private router: Router ) {

    this.users = [];
    
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngOnInit() {
    this.getUsers();


    // this.router.events.subscribe((res) => {      
    // this.activeLinkIndex = AdminTabLinks.NAVLINKS.indexOf(AdminTabLinks.NAVLINKS.find(tab => tab.path === '.' + this.router.url));

      // console.log('activeLinkIndex: ' + this.activeLinkIndex);
      // console.log('res: ' + res);
    // });

  }

  getUsers(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
      this.dataSource = new MatTableDataSource(users);
    });
  }
  
  delete(user: User): void {
    this.users = this.users.filter(u => u !== user);
    this.userService.deleteUser(user).subscribe();
  }

  /**
   * Set the paginator and sort after the view init since this component will
   * be able to query its view for the initialized paginator and sort.
   */
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }



}







