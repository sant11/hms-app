export class NavLink {

  constructor (path: string, desc: string, visible: boolean) {
    this.path = path;
    this.desc = desc;
    this.visible = visible;    
    
  }
  path: string;
  desc: string;
  visible: boolean;
  
}