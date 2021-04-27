import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { Product } from 'src/app/Class/Product/product';
import { Relations } from 'src/app/Class/Relations/relations';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  products: ProductsModel[] = [];
  page: number = 0;

  constructor(private userService: UsersService, private bookmarkService: BookmarkService) { }

  ngOnInit(): void {
    this.page = 0;
    this.userService.getProductModels(this.userService.getUserInfo().idusers, 0).subscribe(
      response => this.products = response,
      error => console.log(error)
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
      this.bookmarkService.deleteBookmark(""+idproduct).subscribe(
        response => {
          console.log(response);
          $("#product" + idproduct).children().attr("class", "la la-bookmark");
        },
        error => console.error(error)
      );
    }
  }

}
