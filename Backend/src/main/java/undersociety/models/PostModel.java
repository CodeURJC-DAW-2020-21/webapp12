package undersociety.models;

import com.fasterxml.jackson.annotation.JsonView;

public class PostModel {
	
	public interface Basic extends Post.PostDetails{}
	
	@JsonView(Basic.class)
	private String typeUser;
	@JsonView(Basic.class)
	private String like;
	@JsonView(Basic.class)
	private Post post;
	
	
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
