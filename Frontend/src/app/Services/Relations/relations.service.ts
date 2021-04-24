import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Relations } from 'src/app/Class/Relations/relations';

@Injectable({
  providedIn: 'root'
})
export class RelationsService {

  constructor(private http: HttpClient) { }
  
  
  getRelations() {
    return this.http.get<Relations[]>("/api/relations/");
  }

  registerRelation(relation: Relations) {
    return this.http.post("/api/relations/", relation);
  }

  deleteRelations(id: String) {
    return this.http.delete("/api/relations/" + id);
  }

  getRelationsByID(id: String) {
    return this.http.get("/api/relations/" + id);
  }

}
