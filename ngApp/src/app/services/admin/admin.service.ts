import { Injectable } from '@angular/core';
import { User } from '../../model/user';
import { Observable } from 'rxjs/observable';
import { of } from 'rxjs/observable/of';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class AdminService{
    public url = 'http://localhost:3000/flashboard/admin/newusers';

    constructor(private http: HttpClient){

    }

    getNewUsers(): Observable<User[]>{

        return this.http.get<User[]>(this.url);
    }
    private handleError(error:any) {
        // In a real world app, we might use a remote logging infrastructure
        // We'd also dig deeper into the error to get a better message
        let errMsg = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}