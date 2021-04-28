import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Likes } from 'src/app/Class/Likes/likes';
import { PostsModel } from 'src/app/Class/Models/posts-model';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { Posts } from 'src/app/Class/Posts/posts';
import { Product } from 'src/app/Class/Product/product';
import { Relations } from 'src/app/Class/Relations/relations';
import { Users } from 'src/app/Class/Users/users';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { LikesService } from 'src/app/Services/Likes/likes.service';
import { PostsService } from 'src/app/Services/Posts/posts.service';
import { ProductsService } from 'src/app/Services/Products/products.service';
import { RelationsService } from 'src/app/Services/Relations/relations.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  pagePosts: number = 0;
  pageProducts: number = 0;
  userpage: Users;
  idFollow: Number = 1;
  follow: String = "#53D690";
  following: Number;
  followers: Number;
  relationId: Number;
  posts: PostsModel[] = [];
  products: ProductsModel[] = [];
  postsImages: Posts[] = [];

  constructor(private userService: UsersService, private postsService: PostsService, private productService: ProductsService, private relationService: RelationsService, private likeService: LikesService, private bookmarkService: BookmarkService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.router.params.subscribe(
      params => this.idFollow = params['id']
    );
    this.userService.getUserFollowings("" + this.idFollow).subscribe(
      response => this.following = response.length,
      error => console.error(error)
    );
    this.userService.getUserFollowers("" + this.idFollow).subscribe(
      response => this.followers = response.length,
      error => console.error(error)
    );
    this.userService.getUser("" + this.idFollow).subscribe(
      response => {
        this.userpage = response;
        this.userService.getPostModelsUserPage(this.userService.getUserInfo().idusers, this.pagePosts, this.userpage.username).subscribe(
          response => this.posts = response,
          error => console.error(error)
        );
        this.userService.getProductModelsUserPage(this.userService.getUserInfo().idusers, this.pageProducts, this.userpage.username).subscribe(
          response => this.products = response,
          error => console.error(error)
        );
        this.userService.getPosts("" + this.idFollow).subscribe(
          response => this.postsImages = response,
          error => console.error(error)
        );
        this.relationService.getRelations().subscribe(
          response => {
            response.forEach(element => {
              if ((element.userone.idusers == this.userService.getUserInfo().idusers) && (element.usertwo.idusers == this.idFollow)) {
                this.follow = "#e44d3a";
                this.relationId = element.iduserrelation;
              }
            });
          },
          error => console.error(error)
        );

      },
      error => console.error(error)
    );




  }

  loadPosts() {
    this.pagePosts++;
    this.userService.getPostModelsUserPage(this.userService.getUserInfo().idusers, this.pagePosts, this.userpage.username).subscribe(
      response => {
        response.forEach(element => {
          this.posts.push(element);
        });
      },
      error => console.error(error)
    );
  }

  loadProducts() {
    this.pageProducts++;
    this.userService.getProductModelsUserPage(this.userService.getUserInfo().idusers, this.pageProducts, this.userpage.username).subscribe(
      response => {
        response.forEach(element => {
          this.products.push(element);
        });
      },
      error => console.error(error)
    );
  }

  followFunction() {
    let relation: Relations = new Relations();
    relation.userone = this.userService.getUserInfo();
    relation.usertwo = this.userpage;
    if (this.follow == "#e44d3a") {
      this.relationService.deleteRelations("" + this.relationId).subscribe(
        response => console.log(response),
        error => console.error(error)
      );
      $(".flww").css("background-color", "#53D690");
    } else {
      this.relationService.registerRelation(relation).subscribe(
        response => console.log(response),
        error => console.error(error)
      );
      $(".flww").css("background-color", "#e44d3a");
    }
  }

  like(idpost: Number, post: Posts) {
    var s = $("#" + idpost);
    if (s.children().attr("class") == "la la-heart") {
      this.likeService.getAllLikes().subscribe(
        response => {
          response.forEach(element => {
            if ((element.iduser.idusers == this.userService.getUserInfo().idusers) && (element.idpost.idpost == post.idpost)) {
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

  mark(idproduct: Number, product: Product) {
    if ($("#product" + idproduct).children().attr("class") == "la la-bookmark") {
      let mark: Bookmarks = new Bookmarks();
      mark.idproduct = product;
      mark.iduser = this.userService.getUserInfo();
      this.bookmarkService.registerBookmark(mark).subscribe(
        response => {
          console.log(response);
          $("#product" + idproduct).children().attr("class", "la la-check-circle");
        },
        error => console.error(error)
      ); 
    } else {
      this.bookmarkService.getAllBookmarks().subscribe(
        response => {
          response.forEach(element => {
            if( (element.iduser.idusers == this.userService.getUserInfo().idusers)&&(element.idproduct.idproduct == product.idproduct) ){
              this.bookmarkService.deleteBookmark(""+element.idproductlist).subscribe(
                response => {
                  console.log(response);
                  $("#product" + idproduct).children().attr("class", "la la-bookmark");
                },
                error => console.error(error)
              );
            }
          });
        },
        error => console.error(error)
      );
    }
  }

}
