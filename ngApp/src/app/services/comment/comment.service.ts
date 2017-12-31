import { Injectable } from '@angular/core';
import { Comment } from '../../model/comment';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentService{
  public guideCommentUrl = 'http://localhost:3000/flashboard/comment/guide';

  constructor(private http: HttpClient){

  }

  getStudyGuideComments(id: number): Observable<Comment[]>{
    return this.http.get<Comment[]>(this.guideCommentUrl + "/" + id);
  }
}
