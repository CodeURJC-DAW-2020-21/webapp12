package undersociety.models;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< develop
=======
import javax.persistence.JoinColumn;
<<<<<<< develop
>>>>>>> fixes to posts and product
=======
import javax.persistence.Lob;
>>>>>>> Created all database models
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< develop
	private int id_post;
	@OneToOne
	private Users id_user;
	private String title;
	private String description;
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public Users getId_user() {
		return id_user;
	}
	public void setId_user(Users id_user) {
		this.id_user = id_user;
=======
	private int idpost;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@Column
	private String title;
	@Column
	private String description;
	@Lob
	@JsonIgnore
	private Blob image;
	
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
>>>>>>> fixes to posts and product
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	
	public void view() {
		System.out.println();
		System.out.println(iduser);
		System.out.println(title);
		System.out.println(description);
		System.out.println(image);
		System.out.println();
	}
}
