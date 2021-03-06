import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from './user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable()
export class UserService {

  private usersUrl = 'users';
  
  constructor(private http: HttpClient) { }
    
    
  getUser(id: number): Observable<User> {
    const url = `${this.usersUrl}/${id}`;
    
    return this.http.get<User>(url)
      .pipe(
        catchError(this.handleError<User>(`getUser id=${id}`))
      );
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
      .pipe(
        catchError(this.handleError('getUsers',[]))
      );
  }
  
  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user, httpOptions)
      .pipe(
        catchError(this.handleError<User>('addUser'))
      )
  }
  
  deleteUser(user: User | number): Observable<User>{
    const id = typeof user === 'number' ? user : user.id;
    const url = `${this.usersUrl}/${id}`;
    
    return this.http.delete<User>(url, httpOptions)
      .pipe(
        catchError(this.handleError<User>('deleteUser'))
      );
  }
  
  updateUser(user: User): Observable<any> {

    return this.http.put(this.usersUrl, user, httpOptions).pipe(
      tap(_ => this.log(`updated user id=${user.id}`)),
      catchError(this.handleError<any>('updatedUser'))
    );  
  }
    
  
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
//    this.messageService.add('HeroService: ' + message);
  }

  
  
  
}
