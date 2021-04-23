import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Posts } from 'src/app/Class/Posts/posts';
import { Users } from 'src/app/Class/Users/users';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { PostsService } from 'src/app/Services/Posts/posts.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userInfo : Users;
  following : Number;
  followers : Number;
  bookmarks : Bookmarks[];
  posts : Posts[];
  
  constructor(private user: UsersService,private postsService: PostsService, private bookmarksService: BookmarkService) { }

  ngOnInit(): void {
    this.postsService.getPostPage("0").subscribe(
      response => this.posts = response,
      error => console.error(error)
    );
    this.userInfo = this.user.getUserInfo();
    this.user.getUserFollowings(""+this.userInfo.idusers).subscribe(
      response => this.following = response.length
    );
    this.user.getUserFollowers(""+this.userInfo.idusers).subscribe(
      response => this.followers = response.length
    );
  }
}
