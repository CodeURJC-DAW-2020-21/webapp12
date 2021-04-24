import { Component, OnInit } from '@angular/core';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { ProductsService } from 'src/app/Services/Products/products.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  products: ProductsModel[] = [];
  page: number = 0;

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.page = 0;
    this.userService.getProductModels(this.userService.getUserInfo().idusers,0).subscribe(
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

}
