import { Component, OnInit, DoCheck } from '@angular/core';
import { Http } from '@angular/http';
import { Location } from '@angular/common';
import { StudyGuideService } from '../../services/studyGuide/study-guide.service';
import { CommentService } from '../../services/comment/comment.service';
import { AuthenticationService } from '../../services/authentication/authentication.service';
import { ActivatedRoute } from '@angular/router';
import { Comment } from '../../model/comment';

@Component({
  selector: 'app-studyguide',
  templateUrl: './studyguide.component.html',
  styleUrls: ['./studyguide.component.css']
})
export class StudyGuideComponent implements OnInit, DoCheck {
  public guide;
  public guideComment: Comment = new Comment();

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private studyGuideService: StudyGuideService,
    private CommentService: CommentService,
    private authService: AuthenticationService
  ) { }

  ngOnInit() {
    this.getGuide();
    console.log(this.guide);
    this.getComments();
  }

  ngDoCheck(){
    
  }

  back() {
    this.location.back();

  }
  getGuide():void {
    let id = +this.route.snapshot.paramMap.get('id');
    this.studyGuideService.getGuide(id)
    .subscribe(guide => this.guide = guide);
  }

  getComments(): void{
    let id = +this.route.snapshot.paramMap.get('id');
    this.CommentService.getStudyGuideComments(id).subscribe(
      comments => {
        this.guide.comments = comments
      },
      err => { console.log(err) }
    );
  }

  submitComment(){
    if(localStorage.getItem('currentUser')){
      let id = +this.route.snapshot.paramMap.get('id');
      this.guideComment.username = this.authService.getAuthor();
      this.CommentService.addStudyGuideComment(id, this.guideComment);
      this.guideComment.content = ' ';
    }
  }
}
