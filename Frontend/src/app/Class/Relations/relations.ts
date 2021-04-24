import { Users } from "../Users/users";

export class Relations {

    iduserrelation : Number;
    userone : Users;
    usertwo : Users;

    constructor( iduserrelation: Number,  userone: Users,  usertwo: Users) {
		this.iduserrelation =  iduserrelation;
		this.userone =  userone;
		this.usertwo =  usertwo;
	}

}
