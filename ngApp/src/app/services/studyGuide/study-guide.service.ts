import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { StudyGuide } from '../../model/studyguides';

@Injectable()
export class StudyGuideService {
  public allguideApi:string = "http://localhost:3000/flashboard/guide/all";
  public guideApi:string = "http://localhost:3000/flashboard/guide/";
  constructor(private http: HttpClient) { }

  getGuides(): Observable<StudyGuide[]>{
    return this.http.get<StudyGuide[]>(this.allguideApi);
  }
  getGuide(guideId:number): Observable<StudyGuide>{
    return this.http.get<StudyGuide>(this.guideApi + guideId);
  }
}
