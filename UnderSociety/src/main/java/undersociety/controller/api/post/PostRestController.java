package undersociety.controller.api.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import undersociety.models.Post;
import undersociety.models.Users;
import undersociety.services.PostsService;

@RestController
@CrossOrigin
@RequestMapping("api/post")
public class PostRestController {
	
	@Autowired
	private PostsService postService;
	public interface PostDetails extends Post.Simple, Post.Multiple, Users.Basic{}
	
	@JsonView(PostDetails.class)
	@GetMapping("/")
	public List<Post> getAllPosts(){
		return postService.getAll();
	}

}
