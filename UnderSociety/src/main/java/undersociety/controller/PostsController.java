package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import undersociety.models.Post;
import undersociety.models.Product;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.services.UserService;

@Controller
public class PostsController {
		
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private TagsRepository tagsrepo;
	
	@Autowired
	private ProductRepository productrepo;

	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/uploadPost")
	private String uploadPost(Model model, HttpServletRequest request,Post post,  @RequestParam(required = false) MultipartFile imag0) throws IOException {
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		if(imag0 != null) {
			post.setImage(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
		}
		post.setIduser(s);
		postsrepo.save(post);
		return "index";
	}
	
	@PostMapping("/uploadProduct")
	private String uploadProduct(Model model, HttpServletRequest request, Product product, @RequestParam(required = false) MultipartFile imag0, @RequestParam(required = false) MultipartFile imag1, @RequestParam(required = false) MultipartFile imag2, @RequestParam(required = false) boolean tag, @RequestParam(required = false) boolean tagtwo, @RequestParam(required = false) boolean tagthree) throws IOException {
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		List<Tags> listag = tagsrepo.findAll();
		if(imag0 != null) {
			product.setImage0(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
		}
		if(imag1 != null) {
			product.setImage1(BlobProxy.generateProxy(imag1.getInputStream(), imag1.getSize()));		
		}
		if(imag2 != null) {
			product.setImage2(BlobProxy.generateProxy(imag2.getInputStream(), imag2.getSize()));
		}
		product.setIduser(s);
		if(tag) {
			product.setIdtag(listag.get(0));
		}
		if(tagtwo) {
			product.setIdtagtwo(listag.get(1));		
		}
		if(tagthree) {
			product.setIdtagthree(listag.get(2));
		}
		product.setStatus("in stock");
		productrepo.save(product);
		return "index";
	}
	
	@GetMapping("/imagepost/{username}")
    private ResponseEntity<Object> downloadImagePost( @PathVariable String username) throws SQLException{
    	Users s = (Users) userservice.findByUser_name(username);
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
	
}
