import { Component, OnInit } from "@angular/core";
import { Quiz } from "../../model/quiz";
import { QuizService } from "../../services/quiz/quiz.service";
import { of } from 'rxjs/observable/of';
import { Location } from '@angular/common';
import { ActivatedRoute } from "@angular/router";

@Component({
    selector: 'app-quiz',
    templateUrl: 'quiz.component.html',
    styleUrls: [
        'quiz.component.css'
    ]
})
export class QuizComponent implements OnInit {

    quiz: Quiz;

    constructor(
        private route: ActivatedRoute,
        private quizService: QuizService,
        private location: Location
    ) {

    }
    ngOnInit() {
        this.getQuiz();
    }
    getQuiz(): void {
        let id = +this.route.snapshot.paramMap.get('id');
        console.log(id);
        this.quizService.getQuiz(id)
            .subscribe(quiz => this.quiz = quiz);
    }
    submitComment(): void {
        
    }
    goBack(): void {
        this.location.back();
    }
}