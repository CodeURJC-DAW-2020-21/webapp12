import { Posts } from "../Posts/posts";
import { Users } from "../Users/users";

export class Likes {
    private idlike : Number;
    private iduser : Users;
    private idpost : Posts;

	constructor( idlike: Number,  iduser: Users,  idpost: Posts) {
		this.idlike =  idlike;
		this.iduser =  iduser;
		this.idpost =  idpost;
	}

	public getIdlike(): Number {
		return this.idlike;
	}

	public getIduser(): Users {
		return this.iduser;
	}

	public getIdpost(): Posts {
		return this.idpost;
	}

	public setIdlike(value: Number) {
		this.idlike = value;
	}

	public setIduser(value: Users) {
		this.iduser = value;
	}

	public setIdpost(value: Posts) {
		this.idpost = value;
	}

}
