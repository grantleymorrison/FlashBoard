import { Injectable } from "@angular/core";

@Injectable()
export class TutorialService {
    constructor() {
    }
    tutorialData() {
        return [
            {
                "title": "4 Pillars of OOP",
                "pubDate": "2017-08-23 14:41:52",
                "link": "http://www.corejavaguru.com/java/oop/4pillars",
                "guid": "http://blog.pusher.com/?p=682#comment-10372",
                "author": "marble",
                "thumbnail": "",
                "description": "always a big fan of linking to bloggers that I enjoy but dont get a great deal of link enjoy from",
                "content": "<p>always a big fan of linking to bloggers that I enjoy but dont get a great deal of link enjoy from</p>",
                "enclosure": [],
                "categories": []
            },
            {
                "title": "Making Angular.js realtime with Websockets by strapless strap on",
                "pubDate": "2017-08-23 05:05:08",
                "link": "https://blog.pusher.com/making-angular-js-realtime-with-pusher/#comment-10371",
                "guid": "http://blog.pusher.com/?p=682#comment-10371",
                "author": "strapless strap on",
                "thumbnail": "",
                "description": "very couple of internet websites that transpire to be detailed beneath, from our point of view are undoubtedly properly worth checking out",
                "content": "<p>very couple of internet websites that transpire to be detailed beneath, from our point of view are undoubtedly properly worth checking out</p>",
                "enclosure": [],
                "categories": []
            },
            {
                "title": "Making Angular.js realtime with Websockets by bondage restraints",
                "pubDate": "2017-08-22 17:09:17",
                "link": "https://blog.pusher.com/making-angular-js-realtime-with-pusher/#comment-10370",
                "guid": "http://blog.pusher.com/?p=682#comment-10370",
                "author": "bondage restraints",
                "thumbnail": "",
                "description": "very couple of web sites that occur to be in depth below, from our point of view are undoubtedly properly worth checking out",
                "content": "<p>very couple of web sites that occur to be in depth below, from our point of view are undoubtedly properly worth checking out</p>",
                "enclosure": [],
                "categories": []
            }
        ];
    }
}