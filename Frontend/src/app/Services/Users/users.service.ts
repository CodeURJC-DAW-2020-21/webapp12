import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  login(username:String, password: String){
      return this.http.post("/api/auth/login",{"username": username, "password": password});
  }

  refresh(){
    return this.http.post("/api/auth/refresh",{});
  }

  logout(){
    return this.http.post("/api/auth/logout",{});
  }

}
