package undersociety.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import undersociety.models.ListProducts.ProductDetails;
import undersociety.models.Post.Simple;

@Entity
@Table(name = "Post_likes")
public class LikeAPost {
	
	public interface PostDetails extends Post.Simple, Post.Multiple, Users.Basic{}
	public interface Basic extends PostDetails, Users.Basic{}
	
	@JsonView(Simple.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlike;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "idpost", referencedColumnName = "idpost")
	private Post idpost;
	
	
	public LikeAPost() {}
	public LikeAPost(Users iduser, Post idpost) {
		super();
		this.iduser = iduser;
		this.idpost = idpost;
	}
	public int getIdlike() {
		return idlike;
	}
	public void setIdlike(int idlike) {
		this.idlike = idlike;
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
