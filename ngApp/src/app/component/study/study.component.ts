import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../model/quiz';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from '../../services/quiz/quiz.service';
import { Location } from '@angular/common';
import { of } from 'rxjs/observable/of';
import { StudyGuide } from '../../model/studyguides';
import { StudyGuideService } from '../../services/studyGuide/study-guide.service';


@Component({
  selector: 'app-study',
  templateUrl: './study.component.html',
  styleUrls: ['./study.component.css']
})
export class StudyComponent implements OnInit {
  guides: StudyGuide[];
  public signedIn: boolean;

  constructor(
    private studyGuideService: StudyGuideService
  ) { }

  ngOnInit() {
    if(localStorage.getItem("currentUser")){
      this.signedIn = true;
    }
    else{
      this.signedIn = false;
    }
    this.getGuides();
    
  }
  getGuides():void{
    this.studyGuideService.getGuides()
      .subscribe(guides => this.guides = guides)
  }

}
