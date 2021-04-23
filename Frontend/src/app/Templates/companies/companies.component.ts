import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  companies: Users[];
  constructor(private userservice: UsersService) { }

  ngOnInit(): void {
    this.userservice.getUserCompaniesPage(0).subscribe(
      response => this.companies = response,
      error => console.error(error)
    );
    
  }

}
