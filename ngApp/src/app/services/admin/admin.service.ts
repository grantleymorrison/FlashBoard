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

    getNewUsers(): Observable<string[]>{

        return this.http.get<string[]>(this.url);
    }
}
