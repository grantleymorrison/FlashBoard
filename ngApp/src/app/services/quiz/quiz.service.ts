import { Injectable } from '@angular/core';
import { MOCK_QUIZS } from '../../data/mock/quizs';
import { HttpClient } from '@angular/common/http';
import { Quiz } from '../../model/quiz';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { mquiz } from '../../model/mquiz';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class QuizService {
  public allQuizApi:string = "http://localhost:3000/flashboard/quiz/all";
  public quizApi:string = "http://localhost:3000/flashboard/quiz/"
  constructor(
    private http: HttpClient
  ) { }

  private quizUrl = 'http://localhost:3000/flashboard/quiz';

  constructor(private http: HttpClient) { }

  getQuiz(quizId: number): Observable<Quiz> {
    return this.http.get<Quiz>(this.quizApi + quizId)
  }

  getQuizs(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(this.allQuizApi);
  }
  getQuizzesRaw() :Observable<any> {
    return this.http.get<any>(this.allQuizApi);
  }

  getQuizsByTopic(topic:string): Observable<Quiz[]>{
    return this.getQuizs()
    .map(quiz => quiz.filter(quiz => quiz.topic === topic));

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
