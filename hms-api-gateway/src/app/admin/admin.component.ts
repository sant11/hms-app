import { Component, OnInit } from '@angular/core';
import { AdminTabLinks } from '../admin-tab-links';
import { NavLink } from '../navlink';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  routeLinks:NavLink[];
  
  activeLinkIndex: number;

  constructor(private router: Router) { 
    this.routeLinks = AdminTabLinks.NAVLINKS;

    this.activeLinkIndex = -1;
  }

  ngOnInit(): void {
    this.router.events.subscribe((res) => {
        this.activeLinkIndex = this.routeLinks.indexOf(this.routeLinks.find(tab => tab.path === '.' + this.router.url));
    });
}

}
