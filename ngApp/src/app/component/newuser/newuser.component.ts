import {Component, Input } from '@angular/core';
import { User } from '../../model/user';
import { HttpClient } '@angular/common/http';

@Component({
    selector: 'app-newuser',
    templateUrl: './newuser.component.html'
})
export class NewUserComponent{
    @Input()
    newUser: string;

    private url = 'http://localhost:3000/flashboard/admin/newusers/';

    constructor(private http: HttpClient){

    }

    sayHello(){
        console.log(this.newUser);
    }

    public denyUser(){
      this.http.delete(this.url + "deny/" + this.newUser).subscribe(
        pass => {
          console.log("deny");
        },
        err => {

        }
      )
    }

    public approveUser(){
      this.http.put(this.url + "approve/" + this.newUser).subscribe(
        pass => {
          console.log("approve");
        },
        err => {
          
        }
      )
    }
}
