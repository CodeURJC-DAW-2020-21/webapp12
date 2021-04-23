import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { PostsModel } from 'src/app/Class/Models/posts-model';
import { Posts } from 'src/app/Class/Posts/posts';
import { Users } from 'src/app/Class/Users/users';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { PostsService } from 'src/app/Services/Posts/posts.service';
import { UsersService } from 'src/app/Services/Users/users.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userInfo: Users;
  following: Number;
  followers: Number;
  bookmarks: Bookmarks[] = [];
  index: PostsModel[] = [];
  page: number = 0;

  constructor(private user: UsersService, private postsService: PostsService, private bookmarksService: BookmarkService) { }

  ngOnInit(): void {
    this.page = 0;
    this.userInfo = this.user.getUserInfo();
    this.user.getUserFollowings("" + this.userInfo.idusers).subscribe(
      response => this.following = response.length,
      error => console.error(error)
    );
    this.user.getUserFollowers("" + this.userInfo.idusers).subscribe(
      response => this.followers = response.length,
      error => console.error(error)
    );
    this.user.getLikes("" + this.userInfo.idusers).subscribe(
      response => {
        let likes: Posts[] = [];
        response.forEach(element => {
          likes.push(element.idpost);
        });
        console.log(likes);
        this.postsService.getPostPage("" + this.page).subscribe(
          response => {
            response.forEach(element => {
              let like = "la la-heart-o";
              let typeUser = "Customer";
              if (likes.includes(element)) {
                like = "la la-heart";
              }
              if (element.iduser.companyprofile) {
                typeUser = "Company";
              }
              let post: PostsModel = new PostsModel(typeUser, like, element);
              this.index.push(post);
            });
            console.log(this.index);
          },
          error => console.error(error)
        );
      },
      error => console.error(error)
    );
    //  ============= POST PROJECT POPUP FUNCTION =========

    $(".post_project").on("click", function () {
      $(".post-popup.pst-pj").addClass("active");
      $(".wrapper").addClass("overlay");
      return false;
    });
    $(".post-project > a").on("click", function () {
      $(".post-popup.pst-pj").removeClass("active");
      $(".wrapper").removeClass("overlay");
      return false;
    });
    $("#cancelposts").on("click", function () {
      $(".post-popup.pst-pj").removeClass("active");
      $(".wrapper").removeClass("overlay");
      return false;
    });

    //  ============= POST JOB POPUP FUNCTION =========

    $(".post-jb").on("click", function () {
      $(".post-popup.job_post").addClass("active");
      $(".wrapper").addClass("overlay");
      return false;
    });
    $(".post-project > a").on("click", function () {
      $(".post-popup.job_post").removeClass("active");
      $(".wrapper").removeClass("overlay");
      return false;
    });
    $("#cancelproduct").on("click", function () {
      $(".post-popup.job_post").removeClass("active");
      $(".wrapper").removeClass("overlay");
      return false;
    });
  }

  like(idpost: Number) {

  }

  readmore(idpost: Number) {

  }

  load() {
    this.page++;
    this.user.getLikes("" + this.userInfo.idusers).subscribe(
      response => {
        let likes: Posts[] = [];
        response.forEach(element => {
          likes.push(element.idpost);
        });
        console.log(likes);
        this.postsService.getPostPage("" + this.page).subscribe(
          response => {
            response.forEach(element => {
              let like = "la la-heart-o";
              let typeUser = "Customer";
              if (likes.includes(element)) {
                like = "la la-heart";
              }
              if (element.iduser.companyprofile) {
                typeUser = "Company";
              }
              let post: PostsModel = new PostsModel(typeUser, like, element);
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


  uploadPosts(){

  }

  uploadProduct(){
    
  }

}
