import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Class/Users/users';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  customers: Users[];
  constructor() { }

  ngOnInit(): void {
  }

}
