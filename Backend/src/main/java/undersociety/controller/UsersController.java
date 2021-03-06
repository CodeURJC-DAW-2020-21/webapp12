package undersociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RestController
@CrossOrigin
public class UsersController {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;

	
    @GetMapping("/fetchAllUsers")
    public Page<Users> fetchAll() {
        return userService.getUsersPage();
    }
    
    @GetMapping("/getUserPage")
    public Page<Users> getUserPage(Pageable page) {
        return userService.getUsersPage(page);
    }
    
    @PostMapping("/registerUser")
	private void registerUser(Users user,HttpServletResponse response , HttpServletRequest sesion, @RequestParam(required = false) MultipartFile image) throws IOException, SQLException {
    	userService.registerUsers(user, image, null);
    	response.sendRedirect("/sign-in");
    }
    
    @PostMapping("/registerCompany")
	private void registerCompany(Users user,HttpServletResponse response, HttpServletRequest sesion, @RequestParam(required = false) MultipartFile image) throws IOException {
    	userService.registerCompanies(user, image);
    	response.sendRedirect("/sign-in");
    }
    
    
    @GetMapping("/imageprofile")
    private ResponseEntity<Object> downloadImage(HttpServletRequest request) throws SQLException, IOException{
    	Users s = userService.getUser(request.getUserPrincipal().getName());
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
    
    @GetMapping("/imageprofile/{username}")
    private ResponseEntity<Object> downloadImageProfile(@PathVariable String username) throws SQLException, IOException{
    	Users s = userService.getUser(username);
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
    
    @GetMapping("/moreUsers")
    public Page<Users> getMoreUsers(Pageable page){    	
    	return userService.getCustomers(page);
    }
    
    @GetMapping("/moreCompany")
    public Page<Users> getMoreCompany(Pageable page){    	
    	return userService.getCompanies(page);
    }
    
    @PostMapping("/follow")
    public boolean follow(HttpServletRequest request, @RequestParam String username) {
    	return userService.follow(request.getUserPrincipal().getName(), username);
    }
    
    @PostMapping("/unfollowlist")
    public boolean unfollow(@RequestParam int idrelation) {
    	return userService.unfollow(idrelation);
    }
    
    @GetMapping("/getFollows")
	public List<UsersRelations> getFollows(HttpServletRequest request) {
		return userService.getFollows(request.getUserPrincipal().getName());
	}
    
    @PostMapping("/modifyUser")
    public void modifyUserSetting(Users user,HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile image) throws IOException, ServletException {
    	userService.usernameIsToken(user.getUsername());
    	userService.modifyDataUser(user, request.getUserPrincipal().getName(), image,null);
    	request.logout();
    	response.sendRedirect("/sign-in");
    }
    
    @PostMapping("/changePassword")
    public void modifyPassword(HttpServletResponse response, HttpServletRequest request, @RequestParam String oldpassword,  @RequestParam String newpassword,  @RequestParam String repeatpassword) throws IOException {
    	Users prev = userService.getUser(request.getUserPrincipal().getName());
    	String page = "/error";
    	if(encoder.matches(oldpassword, prev.getPass())) {
    		if(newpassword.equals(repeatpassword)) {
    			userService.modifyPass(request.getUserPrincipal().getName(), newpassword);
    	    	page = "/sign-in";
    		}
    		
    	}
    	response.sendRedirect(page);
    }
    
    @PostMapping("/deleteUser")
    public void deleteUser(HttpServletResponse response, HttpServletRequest request, @RequestParam String email, @RequestParam String pass, @RequestParam String explication) throws IOException {
    	Users prev = userService.getUser(request.getUserPrincipal().getName());
    	if(email.equals(prev.getEmail())) {
    		if(pass.equals(prev.getPass())) {
    			userService.deleteUser(request.getUserPrincipal().getName());
    	    	response.sendRedirect("/profile-account-setting");
    		}
    	}
    	response.sendRedirect("/error");
    }
}