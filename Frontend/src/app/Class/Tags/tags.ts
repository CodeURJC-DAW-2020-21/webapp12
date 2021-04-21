export class Tags {
    private idtags : Number;
    private description : String;

    constructor(idtags : Number, description : String){
        this.idtags = idtags;
        this.description = description;
    }

    public getIdtags(): Number {
        return this.idtags;
    }

    public setIdtags(value: Number) {
        this.idtags = value;
    }

    public getDescription(): String {
        return this.description;
    }

    public setDescription(value: String) {
        this.description = value;
    }

}
