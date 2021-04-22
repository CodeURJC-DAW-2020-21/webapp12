import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }


  getAllProducts() {
    return this.http.get("/api/products/");
  }

  getProductPage(page : String) {
    return this.http.get("/api/products/?page="+page);
  }

  registerProduct() {
    return this.http.post("/api/products/");
  }


  getProducts(id: String) {
    return this.http.get("/api/products/"+id);
  }


  deleteProducts(id: String) {
    return this.http.delete("/api/products/"+id);
  }

  replaceProducts(id: String) {
    return this.http.put("/api/products/"+id);
  }

  uploadImage0(id: String) {
    return this.http.post("/api/products/"+id+"/image0");
  }

  uploadImage1(id: String) {
    return this.http.post("/api/products/"+id+"/image1");
  }

  uploadImage2(id: String) {
    return this.http.post("/api/products/"+id+"/image2");
  }



}
