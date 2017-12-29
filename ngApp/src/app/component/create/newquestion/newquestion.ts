import { Component, Input } from '@angular/core';
import { Question } from '../../../model/question'; 

@Component ({
    selector: 'new-question',
    templateUrl: 'newquestion.html',
    styleUrls: ['newquestion.css']
})

export class NewQuestionComponent {
    @Input() index: number; 
    @Input() topic: string;
    @Input() isFromTest: boolean = false; 
    
    points:number;
    
    option1:string;
    option2:string;
    option3:string;
    option4:string;

    answerId:number = 0;
    answerString:string;

    explanation:string = ""; 

    chooseAnswer(chosen):void {
        this.answerId = chosen;
        switch(this.answerId){
            case 1: this.answerString = this.option1; break; 
            case 2: this.answerString = this.option2; break; 
            case 3: this.answerString = this.option3; break; 
            case 4: this.answerString = this.option4; break; 
        }
    }

    packageQuestion() {
        switch(this.answerId){
            case 1: this.answerString = this.option1; break; 
            case 2: this.answerString = this.option2; break; 
            case 3: this.answerString = this.option3; break; 
            case 4: this.answerString = this.option4; break; 
        }
    }
    
    
}