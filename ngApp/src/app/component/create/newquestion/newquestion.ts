import { Component, Input, EventEmitter } from '@angular/core';
import { Question } from '../../../model/question';

@Component({
    selector: 'new-question',
    templateUrl: 'newquestion.html',
    styleUrls: ['newquestion.css']
})

export class NewQuestionComponent {
    @Input() DEBUG: boolean = true;

    @Input() index: number;
    @Input() topic: string = "";
    @Input() isFromTest: boolean = false;

    points;

    questionText: string = "";

    option1: string = "";
    option2: string = "";
    option3: string = "";
    option4: string = "";

    answerId: number = 0;
    answerString: string;
    showCorrectAnswerSelection: boolean = false;

    questionReadyToShip: boolean = false;
    showQuestionShipStatus: boolean = false;
    questionShipStatus: string = "Not ready";

    explanation: string = "";

    // constructor(private http: HttpClient, private authServ: AuthenticationService) {
        
    // }


    chooseAnswer(choice): void {
        this.answerId = choice;
        switch (this.answerId) {
            case 1: this.answerString = this.option1; break;
            case 2: this.answerString = this.option2; break;
            case 3: this.answerString = this.option3; break;
            case 4: this.answerString = this.option4; break;
        }
        this.showCorrectAnswerSelection = true;

    }

    packageQuestion() {
        switch (this.answerId) {
            case 1: this.answerString = this.option1; break;
            case 2: this.answerString = this.option2; break;
            case 3: this.answerString = this.option3; break;
            case 4: this.answerString = this.option4; break;
        }
    }

    checkQuestionForShipping(): void {
        if (this.DEBUG) console.log("Verifying question #" + this.index);
        this.questionShipStatus = "Ready for Submission";
        this.questionReadyToShip = true;
        this.showQuestionShipStatus = true;

        if (this.DEBUG) console.log("question text = " + this.questionText);
        if (this.questionText == "") {
            this.questionReadyToShip = false;
            this.questionShipStatus = "No question text.";
            return;
        }

        if (this.DEBUG) console.log("topic = " + this.topic);
        if (this.topic == "") {
            this.questionReadyToShip = false;
            this.questionShipStatus = "No topic given for this question.";
            return;
        }

        var count = 0;
        var options = [];
        
        if (this.DEBUG) console.log("option 1: " + this.option1 + "\noption 2: " + this.option2 + "\noption 3: " + this.option3 + "\noption 4: " + this.option4)
        if (this.option1 != ""){
            count++;
            options.push(this.option1);
        }
        if (this.option2 != "") {
            count++;
            options.push(this.option2);
        }
        if (this.option3 != "") {
            count++;
            options.push(this.option3);
        }
        if (this.option4 != ""){
            count++;
            options.push(this.option4);
        }
        console.log(options); 

        if (this.DEBUG) console.log("count = " + count);
        if (count < 2) {
            console.log(count);
            this.questionReadyToShip = false;
            this.questionShipStatus = "Must have at least two answers to choose from.";
            return;
        }

        if (this.DEBUG) console.log(this.answerId);
        if (this.answerId == 0) {
            this.questionReadyToShip = false;
            this.questionShipStatus = "Select an answer to be the correct one.";
            return;
        }

        var validAnswerId = true;
        switch (this.answerId) {
            case 1: if (this.option1 == "")
                validAnswerId = false;
                break;
            case 2: if (this.option2 == "")
                validAnswerId = false;
                break;
            case 3: if (this.option3 == "")
                validAnswerId = false;
                break;
            case 4: if (this.option4 == "")
                validAnswerId = false;
                break;
        }
        if (!validAnswerId) {
            this.questionReadyToShip = false;
            this.questionShipStatus = "Answer " + this.answerId + " is invalid. Provide an answer that is not blank.";
            return;
        }

        var pointsParsed = parseInt(this.points, 10);
        if (this.DEBUG) console.log("point value = " + pointsParsed + " - type = " + typeof (pointsParsed));
        if (typeof (pointsParsed) != 'number' || !isFinite(pointsParsed)) {
            this.questionReadyToShip = false;
            this.questionShipStatus = "Provide a point value for this question.";
            return;
        }

        if (this.points == 0) {
            this.questionReadyToShip = false;
            this.questionShipStatus = "Cannot have 0 point question.";
            return;
        }

        for(let i = 0; i < options.length; i++){
            let str = options[i]; 
            for(let j = i+1; j < options.length; j++) {
                let other = options[j]; 
                if(this.DEBUG) 
                    console.log(str + " : " + other); 
                if(str == other) {
                    this.questionReadyToShip = false;
                    this.questionShipStatus = "Cannot have duplicate answers."; 
                    return; 
                }
            }
        }





    }

}