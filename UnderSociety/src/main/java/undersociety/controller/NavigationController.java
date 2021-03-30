package undersociety.controller;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import undersociety.models.Users;
import undersociety.services.AdminService;
import undersociety.services.PostsService;
import undersociety.services.ProductService;
import undersociety.services.UserService;


@Controller
@CrossOrigin
public class NavigationController{
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostsService postService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/sign-in")
	private String getSignIn(Model model,HttpServletRequest request) throws IOException {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		adminService.loadDataBase();
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
		model.addAttribute("mostFollow",userService.getListMostFollowed());
		
		model.addAttribute("following", userService.getFollowing(request.getUserPrincipal().getName()).size());
		model.addAttribute("followers", userService.getFollowers(request.getUserPrincipal().getName()).size());
		model.addAttribute("url","/pageProfileUser?&username="+request.getUserPrincipal().getName());
		model.addAttribute("storeList", productService.getBookmarks(request.getUserPrincipal().getName()));
		model.addAttribute("posts", postService.getPostIndex(request.getUserPrincipal().getName()));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "index";
	}
	
	@GetMapping("/pageProfileUser")
	private String getPageProfileUser(Model model,HttpServletRequest request, @RequestParam String username){
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users follow = userService.getUser(username);
		Users actual = userService.getUser(request.getUserPrincipal().getName());
		if(follow.getImageprofile()!=null) {
			model.addAttribute("imageProfile","https://localhost:8443/api/imageThemeProfile");
			
		}else {
			model.addAttribute("imageProfile","images/1600x400.png");
		}
    	model.addAttribute("follow", userService.existsRealtion(actual, follow));
    	model.addAttribute("userfacebook", follow.getLinkfacebook());
		model.addAttribute("userTwitter", follow.getLinktwitter());
		model.addAttribute("userinstagram", follow.getLinkinstagram());
		model.addAttribute("userInfo", follow.getUserinfo());
		model.addAttribute("userCity", follow.getCity());
    	model.addAttribute("following", userService.getFollowing(username).size());
		model.addAttribute("followers", userService.getFollowers(username).size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("postlist", postService.getPostUserPage(actual, follow));
		model.addAttribute("products",productService.getProductUserPage(actual, follow));
		model.addAttribute("username",follow.getUsername());
		model.addAttribute("usernameview", request.getUserPrincipal().getName());
		return "user-profile";
	}
	
	@GetMapping("/store")
	private String getStore(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("products",productService.getPorductIndex(request.getUserPrincipal().getName()));
		return "store";
	}
	
	@GetMapping("/profiles")
	private String getProfiles(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("users",userService.getUsers());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "profiles";
	}
	
	@GetMapping("/companies")
	private String getCompanies(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("companies",userService.getCompanies());
		model.addAttribute("username",request.getUserPrincipal().getName());
		return "companies";
	}
	
	@GetMapping("/my-profile-feed")
	private String getMyProfileFeed(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users s = userService.getUser(request.getUserPrincipal().getName());
		if(s.getImageprofile() != null) {
			model.addAttribute("imageProfile","https://localhost:8443/api/imageThemeProfile");
			
		}else {
			model.addAttribute("imageProfile","http://via.placeholder.com/1600x400");
		}
		model.addAttribute("userfacebook", s.getLinkfacebook());
		model.addAttribute("userTwitter", s.getLinktwitter());
		model.addAttribute("userinstagram", s.getLinkinstagram());
		model.addAttribute("userInfo", s.getUserinfo());
		model.addAttribute("userCity", s.getCity());
		model.addAttribute("userFullName", s.getName());
		model.addAttribute("following", userService.getFollowing(request.getUserPrincipal().getName()).size());
		model.addAttribute("followers", userService.getFollowers(request.getUserPrincipal().getName()).size());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",request.getUserPrincipal().getName());
		model.addAttribute("url", s.getIdusers());
		return "myprofilefeed";
	}
	
	@GetMapping("/profile-account-setting")
	private String getProfileAccountSetting(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Users actual = userService.getUser(request.getUserPrincipal().getName());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("followersList", userService.getFollowers(request.getUserPrincipal().getName()));
		model.addAttribute("productsList", productService.getBookmarks(request.getUserPrincipal().getName()));
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
		model = adminService.getData(model);
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		model.addAttribute("username", request.getUserPrincipal().getName());
		return "admin";
	}
	
	@GetMapping("/forgotPassword")
	private String getForgotPassword(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		return "forgotPassword";
	}
	
}
