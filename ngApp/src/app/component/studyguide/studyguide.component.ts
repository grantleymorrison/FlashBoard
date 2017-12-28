import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { TutorialService } from '../../services/tutorial/tutorial.service';

declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-studyguide',
  templateUrl: './studyguide.component.html',
  styleUrls: ['./studyguide.component.css']
})
export class StudyGuideComponent implements OnInit {
  constructor() {

  }
  ngOnInit() {

  }
}
