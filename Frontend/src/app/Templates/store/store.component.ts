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
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.userService.getProductModels(this.userService.getUserInfo().idusers,0).subscribe(
      response => this.products = response,
      error => console.log(error)
    );
  }

}
