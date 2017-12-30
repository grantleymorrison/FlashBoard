import { Injectable } from '@angular/core';
import { User } from '../../model/user';
import { Observable } from 'rxjs/observable';
import { of } from 'rxjs/observable/of';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class AdminService{
    public newUserUrl = 'http://localhost:3000/flashboard/admin/newusers';
    private promoteesUrl = 'http://localhost:3000/flashboard/admin/promotees';
    private userUrl = 'http://localhost:3000/flashboard/admin/user';

    constructor(private http: HttpClient){

    }

    getNewUsers(): Observable<string[]>{

        return this.http.get<string[]>(this.newUserUrl);
    }

    getPromotees(): Observable<string[]>{
      return this.http.get<string[]>(this.promoteesUrl);
    }

    public blacklistUser(username: string){
      this.http.put(this.userUrl + "/blacklist", username).subscribe(
        pass => {
          console.log("blacklist");
        },
        err => {
          console.log("Issue with blacklisting");
        }
      )
    }

    public deleteUser(username: string){
      this.http.delete(this.userUrl + "/delete/" + username).subscribe(
        pass => {
          console.log("delete");
        },
        err => {
          console.log("Issues with banning");
        }
      )
    }
}
