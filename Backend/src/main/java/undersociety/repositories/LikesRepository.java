package undersociety.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.LikeAPost;
import undersociety.models.Post;
import undersociety.models.Users;

public interface LikesRepository extends JpaRepository<LikeAPost, Integer>{
	public List<LikeAPost> findByidpost(Post idpost);
	public List<LikeAPost> findByiduser(Users iduser);
	public LikeAPost findByidpostAndIduser(Post idpost, Users iduser);
	public Long deleteByIduser(Users iduser);
	public Long deleteByIdpost (Post idpost);
	public boolean existsIdlikeByiduserAndIdpost(Users iduser, Post idpost);
}
