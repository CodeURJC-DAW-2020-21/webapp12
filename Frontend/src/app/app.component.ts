import { Component } from '@angular/core';
import { StatisticsService } from './Services/Statistics/statistics.service';
import { UsersService } from './Services/Users/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';

  constructor(private userService: UsersService, private statiticsService: StatisticsService) {
    this.userService.login("h", "h").subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

  get() {
    this.statiticsService.getStatistics().subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

}
