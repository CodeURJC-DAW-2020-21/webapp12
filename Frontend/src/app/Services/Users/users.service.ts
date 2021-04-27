import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Posts } from 'src/app/Class/Posts/posts';
import { Relations } from 'src/app/Class/Relations/relations';
import { Roles } from 'src/app/Class/Roles/roles';
import { Users } from 'src/app/Class/Users/users';
import { Likes } from 'src/app/Class/Likes/likes';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { ProductsModel } from 'src/app/Class/Models/products-model';
import { PostsModel } from 'src/app/Class/Models/posts-model';
import { Message } from 'src/app/Class/Messages/message';
import { Messages } from 'src/app/Class/Models/messages';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private user: Users = new Users;
  private admin: Boolean = false;
  private loginIn: Boolean = false;

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
    return this.http.post<Users>("/api/users/", user);
  }

  getUsersPage(page: String) {
    return this.http.get<Users[]>("/api/users/?page=" + page);
  }

  getUser(id: String) {
    return this.http.get<Users>("/api/users/" + id);
  }

  replaceUser(id: String, user: Users) {
    return this.http.put<Users>("/api/users/" + id, user);
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
    return this.http.get<Users[]>("/api/users/customers?page="+id+"&size=10&sort=username&direction=asc");
  }

  getUserCompaniesPage(id : Number) {
    return this.http.get<Users[]>("/api/users/companies?page="+id+"&size=10&sort=username&direction=asc");
  }

  uploadImageProfile(id: String, image: FormData) {
    return this.http.post("/api/users/" + id + "/imageProfile",image);
  }

  uploadThemeProfile(id: String, image: FormData) {
    return this.http.post("/api/users/" + id + "/imageThemeProfile",image);
  }

  getPosts(id: String) {
    return this.http.get<Posts[]>("/api/users/" + id + "/posts");
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
    return this.http.get<Bookmarks[]>("/api/users/" + id + "/bookmarks");
  }

  getLikes(id: String) {
    return this.http.get<Likes[]>("/api/users/" + id + "/likes");
  }


  getRoles(id: Number) {
    return this.http.get<Roles[]>("/api/users/" + id + "/rols");
  }

  getProductModels(id: Number, page:Number) {
    return this.http.get<ProductsModel[]>("/api/users/" + id + "/models/products?page="+page);
  }

  getProductModelsUserPage(id: Number, page:Number, username:String) {
    return this.http.get<ProductsModel[]>("/api/users/" + id + "/models/products?page="+page+"&username="+username);
  }

  getPostModels(id: Number, page:Number) {
    return this.http.get<PostsModel[]>("/api/users/" + id + "/models/posts?page="+page);
  }

  getPostModelsUserPage(id: Number, page:Number, username:String) {
    return this.http.get<PostsModel[]>("/api/users/" + id + "/models/posts?page="+page+"&username="+username);
  }

  getRanking() {
    return this.http.get<Users[]>("/api/users/ranking");
  }

  getChats(id: Number,username:String) {
    return this.http.get<Messages[]>("/api/users/"+id+"/chat?username="+username);
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
