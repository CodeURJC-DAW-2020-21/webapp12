import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  customers: Users[];
  page: number = 0;
  constructor(private userservice: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.page = 0;
    this.userservice.getUserCustomersPage(this.page).subscribe(
      response => this.customers = response,
      error => console.error(error)
    );
  }

  load(){
    this.page++;
    this.userservice.getUserCustomersPage(this.page).subscribe(
      response =>{
        response.forEach(element => {
          this.customers.push(element);
        });
      },
      error => console.error(error)
    );
  }

  goUserpage(id: Number){
    this.router.navigate(['/new/userpage', { id: id }]);
  }

}
