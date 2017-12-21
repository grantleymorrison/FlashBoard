import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Test } from '../../model/test';
import { MOCK_TESTS } from '../../data/mock/tests';

@Injectable()
export class TestService {

  constructor() { }

  getTests(): Observable<Test[]>{
    return of(MOCK_TESTS);
  }

}
