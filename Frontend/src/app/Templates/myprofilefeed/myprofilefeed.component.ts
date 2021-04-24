import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-myprofilefeed',
  templateUrl: './myprofilefeed.component.html',
  styleUrls: ['./myprofilefeed.component.css']
})
export class MyprofilefeedComponent implements OnInit {

  userpage: Users;
  following: Number;
  followers: Number;
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.userpage = this.userService.getUserInfo();
    this.userService.getUserFollowings("" + this.userService.getUserInfo().idusers).subscribe(
      response => this.following = response.length,
      error => console.error(error)
    );
    this.userService.getUserFollowers("" + this.userService.getUserInfo().idusers).subscribe(
      response => this.followers = response.length,
      error => console.error(error)
    );
  }

}
