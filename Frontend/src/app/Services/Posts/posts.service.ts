import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) { }

  getAllPosts() {
    return this.http.get("/api/posts/");
  }

  registerPost() {
    return this.http.post("/api/posts/");
  }

  getProductPage(page: String) {
    return this.http.get("/api/posts/?page=" + page);
  }

  getPosts(id: String) {
    return this.http.get("/api/posts/" + id);
  }

  deletePosts(id: String) {
    return this.http.delete("/api/posts/" + id);
  }

  replacePosts(id: String) {
    return this.http.put("/api/posts/" + id);
  }

  uploadPostImage(id: String) {
    return this.http.post("/api/posts/" + id + "/image");
  }

}
