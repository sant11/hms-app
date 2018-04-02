import { Component, OnInit, ViewChild } from '@angular/core';
import { RoleService } from '../role.service';
import { Router } from '@angular/router';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Role } from '../role';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent {

  displayedColumns = ['id', 'name', 'description'];

  dataSource: MatTableDataSource<Role>;

  roles: Role[];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private roleService: RoleService,
              private router: Router) { 

    this.roles = [];

    this.dataSource = new MatTableDataSource(this.roles);
  }


  ngOnInit() {
    this.getRoles();
  }

  getRoles(): void {
    this.roleService.getRoles().subscribe(roles => {
      this.roles = roles;
      this.dataSource = new MatTableDataSource(roles);
    });
  }

  delete(role: Role): void {
    this.roles = this.roles.filter(u => u !== role);
    this.roleService.deleteRole(role).subscribe;
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
