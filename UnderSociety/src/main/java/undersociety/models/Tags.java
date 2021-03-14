package undersociety.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	private int idtag;
=======
	private int idtags;
>>>>>>> SpringAppIndexPage
	@Column
	private String description;
	
	public int getIdtag() {
<<<<<<< HEAD
		return idtag;
	}
	public void setIdtag(int idtag) {
		this.idtag = idtag;
=======
		return idtags;
	}
	public void setIdtag(int idtag) {
		this.idtags = idtag;
>>>>>>> SpringAppIndexPage
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
