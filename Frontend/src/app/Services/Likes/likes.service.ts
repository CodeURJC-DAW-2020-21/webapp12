import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LikesService {

  constructor(private http: HttpClient) { }

  getAllLikes() {
    return this.http.get("/api/likes/");
  }

  registerLike() {
    return this.http.post("/api/likes/");
  }

  getLike(id: String) {
    return this.http.get("/api/likes/" + id);
  }

  deleteLike(id: String) {
    return this.http.delete("/api/likes/" + id);
  }

}
