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
@Table(name = "post")
public class Post {
	public interface Simple{}
	public interface Multiple{}

	@JsonView(Simple.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpost;
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
	private Blob image;
	
	
	public Post() {}
	public Post(Users iduser, String title, String description, Blob image) {
		super();
		this.iduser = iduser;
		this.title = title;
		this.description = description;
		this.image = image;
	}
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
