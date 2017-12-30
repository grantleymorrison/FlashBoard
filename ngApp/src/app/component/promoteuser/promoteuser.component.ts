import {Component, Input } from '@angular/core';
import { User } from '../../model/user';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-promoteuser',
    templateUrl: './promoteuser.component.html'
})
export class PromoteUserComponent{
    @Input()
    promotee: string;

    private visible = true;

    private url = 'http://localhost:3000/flashboard/admin';

    constructor(private http: HttpClient){

    }

    public promoteUser(username: string){
      this.http.put(this.url + "/user/promote", this.promotee).subscribe(
        pass => {
          console.log("promote");
          this.visible = false;
        },
        err => {
          console.log("Issue with promoting");
        }
      )
    }
}
