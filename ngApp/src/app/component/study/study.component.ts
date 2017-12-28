import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../model/quiz';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from '../../services/quiz/quiz.service';
import { Location } from '@angular/common';
import { of } from 'rxjs/observable/of';


@Component({
  selector: 'app-study',
  templateUrl: './study.component.html',
  styleUrls: ['./study.component.css']
})
export class StudyComponent implements OnInit {


  constructor(

  ) { }

  ngOnInit() {

  }

}
