import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  customers: Users[];
  constructor(private userservice: UsersService) { }

  ngOnInit(): void {
    this.userservice.getUserCustomersPage(0).subscribe(
      response => this.customers = response,
      error => console.error(error)
    );
  }

}
