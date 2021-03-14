package undersociety.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_like")
public class PostLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpostlike;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@OneToOne
	@JoinColumn(name = "idpost", referencedColumnName = "idpost")
	private Post idpost;
	
	public int getIdpostlike() {
		return idpostlike;
	}
	public void setIdpostlike(int idpostlike) {
		this.idpostlike = idpostlike;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
	public Post getIdpost() {
		return idpost;
	}
	public void setIdpost(Post idpost) {
		this.idpost = idpost;
	}
}
