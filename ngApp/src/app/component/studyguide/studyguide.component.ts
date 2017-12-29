import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-studyguide',
  templateUrl: './studyguide.component.html',
  styleUrls: ['./studyguide.component.css']
})
export class StudyGuideComponent implements OnInit {
  public guide;

  constructor() {

  }
  ngOnInit() {
    this.guide = {
      studyGuideId: 1,
      title: "post 1",
      image: "https://www.pets4homes.co.uk/images/breeds/9/large/dede5d48a8a132d81559591a61e75425.jpg",
      body: [
        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem deleniti quae, neque libero voluptate maiores ullam unde voluptatem assumenda velit dolores impedit quis qui! Neque, cupiditate labore nulla? Atque, tenetur.",
        "Numquam nobis nam voluptas blanditiis eveniet in quasi possimus voluptatem temporibus doloremque delectus dolorum, voluptatum laborum aut dolorem? In rerum necessitatibus soluta incidunt nihil numquam fugit quas pariatur dolores nesciunt?",
        "Quibusdam placeat quisquam iure repellendus ad in, nihil numquam quaerat, facere alias illo. Tempora perferendis incidunt, ratione eveniet esse earum, corporis sit? Modi enim commodi odio placeat minus, error id?",
        "Corrupti voluptates asperiores ratione laudantium, eveniet molestiae possimus deleniti officia, incidunt quae et. Amet, ducimus eum ipsa reprehenderit ad, et nihil, veritatis ea doloremque ab placeat dolore impedit, quia eius."
      ],
      author: "Nick Moreton",
      comment: null,
      rating: null,
      createdDate: new Date('Feb 13 2018')
    }  
  }
}
