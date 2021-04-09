package undersociety.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import undersociety.models.Product.Simple;

@Entity
@Table(name="tags")
public class Tags {
	
	public interface Simple{}
	
	@JsonView(Simple.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtags;
	@Column
	@JsonView(Simple.class)
	private String description;
	
	
	public Tags() {}
	public Tags(String description) {
		super();
		this.description = description;
	}
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
