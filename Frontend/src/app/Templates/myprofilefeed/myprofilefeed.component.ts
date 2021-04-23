import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-myprofilefeed',
  templateUrl: './myprofilefeed.component.html',
  styleUrls: ['./myprofilefeed.component.css']
})
export class MyprofilefeedComponent implements OnInit {

  iduser: String = "0";
  userFullName : String ="Holo";
  userInfo : String ="info";
  userCity : String ="city";
  following : String = "21";
  followers : String = "21";
  userFacebook : String = "<li><a href='#' title=''><i class='fa fa-facebook-square'></i>userfacebook</a></li>";
  userTwitter : String = "<li><a href='#' title=''><i class='fa fa-twitter'></i>userTwitter</a></li>";
  userInstagram : String = "<li><a href='#' title=''><i class='fa fa-instagram'></i>userInstagram</a></li>";

  constructor() { }

  ngOnInit(): void {
  }

}
