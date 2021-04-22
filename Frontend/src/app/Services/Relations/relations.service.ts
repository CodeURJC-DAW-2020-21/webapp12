import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RelationsService {

  constructor(private http: HttpClient) { }
  
  
  getRelations() {
    return this.http.get("/api/relations/");
  }

  registerRelation() {
    return this.http.post("/api/relations/");
  }

  deleteRelations(id: String) {
    return this.http.delete("/api/relations/" + id);
  }

  getRelationsByID(id: String) {
    return this.http.get("/api/relations/" + id);
  }

}
