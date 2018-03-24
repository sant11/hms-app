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
//export class TableOverviewExample {
  displayedColumns = ['id', 'login', 'firstName', 'lastName', 'email', 'edit', 'delete'];
  // dataSource: MatTableDataSource<UserData>;
  dataSource: MatTableDataSource<User>;

  users: User[];
  activeLinkIndex: number = 0;
  navLinks: NavLink[] = AdminTabLinks.NAVLINKS;

  id: number = 1;
  // navLinks: NavLink[] = [new NavLink('admin/users'),
                                // new NavLink('new'),
                                // new NavLink('admin/grouproles')];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private userService: UserService,
              private router: Router ) {

    this.users = [];
    

    // routeLinks: any[];
    // // Create 100 users
    // const users: UserData[] = [];
    // for (let i = 1; i <= 100; i++) { users.push(createNewUser(i)); }

    // // Assign the data to the data source for the table to render
    // this.dataSource = new MatTableDataSource(this.users);
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngOnInit() {
    this.getUsers();


    this.router.events.subscribe((res) => {
      
    this.activeLinkIndex = AdminTabLinks.NAVLINKS.indexOf(AdminTabLinks.NAVLINKS.find(tab => tab.path === '.' + this.router.url));

      // console.log('activeLinkIndex: ' + this.activeLinkIndex);
      // console.log('res: ' + res);
    });
  // }

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

/** Builds and returns a new User. */
// function createNewUser(id: number): UserData {
//   const name =
//       NAMES[Math.round(Math.random() * (NAMES.length - 1))] + ' ' +
//       NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) + '.';

//   return {
//     id: id.toString(),
//     name: name,
//     progress: Math.round(Math.random() * 100).toString(),
//     color: COLORS[Math.round(Math.random() * (COLORS.length - 1))]
//   };
// }

/** Constants used to fill up our data base. */
// const COLORS = ['maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple',
//   'fuchsia', 'lime', 'teal', 'aqua', 'blue', 'navy', 'black', 'gray'];
// const NAMES = ['Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack',
//   'Charlotte', 'Theodore', 'Isla', 'Oliver', 'Isabella', 'Jasper',
//   'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'];

// export interface UserData {
//   id: string;
//   name: string;
//   progress: string;
//   color: string;
// }







