// node_module imports
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

// project imports
import { AppComponent } from './app.component';
import { AppRoutes } from './router';
import { BrowseComponent } from './component/browse/browse.component';
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
import { LoginComponent } from './component/login/login.component';
import { StudyGuideComponent } from './component/studyguide/studyguide.component';
import { NewUserComponent } from './component/newuser/newuser.component';
import { PromoteUserComponent } from './component/promoteuser/promoteuser.component';

// import Services
import { TopicService } from './services/topic/topic.service';
import { QuizService } from './services/quiz/quiz.service';
import { AlertService } from './services/alert/alert.service';
import { AdminService } from './services/admin/admin.service';
import { AuthenticationService } from './services/authentication/authentication.service';
import { FooterComponent } from './component/footer/footer.component';
import { StudyGuideService } from './services/studyGuide/study-guide.service';

import { JwtInterceptor } from './_helper/jwt.interceptor';
import { PostGuideComponent } from './component/study/post-guide/post-guide.component';
import { CreatequizComponent } from './component/create/createquiz/createquiz.component';
import { QuestionComponent } from './component/create/question/question.component';



@NgModule({
  declarations: [
    AppComponent,
    BrowseComponent,
    BrowseTopicComponent,
    HomeComponent,
    NavbarComponent,
    ProfileComponent,
    QuizComponent,
    SearchComponent,
    SignUpComponent,
    StudyComponent,
    AdminComponent,
    AlertComponent,
    FooterComponent,
    LoginComponent,
    StudyGuideComponent,
    LoginComponent,
    PostGuideComponent,
    NewUserComponent,
    PromoteUserComponent,
    CreatequizComponent,
    QuestionComponent

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
    StudyGuideService,
    AdminService,
    AuthenticationService, {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }