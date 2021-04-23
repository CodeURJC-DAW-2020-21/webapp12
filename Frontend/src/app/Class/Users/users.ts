export class Users {
     idusers: Number;
     email : String;
     username : String;
     pass : String;
     name : String;
     companyprofile : boolean;
     city : String;
     userinfo : String;
     linkfacebook : String;
     linktwitter : String;
     linkinstagram : String;

	constructor(email : String, username : String, pass : String, name : String, companyprofile : boolean, city : String, userinfo : String, linkfacebook : String, linktwitter : String, linkinstagram : String) {
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.companyprofile = companyprofile;
        this.city = city;
        this.userinfo = userinfo;
        this.linkfacebook = linkfacebook;
        this.linktwitter = linktwitter;
        this.linkinstagram = linkinstagram;
    }
    
}
