import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: [
        './signup.component.css'
    ]

})
export class SignUpComponent {
    public fname;
    public lname;
    public username;
    public password;
    public rePassword;
    public email;
    public favColor;
    public feedbackMsg = "";
    public msgStyle;
    public url = 'http://localhost:3000/flashboard/registration';

    private successStyle = {
        color:'green'
    }

    private errorStyle = {
        color:'red'
    }

    constructor(
        private http: HttpClient,
        private router: Router
    ) {
    }

    public registerAccount() {
       this.http.post(this.url, {
            "fname": this.fname,
            "lname": this.lname,
            "username": this.username,
            "password": this.password,
            "rePassword": this.rePassword,
            "email": this.email,
            "favColor":this.favColor
        }).subscribe(
            pass => {
                this.msgStyle = this.successStyle;
                this.feedbackMsg = "Success";
                this.router.navigate(['home']);
            },
            fail => {
                this.msgStyle = this.errorStyle;
                console.log(fail);
                if(fail.status === 500){
                  this.feedbackMsg = "Server Error";
                }
                else{
                  this.feedbackMsg = "Invalid Username";
                }
            });
    }

    public validateRegistration():boolean{
        var emailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        this.password = this.password.trim();
        this.username = this.username.trim();

        if(this.password === undefined || this.username === undefined ||
          this.password.length === 0 || this.username.length === 0){

          this.msgStyle = this.errorStyle;
          this.feedbackMsg = "Empty Inputs";
          return false;
        }

        if(this.password.length < 8){
          this.msgStyle = this.errorStyle;
          this.feedbackMsg = "Password needs at least 8 characters";
          return false;
        }

        if(this.password != this.rePassword){
            this.msgStyle = this.errorStyle;
            this.feedbackMsg = "Password Does Not Match";
            return false;
        }

        if(emailPattern.test(this.email) === false){
            this.msgStyle = this.errorStyle;
            this.feedbackMsg = "Invalid E-mail";
            return false;
        }
        this.registerAccount();
        return true;
    }
}
