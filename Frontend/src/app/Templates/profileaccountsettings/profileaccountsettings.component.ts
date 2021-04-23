import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Users } from 'src/app/Class/Users/users';

@Component({
  selector: 'app-profileaccountsettings',
  templateUrl: './profileaccountsettings.component.html',
  styleUrls: ['./profileaccountsettings.component.css']
})
export class ProfileaccountsettingsComponent implements OnInit {
  iduser: String = "h";
  username: String = "h";
  email: String = "h";
  name: String = "h";
  city: String = "h";
  linkfacebook : String = "<li><a href='#' title=''><i class='fa fa-facebook-square'></i>userfacebook</a></li>";
  linktwitter : String = "<li><a href='#' title=''><i class='fa fa-twitter'></i>userTwitter</a></li>";
  linkinstagram : String = "<li><a href='#' title=''><i class='fa fa-instagram'></i>userInstagram</a></li>";
  bookmarks : Bookmarks[];
  followers : Users[];
  constructor() { }

  ngOnInit(): void {
  }

}
