import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: "app-profile",
    templateUrl: "profile.component.html",
    styleUrls: [
        './profile.component.css'
    ]
})
export class ProfileComponent implements OnInit{

  public profile = {
    username: "",
    fname: "",
    lname: "",
    email: "",
    favColor: "",
    avgScore: 0,
    role: 0
  };

  public url;
  public roleName: string = "User";

  constructor(private http: HttpClient, private route: ActivatedRoute){
    this.url = 'http://localhost:3000/flashboard/profile/' + route.snapshot.url[1].path;
  }

  ngOnInit(){
    this.getProfile();
  }

  public styleObject = {
    "background-color": 'black'
  }

  public roleObject = {
    "background-color": 'black'
  }



  private getProfile(){
    this.http.get(this.url).subscribe(
      data => {
        this.profile.username = data["username"];
        this.profile.fname = data["fname"];
        this.profile.lname = data["lname"];
        this.profile.email = data["email"];
        this.profile.favColor = data["favColor"];
        this.profile.avgScore = data["avgScore"];
        this.profile.role = data["role"];

        this.populateBages();
      },
      err => {
        console.log(err);
      }
    )
  }

  private populateBages(){

    if(this.profile.role === 2){
      this.roleObject["background-color"] = 'blue';
      this.roleName = "Admin";
    }
    else if(this.profile.role === 1){
      this.roleObject["background-color"] = 'red';
      this.roleName = "Writer";
    }

    if(this.profile.avgScore >= 70){
        this.styleObject["background-color"] = 'gold';
    }
    else if(this.profile.avgScore >= 50){
      this.styleObject["background-color"] = 'silver';
    }
    else if(this.profile.avgScore >= 30){
      this.styleObject["background-color"] = "#ffa64d";
    }
  }
}
