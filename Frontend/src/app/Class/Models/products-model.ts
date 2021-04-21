import { Product } from "../Product/product";

export class ProductsModel {
    private typeUser : String;
    private color : String;
    private bookamark : String;
    private product : Product;

	constructor( typeUser: String,  color: String,  bookamark: String,  product: Product) {
		this.typeUser =  typeUser;
		this.color =  color;
		this.bookamark =  bookamark;
		this.product =  product;
	}

	public getTypeUser(): String {
		return this.typeUser;
	}

	public getColor(): String {
		return this.color;
	}

	public getBookamark(): String {
		return this.bookamark;
	}

	public getProduct(): Product {
		return this.product;
	}
}
