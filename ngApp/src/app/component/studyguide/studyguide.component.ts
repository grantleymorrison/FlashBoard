import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Location } from '@angular/common';
import { StudyGuideService } from '../../services/studyGuide/study-guide.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-studyguide',
  templateUrl: './studyguide.component.html',
  styleUrls: ['./studyguide.component.css']
})
export class StudyGuideComponent implements OnInit {
  public guide;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private studyGuideService: StudyGuideService
  ) { }
  ngOnInit() {
    this.getGuide();
    console.log(this.guide)
  }
  back() {
    this.location.back();
    
  }
  getGuide():void {
    let id = +this.route.snapshot.paramMap.get('id');
    this.studyGuideService.getGuide(id)
    .subscribe(guide => this.guide = guide);
  }
}
