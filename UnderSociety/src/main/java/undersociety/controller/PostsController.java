package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.LikeAPost;
import undersociety.models.Post;
import undersociety.services.PostsService;

@RestController
public class PostsController {
	
	@Autowired
	 private PostsService postService;
			
	
	@PostMapping("/uploadPost")
	private void uploadPost(Model model,HttpServletResponse response, HttpServletRequest request,Post post,  @RequestParam(required = false) MultipartFile imag0) throws IOException {
		postService.savePost(request.getUserPrincipal().getName(), post, imag0);
		response.sendRedirect("/index");
	}
	
	@GetMapping("/getPosts")
	private Page<Post> getPosts(Pageable page){
		return postService.getPosts(page);
	}
	
	@GetMapping("/getMorePosts")
	private Page<Post> getMorePost(Pageable page){
		return postService.getPosts(page);
	}
	
	@GetMapping("/getMorePostsUser")
	private Page<Post> getMorePostUser(Pageable page, @RequestParam String username){
		return postService.getPostsByUsername(username, page);
	}
	
	@GetMapping("/imagepost/{idpost}")
    private ResponseEntity<Object> downloadImagePost( @PathVariable int idpost) throws SQLException, IOException{
		Post p = postService.getPost(idpost);
    	Resource file = new InputStreamResource(p.getImage().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage().length())
				.body(file);
    }
	
	@PostMapping("/likePost")
	public boolean likePost(@RequestParam int idpost, HttpServletRequest request){
		boolean win = true;
		postService.likePost(request.getUserPrincipal().getName(), idpost);
		return win;
	}
	
	@PostMapping("/unlikePost")
	public boolean unlikePost(@RequestParam int idpost, HttpServletRequest request){
		boolean win = true;
		postService.unLikePosts(request.getUserPrincipal().getName(), idpost);
		return win;
	}
	
	@GetMapping("/getLikes")
	public List<LikeAPost> getLikes(HttpServletRequest request) {
		return postService.getLikes(request.getUserPrincipal().getName());
	}
}
