import { Component, OnInit, Input } from '@angular/core';
import { Topic } from '../../../model/topic';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { TopicService } from '../../../services/topic/topic.service';

@Component({
    selector: 'app-browse-topic',
    templateUrl: './browseTopic.component.html',
    styleUrls: ['./browseTopic.component.css']
})
export class BrowseTopicComponent {
    topic: Topic;

    constructor( 
        private route: ActivatedRoute,
        private topicService: TopicService,
        private location: Location 
    ) { }

    ngOnInit(){
        this.getTopic();
    }

    getTopic(): void{
        const topic = this.route.snapshot.paramMap.get('pathName');
        this.topicService.getTopicByPathName(topic)
              .subscribe(topic => this.topic = topic);
    }
    goBack(): void {
        this.location.back();
    }
}