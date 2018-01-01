import { Injectable } from '@angular/core';
import { Comment } from '../../model/comment';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentService{
  public guideCommentUrl: string = 'http://localhost:3000/flashboard/comment/guide/';
  public quizCommentUrl: string = "http://localhost:3000/flashboard/comment/quiz/";

  constructor(private http: HttpClient){

  }

  getStudyGuideComments(id: number): Observable<Comment[]>{
    return this.http.get<Comment[]>(this.guideCommentUrl + id);
  }

  addStudyGuideComment(guideId: number, comment: Comment){
    return this.http.post(this.guideCommentUrl + "add/" + guideId, comment).subscribe(
      pass => { console.log(pass) },
      err => { console.log(err) }
    );
  }

  getQuizComments(id: number): Observable<Comment[]>{
    return this.http.get<Comment[]>(this.quizCommentUrl + id);
  }

  addQuizComment(quizId: number, comment: Comment){
    return this.http.post(this.quizCommentUrl + "add/" + quizId, comment).subscribe(
      pass => {console.log(pass) },
      err => { console.log(err) }
    );
  }
}
