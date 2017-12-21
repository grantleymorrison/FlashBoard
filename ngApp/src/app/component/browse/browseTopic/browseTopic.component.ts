import { Component, OnInit } from '@angular/core';
import { Topic } from '../../../model/topic';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { TopicService } from '../../../services/topic/topic.service';
import { Quiz } from '../../../model/quiz';
import { QuizService } from '../../../services/quiz/quiz.service';

@Component({
    selector: 'app-browse-topic',
    templateUrl: './browseTopic.component.html',
    styleUrls: ['./browseTopic.component.css']
})
export class BrowseTopicComponent {
    topic: Topic;
    quizs: Quiz[];

    constructor( 
        private route: ActivatedRoute,
        private topicService: TopicService,
        private quizService: QuizService,
        private location: Location 
    ) { }

    ngOnInit(){
        this.getTopic();
        this.getQuizs();
    }

    getTopic(): void{
        let topic = this.route.snapshot.paramMap.get('pathName');
        this.topicService.getTopicByPathName(topic)
              .subscribe(topic => this.topic = topic);
    }

    getQuizs(): void{
        this.quizService.getQuizsByTopic(this.topic.name)
        .subscribe(quizs => this.quizs = quizs);
    }
    goBack(): void {
        this.location.back();
    }
}