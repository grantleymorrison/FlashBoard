import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';

interface AppState {
    message: string;
}

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls : [
        './home.component.css'
    ]
})

export class HomeComponent implements OnInit {
    title = 'FlashBoard';
    
    ngOnInit(){
    }
}