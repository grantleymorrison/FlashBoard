import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { StudyGuideService } from '../../services/studyGuide/study-guide.service';
import { QuizService } from '../../services/quiz/quiz.service';
import { Quiz } from '../../model/quiz';
import { StudyGuide } from '../../model/studyguides';


@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.css']
})
export class SearchComponent{
    public loading = false;
    public searchOption="Quiz";
    public quizzes:Quiz[];
    public guides: StudyGuide[]
    public searchString;
    public options = [
        {
            id: 0,
            option: "Quiz"
        },
        {
            id:1,
            option: "Study Guide"
        }
    ]

    public searchItem
    constructor(
        private http: HttpClient,
        private guideService: StudyGuideService,
        private quizService: QuizService
    ) { }

    ngOnInit(){

    }
    
    fetchData(){
        this.loading = true;
        this.search();
    }

    search(){
        if(this.searchOption == "Quiz"){
            this.quizService.getQuizs()
            .subscribe(quizzes => this.quizzes = quizzes);

        }else{
            this.guideService.getGuides()
            .subscribe(guides => this.guides = guides);
        }
    }
}