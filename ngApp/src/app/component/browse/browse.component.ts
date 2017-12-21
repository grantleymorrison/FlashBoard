import { Component, OnInit } from '@angular/core';
import { HomeComponent } from '../home/home.component'
import { Topic } from '../../model/topic';
import { TopicService } from '../../services/topic/topic.service';

@Component({
    selector: 'app-browse',
    templateUrl: './browse.component.html',
    styleUrls: [
        './browse.component.css'
    ]
})
export class BrowseComponent implements OnInit {
    topics: Topic[];

    constructor(private topicService: TopicService) { }

    ngOnInit() {
        this.getTopics();
    }

    // Gets the list of available topics
    getTopics(): void {
        this.topicService.getTopics()
            .subscribe(topics => this.topics = topics);
    }
}