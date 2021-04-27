import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { PostsModel } from 'src/app/Class/Models/posts-model';
import { Posts } from 'src/app/Class/Posts/posts';
import { Users } from 'src/app/Class/Users/users';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { PostsService } from 'src/app/Services/Posts/posts.service';
import { UsersService } from 'src/app/Services/Users/users.service';
import * as $ from 'jquery';
import { Router } from '@angular/router';
import { Tags } from 'src/app/Class/Tags/tags';
import { ProductsService } from 'src/app/Services/Products/products.service';
import { Product } from 'src/app/Class/Product/product';
import { post } from 'jquery';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { LikesService } from 'src/app/Services/Likes/likes.service';
import { Likes } from 'src/app/Class/Likes/likes';

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
  tags: Tags[] = [];
  mostFollow: Users[] = [];
  page: number = 0;
  product: Product = new Product();
  post: Posts = new Posts();
  imagePosts: FormData;
  imageProduct0: FormData;
  imageProduct1: FormData;
  imageProduct2: FormData;

  tag: Boolean;
  tag1: Boolean;
  tag2: Boolean;
  tag3: Boolean;
  tag4: Boolean;

  constructor(private userService: UsersService, private postsService: PostsService, private productService: ProductsService, private bookmarksService: BookmarkService, private likeService: LikesService, private router: Router) { }

  ngOnInit(): void {
    this.page = 0;
    this.userInfo = this.userService.getUserInfo();
    this.userService.getUserFollowings("" + this.userInfo.idusers).subscribe(
      response => this.following = response.length,
      error => console.error(error)
    );
    this.userService.getUserFollowers("" + this.userInfo.idusers).subscribe(
      response => this.followers = response.length,
      error => console.error(error)
    );
    this.userService.getBookmarks("" + this.userInfo.idusers).subscribe(
      response => this.bookmarks = response,
      error => console.error(error)
    );
    this.productService.getTags().subscribe(
      response => this.tags = response,
      error => console.error(error)
    );
    this.userService.getRanking().subscribe(
      response => this.mostFollow = response,
      error => console.error(error)
    );
    this.userService.getPostModels(this.userInfo.idusers, this.page).subscribe(
      response => this.index = response,
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

  like(idpost: Number, post: Posts) {
    var s = $("#" + idpost);
    if (s.children().attr("class") == "la la-heart") {
      this.likeService.deleteLike("" + idpost).subscribe(
        response => {
          console.log(response);
          s.children().attr("class", "la la-heart-o");
        },
        error => console.error(error)
      );
    } else {
      let like = new Likes();
      like.iduser = this.userService.getUserInfo();
      like.idpost = post
      this.likeService.registerLike(like).subscribe(
        response => {
          console.log(response);
          s.children().attr("class", "la la-heart");
        },
        error => console.error(error)
      );
    }
  }

  readmore(idpost: Number) {
    $("#readmore" + idpost).parent().children(".row").children(".description-store").toggleClass("show");
  }

  load() {
    this.page++;
    this.userService.getPostModels(this.userInfo.idusers, this.page).subscribe(
      response => {
        response.forEach(element => {
          this.index.push(element);
        });
      },
      error => console.error(error)
    );
  }

  imagePost(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imagePosts = formData;
  }

  deleteImagePosts() {
    this.imagePost = undefined;
  }

  setimageProduct0(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageProduct0 = formData;
  }

  deleteImageProduct0() {
    this.imageProduct0 = undefined;
  }

  setimageProduct1(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageProduct1 = formData;
  }
  deleteImageProduct1() {
    this.imageProduct1 = undefined;
  }

  setimageProduct2(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageProduct2 = formData;
  }

  deleteImageProduct2() {
    this.imageProduct2 = undefined;
  }

  uploadPosts() {
    this.post.iduser = this.userService.getUserInfo();
    console.log(this.post);
    this.postsService.registerPost(this.post).subscribe(
      response => {
        let data: any = response;
        this.postsService.getPosts(data.idpost).subscribe(
          response => {
            this.post = response;
            console.log(post);
            if (this.imagePosts != undefined) {
              this.postsService.uploadPostImage("" + this.post.idpost, this.imagePosts).subscribe(
                response => {
                  let newposts: PostsModel = new PostsModel();
                  newposts.typeUser = "user";
                  if (this.userInfo.companyprofile) {
                    newposts.typeUser = "company";
                  }
                  newposts.like = "la la-heart-o";
                  newposts.post = this.post;
                  this.index.unshift(newposts);
                  $(".post-popup.pst-pj").removeClass("active");
                  $(".wrapper").removeClass("overlay");
                },
                error => console.error(error)
              );
            } else {
              alert("Nesesario la imagen");
            }
          },
          error => console.log(error)
        );
      },
      error => console.error(error)
    );
  }

  uploadProduct() {
    this.product.iduser = this.userService.getUserInfo();
    console.log(this.product);
    let tagone: Tags;
    let tagtwo: Tags;
    let tagthree: Tags;
    let tagfour: Tags;
    let tagfive: Tags;
    let image0: Boolean = false;
    let image1: Boolean = false;
    let image2: Boolean = false;
    if (this.tag) {
      tagone = this.tags[0];
    }

    if (this.tag1) {
      tagone = this.tags[1];
    }

    if (this.tag2) {
      tagone = this.tags[2];
    }

    if (this.tag3) {
      tagone = this.tags[3];
    }

    if (this.tag4) {
      tagone = this.tags[4];
    }

    if (this.imageProduct0 != undefined) {
      image0 = true;
    }

    if (this.imageProduct1 != undefined) {
      image1 = true;
    }

    if (this.imageProduct2 != undefined) {
      image2 = true;
    }
    this.productService.registerProduct(this.product).subscribe(
      response => {
        if (this.imageProduct0 != undefined) {
          this.productService.uploadImage0("" + response.idproduct, this.imageProduct0).subscribe();
        }

        if (this.imageProduct1 != undefined) {
          this.productService.uploadImage1("" + response.idproduct, this.imageProduct1).subscribe();
        }

        if (this.imageProduct2 != undefined) {
          this.productService.uploadImage2("" + response.idproduct, this.imageProduct2).subscribe();
        }
        $(".post-popup.job_post").removeClass("active");
        $(".wrapper").removeClass("overlay");
      },
      error => console.error(error)
    );
  }

  userpage(id: Number) {
    this.router.navigate(['/new/userpage', { id: id }]);
  }
}
