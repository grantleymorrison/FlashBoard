import { Component, OnInit } from '@angular/core';
import { mquestion } from '../../../model/mquestion';
import { mquiz } from '../../../model/mquiz';
import { QuizService } from '../../../services/quiz/quiz.service';

@Component({
  selector: 'app-createquiz',
  templateUrl: './createquiz.component.html',
  styleUrls: ['./createquiz.component.css']
})
export class CreatequizComponent implements OnInit {


  public questions: Array<mquestion> = new Array<mquestion>();
  public quiz: mquiz = new mquiz();
  public author: string;

  constructor(private quizService: QuizService) { }

  ngOnInit() {
  }

  public add(){
    this.questions.push(new mquestion());
  }

  public submit(){
    for(let q of this.questions){
      if(!q.question){
        q.question = "null";
      }
      if(!q.canswer){
        q.canswer = "null";
      }
      if(!q.wanswer1){
        q.wanswer1 = "null";
      }
      if(!q.wanswer2){
        q.wanswer2 = "null";
      }
      if(!q.wanswer3){
        q.wanswer3 = "null";
      }
    }
    this.quiz.creator = "jon";
    this.quiz.questions = this.questions;
    this.quizService.submitQuiz(this.quiz);
  }

  getAuthor(){
    let currentUser = JSON.parse(localStorage.getItem("currentUser"))
    this.author = this.parseJwt(currentUser.token.toString()).sub;
  }

  parseJwt(token){
    let base64Url = token.split('.')[1];
    let base64 =  base64Url.replace('-', '+').replace('_', '/');
    return JSON.parse(window.atob(base64));
  }
}
