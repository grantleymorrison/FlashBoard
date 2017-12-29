import {Component, Input } from '@angular/core';
import { User } from '../../model/user';

@Component({
    selector: 'app-newuser',
    templateUrl: './newuser.component.html'
})
export class NewUserComponent{
    @Input()
    newUser: string;

    sayHello(){
        console.log(this.newUser);
    }
}
