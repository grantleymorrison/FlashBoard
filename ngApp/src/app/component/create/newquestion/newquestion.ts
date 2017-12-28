import { Component, Input } from '@angular/core';


@Component ({
    selector: 'new-question',
    templateUrl: 'newquestion.html',
    styleUrls: ['newquestion.css']
})

export class NewQuestionComponent {
    @Input() index: number; 
    @Input() topic: string;
    @Input() isFromTest: boolean = false; 

    option1:string;
    option2:string;
    option3:string;
    option4:string;
    
    
}