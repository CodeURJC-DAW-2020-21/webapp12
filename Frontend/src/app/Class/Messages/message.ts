import { Users } from "../Users/users";

export class Message {
    private idmessage : Number;
    private iduser : Users;
    private iduserto : Users;
    private message : String;
    private time : String;

	constructor( idmessage: Number,  iduser: Users,  iduserto: Users,  message: String,  time: String) {
		this.idmessage =  idmessage;
		this.iduser =  iduser;
		this.iduserto =  iduserto;
		this.message =  message;
		this.time =  time;
	}

	public getIdmessage(): Number {
		return this.idmessage;
	}

	public getIduser(): Users {
		return this.iduser;
	}

	public getIduserto(): Users {
		return this.iduserto;
	}

	public getMessage(): String {
		return this.message;
	}

	public getTime(): String {
		return this.time;
	}

	public setIdmessage(value: Number) {
		this.idmessage = value;
	}

	public setIduser(value: Users) {
		this.iduser = value;
	}

	public setIduserto(value: Users) {
		this.iduserto = value;
	}

	public setMessage(value: String) {
		this.message = value;
	}

	public setTime(value: String) {
		this.time = value;
	}
}
