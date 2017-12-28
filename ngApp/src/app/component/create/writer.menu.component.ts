import { Component } from '@angular/core'; 

@Component ({
    selector: 'writer-menu',
    templateUrl: 'writer.menu.component.html',
    styleUrls: ['./writer.menu.component.css']
})

export class WriterMenuComponent {
    displayCreateTestMenu = false;
    displayCreateStudyMenu = false; 
    showCreateContentButtons = true; 
    showBackButton = false; 

    showTestMenu():void {
        this.displayCreateTestMenu = true;
        this.displayCreateStudyMenu = false; 
        this.showCreateContentButtons = false; 
        this.showBackButton = true; 
    }
    showStudyMenu():void {
        this.displayCreateTestMenu = false;
        this.displayCreateStudyMenu = true; 
        this.showCreateContentButtons = false; 
        this.showBackButton = true; 
    }
    backToWriterMenuMain() {
        this.displayCreateTestMenu = false;
        this.displayCreateStudyMenu = false; 
        this.showCreateContentButtons = true; 
        this.showBackButton = false; 
    }
    

}