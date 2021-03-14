package undersociety.controller;


<<<<<<< HEAD
<<<<<<< HEAD
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
=======
>>>>>>> SpringAppUserAndCompanyPage

=======
>>>>>>> SpringAppIndexPage
import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
>>>>>>> SpringAppUserAndCompanyPage
=======
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
>>>>>>> SpringAppIndexPage
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> SpringAppUserAndCompanyPage

import undersociety.models.Roles;
import undersociety.models.Users;
<<<<<<< HEAD
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;
import undersociety.services.UserService;
=======
import undersociety.repositories.UserRepository;
>>>>>>> SpringAppUserAndCompanyPage
=======
import org.springframework.web.bind.annotation.RequestMapping;

import undersociety.models.Post;
import undersociety.models.Product;
import undersociety.models.Users;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.UserRepository;
>>>>>>> SpringAppIndexPage


@Controller
@CrossOrigin
public class NavigationController implements ErrorController{
<<<<<<< HEAD
<<<<<<< HEAD
	
	@Autowired
	 private UserRepository userRepository;
	
	 @Autowired
	 private RolesRepository rolesRepository;
=======
>>>>>>> SpringAppUserAndCompanyPage
=======
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private PostRepository postsrepo;
>>>>>>> SpringAppIndexPage
	
	@Autowired
	 private UserRepository userRepository;
	
	@GetMapping("/sign-in")
	private String getSignIn() {
		return "sign-in";
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
    @PostMapping("/registerUser")
	private String registerUser(Users user, HttpServletRequest sesion, @RequestParam(required = false) MultipartFile imagen) throws IOException, SQLException {
    	if(imagen != null) {
    		user.setUserimg(BlobProxy.generateProxy(imagen.getInputStream(), imagen.getSize()));
    	}
    	user.setUserprofile(true);
		user.setCompanyprofile(false);
		user.setPass(encoder.encode(user.getPass()));
		userservice.save(user);
		Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found")));
		Roles r = new Roles();
		r.setIduser(use);
		r.setRol("USER");
		rolesRepository.save(r);
		return "sign-in";
	}
    
    @GetMapping("/imageprofile")
    private ResponseEntity<Object> downloadImage(HttpServletRequest sesion) throws SQLException{
    	Users s = (Users) userservice.findByUser_name(sesion.getUserPrincipal().getName());
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
    
    
    @PostMapping("/registerCompany")
	private String registerCompany(Users user, HttpServletRequest sesion) {
		user.setUserprofile(false);
		user.setCompanyprofile(true);
		user.setPass(encoder.encode(user.getPass()));
		userservice.save(user);
		Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found")));
		Roles r = new Roles();
		r.setIduser(use);
		r.setRol("USER");
		rolesRepository.save(r);
		return "/sign-in";
	}
=======
    
>>>>>>> SpringAppUserAndCompanyPage
=======
    
>>>>>>> SpringAppIndexPage
	
	@GetMapping("/")
	private String getInit(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/index")
	private String getIndex(Model model,HttpServletRequest request) {
<<<<<<< HEAD
=======
		Page<Post> p = postsrepo.findAll(PageRequest.of(0, 10,Sort.by("idpost").ascending()));
		model.addAttribute("posts", p.getContent());
>>>>>>> SpringAppIndexPage
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		Page<Users> users = userRepository.findByuserprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("users",users.getContent());
<<<<<<< HEAD
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		Page<Users> companies = userRepository.findBycompanyprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("companies",companies.getContent());
=======
>>>>>>> SpringAppIndexPage
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		Page<Users> companies = userRepository.findBycompanyprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
		model.addAttribute("companies",companies.getContent());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "companies";
	}
	
	@GetMapping("/messages")
	private String getMessages(Model model,HttpServletRequest request) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< develop
<<<<<<< develop
		model.addAttribute("name",request.getUserPrincipal().getName());
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> Implemented chat function
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
<<<<<<< HEAD
>>>>>>> Implemented Email functions in App
=======
>>>>>>> fixes to posts and product
>>>>>>> SpringAppPostsAndProducts
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> SpringAppUserAndCompanyPage
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> SpringAppIndexPage
		model.addAttribute("time","{{time}}");
		model.addAttribute("messageOutput","{{messageOutput}}");
		model.addAttribute("userName","{{userName}}");
		model.addAttribute("response","{{response}}");
		return "messages";
	}

	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
		Page<Product> products = productrepo.findAll( PageRequest.of(0, 10,Sort.by("idproduct").ascending()));
		model.addAttribute("products", products);
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "store";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		List<Users> users = userservice.load();
		model.addAttribute("users",users);
=======
	@GetMapping("/company-profile")
	private String getCompanyProfile(Model model, HttpServletRequest request) {
>>>>>>> SpringAppIndexPage
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "company-profile";
	}
	
<<<<<<< HEAD
=======
>>>>>>> SpringAppUserAndCompanyPage
	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
=======
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
>>>>>>> SpringAppIndexPage
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profile-account-setting";
	}
	
	
	@GetMapping("/user-profile")
	private String getUserProfile(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "user-profile";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< develop
<<<<<<< HEAD
=======
=======
<<<<<<< develop
=======
=======
=======
>>>>>>> SpringAppUserAndCompanyPage
=======
>>>>>>> SpringAppIndexPage
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "myprofilefeed";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Created all database models
>>>>>>> SpringAppPostsAndProducts
=======
>>>>>>> SpringAppUserAndCompanyPage
=======
>>>>>>> SpringAppIndexPage
	@GetMapping("/forgotPassword")
	private String getForgotPassword() {
		return "forgotPassword";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Implemented Email functions in App
=======
<<<<<<< develop
>>>>>>> fixes to posts and product
=======
=======
>>>>>>> SpringAppUserAndCompanyPage
=======
>>>>>>> SpringAppIndexPage
	@GetMapping("/admin")
	private String getAdminpage(Model model) {
		return "admin";
	}
	
	@GetMapping("/errorpage")
	private String errorpage(Model model) {
		return "error";
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
	
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Posts and Products forms
>>>>>>> SpringAppPostsAndProducts
=======
>>>>>>> SpringAppUserAndCompanyPage
=======
>>>>>>> SpringAppIndexPage
}
