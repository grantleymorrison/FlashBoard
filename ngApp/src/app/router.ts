import { Routes } from '@angular/router';

// import project components
import { HomeComponent } from './component/home/home.component';
import { SearchComponent } from './component/search/search.component';
import { SignUpComponent } from './component/signup/signup.component';
import { BrowseComponent } from './component/browse/browse.component';
import { CreateComponent } from './component/create/create.component';
import { ProfileComponent } from './component/profile/profile.component';
export const AppRoutes: Routes = [
    {
        path: 'browse',
        component: BrowseComponent
    },
    {
        path: 'create',
        component: CreateComponent
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'search',
        component: SearchComponent
    },
    {
        path: 'signup',
        component: SignUpComponent
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    }
]