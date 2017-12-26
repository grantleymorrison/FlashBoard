import { Component } from '@angular/core';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        './navbar.component.css'
    ]
})
export class NavbarComponent{
    // Setting state to true or false will generate the appropriate selections
    public loginData; 

    public loginChange(event){
        console.log("helo");
        this.loginData = event;
    }

    public logOutAccount(){
        this.authService.logout();
        this.loginData.loggedIn = false;
        this.loginData.profileUrl = "profile/*";
        this.loginData.userRole = 0;
        this.login.emit(this.loginData);

        this.authData.userRole = 0;
        this.authData.token = "";
        this.router.navigate(['home']);
    }

}
