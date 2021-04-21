import { Users } from "../Users/users";

export class Relations {

    private iduserrelation : Number;
    private userone : Users;
    private usertwo : Users;

    constructor( iduserrelation: Number,  userone: Users,  usertwo: Users) {
		this.iduserrelation =  iduserrelation;
		this.userone =  userone;
		this.usertwo =  usertwo;
	}

	public getIduserrelation(): Number {
		return this.iduserrelation;
	}

	public getUserone(): Users {
		return this.userone;
	}

	public getUsertwo(): Users {
		return this.usertwo;
	}

	public setIduserrelation(value: Number) {
		this.iduserrelation = value;
	}

	public setUserone(value: Users) {
		this.userone = value;
	}

	public setUsertwo(value: Users) {
		this.usertwo = value;
	}

}
