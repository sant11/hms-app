import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from './user';


@Injectable()
export class UserService {

  private userUrl = 'users/1';
  private usersUrl = 'users';
  
  constructor(private http: HttpClient) { }
    
    
  getUser(): Observable<User> {
    return this.http.get<User>(this.userUrl);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }
  
  
  
}
