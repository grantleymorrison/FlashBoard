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
    public email;
    public favColor;

    constructor(private http: HttpClient) {
    }
    public registerAccount() {
       this.http.post('http://jsonplaceholder.typicode.com/posts', {
            "fname": this.fname,
            "lname": this.lname,
            "username": this.username,
            "password": this.password,
            "email": this.email
        }).subscribe(
            res => {
                console.log(res);
            },
            err => {
                console.log("Error occured");
            });
    }
}