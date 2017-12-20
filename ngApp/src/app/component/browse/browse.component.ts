import { Component } from '@angular/core';
import { HomeComponent } from '../home/home.component'
@Component({
    selector: 'app-browse',
    templateUrl: './browse.component.html',
    styleUrls: [
        './browse.component.css'
    ]
})
export class BrowseComponent {
    topics: Object[];
    constructor() {
        this.topics =
            [
                {
                    subject: "Java" ,
                    description: "Study for Java and OOP Topics"
                },
                {
                    subject: "SQL",
                    description: "Fun with SQL"
                },
                {
                    subject: "Angular 4",
                    description: "Test your knowledge in Angular 4"
                },
                {
                    subject: "Testing Tools",
                    description: "Testing is what we live for"
                },
                {
                    subject: "Database",
                    description: "More than just querying"
                },
                {
                    subject: "Web Services",
                    description: "Ipsum ... you know fillers"
                },
                {
                    subject: "JavaScript",
                    description: "Best Language right here"
                }
            ]
    }
}