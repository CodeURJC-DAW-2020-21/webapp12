package undersociety.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import undersociety.models.LikeAPost;
import undersociety.models.ListProducts;
import undersociety.models.Loader;
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
import undersociety.repositories.RolesRepository;
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
	
	
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/sign-in")
	private String getSignIn(Model model,HttpServletRequest request) throws IOException {
		Loader ld = new Loader(likerepo, relationrepo, productrepo, listproductrepo, postsrepo, userRepository, tagrepo, rolesRepository, encoder);
		ld.load();
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
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
		
		/*algorithm*/
		List<Users> listMostFollower = relationrepo.findMostFollowers(PageRequest.of(0, 5));
		model.addAttribute("mostFollow",listMostFollower);
		
		Page<Post> p = postsrepo.findAll(PageRequest.of(0, 10,Sort.by("idpost").descending()));
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(post.getIduser().getUserprofile()) {
				postmodel.setTypeUser("user");
			}else {
				postmodel.setTypeUser("company");
			}
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		List<UsersRelations> following = relationrepo.findByuserone(s);
		List<UsersRelations> followers = relationrepo.findByusertwo(s);
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("url","/pageProfileUser?&username="+request.getUserPrincipal().getName());
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
		Users follow = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		Users actual = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		Page<Post> p = postsrepo.findByiduser(follow,PageRequest.of(0, 10,Sort.by("idpost").descending()));
		Page<Product> products = productrepo.findByiduser(follow,PageRequest.of(0, 10,Sort.by("idproduct").descending()));
		List<UsersRelations> following = relationrepo.findByuserone(follow);
		List<UsersRelations> followers = relationrepo.findByusertwo(follow);
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(follow.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(post.getIduser().getUserprofile()) {
				postmodel.setTypeUser("user");
			}else {
				postmodel.setTypeUser("company");
			}
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		List<ListProducts> lproduct = listproductrepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lproduct) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if(product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			}else {
				productmodel.setTypeUser("company");
			}
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
		if(follow.getImageprofile() != null) {
			model.addAttribute("imageProfile","https://localhost:8443/api/imageThemeProfile");
			
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
    	model.addAttribute("userfacebook", follow.getLinkfacebook());
		model.addAttribute("userTwitter", follow.getLinktwitter());
		model.addAttribute("userinstagram", follow.getLinkinstagram());
		model.addAttribute("userInfo", follow.getUserinfo());
		model.addAttribute("userCity", follow.getCity());
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
		Page<Product> products = productrepo.findAll(PageRequest.of(0, 10,Sort.by("idproduct").descending()));
		List<ListProducts> lp = listproductrepo.findByiduser(userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lp) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if(product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			}else {
				productmodel.setTypeUser("company");
			}
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
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
		List<UsersRelations> following = relationrepo.findByuserone(s);
		List<UsersRelations> followers = relationrepo.findByusertwo(s);
		model.addAttribute("userfacebook", s.getLinkfacebook());
		model.addAttribute("userTwitter", s.getLinktwitter());
		model.addAttribute("userinstagram", s.getLinkinstagram());
		model.addAttribute("userInfo", s.getUserinfo());
		model.addAttribute("userCity", s.getCity());
		model.addAttribute("userFullName", s.getName());
		model.addAttribute("following", following.size());
		model.addAttribute("followers", followers.size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("url", s.getIdusers());
		return "myprofilefeed";
	}
	
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users actual = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
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
		int tuser = userRepository.findAll().size();
		int user = rolesRepository.findByrol("USER").size();
		int admin = rolesRepository.findByrol("ADMIN").size();
		int sum = 0;
		
		model.addAttribute("user", ((user*100)/tuser));
		model.addAttribute("admin", ((admin*100)/tuser));
		
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
	
}
