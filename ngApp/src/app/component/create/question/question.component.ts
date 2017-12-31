import { Component, OnInit, Input } from '@angular/core';
import { mquestion } from '../../../model/mquestion';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  @Input()
  public quizObject: mquestion;

  constructor() { }

  ngOnInit() {
  }

}
