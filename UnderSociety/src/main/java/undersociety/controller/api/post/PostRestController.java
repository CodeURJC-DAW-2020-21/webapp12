package undersociety.controller.api.post;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;


import io.swagger.v3.oas.annotations.Parameter;

import undersociety.models.Post;
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
	
	@GetMapping("/{id}/image")
	public ResponseEntity<Object> getPostImage( @Parameter(description="id of Post to be searched") @PathVariable int id) throws SQLException{
		Optional<Post> post = postService.getPostById(id);
		if(post.isPresent()) {
			if(post.get().getImage() != null) {
				Resource file = new InputStreamResource(post.get().getImage().getBinaryStream());
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
						.contentLength(post.get().getImage().length())
						.body(file);
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/{id}/image")
	public ResponseEntity<Object> uploadPostImage( @Parameter(description="id of Post to be searched") @PathVariable int id, @Parameter(description="Image Post") @RequestParam() MultipartFile image) throws SQLException, IOException{
		Optional<Post> post = postService.getPostById(id);
		if(post.isPresent()) {
			if(image != null) {
				post.get().setImage(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
				postService.savePost(post.get());
				URI location = fromCurrentRequest().build().toUri();
				return ResponseEntity.created(location).build();
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

	