import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from './Class/Users/users';
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
  loginUser : Boolean = false;

  constructor(private userService: UsersService, private router: Router) {
  }

  ngOnInit(): void {
    if(this.loginUser == false){
      this.router.navigate(['/signIn']);
    }else{
      this.user = this.userService.getUserInfo();
      this.router.navigate(['/home']);
    } 
  }

  logout(){
    this.userService.logout().subscribe(
      response =>{ 
        this.router.navigate(['/signIn']); 
        this.userService.setLogin(false)
      },
      error => console.log(error)
    );
  }

}
