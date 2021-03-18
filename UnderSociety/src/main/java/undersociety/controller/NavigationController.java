package undersociety.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class NavigationController{
	
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
	private String getSignIn(Model model,HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		loadData();
		return "sign-in";
	}
    
	
	@GetMapping("/")
	private void getInit(HttpServletResponse response) throws IOException {
		response.sendRedirect("/index");
	}
	
	@GetMapping("/index")
	private String getIndex(Model model,HttpServletRequest request) throws SQLException {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
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
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<UsersRelations> following = relationrepo.findByuserone(s);
		List<UsersRelations> followers = relationrepo.findByusertwo(s);
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		if(s.getUserprofile()) {
			model.addAttribute("url","/pageProfileUser?&username="+request.getUserPrincipal().getName());
		}else {
			model.addAttribute("url","/company-profile?&username="+request.getUserPrincipal().getName());	
		}
		model.addAttribute("storeList",listproductrepo.findByiduser(s));
		model.addAttribute("posts", postsmodels);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/pageProfileUser")
	private String getPageProfileUser(Model model,HttpServletRequest request, @RequestParam String username){
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users follow = userRepository.findByusername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Users actual = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Page<Post> p = postsrepo.findByiduser(follow,PageRequest.of(0, 10,Sort.by("idpost").ascending()));
		Page<Product> products = productrepo.findByiduser(follow,PageRequest.of(0, 10,Sort.by("idproduct").ascending()));
		List<UsersRelations> following = relationrepo.findByuserone(follow);
		List<UsersRelations> followers = relationrepo.findByusertwo(follow);
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(follow.getUsername()).get());
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
		if(follow.getImageprofile() != null) {
			model.addAttribute("imageProfile","");
			
		}else {
			model.addAttribute("imageProfile","http://via.placeholder.com/1600x400");
		}
    	UsersRelations save = new UsersRelations();
    	save.setUserone(actual);
    	save.setUsertwo(follow);
    	UsersRelations s =  relationrepo.findByuseroneAndUsertwo(actual, follow);
    	if(s != null) {
    		model.addAttribute("follow","#e44d3a");
    	}else {
    		model.addAttribute("follow","#53D690");
    	}
    	model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("postlist", postsmodels);
		model.addAttribute("products",productmodels);
		model.addAttribute("username",follow.getUsername());
		model.addAttribute("usernameview", request.getUserPrincipal().getName());
		return "user-profile";
	}
	
	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Page<Product> products = productrepo.findAll(PageRequest.of(0, 10,Sort.by("idproduct").ascending()));
		List<ListProducts> lp = listproductrepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).get());
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lp) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			
			if(product.getStatus().equalsIgnoreCase("in stock")) {
				productmodel.setColor("#228B22");
			}
			
			if(product.getStatus().equalsIgnoreCase("sold")) {
				productmodel.setColor("#DC143C");
			}
			
			if(product.getStatus().equalsIgnoreCase("reserved")) {
				productmodel.setColor("#FFD700");
			}
			
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
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Page<Users> users = userRepository.findByuserprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("users",users.getContent());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Page<Users> companies = userRepository.findBycompanyprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("companies",companies.getContent());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "companies";
	}
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<UsersRelations> following = relationrepo.findByuserone(s);
		List<UsersRelations> followers = relationrepo.findByusertwo(s);
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "myprofilefeed";
	}
	
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users actual = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("followersList", relationrepo.findByuserone(actual));
		model.addAttribute("productsList", listproductrepo.findByiduser(actual));
		model.addAttribute("username",request.getUserPrincipal().getName());
		
		if(actual.getName() != null) {
			model.addAttribute("name",actual.getName());
		}else {
			model.addAttribute("name","");
		}
		
		if(actual.getEmail() != null) {
			model.addAttribute("email",actual.getEmail());
		}else {
			model.addAttribute("email","");
		}
		
		if(actual.getCity() != null) {
			model.addAttribute("city",actual.getCity());
		}else {
			model.addAttribute("city","");
		}
		
		if(actual.getLinkfacebook() != null) {
			model.addAttribute("linkfacebook",actual.getLinkfacebook());
		}else {
			model.addAttribute("linkfacebook","");
		}
		
		if(actual.getLinkinstagram() != null) {
			model.addAttribute("linkinstagram",actual.getLinkinstagram());
		}else {
			model.addAttribute("linkinstagram","");
		}
		
		if(actual.getLinktwitter() != null) {
			model.addAttribute("linktwitter",actual.getLinktwitter());
		}else {
			model.addAttribute("linktwitter","");
		}
		return "profile-account-setting";
	}
	
	@GetMapping("/messages")
	private String getMessages(Model model,HttpServletRequest request,@RequestParam(required = false) String to) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
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
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		model.addAttribute("username", request.getUserPrincipal().getName());
		model.addAttribute("numpost", postsrepo.findAll().size());
		List<Product> p = productrepo.findAll();
		List<Tags> tag = tagrepo.findAll(Sort.by("idtags"));
		int elec = productrepo.findByidtagone(tag.get(0)).size();
		int fur = productrepo.findByidtagtwo(tag.get(1)).size();
		int appli = productrepo.findByidtagthree(tag.get(2)).size();
		int book = productrepo.findByidtagfour(tag.get(3)).size();
		int clot = productrepo.findByidtagfive(tag.get(4)).size();
		int instock = productrepo.findBystatus("in stock").size();
		int sold = productrepo.findBystatus("sold").size();
		int reserved = productrepo.findBystatus("reserved").size();
		int tproduct = p.size();
		int sum = 0;
		for (Product product : p) {
			sum = sum + product.getPrice();
		}
		model.addAttribute("sumstore", sum);
		model.addAttribute("numproduct", productrepo.findAll().size());
		model.addAttribute("sumuser", userRepository.findAll().size());
		if (tproduct > 0) {
			model.addAttribute("electronic", ((elec*100)/tproduct));
			model.addAttribute("furniture", ((fur*100)/tproduct));
			model.addAttribute("appliance", ((appli*100)/tproduct));
			model.addAttribute("book", ((book*100)/tproduct));
			model.addAttribute("clothe", ((clot*100)/tproduct));
			model.addAttribute("stock", ((instock*100)/tproduct));
			model.addAttribute("sold", ((sold*100)/tproduct));
			model.addAttribute("reserved", ((reserved*100)/tproduct));
		  
		} else {
			model.addAttribute("electronic", 0);
			model.addAttribute("furniture", 0);
			model.addAttribute("appliance", 0);
			model.addAttribute("book", 0);
			model.addAttribute("clothe",0);
			model.addAttribute("stock",0);
			model.addAttribute("sold", 0);
			model.addAttribute("reserved",0);
		}
		return "admin";
	}
	
	@GetMapping("/forgotPassword")
	private String getForgotPassword(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		return "forgotPassword";
	}
	
	
    @GetMapping("/prueba")
    private void prueba() {
    	Users s = userRepository.findByusername("null").orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
	
	private void loadData() {
		if(tagrepo.findAll().isEmpty()) {
			Tags tag1 = new Tags();
			Tags tag2 = new Tags();
			Tags tag3 = new Tags();
			Tags tag4 = new Tags();
			Tags tag5 = new Tags();
			tag1.setDescription("Electronics");
			tag2.setDescription("Furniture");
			tag3.setDescription("Appliance");
			tag4.setDescription("Books");
			tag5.setDescription("Clothes");
			tagrepo.save(tag1);
			tagrepo.save(tag2);
			tagrepo.save(tag3);
			tagrepo.save(tag4);
			tagrepo.save(tag5);
		}
	}
	
}
