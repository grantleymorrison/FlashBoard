import { Component } from '@angular/core';



@Component({
    selector: 'app-create',
    templateUrl: './create.component.html'

})
export class CreateComponent{
    questionId = 0
    questions = [
        0
    ]

    addQuestion(): void {
        this.questions.push(++this.questionId);
    }

}