import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Posts } from 'src/app/Class/Posts/posts';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: String = "Holo";
  following: String = "21";
  followers: String = "22";
  iduser : String = "1";
  bookmarks : Bookmarks[];
  posts : Posts[];
  constructor() { }

  ngOnInit(): void {
  }

}
