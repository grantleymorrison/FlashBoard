import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication/authentication.service';

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
    public url = 'http://localhost:3000/flashboard/login';
    public authData = {
      token: "",
      userRole: 0
    };

    constructor(private http: HttpClient, private router: Router, 
        private authService: AuthenticationService){

    }

    public loginAccount() {
        this.authService.login(this.username, this.password, this.url).subscribe(
            res => {
                console.log(res);
                this.authData.token = res["token"];
                this.authData.userRole = res["userRole"];
                this.loggedIn = true;
                this.profileUrl = "profile/" + this.username;
            },
            err => {
                console.log(err + "Error ocurred");
            }
        );
    }

    public logOutAccount(){
        this.authService.logout();
        this.loggedIn = false;
        this.profileUrl = "profile/*";
        this.authData.userRole = 0;
        this.authData.token = "";
        this.router.navigate(['home']);
    }
}
