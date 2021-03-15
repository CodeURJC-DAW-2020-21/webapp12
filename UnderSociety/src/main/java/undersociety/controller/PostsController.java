package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
import undersociety.services.UserService;

@RestController
public class PostsController {
	
	@Autowired
	 private UserRepository userRepository;
		
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private LikesRepository likerepo;
		
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/api/uploadPost")
	private void uploadPost(Model model,HttpServletResponse response, HttpServletRequest request,Post post,  @RequestParam(required = false) MultipartFile imag0) throws IOException {
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
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
		Optional<Post> p = postsrepo.findById(idpost);
    	Resource file = new InputStreamResource(p.get().getImage().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.get().getImage().length())
				.body(file);
    }
	
	@PostMapping("/api/likePost")
	public boolean likePost(@RequestParam int idpost, HttpServletRequest request){
		Optional<Post> p = postsrepo.findById(idpost);
		Optional<Users> s = userRepository.findByusername(request.getUserPrincipal().getName());
		LikeAPost lp = new LikeAPost();
		lp.setIdpost(p.get());
		lp.setIduser(s.get());
		likerepo.save(lp);
		return  true;
	}
	
	@PostMapping("/api/unlikePost")
	public boolean unlikePost(@RequestParam int idpost, HttpServletRequest request){
		Optional<Post> p = postsrepo.findById(idpost);
		Optional<Users> s = userRepository.findByusername(request.getUserPrincipal().getName());
		LikeAPost lp = likerepo.findByidpostAndIduser(p.get(), s.get());
		if(lp != null) {
			likerepo.deleteById(lp.getIdlike());
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/api/getLikes")
	public List<LikeAPost> getLikes(HttpServletRequest request) {
		Optional<Users> s = userRepository.findByusername(request.getUserPrincipal().getName());
		return likerepo.findByiduser(s.get());
	}
}
