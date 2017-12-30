import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-post-guide',
  templateUrl: './post-guide.component.html',
  styleUrls: ['./post-guide.component.css']
})
export class PostGuideComponent implements OnInit {
  public textareaParsed;
  public guideTitle;
  public guideBody;
  public guideImgUrl;
  public author;
  public url = 'http://localhost:3000/flashboard/guide/create';

  constructor(
    private location: Location,
    private http: HttpClient) { }

  ngOnInit() {
  }

  parseTextArea() {
    this.textareaParsed = this.guideBody.split("\n");
  }

  submitGuide() {
    this.getAuthor();
    this.http.post(this.url, {
      "title": this.guideTitle,
      "body" : this.textareaParsed,
      "imgUrl": this.guideImgUrl,
      "author": this.author
    }).subscribe(
      res => {
        alert("success");
        this.location.back();
      },
      err => {
        alert("not so success");
        this.location.back();
        console.log("error has occured")
      }

    );
  }

  getAuthor(){
    let currentUser = JSON.parse(localStorage.getItem("currentUser"))
    this.author = this.parseJwt(currentUser.token.toString()).sub;
  }

  back() {
    this.location.back();
  }

  parseJwt(token){
    let base64Url = token.split('.')[1];
    let base64 =  base64Url.replace('-', '+').replace('_', '/');
    return JSON.parse(window.atob(base64));
  }

}
