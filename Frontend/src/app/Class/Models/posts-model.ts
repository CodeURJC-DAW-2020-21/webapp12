import { Posts } from "../Posts/posts";

export class PostsModel {
    private typeUser : String;
    private like : String;
    private post : Posts;

	constructor( typeUser: String,  like: String,  post: Posts) {
		this.typeUser =  typeUser;
		this.like =  like;
		this.post =  post;
	}

	public getTypeUser(): String {
		return this.typeUser;
	}

	public getLike(): String {
		return this.like;
	}

	public getPost(): Posts {
		return this.post;
	}

	public setTypeUser(value: String) {
		this.typeUser = value;
	}

	public setLike(value: String) {
		this.like = value;
	}

	public setPost(value: Posts) {
		this.post = value;
	}

}
