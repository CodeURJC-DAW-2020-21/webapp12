package undersociety.controller;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
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


import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.repositories.LikesRepository;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.MessageRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;
import undersociety.repositories.UsersRelationsRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RestController
@CrossOrigin
public class UsersController {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images/");
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private LikesRepository likerepo;
	
	@Autowired
	private MessageRepository messagerepo;
	
	@Autowired
	private UsersRelationsRepository relationrepo;
	
	@Autowired
	private ListProductsRepository listproductrepo;
	
	@Autowired
	 private UserRepository userRepository;
		
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private PasswordEncoder encoder;
	
    @GetMapping("/api/fetchAllUsers")
    public Page<Users> fetchAll() {
        return userRepository.findAll(PageRequest.of(0, 10,Sort.by("username").ascending()));
    }
    
    @GetMapping("/api/getUserPage")
    public Page<Users> getUserPage(Pageable page) {
        return userRepository.findAll(page);
    }
    
    @PostMapping("/api/registerUser")
	private void registerUser(Users user,HttpServletResponse response , HttpServletRequest sesion, @RequestParam(required = false) MultipartFile image) throws IOException, SQLException {
    	if(userRepository.existsIdusersByUsername(user.getUsername())) {
    		throw new NoSuchElementException("USERNAME IS TOKEN");
    	}else {
	    	if(image != null) {
	    		user.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
	    	}
	    	user.setCity("");
	    	user.setUserinfo("");
	    	user.setUserprofile(true);
			user.setCompanyprofile(false);
			user.setPass(encoder.encode(user.getPass()));
			userRepository.save(user);
			Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
			Roles r = new Roles();
			r.setIduser(use);
			r.setRol("USER");
			rolesRepository.save(r);
			response.sendRedirect("/sign-in");
    	}
    }
    
    @PostMapping("/api/registerCompany")
	private void registerCompany(Users user,HttpServletResponse response, HttpServletRequest sesion, @RequestParam(required = false) MultipartFile image) throws IOException {
    	if(userRepository.existsIdusersByUsername(user.getUsername())) {
    		throw new NoSuchElementException("USERNAME IS TOKEN");
    	}else {
	    	if(image != null) {
	    		user.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
	    	}
			user.setUserprofile(false);
			user.setCompanyprofile(true);
			user.setPass(encoder.encode(user.getPass()));
			userRepository.save(user);
			Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
			Roles r = new Roles();
			r.setIduser(use);
			r.setRol("USER");
			rolesRepository.save(r);
			response.sendRedirect("/sign-in");
    	}
    }
    
    
    @GetMapping("/api/imageprofile")
    private ResponseEntity<Object> downloadImage(HttpServletRequest sesion) throws SQLException{
    	Users s = userRepository.findByusername(sesion.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
    
    @GetMapping("/api/imageprofile/{username}")
    private ResponseEntity<Object> downloadImageProfile(@PathVariable String username) throws SQLException{
    	Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Resource file = new InputStreamResource(s.getUserimg().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getUserimg().length())
				.body(file);
    }
    
    @GetMapping("/api/moreUsers")
    public Page<Users> getMoreUsers(Pageable page){    	
    	return userRepository.findByuserprofile(true,page);
    }
    
    @GetMapping("/api/moreCompany")
    public Page<Users> getMoreCompany(Pageable page){    	
    	return userRepository.findBycompanyprofile(true,page);
    }
    
    @PostMapping("/api/follow")
    public boolean follow(HttpServletRequest request, @RequestParam String username) {
    	Users follow = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Users actual = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	UsersRelations save = new UsersRelations();
    	save.setUserone(actual);
    	save.setUsertwo(follow);
    	UsersRelations s =  relationrepo.findByuseroneAndUsertwo(actual, follow);
    	if(s != null) {
    		save.setIduserrelation(s.getIduserrelation());
    		relationrepo.delete(save);
    		return false;
    	}else {
    		relationrepo.save(save);
    		return true;
    	}
    }
    
    @PostMapping("/api/unfollowlist")
    public boolean follow(@RequestParam int idrelation) {
    	relationrepo.deleteById(idrelation);
    	return true;
    }
    
    @GetMapping("api/getFollows")
	public List<UsersRelations> getFollows(HttpServletRequest request) {
		return relationrepo.findByuserone(userRepository.findByusername(request.getUserPrincipal().getName()).get());
	}
    
    @Modifying
    @PostMapping("/api/modifyUser")
    public void modifyUserSetting(Users user,HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile image) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(userRepository.existsIdusersByUsername(user.getUsername())) {
    		throw new NoSuchElementException("USERNAME IS TOKEN");
    	}
    	if(!image.isEmpty()) {
    		prev.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
    	}
    	if(!user.getUsername().isEmpty()) {
    		prev.setUsername(user.getUsername());
    	}
    	if(!user.getEmail().isEmpty()) {
    		prev.setEmail(user.getEmail());
    	}
    	if(!user.getName().isEmpty()) {
    		prev.setName(user.getName());
    	}
    	if(!user.getCity().isEmpty()) {
    		prev.setCity(user.getCity());
    	}
    	if(!user.getLinkfacebook().isEmpty()) {
    		prev.setLinkfacebook(user.getLinkfacebook());
    	}
    	if(!user.getLinkinstagram().isEmpty()) {
    		prev.setLinkinstagram(user.getLinkinstagram());
    	}
    	if(!user.getLinktwitter().isEmpty()) {
    		prev.setLinktwitter(user.getLinktwitter());
    	}
    	userRepository.save(prev);
    	response.sendRedirect("/profile-account-setting");
    }
    
    @Modifying
    @PostMapping("/api/changePassword")
    public void modifyPassword(HttpServletResponse response, HttpServletRequest request, @RequestParam String oldpassword,  @RequestParam String newpassword,  @RequestParam String repeatpassword) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	String page = "/error";
    	if(encoder.matches(oldpassword, prev.getPass())) {
    		System.out.println("entro");
    		if(newpassword.equals(repeatpassword)) {
    			prev.setPass(encoder.encode(newpassword));
    			userRepository.save(prev);
    	    	page = "/sign-in";
    		}
    		
    	}
    	response.sendRedirect(page);
    }
    
    @PostMapping("/api/deleteUser")
    public void deleteUser(HttpServletResponse response, HttpServletRequest request, @RequestParam String email, @RequestParam String pass, @RequestParam String explication) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(email.equals(prev.getEmail())) {
    		if(pass.equals(prev.getPass())) {
    			listproductrepo.deleteByIduser(prev);
    	    	relationrepo.deleteByUserone(prev);
    	    	relationrepo.deleteByUsertwo(prev);
    	    	messagerepo.deleteByIduser(prev);
    	    	messagerepo.deleteByIduserto(prev);
    	    	likerepo.deleteByIduser(prev);
    	    	postsrepo.deleteByIduser(prev);
    	    	productrepo.deleteByIduser(prev);
    	    	relationrepo.deleteByUserone(prev);
    	    	rolesRepository.deleteByIduser(prev);
    	    	userRepository.deleteById(prev.getIdusers());
    	    	response.sendRedirect("/profile-account-setting");
    		}
    	}
    	response.sendRedirect("/error");
    }
}