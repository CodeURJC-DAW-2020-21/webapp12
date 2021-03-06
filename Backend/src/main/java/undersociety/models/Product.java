package undersociety.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="product")
public class Product {
	
	public interface Simple{}
	public interface Multiple{}
	public interface ProductDetails extends Product.Simple, Product.Multiple, Users.Basic, Tags.Simple{}

	
	@JsonView(Simple.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproduct;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@JsonView(Simple.class)
	@Column
	private String title;
	@JsonView(Simple.class)
	@Column
	private String description;
	@Lob
	@JsonIgnore
	private Blob image0;
	@Lob
	@JsonIgnore
	private Blob image1;
	@Lob
	@JsonIgnore
	private Blob image2;
	@JsonView(Simple.class)
	@Column
	private int price;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "idtagone", referencedColumnName = "idtags")
	private Tags idtagone;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "idtagtwo", referencedColumnName = "idtags")
	private Tags idtagtwo;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "idtagthree", referencedColumnName = "idtags")
	private Tags idtagthree;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "idtagfour", referencedColumnName = "idtags")
	private Tags idtagfour;
	@JsonView(Multiple.class)
	@OneToOne
	@JoinColumn(name = "idtagfive", referencedColumnName = "idtags")
	private Tags idtagfive;
	@JsonView(Simple.class)
	@Column
	private String status;
	@JsonView(Simple.class)
	@Column
	private Boolean img0;
	@JsonView(Simple.class)
	@Column
	private Boolean img1;
	@JsonView(Simple.class)
	@Column
	private Boolean img2;
	
	
	
	public Product() {}
	public Product(Users iduser, String title, String description, Blob image0, Blob image1, Blob image2, int price,
			Tags idtagone, Tags idtagtwo, Tags idtagthree, Tags idtagfour, Tags idtagfive, String status, Boolean img0,
			Boolean img1, Boolean img2) {
		super();
		this.iduser = iduser;
		this.title = title;
		this.description = description;
		this.image0 = image0;
		this.image1 = image1;
		this.image2 = image2;
		this.price = price;
		this.idtagone = idtagone;
		this.idtagtwo = idtagtwo;
		this.idtagthree = idtagthree;
		this.idtagfour = idtagfour;
		this.idtagfive = idtagfive;
		this.status = status;
		this.img0 = img0;
		this.img1 = img1;
		this.img2 = img2;
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getImage0() {
		return image0;
	}
	public void setImage0(Blob image0) {
		this.image0 = image0;
	}
	public Blob getImage1() {
		return image1;
	}
	public void setImage1(Blob image1) {
		this.image1 = image1;
	}
	public Blob getImage2() {
		return image2;
	}
	public void setImage2(Blob image2) {
		this.image2 = image2;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Tags getIdtag() {
		return idtagone;
	}
	public void setIdtag(Tags idtag) {
		this.idtagone = idtag;
	}
	public Tags getIdtagtwo() {
		return idtagtwo;
	}
	public void setIdtagtwo(Tags idtagtwo) {
		this.idtagtwo = idtagtwo;
	}
	public Tags getIdtagthree() {
		return idtagthree;
	}
	
	public Tags getIdtagfour() {
		return idtagfour;
	}
	public void setIdtagfour(Tags idtagfour) {
		this.idtagfour = idtagfour;
	}
	public Tags getIdtagfive() {
		return idtagfive;
	}
	public void setIdtagfive(Tags idtagfive) {
		this.idtagfive = idtagfive;
	}
	public void setIdtagthree(Tags idtagthree) {
		this.idtagthree = idtagthree;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Boolean getImg0() {
		return img0;
	}
	public void setImg0(Boolean img0) {
		this.img0 = img0;
	}
	public Boolean getImg1() {
		return img1;
	}
	public void setImg1(Boolean img1) {
		this.img1 = img1;
	}
	public Boolean getImg2() {
		return img2;
	}
	public void setImg2(Boolean img2) {
		this.img2 = img2;
	}
}
