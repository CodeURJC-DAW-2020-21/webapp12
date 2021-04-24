import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from 'src/app/Class/Product/product';
import { Tags } from 'src/app/Class/Tags/tags';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }


  getAllProducts() {
    return this.http.get("/api/products/");
  }

  getTags() {
    return this.http.get<Tags[]>("/api/products/tags");
  }

  getProductPage(page : String) {
    return this.http.get("/api/products/?page="+page);
  }

  registerProduct(product: Product) {
    return this.http.post("/api/products/", product);
  }


  getProducts(id: String) {
    return this.http.get("/api/products/"+id);
  }


  deleteProducts(id: String) {
    return this.http.delete("/api/products/"+id);
  }

  replaceProducts(id: String,product: Product ) {
    return this.http.put("/api/products/"+id, product);
  }
/*
  uploadImage0(id: String) {
    return this.http.post("/api/products/"+id+"/image0");
  }

  uploadImage1(id: String) {
    return this.http.post("/api/products/"+id+"/image1");
  }

  uploadImage2(id: String) {
    return this.http.post("/api/products/"+id+"/image2");
  }

*/

}
