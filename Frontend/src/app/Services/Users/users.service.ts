import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Posts } from 'src/app/Class/Posts/posts';
import { Relations } from 'src/app/Class/Relations/relations';
import { Roles } from 'src/app/Class/Roles/roles';
import { Users } from 'src/app/Class/Users/users';
import { Likes } from 'src/app/Class/Likes/likes';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  user: Users = new Users("","","","",false,"","","","","");
  roles: Roles[];
  admin: Boolean = false;
  loginIn: Boolean = false;

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
    return this.http.get<Users[]>("/api/users/");
  }

  registerUser(user: Users) {
    return this.http.post("/api/users/", user);
  }

  getUsersPage(page: String) {
    return this.http.get("/api/users/?page=" + page);
  }

  getUser(id: String) {
    return this.http.get<Users>("/api/users/" + id);
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

  uploadImageProfile(id: String, image: FormData) {
    return this.http.post("/api/users/" + id + "/imageProfile",image);
  }

  uploadThemeProfile(id: String, image: FormData) {
    return this.http.post("/api/users/" + id + "/imageThemeProfile",image);
  }

  getPosts(id: String) {
    return this.http.get("/api/users/" + id + "/posts");
  }

  getProducts(id: String) {
    return this.http.get("/api/users/" + id + "/products");
  }

  getUserFollowings(id: String) {
    return this.http.get<Relations[]>("/api/users/" + id + "/followings");
  }

  getUserFollowers(id: String) {
    return this.http.get<Relations[]>("/api/users/" + id + "/followers");
  }

  getBookmarks(id: String) {
    return this.http.get("/api/users/" + id + "/bookmarks");
  }

  getLikes(id: String) {
    return this.http.get<Likes[]>("/api/users/" + id + "/likes");
  }


  getRoles(id: Number) {
    return this.http.get<Roles[]>("/api/users/" + id + "/rols");
  }

  setAdmin(admin: boolean){
    this.admin =admin;
  }

  setLogin(login: boolean){
    this.loginIn = login;
  }

  getAdmin(): Boolean{
    return this.admin;
  }

  getLogin(): Boolean{
    return this.loginIn;
  }

  setUserInfo(user : Users){
    this.user = user;
  }

  getUserInfo(): Users{
    return this.user;
  }
  
}
