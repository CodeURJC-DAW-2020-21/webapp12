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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import undersociety.models.LikeAPost;
import undersociety.services.PostsService;

@RestController
@CrossOrigin
@RequestMapping("api/likes")
public class LikesRestController {
	
	@Autowired
	private PostsService postService;
	
	
	@Operation(summary = "Get a all Likes")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Likes", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(LikeAPost.Basic.class)
	@GetMapping("/")
	public List<LikeAPost> getAllLikes(){
		return postService.getAllLikes();
	}
	
	@Operation(summary = "Create Like")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful Like creation", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 )  
	})
	@JsonView(LikeAPost.Basic.class)
	@PostMapping("/")
	public ResponseEntity<LikeAPost> registerLike(@Parameter(description="Object Type LikeAPost") @RequestBody LikeAPost like) throws IOException{
		postService.saveLike(like);
		like = postService.getLikesapi(like);
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(like.getIdpost()).toUri();
		return ResponseEntity.created(location).body(like);
	}
	
	@Operation(summary = "Get a Like by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Like", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Like not found", 
	 content = @Content
	 )  
	})
	@JsonView(LikeAPost.Basic.class)
	@GetMapping("/{id}")
	public ResponseEntity<LikeAPost> getlike ( @Parameter(description="id of like to be searched") @PathVariable int id) throws IOException{
		Optional<LikeAPost> like = postService.getLikesbyid(id);
		if(!like.isEmpty()) {
			return ResponseEntity.ok(like.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Delete a Like")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Successful Like delete", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Like not found", 
	 content = @Content
	 ) 
	})
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
	
}