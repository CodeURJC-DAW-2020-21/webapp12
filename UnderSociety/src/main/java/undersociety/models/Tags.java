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
	private int idtags;
	@Column
	private String description;
	
	public int getIdtag() {
		return idtags;
	}
	public void setIdtag(int idtag) {
		this.idtags = idtag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}