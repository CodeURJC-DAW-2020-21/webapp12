package undersociety.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import undersociety.models.Post;
import undersociety.models.Users;
import undersociety.repositories.PostRepository;
import undersociety.services.UserService;

@Controller
public class PostsController {

	@Autowired
	private PostRepository posts;

	@Autowired
	private UserService userservice;
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		List<Post> p = posts.findAll();
		model.addAttribute("posts",p);
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "my-profile-feed";
	}
	
	@PostMapping("/uploadPost")
	private String uploadPost(Model model, HttpServletRequest request,Post post) {
		System.out.println(post.getTitle());
		System.out.println(post.getDescription());
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		post.setId_post(0);
		post.setId_user(s);
		posts.save(post);
		System.out.println(post.getId_user().getId_users());
		return "index";
	}
}
