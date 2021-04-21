export class Statistics {

    private electronics : Number;
	private furnitures : Number;
	private appliances : Number;
	private books : Number;
	private clothes : Number;
	private instock : Number;
	private sold : Number;
	private reserved : Number;
	private totalUsers : Number;
	private users : Number;
	private admins : Number;
	private earnings : Number;
	private products : Number;
	private posts : Number;
	private customers : Number;
	private companies : Number;

	constructor( electronics: Number,  furnitures: Number,  appliances: Number,  books: Number,  clothes: Number,  instock: Number,  sold: Number,  reserved: Number,  totalUsers: Number,  users: Number,  admins: Number,  earnings: Number,  products: Number,  posts: Number,  customers: Number,  companies: Number) {
		this.electronics =  electronics;
		this.furnitures =  furnitures;
		this.appliances =  appliances;
		this.books =  books;
		this.clothes =  clothes;
		this.instock =  instock;
		this.sold =  sold;
		this.reserved =  reserved;
		this.totalUsers =  totalUsers;
		this.users =  users;
		this.admins =  admins;
		this.earnings =  earnings;
		this.products =  products;
		this.posts =  posts;
		this.customers =  customers;
		this.companies =  companies;
	}


	public getElectronics(): Number {
		return this.electronics;
	}

	public getFurnitures(): Number {
		return this.furnitures;
	}

	public getAppliances(): Number {
		return this.appliances;
	}

	public getBooks(): Number {
		return this.books;
	}

	public getClothes(): Number {
		return this.clothes;
	}

	public getInstock(): Number {
		return this.instock;
	}

	public getSold(): Number {
		return this.sold;
	}

	public getReserved(): Number {
		return this.reserved;
	}

	public getTotalUsers(): Number {
		return this.totalUsers;
	}
   
	public getUsers(): Number {
		return this.users;
	}

	public getAdmins(): Number {
		return this.admins;
	}

	public getEarnings(): Number {
		return this.earnings;
	}

	public getProducts(): Number {
		return this.products;
	}

	public getPosts(): Number {
		return this.posts;
	}

	public getCustomers(): Number {
		return this.customers;
	}

	public getCompanies(): Number {
		return this.companies;
	}
}
