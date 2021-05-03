import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService {

  constructor(private http: HttpClient) { }

  getAllBookmarks() {
    return this.http.get<Bookmarks[]>("/api/bookmarks/");
  }

  registerBookmark(bookmark: Bookmarks) {
    return this.http.post("/api/bookmarks/", bookmark);
  }

  getBookmark(id: String) {
    return this.http.get("/api/bookmarks/" + id);
  }

  deleteBookmark(id: String) {
    return this.http.delete("/api/bookmarks/" + id);
  }

}
