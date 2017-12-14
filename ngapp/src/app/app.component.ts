import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  // NOTE: below declared for sample
  public searchString;
  constructor(private http:HttpClient){
  }
  ngOnInit(): void {
    this.http.get('http://localhost:3000/flashboard/SampleServlet').subscribe(data => {
      console.log(data);
    });
  }
}
