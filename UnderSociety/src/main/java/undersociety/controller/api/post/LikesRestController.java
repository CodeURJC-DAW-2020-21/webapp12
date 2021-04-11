package undersociety.controller.api.post;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Parameter;

import undersociety.models.LikeAPost;
import undersociety.services.PostsService;

@RestController
@CrossOrigin
@RequestMapping("api/Like")
public class LikesRestController {
	
	@Autowired
	private PostsService postService;
	
	
	
	@JsonView(LikeAPost.Basic.class)
	@GetMapping("/")
	public List<LikeAPost> getAllLikes(){
		return postService.getAllLikes();
	}
	
	
	@JsonView(LikeAPost.Basic.class)
	@PostMapping("/")
	public ResponseEntity<LikeAPost> registerLike(@Parameter(description="Object Type LikeAPost") @RequestBody LikeAPost like) throws IOException{
		postService.saveLike(like);
		like = postService.getLikesapi(like);
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(like.getIdpost()).toUri();
		return ResponseEntity.created(location).body(like);
	}
	
	
	@JsonView(LikeAPost.Basic.class)
	@GetMapping("/{id}")
	public ResponseEntity<LikeAPost> getbookmark ( @Parameter(description="id of like to be searched") @PathVariable int id) throws IOException{
		Optional<LikeAPost> like = postService.getLikesbyid(id);
		if(!like.isEmpty()) {
			return ResponseEntity.ok(like.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@JsonView(LikeAPost.Basic.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<LikeAPost> deletelike( @Parameter(description="id of like to be searched") @PathVariable int id){
		Optional<LikeAPost> like = postService.getLikesbyid(id);
		if(like.isPresent()){
			postService.deleteLikesbyid(id);
			return ResponseEntity.ok(like.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@JsonView(LikeAPost.Basic.class)
	@PutMapping("/{id}")
	public ResponseEntity<LikeAPost> replacelike( @Parameter(description="id of like to be searched") @PathVariable int id, @Parameter(description="Object Type LikeAPost") @RequestBody LikeAPost newlike) throws IOException{
		Optional<LikeAPost> like = postService.getLikesbyid(id);
		if(!like.isEmpty()) {
			postService.saveLike(newlike);
			newlike = postService.getLikesbyid(id).get();
			return ResponseEntity.ok(newlike);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}