import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Likes } from 'src/app/Class/Likes/likes';

@Injectable({
  providedIn: 'root'
})
export class LikesService {

  constructor(private http: HttpClient) { }

  getAllLikes() {
    return this.http.get<Likes[]>("/api/likes/");
  }

  registerLike(like: Likes) {
    return this.http.post<Likes>("/api/likes/", like);
  }

  getLike(id: String) {
    return this.http.get<Likes>("/api/likes/" + id);
  }

  deleteLike(id: String) {
    return this.http.delete<Likes>("/api/likes/" + id);
  }
}
