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
    avgScore: ""
  };

  public url;

  constructor(private http: HttpClient, private route: ActivatedRoute){
    this.url = 'http://localhost:3000/flashboard/profile/' + route.snapshot.url[1].path;
  }

  ngOnInit(){
    this.http.get(this.url).subscribe(
      data => {
        this.profile.username = data["username"];
        this.profile.fname = data["fname"];
        this.profile.lname = data["lname"];
        this.profile.email = data["email"];
        this.profile.favColor = data["favColor"];
        this.profile.avgScore = data["avgScore"];
      },
      err => {
        console.log(err);
      }
    )
  }
}
