import {Component, Input } from '@angular/core';
import { User } from '../../model/user';
import { Topic } from '../../model/topic';

@Component({
    selector: 'app-newuser',
    templateUrl: './newuser.component.html'
})
export class NewUserComponent{
    @Input()
    newUser: Topic;

    sayHello(){
        console.log(this.newUser);
    }
}