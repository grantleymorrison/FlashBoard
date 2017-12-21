import { Component, OnInit } from "@angular/core";
import { Quiz } from "../../model/quiz";
import { QuizService } from "../../services/quiz/quiz.service";
import { of } from 'rxjs/observable/of';

@Component({
    selector: 'app-quiz',
    templateUrl: 'quiz.component.html'
})
export class QuizComponent implements OnInit{
    
    quiz: Quiz;

    
    constructor(private quizService: QuizService){

    }
    ngOnInit(){
        this.getQuiz();
    }
    getQuiz(){

    }
}