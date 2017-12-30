import { Component } from '@angular/core';
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
    public loginData = {
        loggedIn: false,
        profileUrl: "profile/*",
        userRole: 0
    };

    constructor(private authService: AuthenticationService, private router: Router){

    }

    public loginChange(event){
        this.loginData = event;
        this.router.navigate(['home']);
    }

    public logOutAccount(){
        this.authService.logout();
        this.loginData.loggedIn = false;
        this.loginData.profileUrl = "profile/*";
        this.loginData.userRole = 0;

        this.router.navigate(['home']);
    }

}
