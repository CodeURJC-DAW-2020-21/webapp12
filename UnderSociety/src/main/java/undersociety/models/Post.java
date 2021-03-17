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
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
