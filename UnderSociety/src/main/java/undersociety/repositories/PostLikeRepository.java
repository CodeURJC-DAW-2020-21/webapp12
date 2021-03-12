package undersociety.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, Integer>{

}
