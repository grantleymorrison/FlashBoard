import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        './navbar.component.css'
    ]
})

export class NavbarComponent{

    public username;
    public password;

    constructor(private http: HttpClient){

    }

    public loginAccount() {
      let body = {"username":this.username, "password":this.password}
       this.http.post('http://localhost:3000/flashboard/rest/login', body)
       .subscribe(
            pass => {
                console.log("Success");
            },
            fail => {
                console.log("Error occured");
            });
    }
}
