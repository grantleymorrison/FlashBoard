import { Injectable } from '@angular/core';
import { Topic } from '../../model/topic';
import { TOPICS } from '../../data/topics';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

@Injectable()
export class TopicService {
    constructor() {
    }

    getTopics(): Observable<Topic[]> {
        return of(TOPICS);
    }
    getTopicByPathName(pathName: string): Observable<Topic> {
        return of(TOPICS.find(topic => topic.pathName === pathName))
    }
}