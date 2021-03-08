package undersociety.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{

}
