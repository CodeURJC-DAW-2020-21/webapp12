import { Users } from "../Users/users";

export class Roles {

    rol : String;

    constructor( rol: String) {
		this.rol =  rol;
	}

	getRol(): String {
		return this.rol;
	}
	
	setRol(value: String) {
		this.rol = value;
	}
}
