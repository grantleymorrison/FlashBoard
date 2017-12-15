// node_module imports
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
// project imports
import { AppComponent } from './app.component';
import { AppRoutes } from './router';
import { HomeComponent } from './component/home/home.component'
import { SideNavComponent } from './component/sidenav/sidenav.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SideNavComponent
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
