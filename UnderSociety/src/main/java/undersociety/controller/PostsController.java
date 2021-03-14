package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
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


import undersociety.models.Post;
import undersociety.models.Users;
import undersociety.repositories.PostRepository;
import undersociety.services.UserService;

@RestController
public class PostsController {
		
	@Autowired
	private PostRepository postsrepo;

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
	
}
