package undersociety.models;

import com.fasterxml.jackson.annotation.JsonView;

import undersociety.models.PostModel.Basic;

public class ProductModel {
	
	public interface Basic extends Product.ProductDetails{}
	
	@JsonView(Basic.class)
	private String typeUser;
	@JsonView(Basic.class)
	private String color;
	@JsonView(Basic.class)
	private String bookamark;
	@JsonView(Basic.class)
	private Product product;
	
	
	
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBookamark() {
		return bookamark;
	}
	public void setBookamark(String bookamark) {
		this.bookamark = bookamark;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
