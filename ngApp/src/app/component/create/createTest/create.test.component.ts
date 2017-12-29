import { Component } from '@angular/core';



@Component({
    selector: 'app-create-test',
    templateUrl: './create.test.component.html',
    styleUrls: ['./create.test.component.css']
})
export class CreateTestComponent{
    questionId = 0
    questions = [
        0
    ]
    testTopic = ""; 

    addQuestion(): void {
        this.questions.push(++this.questionId);
    }

}