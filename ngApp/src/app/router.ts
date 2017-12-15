import { Routes } from '@angular/router';

// import project components
import { HomeComponent } from './component/home/home.component';
import { SearchComponent } from './component/search/search.component';

export const AppRoutes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'search',
        component: SearchComponent
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    }
]