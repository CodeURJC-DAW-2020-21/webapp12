import { Product } from "../Product/product";
import { Users } from "../Users/users";

export class Bookmarks {
    private idproductlist : Number;
    private iduser : Users;
    private idproduct : Product;

	constructor( idproductlist: Number,  iduser: Users,  idproduct: Product) {
		this.idproductlist =  idproductlist;
		this.iduser =  iduser;
		this.idproduct =  idproduct;
	}

	public getIdproductlist(): Number {
		return this.idproductlist;
	}

	public getIduser(): Users {
		return this.iduser;
	}

	public getIdproduct(): Product {
		return this.idproduct;
	}

	public setIdproductlist(value: Number) {
		this.idproductlist = value;
	}

	public setIduser(value: Users) {
		this.iduser = value;
	}

	public setIdproduct(value: Product) {
		this.idproduct = value;
	}
}
