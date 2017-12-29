import { Component } from '@angular/core'; 

@Component ({
    selector: 'writer-menu',
    templateUrl: 'writer.menu.component.html',
    styleUrls: ['./writer.menu.component.css']
})

export class WriterMenuComponent {

    questionCount = 0; 
    questionTopic = ""; 

    displayCreateTestMenu = false;
    displayWriteNewQues = false; 
    showCreateContentButtons = true; 
    showBackButton = false; 

    showTestMenu():void {
        this.displayCreateTestMenu = true;
        this.displayWriteNewQues = false; 
        this.showCreateContentButtons = false; 
        this.showBackButton = true; 
    }
    showAddQuestion():void {
        this.displayCreateTestMenu = false;
        this.displayWriteNewQues = true; 
        this.showCreateContentButtons = false; 
        this.showBackButton = true; 
    }
    backToWriterMenuMain() {
        this.displayCreateTestMenu = false;
        this.displayWriteNewQues = false; 
        this.showCreateContentButtons = true; 
        this.showBackButton = false; 
    }
    

}