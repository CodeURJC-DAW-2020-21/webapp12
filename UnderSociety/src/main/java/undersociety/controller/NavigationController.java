package undersociety.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import undersociety.models.Users;
import undersociety.services.UserService;


@Controller
@CrossOrigin
public class NavigationController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/sign-in")
	private String getSignIn() {
		return "sign-in";
	}
	
    @PostMapping("/registerUser")
	private String registerUser(Users user, HttpServletRequest sesion) {
		user.setUser_profile(true);
		user.setCompany_profile(false);
		user.setPass(encoder.encode(user.getPass()));
		userservice.save(user);
		return "/sign-in";
	}
    
    @PostMapping("/registerCompany")
	private String registerCompany(Users user, HttpServletRequest sesion) {
		user.setUser_profile(false);
		user.setCompany_profile(true);
		user.setPass(encoder.encode(user.getPass()));
		userservice.save(user);
		return "/sign-in";
	}
	
	@GetMapping("/")
	private String getInit(Model model, HttpServletRequest request) {
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/index")
	private String getIndex(Model model,HttpServletRequest request) {
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
<<<<<<< develop
<<<<<<< develop
		model.addAttribute("name",request.getUserPrincipal().getName());
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> Implemented chat function
=======
		model.addAttribute("username",request.getUserPrincipal().getName());
>>>>>>> Implemented Email functions in App
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
	
<<<<<<< develop
=======
	@GetMapping("/forgotPassword")
	private String getForgotPassword() {
		return "forgotPassword";
	}
	
>>>>>>> Implemented Email functions in App
}
