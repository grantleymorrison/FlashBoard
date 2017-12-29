import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-post-guide',
  templateUrl: './post-guide.component.html',
  styleUrls: ['./post-guide.component.css']
})
export class PostGuideComponent implements OnInit {
  public textareaParsed;
  public guideTitle;
  public guideBody;
  constructor(private location: Location) { }

  ngOnInit() {
  }
  parseTextArea() {
    this.textareaParsed = this.guideBody.split("\n");
    console.log(this.textareaParsed);
  }
  submitGuide() {

  }
  back() {

    this.location.back();
  }
}
