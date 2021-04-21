import { Users } from "../Users/users";

export class Posts {

    private idpost : Number;
    private iduser : Users;
    private title : String;
    private description : String;

	constructor( idpost: Number,  iduser: Users,  title: String,  description: String) {
		this.idpost =  idpost;
		this.iduser =  iduser;
		this.title =  title;
		this.description =  description;
	}

	public getIdpost(): Number {
		return this.idpost;
	}

	public getIduser(): Users {
		return this.iduser;
	}

	public getTitle(): String {
		return this.title;
	}

	public getDescription(): String {
		return this.description;
	}

	public setIdpost(value: Number) {
		this.idpost = value;
	}

	public setIduser(value: Users) {
		this.iduser = value;
	}

	public setTitle(value: String) {
		this.title = value;
	}

	public setDescription(value: String) {
		this.description = value;
	}
}
