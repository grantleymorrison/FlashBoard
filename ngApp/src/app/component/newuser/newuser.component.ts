import {Component, Input } from '@angular/core';
import { User } from '../../model/user';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-newuser',
    templateUrl: './newuser.component.html'
})
export class NewUserComponent{
    @Input()
    newUser: string;

    private url = 'http://localhost:3000/flashboard/admin';

    constructor(private http: HttpClient){

    }

    public denyUser(){
      this.http.delete(this.url + "/newusers/deny/" + this.newUser).subscribe(
        pass => {
          console.log("deny");
        },
        err => {

        }
      )
    }

    public approveUser(){
      this.http.put(this.url + "/newusers/approve", this.newUser).subscribe(
        pass => {
          console.log("approve");
        },
        err => {

        }
      )
    }
}
