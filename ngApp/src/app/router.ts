import { Routes } from '@angular/router';

// import project components
import { HomeComponent } from './component/home/home.component';
import { SearchComponent } from './component/search/search.component';
import { SignUpComponent } from './component/signup/signup.component';
import { BrowseComponent } from './component/browse/browse.component';
import { CreateComponent } from './component/create/create.component';
import { ProfileComponent } from './component/profile/profile.component';
import { BrowseTopicComponent } from './component/browse/browseTopic/browseTopic.component';
import { QuizComponent } from './component/quiz/quiz.component';
import { AdminComponent } from './component/admin/admin.component';
import { StudyComponent } from './component/study/study.component';

export const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'browse',
        component: BrowseComponent
    },
    {
        path: 'browse/:pathName',
        component: BrowseTopicComponent
    },
    {
        path: 'quiz/:id',
        component: QuizComponent
    },
    {
        path: 'study/:id',
        component: StudyComponent
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
        path: 'profile/:username',
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
      path: 'admin',
      component: AdminComponent
    }
]
