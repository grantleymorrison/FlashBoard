import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        './navbar.component.css'
    ]
})

export class NavbarComponent{
    // Setting state to true or false will generate the appropriate selections
    public loggedIn = false;
    public username;
    public password;
    public profileUrl = "profile/*";
    public authData = {
      token: "",
      userRole: 0
    };

    constructor(private http: HttpClient, private router: Router){

    }

    public loginAccount() {
      let body = {"username":this.username, "password":this.password}
       this.http.post('http://localhost:3000/flashboard/login', body)
       .subscribe(
            res => {
                console.log(res);
                this.authData.token = res["token"];
                this.authData.userRole = res["userRole"];
                this.loggedIn = true;
                this.profileUrl = "profile/" + this.username;
            },
            err => {
                console.log(err + " Error occured");
            });
    }

    public logOutAccount(){
      this.loggedIn = false;
      this.profileUrl = "profile/*";
      this.authData.userRole = 0;
      this.authData.token = "";
      this.router.navigate(['home']);
    }
}
