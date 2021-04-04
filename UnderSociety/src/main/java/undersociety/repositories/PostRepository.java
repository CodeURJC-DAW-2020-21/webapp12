package undersociety.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Post;
import undersociety.models.Users;


public interface PostRepository extends JpaRepository<Post, Integer>{
	public Page<Post> findByiduser(Users iduser, Pageable page);
	public Long deleteByIduser(Users iduser);
	public List<Post> findByiduser(Users user);
}
