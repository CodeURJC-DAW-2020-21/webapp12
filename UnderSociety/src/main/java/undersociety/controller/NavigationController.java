package undersociety.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;
import undersociety.services.UserService;


@Controller
@CrossOrigin
public class NavigationController implements ErrorController{
	
	@Autowired
	 private UserRepository userRepository;
	
	 @Autowired
	 private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/sign-in")
	private String getSignIn() {
		return "sign-in";
	}
	
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
	
	@GetMapping("/")
	private String getInit(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/index")
	private String getIndex(Model model,HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "companies";
	}
	
	@GetMapping("/company-profile")
	private String getCompanyProfile(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "company-profile";
	}
	
	@GetMapping("/messages")
	private String getMessages(Model model,HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("time","{{time}}");
		model.addAttribute("messageOutput","{{messageOutput}}");
		model.addAttribute("userName","{{userName}}");
		model.addAttribute("response","{{response}}");
		return "messages";
	}
	
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profile-account-setting";
	}
	
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		List<Users> users = userservice.load();
		model.addAttribute("users",users);
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "store";
	}
	
	@GetMapping("/user-profile")
	private String getUserProfile(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "user-profile";
	}
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "myprofilefeed";
	}
	
	@GetMapping("/forgotPassword")
	private String getForgotPassword() {
		return "forgotPassword";
	}
	
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
	
}
