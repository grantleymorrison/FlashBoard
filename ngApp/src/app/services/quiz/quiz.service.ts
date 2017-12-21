import { Injectable } from '@angular/core';
import { MOCK_QUIZS } from '../../data/mock/quizs';
import { Quiz } from '../../model/quiz';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

@Injectable()
export class QuizService {

  constructor() { }

  getQuizs(): Observable<Quiz[]> {
    return of(MOCK_QUIZS);
  }
  getQuizsByTopic(topic:string): Observable<Quiz[]>{
    return of(MOCK_QUIZS.filter(quiz => quiz.topic === topic));
  }

}
