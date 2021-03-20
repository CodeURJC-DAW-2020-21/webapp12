package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
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
import undersociety.models.Users;
import undersociety.repositories.LikesRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.UserRepository;

@RestController
public class PostsController {
	
	@Autowired
	 private UserRepository userRepository;
		
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private LikesRepository likerepo;
			
	
	@PostMapping("/api/uploadPost")
	private void uploadPost(Model model,HttpServletResponse response, HttpServletRequest request,Post post,  @RequestParam(required = false) MultipartFile imag0) throws IOException {
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		if(imag0 != null) {
			post.setImage(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
		}
		post.setIduser(s);
		postsrepo.save(post);
		response.sendRedirect("/index");
	}
	
	@GetMapping("/api/getPosts")
	private Page<Post> getPost(Pageable page){
		return postsrepo.findAll(page);
	}
	
	@GetMapping("/api/getMorePosts")
	private Page<Post> getMorePost(Pageable page){
		return postsrepo.findAll(page);
	}
	
	
	@GetMapping("/api/imagepost/{idpost}")
    private ResponseEntity<Object> downloadImagePost( @PathVariable int idpost) throws SQLException, IOException{
		Post p = postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("Post not found"));
    	Resource file = new InputStreamResource(p.getImage().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage().length())
				.body(file);
    }
	
	@PostMapping("/api/likePost")
	public boolean likePost(@RequestParam int idpost, HttpServletRequest request){
		Post p = postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("Post not found"));
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		LikeAPost lp = new LikeAPost();
		lp.setIdpost(p);
		lp.setIduser(s);
		likerepo.save(lp);
		return  true;
	}
	
	@PostMapping("/api/unlikePost")
	public boolean unlikePost(@RequestParam int idpost, HttpServletRequest request){
		Post p = postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("	Post not found"));
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		LikeAPost lp = likerepo.findByidpostAndIduser(p, s);
		if(lp != null) {
			likerepo.deleteById(lp.getIdlike());
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/api/getLikes")
	public List<LikeAPost> getLikes(HttpServletRequest request) {
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		return likerepo.findByiduser(s);
	}
}
