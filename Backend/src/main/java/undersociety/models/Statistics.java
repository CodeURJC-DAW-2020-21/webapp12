package undersociety.models;

public class Statistics {

	private double electronics = 0;
	private double furnitures = 0;
	private double appliances = 0;
	private double books = 0;
	private double clothes = 0;
	private double instock = 0;
	private double sold = 0;
	private double reserved = 0;
	private double totalUsers = 0;
	private double users = 0;
	private double admins = 0;
	private int earnings = 0;
	private int products = 0;
	private int posts = 0;
	private int customers = 0;
	private int companies = 0;
	
	public Statistics(double electronics, double furnitures, double appliances, double books, double clothes,
			double instock, double sold, double reserved, double totalUsers, double users, double admins, int earnings,
			int products, int posts, int customers, int companies) {
		super();
		this.electronics = electronics;
		this.furnitures = furnitures;
		this.appliances = appliances;
		this.books = books;
		this.clothes = clothes;
		this.instock = instock;
		this.sold = sold;
		this.reserved = reserved;
		this.totalUsers = totalUsers;
		this.users = users;
		this.admins = admins;
		this.earnings = earnings;
		this.products = products;
		this.posts = posts;
		this.customers = customers;
		this.companies = companies;
	}

	public double getElectronics() {
		return electronics;
	}

	public void setElectronics(double electronics) {
		this.electronics = electronics;
	}

	public double getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(double furnitures) {
		this.furnitures = furnitures;
	}

	public double getAppliances() {
		return appliances;
	}

	public void setAppliances(double appliances) {
		this.appliances = appliances;
	}

	public double getBooks() {
		return books;
	}

	public void setBooks(double books) {
		this.books = books;
	}

	public double getClothes() {
		return clothes;
	}

	public void setClothes(double clothes) {
		this.clothes = clothes;
	}

	public double getInstock() {
		return instock;
	}

	public void setInstock(double instock) {
		this.instock = instock;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public double getReserved() {
		return reserved;
	}

	public void setReserved(double reserved) {
		this.reserved = reserved;
	}

	public double getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(double totalUsers) {
		this.totalUsers = totalUsers;
	}

	public double getUsers() {
		return users;
	}

	public void setUsers(double users) {
		this.users = users;
	}

	public double getAdmins() {
		return admins;
	}

	public void setAdmins(double admins) {
		this.admins = admins;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public int getProducts() {
		return products;
	}

	public void setProducts(int products) {
		this.products = products;
	}

	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public int getCustomers() {
		return customers;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}

	public int getCompanies() {
		return companies;
	}

	public void setCompanies(int companies) {
		this.companies = companies;
	}
	
}
