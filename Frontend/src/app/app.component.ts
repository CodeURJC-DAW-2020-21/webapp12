import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { error } from 'protractor';
import { Users } from './Class/Users/users';
import { StatisticsService } from './Services/Statistics/statistics.service';
import { UsersService } from './Services/Users/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';
  user : Users;
  admin: boolean = true;

  constructor(private userService: UsersService, private router: Router) {
    this.user = this.userService.getUserInfo();
  }

  ngOnInit(): void {
    console.log(this.userService.getLogin());
    if(this.userService.getLogin() == false){
      this.router.navigate(['new/signIn']);
    }else{
      this.user = this.userService.getUserInfo();
    } 
  }

  logout(){
    this.userService.logout().subscribe(
      response =>{ 
        this.router.navigate(['new/signIn']); 
        this.userService.setLogin(false)
      },
      error => console.log(error)
    );
  }

}
