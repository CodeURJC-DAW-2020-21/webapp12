import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostsModel } from 'src/app/Class/Models/posts-model';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { Posts } from 'src/app/Class/Posts/posts';
import { Product } from 'src/app/Class/Product/product';
import { Users } from 'src/app/Class/Users/users';
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

  pagePosts : number = 0;
  pageProducts : number = 0;
  userpage: Users;
  idFollow: Number = 1;
  follow: String = "#53D690";
  following: Number;
  followers: Number;
  posts: PostsModel[] = [];
  products: ProductsModel[] = [];
  postsImages: Posts[] = [];

  constructor(private userService: UsersService, private postsService: PostsService, private productService: ProductsService, private relationService: RelationsService,private router: ActivatedRoute) { }

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
    this.userService.getUser(""+this.idFollow).subscribe(
      response =>{ 
        this.userpage= response;
        this.userService.getPostModelsUserPage(this.userService.getUserInfo().idusers,this.pagePosts,this.userpage.username).subscribe(
          response => this.posts = response,
          error => console.error(error)
        );
        this.userService.getProductModelsUserPage(this.userService.getUserInfo().idusers,this.pageProducts,this.userpage.username).subscribe(
          response => this.products = response,
          error => console.error(error)
        );
        this.userService.getPosts(""+this.idFollow).subscribe(
          response => this.postsImages = response,
          error => console.error(error)
        );
        this.relationService.getRelations().subscribe(
          response =>{
            response.forEach(element => {
              if( (element.userone.idusers == this.userService.getUserInfo().idusers)&&(element.usertwo.idusers == this.idFollow) ){
                this.follow = "#e44d3a";
              }
            });
          },
          error => console.error(error)
        );
    
      },
       error => console.error(error)
    );

    
    
    
  }

  loadPosts(){
    this.pagePosts++;
    this.userService.getPostModelsUserPage(this.userService.getUserInfo().idusers,this.pagePosts,this.userpage.username).subscribe(
      response =>{
        response.forEach(element => {
          this.posts.push(element);
        });
      },
      error => console.error(error)
    );
  }

  loadProducts(){
    this.pageProducts++;
    this.userService.getProductModelsUserPage(this.userService.getUserInfo().idusers,this.pageProducts,this.userpage.username).subscribe(
      response =>{
        response.forEach(element => {
          this.products.push(element);
        });
      },
      error => console.error(error)
    );
  }

}
