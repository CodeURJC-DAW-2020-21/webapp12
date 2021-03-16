package undersociety.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import undersociety.models.LikeAPost;
import undersociety.models.ListProducts;
import undersociety.models.Post;
import undersociety.models.PostModel;
import undersociety.models.Product;
import undersociety.models.ProductModel;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.repositories.LikesRepository;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.repositories.UserRepository;
import undersociety.repositories.UsersRelationsRepository;


@Controller
@CrossOrigin
public class NavigationController implements ErrorController{
	
	@Autowired
	private LikesRepository likerepo;
	
	@Autowired
	private UsersRelationsRepository relationrepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private ListProductsRepository listproductrepo;
	
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	 private TagsRepository tagrepo;
	
	@GetMapping("/sign-in")
	private String getSignIn() {
		return "sign-in";
	}
    
	
	@GetMapping("/")
	private void getInit(HttpServletResponse response) throws IOException {
		response.sendRedirect("/index");
	}
	
	@GetMapping("/index")
	private String getIndex(Model model,HttpServletRequest request) {
		Page<Post> p = postsrepo.findAll(PageRequest.of(0, 10,Sort.by("idpost").ascending()));
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).get());
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		Optional<Users> s = userRepository.findByusername(request.getUserPrincipal().getName());
		List<UsersRelations> following = relationrepo.findByuserone(s.get());
		List<UsersRelations> followers = relationrepo.findByusertwo(s.get());
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		if(s.get().getUserprofile()) {
			model.addAttribute("url","/pageProfileUser?&username="+request.getUserPrincipal().getName());
		}else {
			model.addAttribute("url","/company-profile?&username="+request.getUserPrincipal().getName());	
		}
		model.addAttribute("storeList",listproductrepo.findByiduser(s.get()));
		model.addAttribute("posts", postsmodels);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/pageProfileUser")
	private String getPageProfileUser(Model model,HttpServletRequest request, @RequestParam String username){
		Optional<Users> follow = userRepository.findByusername(username);
		Optional<Users> actual = userRepository.findByusername(request.getUserPrincipal().getName());
		Page<Post> p = postsrepo.findByiduser(follow.get(),PageRequest.of(0, 10,Sort.by("idpost").ascending()));
		Page<Product> products = productrepo.findByiduser(follow.get(),PageRequest.of(0, 10,Sort.by("idproduct").ascending()));
		List<UsersRelations> following = relationrepo.findByuserone(follow.get());
		List<UsersRelations> followers = relationrepo.findByusertwo(follow.get());
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(follow.get().getUsername()).get());
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		List<ListProducts> lproduct = listproductrepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).get());
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lproduct) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if(bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			}else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		if(follow.get().getImageprofile() != null) {
			model.addAttribute("imageProfile","");
			
		}else {
			model.addAttribute("imageProfile","http://via.placeholder.com/1600x400");
		}
    	UsersRelations save = new UsersRelations();
    	save.setUserone(actual.get());
    	save.setUsertwo(follow.get());
    	UsersRelations s =  relationrepo.findByuseroneAndUsertwo(actual.get(), follow.get());
    	if(s != null) {
    		model.addAttribute("follow","#e44d3a");
    	}else {
    		model.addAttribute("follow","#53D690");
    	}
    	model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("postlist", postsmodels);
		System.out.println(productmodels.size());
		model.addAttribute("products",productmodels);
		model.addAttribute("username",follow.get().getUsername());
		model.addAttribute("usernameview", request.getUserPrincipal().getName());
		return "user-profile";
	}
	
	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
		Page<Product> products = productrepo.findAll(PageRequest.of(0, 10,Sort.by("idproduct").ascending()));
		List<ListProducts> lp = listproductrepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).get());
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lp) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if(bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			}else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("products",productmodels);
		return "store";
	}
	
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		Page<Users> users = userRepository.findByuserprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("users",users.getContent());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		Page<Users> companies = userRepository.findBycompanyprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("companies",companies.getContent());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "companies";
	}
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		Optional<Users> s = userRepository.findByusername(request.getUserPrincipal().getName());
		List<UsersRelations> following = relationrepo.findByuserone(s.get());
		List<UsersRelations> followers = relationrepo.findByusertwo(s.get());
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "myprofilefeed";
	}
	
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
		Optional<Users> actual = userRepository.findByusername(request.getUserPrincipal().getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("followersList", relationrepo.findByuserone(actual.get()));
		model.addAttribute("productsList", listproductrepo.findByiduser(actual.get()));
		model.addAttribute("username",request.getUserPrincipal().getName());
		
		if(actual.get().getName() != null) {
			model.addAttribute("name",actual.get().getName());
		}else {
			model.addAttribute("name","");
		}
		
		if(actual.get().getEmail() != null) {
			model.addAttribute("email",actual.get().getEmail());
		}else {
			model.addAttribute("email","");
		}
		
		if(actual.get().getCity() != null) {
			model.addAttribute("city",actual.get().getCity());
		}else {
			model.addAttribute("city","");
		}
		
		if(actual.get().getLinkfacebook() != null) {
			model.addAttribute("linkfacebook",actual.get().getLinkfacebook());
		}else {
			model.addAttribute("linkfacebook","");
		}
		
		if(actual.get().getLinkinstagram() != null) {
			model.addAttribute("linkinstagram",actual.get().getLinkinstagram());
		}else {
			model.addAttribute("linkinstagram","");
		}
		
		if(actual.get().getLinktwitter() != null) {
			model.addAttribute("linktwitter",actual.get().getLinktwitter());
		}else {
			model.addAttribute("linktwitter","");
		}
		
		return "profile-account-setting";
	}
	
	@GetMapping("/messages")
	private String getMessages(Model model,HttpServletRequest request,@RequestParam(required = false) String to) {
		if(to != null) {
			model.addAttribute("to",to);
		}else {
			model.addAttribute("to","null");
		}
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("time","{{time}}");
		model.addAttribute("messageOutput","{{messageOutput}}");
		model.addAttribute("userName","{{userName}}");
		model.addAttribute("response","{{response}}");
		return "messages";
	}	
		
	@GetMapping("/admin")
	private String getAdminpage(Model model, HttpServletRequest request) {
		model.addAttribute("username", request.getUserPrincipal().getName());
		model.addAttribute("numpost", postsrepo.findAll().size());
		List<Product> p = productrepo.findAll();
		List<Tags> tag = tagrepo.findAll();
		int elec = productrepo.findByidtagone(tag.get(0)).size();
		int fur = productrepo.findByidtagtwo(tag.get(1)).size();
		int appli = productrepo.findByidtagthree(tag.get(2)).size();
		int book = productrepo.findByidtagfour(tag.get(3)).size();
		int clot = productrepo.findByidtagfive(tag.get(4)).size();
		int instock = productrepo.findBystatus("in stock").size();
		int available = productrepo.findBystatus("available").size();
		int reserved = productrepo.findBystatus("reserved").size();
		int tproduct = p.size();
		int sum = 0;
		
		for (Product product : p) {
			sum = sum + product.getPrice();
		}
		model.addAttribute("sumstore", sum);
		model.addAttribute("numproduct", productrepo.findAll().size());
		model.addAttribute("sumuser", userRepository.findAll().size());
		model.addAttribute("electronic", ((elec*100)/tproduct));
		model.addAttribute("furniture", ((fur*100)/tproduct));
		model.addAttribute("appliance", ((appli*100)/tproduct));
		model.addAttribute("book", ((book*100)/tproduct));
		model.addAttribute("clothe", ((clot*100)/tproduct));
		model.addAttribute("stock", ((instock*100)/tproduct));
		model.addAttribute("available", ((available*100)/tproduct));
		model.addAttribute("reserved", ((reserved*100)/tproduct));
		return "admin";
	}
	
	@GetMapping("/forgotPassword")
	private String getForgotPassword() {
		return "forgotPassword";
	}
	
	 @RequestMapping("/error")
	    public String handleError() {
	        //do something like logging
	        return "error";
	 }

	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
}
