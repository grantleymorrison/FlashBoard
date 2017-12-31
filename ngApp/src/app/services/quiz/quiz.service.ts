import { Injectable } from '@angular/core';
import { MOCK_QUIZS } from '../../data/mock/quizs';
import { Quiz } from '../../model/quiz';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { mquiz } from '../../model/mquiz';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class QuizService {

  private quizUrl = 'http://localhost:3000/flashboard/quiz';

  constructor(private http: HttpClient) { }

  getQuiz(quizId: number): Observable<Quiz> {
    return of(MOCK_QUIZS.find(quiz => quiz.quizId === quizId))
  }

  getQuizs(): Observable<Quiz[]> {
    return of(MOCK_QUIZS);
  }
  getQuizsByTopic(topic:string): Observable<Quiz[]>{
    return of(MOCK_QUIZS.filter(quiz => quiz.topic === topic));
  }

  public submitQuiz(quiz: mquiz){
    this.http.post(this.quizUrl, quiz).subscribe(
      pass => {
        console.log(pass);
      },
      err => {
        console.log(err);
      }
    )
  }


}
