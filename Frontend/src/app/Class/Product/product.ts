import { Tags } from "../Tags/tags";
import { Users } from "../Users/users";

export class Product {
     idproduct : Number;
     iduser : Users;
     title : String;
     description : String;
	 price : Number;
     idtagone : Tags;
     idtagtwo : Tags;
     idtagthree : Tags;
     idtagfour : Tags;
     idtagfive : Tags;
     status : String;
     img0 : Boolean;
     img1 : Boolean;
     img2 : Boolean;

	constructor( iduser: Users,  title: String,  description: String, price : Number,  idtagone: Tags,  idtagtwo: Tags,  idtagthree: Tags,  idtagfour: Tags,  idtagfive: Tags,  status: String,  img0: Boolean,  img1: Boolean,  img2: Boolean) {
		this.iduser =  iduser;
		this.title =  title;
		this.description =  description;
		this.price =  price;
		this.idtagone =  idtagone;
		this.idtagtwo =  idtagtwo;
		this.idtagthree =  idtagthree;
		this.idtagfour =  idtagfour;
		this.idtagfive =  idtagfive;
		this.status =  status;
		this.img0 =  img0;
		this.img1 =  img1;
		this.img2 =  img2;
	}
}
