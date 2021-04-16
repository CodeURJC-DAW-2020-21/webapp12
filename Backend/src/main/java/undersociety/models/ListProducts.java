package undersociety.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "List_Products")
public class ListProducts {
	
	public interface ProductDetails extends Product.Simple, Product.Multiple, Users.Basic, Tags.Simple{}
	public interface Basic extends ProductDetails, Users.Basic{}
	
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproductlist;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "idproduct", referencedColumnName = "idproduct")
	private Product idproduct;
	
	
	public ListProducts() {}
	public ListProducts(Users iduser, Product idproduct) {
		super();
		this.iduser = iduser;
		this.idproduct = idproduct;
	}
	public int getIdproductlist() {
		return idproductlist;
	}
	public void setIdproductlist(int idproductlist) {
		this.idproductlist = idproductlist;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
	public Product getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(Product idproduct) {
		this.idproduct = idproduct;
	}
	
	
}
