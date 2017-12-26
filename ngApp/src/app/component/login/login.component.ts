import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    @Output()
    public login: EventEmitter<loginData> = new EventEmitter<loginData>();
    @Output('thingy')
    thingy: EventEmitter<string>  = new EventEmitter<string>();
    thing = "Piece of ";
    public username;
    public password;
    public profileUrl = "profile/*";
    public url = 'http://localhost:3000/flashboard/login';
    public authData = {
      token: "",
      userRole: 0
    };

    public loginData = {
        loggedIn: false,
        profileUrl: "profile/*",
        userRole: 0
    }

    constructor(private http: HttpClient, private router: Router, 
        private authService: AuthenticationService){

    }

    ngOnInit() {
    }

    getThingy(){
        console.log("here");
        this.thingy.emit(this.thing);
    }

    public loginAccount() {
        this.authService.login(this.username, this.password, this.url).subscribe(
            res => {
                console.log(res);
                this.authData.token = res["token"];
                this.authData.userRole = res["userRole"];

                this.loginData.userRole = res["userRole"];
                this.loginData.loggedIn = true;
                this.loginData.profileUrl = "profile/" + this.username;
                
                this.login.emit(this.loginData);
            },
            err => {
                console.log(err + "Error ocurred");
            }
        );
    }
}
