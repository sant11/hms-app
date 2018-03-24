import { NavLink } from './navlink';

export class AdminTabLinks {

    public static NAVLINKS: NavLink[] = [
      new NavLink('users','Users', true),
      new NavLink('new','New', true)      
    ];
}