import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Role } from './role';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RoleService {

private rolesUrl = 'roles';

  constructor(private http: HttpClient) { }

  getRole(id: number): Observable<Role> {
    const url = `${this.rolesUrl}/${id}`;

    return this.http.get<Role>(url)
      .pipe(
        catchError(this.handleError<Role>(`getRole id=${id}`))
      );
  }

  getRoles(): Observable<Role[]> {
    return this.http.get<Role[]>(this.rolesUrl)
      .pipe(
        catchError(this.handleError('getRoles',[]))
      );
  }

  addRole(role: Role): Observable<Role> {
    return this.http.post<Role>(this.rolesUrl, role, httpOptions)
      .pipe(
        catchError(this.handleError<Role>('addRole'))
      )
  }

  deleteRole(role: Role | number): Observable<Role> {
    const id = typeof role === 'number' ? role : role.id;
    const url = `${this.rolesUrl}/${id}`;

    return this.http.delete<Role>(url, httpOptions)
      .pipe(
        catchError(this.handleError<Role>('deleteRole'))
      );
  } 

  updateRole(role: Role): Observable<any> {

    return this.http.put(this.rolesUrl, role, httpOptions)
      .pipe(
        tap(_ => this.log(`updated role id=${role.id}`)),
        catchError(this.handleError<any>('updatedRole'))
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
