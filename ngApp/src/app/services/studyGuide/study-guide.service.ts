import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { StudyGuide } from '../../model/studyguides';

@Injectable()
export class StudyGuideService {
  public allguideApi:string = "localhost:3000/guide/all";
  public guideApi:string;
  constructor(private http: HttpClient) { }

  getGuides(): Observable<StudyGuide[]>{
    return this.http.get<StudyGuide[]>(this.allguideApi);
  }
  getGuide(guidename:string): Observable<StudyGuide>{
    return this.http.get<StudyGuide>(this.guideApi + "/" + guidename);
  }
}
