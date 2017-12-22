import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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

    private successStyle = {
        color:'green'
    }

    private errorStyle = {
        color:'red'
    }

    constructor(private http: HttpClient) {
    }

    public registerAccount() {
       this.http.post('http://localhost:3000/flashboard/registration', {
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
            },
            fail => {
                this.msgStyle = this.errorStyle;
                this.feedbackMsg = "Server Error";
            });
    }

    public validateRegistration():boolean{
        var emailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if(this.password === undefined || this.username === undefined){
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
