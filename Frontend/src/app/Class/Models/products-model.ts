import { Product } from "../Product/product";

export class ProductsModel {
    typeUser : String;
    color : String;
    bookamark : String;
    product : Product;

	constructor( typeUser: String,  color: String,  bookamark: String,  product: Product) {
		this.typeUser =  typeUser;
		this.color =  color;
		this.bookamark =  bookamark;
		this.product =  product;
	}
}
