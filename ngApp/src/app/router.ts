import { Routes } from '@angular/router';

// import project components
import { HomeComponent } from './component/home/home.component';

export const AppRoutes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    }
]