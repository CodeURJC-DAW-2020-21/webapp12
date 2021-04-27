import { Component, OnInit } from '@angular/core';
import { Statistics } from 'src/app/Class/Statistics/statistics';
import { StatisticsService } from 'src/app/Services/Statistics/statistics.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  statitics: Statistics = new Statistics();
  
  
  data: any;
  data2: any;
  constructor(private statiticService: StatisticsService) { 
    
  }

  ngOnInit(): void {
    this.statiticService.getStatistics().subscribe(
      response => {
         this.statitics = response;
         this.data = {
          labels: ['USER','COMPANIES'],
          datasets: [
              {
                  data: [this.statitics.customers, this.statitics.companies],
                  backgroundColor: [
                      "#E74C3C",
                      "#007bff"
                  ],
                  hoverBackgroundColor: [
                      "#E74C3C",
                      "#007bff"
                  ]
              }]    
          };
          this.data2 = {
            labels: ['POSTS','PRODUCTS'],
            datasets: [
                {
                    data: [this.statitics.posts, this.statitics.products],
                    backgroundColor: [
                        "#E74C3C",
                        "#007bff"
                    ],
                    hoverBackgroundColor: [
                        "#E74C3C",
                        "#007bff"
                    ]
                }]    
            };
        },
      error => console.error(error)
    );


  }

}
