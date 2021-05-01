import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { Product } from 'src/app/Class/Product/product';
import { Relations } from 'src/app/Class/Relations/relations';
import { Tags } from 'src/app/Class/Tags/tags';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { ProductsService } from 'src/app/Services/Products/products.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  products: ProductsModel[] = [];
  productscopy: ProductsModel[] = [];
  page: number = 0;
  value: string;
  tags: Tags [] = [];
  tagFilter = "Select tag";
  status: String [] = ["sold","reserved","in stock"];
  statusFilter = "Select status";
  cities: String [] = ["Madrid","Barcelona","Oviedo"];
  cityFilter = "Select city";

  constructor(private userService: UsersService, private bookmarkService: BookmarkService, private productService: ProductsService) { }

  ngOnInit(): void {
    this.page = 0;
    this.userService.getProductModels(this.userService.getUserInfo().idusers, 0).subscribe(
      response => {
        this.products = response;
        this.productscopy = response;
      },
      error => console.error(error)
    );
    this.productService.getTags().subscribe(
      response => this.tags = response, 
      error => console.error(error)
    );
  }

  load() {
    this.page++;
    this.userService.getProductModels(this.userService.getUserInfo().idusers, this.page).subscribe(
      response => {
        response.forEach(element => {
          this.products.push(element);
        });
      },
      error => console.error(error)
    );
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

  search(){
    let search: ProductsModel[] = [];
    this.products.forEach(element => {
      if(element.product.title.includes(this.value)){
          search.push(element);
      }      
    });
    if(this.value.length == 0){
      this.products = this.productscopy;
    }else{
      this.products = search;
    }
  }
  
  searchTags(){
    console.log(this.tagFilter);
  }

  searchStatus(){
    console.log(this.statusFilter);
  }

  searchCity(){
    console.log(this.cityFilter);
  }

  clear(){
    this.tagFilter = "Select tag";
    this.statusFilter = "Select status";
    this.cityFilter = "Select city";
  }
}
