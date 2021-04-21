export class Users {
    private idusers: Number;
    private email : String;
    private username : String;
    private pass : String;
    private name : String;
    private city : String;
    private userinfo : String;
    private linkfacebook : String;
    private linktwitter : String;
    private linkinstagram : String;

	constructor(idusers : Number, email : String, username : String, pass : String, name : String, city : String, userinfo : String, linkfacebook : String, linktwitter : String, linkinstagram : String) {
        this.idusers = idusers;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.city = city;
        this.userinfo = userinfo;
        this.linkfacebook = linkfacebook;
        this.linktwitter = linktwitter;
        this.linkinstagram = linkinstagram;
    }
    
    public getIdusers(): Number {
        return this.idusers;
    }

    public setIdusers(value: Number) {
        this.idusers = value;
    }

    public getEmail(): String {
        return this.email;
    }
    
    public setEmail(value: String) {
        this.email = value;
    }

    public getUsername(): String {
        return this.username;
    }
    
    public setUsername(value: String) {
        this.username = value;
    }

    public getPass(): String {
        return this.pass;
    }
    
    public setPass(value: String) {
        this.pass = value;
    }

    public getName(): String {
        return this.name;
    }
    
    public setName(value: String) {
        this.name = value;
    }

    public getCity(): String {
        return this.city;
    }
    
    public setCity(value: String) {
        this.city = value;
    }

    public getUserinfo(): String {
        return this.userinfo;
    }
    
    public setUserinfo(value: String) {
        this.userinfo = value;
    }
    
    public getLinkfacebook(): String {
        return this.linkfacebook;
    }
    
    public setLinkfacebook(value: String) {
        this.linkfacebook = value;
    }

    public getLinktwitter(): String {
        return this.linktwitter;
    }
    
    public setLinktwitter(value: String) {
        this.linktwitter = value;
    }

    public getLinkinstagram(): String {
        return this.linkinstagram;
    }
    
    public setLinkinstagram(value: String) {
        this.linkinstagram = value;
    }
}
