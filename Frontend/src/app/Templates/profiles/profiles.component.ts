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

  copy : Users[];
  customers: Users[];
  page: number = 0;
  value: string;

  constructor(private userservice: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.page = 0;
    this.userservice.getUserCustomersPage(this.page).subscribe(
      response => {
        this.customers = response;
        this.copy = response;
      },
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
    this.router.navigate(['/userpage', { id: id }]);
  }

  search(){
    let search: Users[] = [];
    this.customers.forEach(element => {
      if(element.username.includes(this.value)){
          search.push(element);
      }      
    });
    if(this.value.length == 0){
      this.customers = this.copy;
    }else{
      this.customers = search;
    }
  }
}
