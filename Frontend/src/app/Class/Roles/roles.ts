import { Users } from "../Users/users";

export class Roles {

    private idroles : Number;
    private rol : String;
    private iduser : Users;

    constructor( idroles: Number,  rol: String,  iduser: Users) {
		this.idroles =  idroles;
		this.rol =  rol;
		this.iduser =  iduser;
	}

	public getIdroles(): Number {
		return this.idroles;
	}

	public getRol(): String {
		return this.rol;
	}

	public getIduser(): Users {
		return this.iduser;
	}

	public setIdroles(value: Number) {
		this.idroles = value;
	}

	public setRol(value: String) {
		this.rol = value;
	}

	public setIduser(value: Users) {
		this.iduser = value;
	}

}
