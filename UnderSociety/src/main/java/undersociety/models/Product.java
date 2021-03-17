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

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idproduct;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@Column
	private String title;
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
	@Column
	private int price;
	@OneToOne
	@JoinColumn(name = "idtagone", referencedColumnName = "idtags")
	private Tags idtagone;
	@OneToOne
	@JoinColumn(name = "idtagtwo", referencedColumnName = "idtags")
	private Tags idtagtwo;
	@OneToOne
	@JoinColumn(name = "idtagthree", referencedColumnName = "idtags")
	private Tags idtagthree;
	@OneToOne
	@JoinColumn(name = "idtagfour", referencedColumnName = "idtags")
	private Tags idtagfour;
	@OneToOne
	@JoinColumn(name = "idtagfive", referencedColumnName = "idtags")
	private Tags idtagfive;
	@Column
	private String status;
	@Column
	private Boolean img0;
	@Column
	private Boolean img1;
	@Column
	private Boolean img2;
	
	
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
