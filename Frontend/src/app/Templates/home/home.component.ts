import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Likes } from 'src/app/Class/Likes/likes';
import { PostsModel } from 'src/app/Class/Models/posts-model';
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
  bookmarks : Bookmarks[] = [];
  index : PostsModel[] = []; 
  
  constructor(private user: UsersService,private postsService: PostsService, private bookmarksService: BookmarkService) { }

  ngOnInit(): void {
    this.userInfo = this.user.getUserInfo();
    this.user.getUserFollowings(""+this.userInfo.idusers).subscribe(
      response => this.following = response.length,
      error => console.error(error)
    );
    this.user.getUserFollowers(""+this.userInfo.idusers).subscribe(
      response => this.followers = response.length,
      error => console.error(error)
    );
    this.user.getLikes(""+this.userInfo.idusers).subscribe(
      response =>{
        let likes : Posts[] = [];
        response.forEach(element => {
          likes.push(element.idpost);
        });
        console.log(likes);
        this.postsService.getPostPage("0").subscribe(
          response =>{
            response.forEach(element => {
              let like = "la la-heart-o";
              let typeUser = "Customer";
              if(likes.includes(element)){
                like = "la la-heart";
              }
              if(element.iduser.companyprofile){
                typeUser = "Company";
              }
              let post : PostsModel = new PostsModel(typeUser,like,element);
              this.index.push(post);
            });
            console.log(this.index);
          },
          error => console.error(error)
        );
      },
      error => console.error(error)
    );
  }

  like(idpost : Number){

  }

  readmore(idpost : Number){

  }
}
