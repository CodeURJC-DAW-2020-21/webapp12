import { Posts } from "../Posts/posts";
import { Users } from "../Users/users";

export class Likes {
     idlike : Number;
     iduser : Users;
     idpost : Posts;

	constructor( idlike: Number,  iduser: Users,  idpost: Posts) {
		this.idlike =  idlike;
		this.iduser =  iduser;
		this.idpost =  idpost;
	}
}
