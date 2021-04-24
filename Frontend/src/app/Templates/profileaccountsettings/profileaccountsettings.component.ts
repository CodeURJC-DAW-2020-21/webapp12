import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Relations } from 'src/app/Class/Relations/relations';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-profileaccountsettings',
  templateUrl: './profileaccountsettings.component.html',
  styleUrls: ['./profileaccountsettings.component.css']
})
export class ProfileaccountsettingsComponent implements OnInit {
  userpage: Users;
  bookmarks : Bookmarks[] = [];
  followers : Relations[] = [];
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.userpage = this.userService.getUserInfo();
    this.userService.getBookmarks(""+this.userpage.idusers).subscribe(
      response => this.bookmarks = response,
      error => console.log(error)
    );
    this.userService.getUserFollowers(""+this.userpage.idusers).subscribe(
      response => this.followers = response,
      error => console.log(error)
    );
  }

}
