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
  quiz: Quiz;

  constructor(
    private route: ActivatedRoute,
    private quizService: QuizService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getQuiz();
  }
  getQuiz(): void {
    let id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.quizService.getQuiz(id)
      .subscribe(quiz => this.quiz = quiz);
  }

  goBack(): void {
    this.location.back();
  }


}
