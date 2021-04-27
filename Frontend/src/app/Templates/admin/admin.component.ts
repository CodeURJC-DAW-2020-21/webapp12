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

  constructor(private statiticService: StatisticsService) { }

  ngOnInit(): void {
    this.statiticService.getStatistics().subscribe(
      response => this.statitics = response,
      error => console.error(error)
    );


  }

}
