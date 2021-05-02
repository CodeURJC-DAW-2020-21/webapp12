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
}
