import {Component, Input } from '@angular/core';
import { User } from '../../model/user';

@Component({
    selector: 'app-promotee',
    templateUrl: './promotee.component.html'
})
export class PromoteeComponent{
    @Input()
    promotee: User;
}