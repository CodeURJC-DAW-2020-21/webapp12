import { Posts } from "../Posts/posts";

export class PostsModel {
     typeUser : String;
     like : String;
     post : Posts;

	constructor( typeUser: String,  like: String,  post: Posts) {
		this.typeUser =  typeUser;
		this.like =  like;
		this.post =  post;
	}

}
