import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService {

  constructor(private http: HttpClient) { }

  getAllBookmarks() {
    return this.http.get("/api/bookmarks/");
  }

  registerBookmark() {
    return this.http.post("/api/bookmarks/");
  }

  getBookmark(id: String) {
    return this.http.get("/api/bookmarks/" + id);
  }

  deleteBookmark(id: String) {
    return this.http.delete("/api/bookmarks/" + id);
  }

}
