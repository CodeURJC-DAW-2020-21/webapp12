import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from 'src/app/Class/Users/users';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  username: String = "holo";
  iduser: Number = 1;
  admin: Boolean = false;

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

  getAllUsers() {
    return this.http.get("/api/users/");
  }

  registerUser(user: Users) {
    return this.http.post("/api/users/", user);
  }

  getUsersPage(page: String) {
    return this.http.get("/api/users/?page=" + page);
  }

  getUser(id: String) {
    return this.http.get("/api/users/" + id);
  }

  replaceUser(id: String, user: Users) {
    return this.http.put("/api/users/" + id, user);
  }

  deleteUser(id: String) {
    return this.http.delete("/api/users/" + id);
  }

  getUserCustomers() {
    return this.http.get<Users[]>("/api/users/customers/");
  }

  getUserCompanies() {
    return this.http.get<Users[]>("/api/users/companies/");
  }

  getUserCustomersPage(id : Number) {
    return this.http.get<Users[]>("/api/users/customers?page="+id);
  }

  getUserCompaniesPage(id : Number) {
    return this.http.get<Users[]>("/api/users/companies?page="+id);
  }
/*
  uploadImageProfile(id: String) {
    return this.http.post("/api/users/" + id + "/imageProfile");
  }

  uploadThemeProfile(id: String) {
    return this.http.post("/api/users/" + id + "/imageThemeProfile");
  }
*/
  getPosts(id: String) {
    return this.http.get("/api/users/" + id + "/posts");
  }

  getProducts(id: String) {
    return this.http.get("/api/users/" + id + "/products");
  }

  getUserRelations(id: String) {
    return this.http.get("/api/users/" + id + "/followings");
  }

  getBookmarks(id: String) {
    return this.http.get("/api/users/" + id + "/bookmarks");
  }

  getLikes(id: String) {
    return this.http.get("/api/users/" + id + "/likes");
  }

  setUsername(username: String){
    this.username = username;
  }

  setId(id: Number){
    this.iduser = id;
  }

  setAdmin(admin: boolean){
    this.admin =admin;
  }

  getUsername(){
    return this.username;
  }

  getId(){
    return this.iduser;
  }

  getAdmin(){
    return this.admin;
  }
}
