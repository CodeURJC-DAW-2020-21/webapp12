package undersociety.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column
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
<<<<<<< HEAD
	@JoinColumn(name = "idtag", referencedColumnName = "idtag")
	private Tags idtag;
	@OneToOne
	@JoinColumn(name = "idtagtwo", referencedColumnName = "idtag")
	private Tags idtagtwo;
	@OneToOne
	@JoinColumn(name = "idtagthree", referencedColumnName = "idtag")
=======
	@JoinColumn(name = "idtagone", referencedColumnName = "idtags")
	private Tags idtagone;
	@OneToOne
	@JoinColumn(name = "idtagtwo", referencedColumnName = "idtags")
	private Tags idtagtwo;
	@OneToOne
	@JoinColumn(name = "idtagthree", referencedColumnName = "idtags")
>>>>>>> SpringAppIndexPage
	private Tags idtagthree;
	@Column
	private String status;
	
	
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
<<<<<<< HEAD
		return idtag;
	}
	public void setIdtag(Tags idtag) {
		this.idtag = idtag;
=======
		return idtagone;
	}
	public void setIdtag(Tags idtag) {
		this.idtagone = idtag;
>>>>>>> SpringAppIndexPage
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
	public void setIdtagthree(Tags idtagthree) {
		this.idtagthree = idtagthree;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void view() {
		System.out.println();
		System.out.println(iduser);
		System.out.println(title);
		System.out.println(description);
		System.out.println(image0);
		System.out.println(image1);
		System.out.println(image2);
		System.out.println(price);
<<<<<<< HEAD
		System.out.println(idtag);
=======
		System.out.println(idtagone);
>>>>>>> SpringAppIndexPage
		System.out.println(idtagtwo);
		System.out.println(idtagthree);
		System.out.println(status);
		System.out.println();
	}
}
