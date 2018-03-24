export class NavLink {

  constructor (path: string, desc: string, active: boolean) {
    this.path = path;
    this.desc = desc;
    this.active = active;    
  }
  path: string;
  desc: string;
  active: boolean;
}