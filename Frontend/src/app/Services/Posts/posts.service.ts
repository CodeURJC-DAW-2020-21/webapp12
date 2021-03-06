import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Posts } from 'src/app/Class/Posts/posts';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) { }

  getAllPosts() {
    return this.http.get<Posts[]>("/api/posts/");
  }

  registerPost(post: Posts) {
    return this.http.post("/api/posts/", post);
  }

  getPostPage(page: String) {
    return this.http.get<Posts[]>("/api/posts/?page=" + page);
  }

  getPosts(id: String) {
    return this.http.get<Posts>("/api/posts/" + id);
  }

  deletePosts(id: String) {
    return this.http.delete("/api/posts/" + id);
  }

  replacePosts(id: String, post: Posts) {
    return this.http.put("/api/posts/" + id, post);
  }
  uploadPostImage(id: String,image:FormData) {
    return this.http.post("/api/posts/" + id + "/image",image);
  }
}
