package undersociety.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import undersociety.models.Users;
import undersociety.repositories.UserRepository;


@Controller
@CrossOrigin
public class NavigationController implements ErrorController{
	
	@Autowired
	 private UserRepository userRepository;
	
	@GetMapping("/sign-in")
	private String getSignIn() {
		return "sign-in";
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
	
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		List<Users> users = userRepository.findByuserprofile(true);
		model.addAttribute("users",users);
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		List<Users> companies = userRepository.findBycompanyprofile(true);
		model.addAttribute("companies",companies);
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
