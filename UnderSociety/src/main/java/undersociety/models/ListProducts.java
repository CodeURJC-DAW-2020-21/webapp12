package undersociety.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "List_Products")
public class ListProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproductlist;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
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
