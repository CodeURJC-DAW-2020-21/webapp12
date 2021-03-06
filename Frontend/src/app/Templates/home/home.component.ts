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
  posts: PostsModel[] = [];
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

  value: string;

  constructor(private userService: UsersService, private postsService: PostsService, private productService: ProductsService, private bookmarksService: BookmarkService, private likeService: LikesService, private router: Router) { }

  ngOnInit(): void {
    this.product.img0 = false;
    this.product.img1 = false;
    this.product.img2 = false;
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
      response => {
        this.index = response;
        this.posts = response;
      },
      error => console.error(error)
    );
    this.userService.getUser(""+this.userInfo.idusers).subscribe(
      response =>{
        console.log(response);
        this.userInfo = response;
        this.post.iduser = response;
        this.product.iduser = response;
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

  like(idpost: Number, post: Posts) {
    var s = $("#" + idpost);
    if (s.children().attr("class") == "la la-heart") {
      this.likeService.getAllLikes().subscribe(
        response => {
          response.forEach(element => {
            if ((element.iduser.idusers == this.userInfo.idusers) && (element.idpost.idpost == post.idpost)) {
              this.likeService.deleteLike("" + element.idlike).subscribe(
                response => {
                  console.log(response);
                  s.children().attr("class", "la la-heart-o");
                },
                error => console.error(error)
              );
            }
          });
        },
        error => console.error(error)
      );

    } else {
      let like = new Likes();
      like.iduser = this.userInfo;
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
    this.product.status = "in stock";
    if (this.tag) {
      this.product.idtagone = this.tags[0];
    }

    if (this.tag1) {
      this.product.idtagtwo = this.tags[1];
    }

    if (this.tag2) {
      this.product.idtagthree = this.tags[2];
    }

    if (this.tag3) {
      this.product.idtagfour = this.tags[3];
    }

    if (this.tag4) {
      this.product.idtagfive = this.tags[4];
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
    this.router.navigate(['/userpage', { id: id }]);
  }

  search(){
    let search: PostsModel[] = [];
    this.index.forEach(element => {
      if(element.post.title.includes(this.value)){
          search.push(element);
      }      
    });
    if(this.value.length == 0){
      this.index = this.posts;
    }else{
      this.index = search;
    }
  }
}
