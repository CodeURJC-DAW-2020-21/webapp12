import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  copy : Users[];
  companies: Users[];
  page: number = 0;
  value: string;

  constructor(private userservice: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.page = 0;
    this.userservice.getUserCompaniesPage(this.page).subscribe(
      response => {
        this.companies = response;
        this.copy = response;
      },
      error => console.error(error)
    );
    
  }

  load(){
    this.page++;
    this.userservice.getUserCompaniesPage(this.page).subscribe(
      response =>{
        response.forEach(element => {
          this.companies.push(element);
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
    this.companies.forEach(element => {
      if(element.username.includes(this.value)){
          search.push(element);
      }      
    });
    if(this.value.length == 0){
      this.companies = this.copy;
    }else{
      this.companies = search;
    }
  }
}
