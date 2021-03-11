package undersociety.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import undersociety.models.Post;
import undersociety.models.Product;
import undersociety.models.Users;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.services.UserService;

@Controller
public class PostsController {
		
	@Autowired
	private PostRepository posts;
	
	@Autowired
	private TagsRepository tagsrepo;
	
	@Autowired
	private ProductRepository productrepo;

	@Autowired
	private UserService userservice;
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
<<<<<<< develop
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> fixes to posts and product
		List<Post> p = posts.findAll();
		model.addAttribute("posts",p);
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "my-profile-feed";
	}
	
	@PostMapping("/uploadPost")
	private String uploadPost(Model model, HttpServletRequest request,Post post) {
<<<<<<< develop
		System.out.println(post.getTitle());
		System.out.println(post.getDescription());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		post.setId_post(0);
		post.setId_user(s);
		posts.save(post);
		System.out.println(post.getId_user().getId_users());
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		System.out.println("image0: "+post.getImage0());
		post.setIduser(s);
<<<<<<< develop
		posts.save(post);
>>>>>>> fixes to posts and product
=======
		return "index";
	}
	
	@PostMapping("/uploadProduct")
	private String uploadProduct(Model model, HttpServletRequest request, Product product, @RequestParam(required = false) MultipartFile imag0, @RequestParam(required = false) MultipartFile imag1, @RequestParam(required = false) MultipartFile imag2) throws IOException {
		model.addAttribute("username",request.getUserPrincipal().getName());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		URI location = fromCurrentRequest().build().toUri();
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
		product.view();
>>>>>>> Porduct form
		return "index";
	}
}
