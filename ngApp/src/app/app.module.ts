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

@NgModule({
  declarations: [
    AppComponent,
    BrowseComponent,
    CreateComponent,
    HomeComponent,
    NavbarComponent,
    SearchComponent,
    SignUpComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(AppRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
