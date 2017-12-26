// node_module imports
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';

// project imports
import { AppComponent } from './app.component';
import { AppRoutes } from './router';
import { BrowseComponent } from './component/browse/browse.component';
import { CreateComponent } from './component/create/create.component';
import { HomeComponent } from './component/home/home.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { SearchComponent } from './component/search/search.component';
import { SignUpComponent } from './component/signup/signup.component';
import { ProfileComponent } from './component/profile/profile.component';
import { BrowseTopicComponent } from './component/browse/browseTopic/browseTopic.component';
import { QuizComponent } from './component/quiz/quiz.component';
import { AdminComponent } from './component/admin/admin.component';
import { StudyComponent } from './component/study/study.component';
import { AlertComponent } from './component/alert/alert.component';
import { NewQuestionComponent } from './component/create/newquestion/newquestion'; 

// import Services
import { TopicService } from './services/topic/topic.service';
import { QuizService } from './services/quiz/quiz.service';
import { AlertService } from './services/alert/alert.service';
import { AuthenticationService } from './services/authentication/authentication.service';


@NgModule({
  declarations: [
    AppComponent,
    BrowseComponent,
    BrowseTopicComponent,
    CreateComponent,
    NewQuestionComponent,
    HomeComponent,
    NavbarComponent,
    ProfileComponent,
    QuizComponent,
    SearchComponent,
    SignUpComponent,
    StudyComponent,
    AdminComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(AppRoutes),
  ],
  providers: [
    TopicService,
    QuizService,
    AlertService,
    AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
