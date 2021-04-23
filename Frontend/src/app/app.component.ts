import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StatisticsService } from './Services/Statistics/statistics.service';
import { UsersService } from './Services/Users/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';
  username: String = "Holo";
  iduser: String = "1";
  admin : boolean = true;

  constructor(private userService: UsersService, private statiticsService: StatisticsService, private router: Router) {
    this.userService.login("h", "h").subscribe(
      response => {
        console.log(response);
        userService.setUsername("h");
        userService.setId(1);
        userService.setLogin(true);
      },
      error => console.error(error)
    );
  }

  ngOnInit(): void {
    if(!this.userService.getLogin()){
      this.router.navigate(['signIn']);
    }  
    
  }

  get() {
    this.statiticsService.getStatistics().subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

}
