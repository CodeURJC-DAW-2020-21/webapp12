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
import undersociety.models.Post;
import undersociety.models.Users;
import undersociety.services.PostsService;

@RestController
@CrossOrigin
@RequestMapping("api/post")
public class PostRestController {
	
	@Autowired
	private PostsService postService;

	
	@JsonView(Post.PostDetails.class)
	@GetMapping("/")
	public List<Post> getAllPosts(){
		return postService.getAll();
	}
	
	@JsonView(Post.PostDetails.class)
	@PostMapping("/")
	public ResponseEntity<Post> registerPost( @Parameter(description="Object Type Post") @RequestBody Post post) throws IOException{
		postService.savePost(post); 
		post = postService.getPostByTitle(post.getTitle());
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getIdpost()).toUri();
		return ResponseEntity.created(location).body(post);
	}
	
	@JsonView(Post.PostDetails.class)
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost ( @Parameter(description="id of Post to be searched") @PathVariable int id) throws IOException{
		Optional<Post> post = postService.getPostById(id);
		if(!post.isEmpty()) {
			return ResponseEntity.ok(post.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@JsonView(Post.PostDetails.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletePost( @Parameter(description="id of Post to be searched") @PathVariable int id){
		Optional<Post> post = postService.getPostById(id);
		if(post.isPresent()){
			postService.deletePostbyid(post.get().getIdpost());
			return ResponseEntity.ok(post.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@JsonView(Post.PostDetails.class)
	@PutMapping("/{id}")
	public ResponseEntity<Post> replacePost( @Parameter(description="id of Post to be searched") @PathVariable int id, @Parameter(description="Object Type Post") @RequestBody Post newpost) throws IOException{
		Optional<Post> post = postService.getPostById(id);
		if(!post.isEmpty()) {
			newpost.setIdpost(id);
			postService.savePost(newpost);
			newpost = postService.getPostById(id).get();
			return ResponseEntity.ok(newpost);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

	