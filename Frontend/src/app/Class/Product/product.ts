import { Tags } from "../Tags/tags";
import { Users } from "../Users/users";

export class Product {
    private idproduct : Number;
    private iduser : Users;
    private title : String;
    private description : String;
    private idtagone : Tags;
    private idtagtwo : Tags;
    private idtagthree : Tags;
    private idtagfour : Tags;
    private idtagfive : Tags;
    private status : String;
    private img0 : Boolean;
    private img1 : Boolean;
    private img2 : Boolean;

	constructor( idproduct: Number,  iduser: Users,  title: String,  description: String,  idtagone: Tags,  idtagtwo: Tags,  idtagthree: Tags,  idtagfour: Tags,  idtagfive: Tags,  status: String,  img0: Boolean,  img1: Boolean,  img2: Boolean) {
		this.idproduct =  idproduct;
		this.iduser =  iduser;
		this.title =  title;
		this.description =  description;
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

	public getIdproduct(): Number {
		return this.idproduct;
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

	public getIdtagone(): Tags {
		return this.idtagone;
	}

	public getIdtagtwo(): Tags {
		return this.idtagtwo;
	}

	public getIdtagthree(): Tags {
		return this.idtagthree;
	}

	public getIdtagfour(): Tags {
		return this.idtagfour;
	}

	public getIdtagfive(): Tags {
		return this.idtagfive;
	}

	public getStatus(): String {
		return this.status;
	}

	public getImg0(): Boolean {
		return this.img0;
	}

	public getImg1(): Boolean {
		return this.img1;
	}

	public getImg2(): Boolean {
		return this.img2;
	}

	public setIdproduct(value: Number) {
		this.idproduct = value;
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

	public setIdtagone(value: Tags) {
		this.idtagone = value;
	}

	public setIdtagtwo(value: Tags) {
		this.idtagtwo = value;
	}

	public setIdtagthree(value: Tags) {
		this.idtagthree = value;
	}

	public setIdtagfour(value: Tags) {
		this.idtagfour = value;
	}

	public setIdtagfive(value: Tags) {
		this.idtagfive = value;
	}

	public setStatus(value: String) {
		this.status = value;
	}

	public setImg0(value: Boolean) {
		this.img0 = value;
	}

	public setImg1(value: Boolean) {
		this.img1 = value;
	}

	public setImg2(value: Boolean) {
		this.img2 = value;
	}

}
