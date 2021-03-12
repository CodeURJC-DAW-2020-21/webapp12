package undersociety.controller;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;
import undersociety.services.UserService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RestController
@CrossOrigin
public class UsersController {
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private UserService userservice;
		
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private PasswordEncoder encoder;
	
    @GetMapping("/fetchAllUsers")
    public Page<Users> fetchAll() {
        return userRepository.findAll(PageRequest.of(0, 10,Sort.by("username").ascending()));
    }
    
    @GetMapping("/getUserPage")
    public Page<Users> getUserPage(Pageable page) {
        return userRepository.findAll(page);
    }
    
    @PostMapping("/registerUser")
	private void registerUser(Users user,HttpServletResponse response , HttpServletRequest sesion, @RequestParam(required = false) MultipartFile imagen) throws IOException, SQLException {
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
		response.sendRedirect("sign-in");
	}
    
    @PostMapping("/registerCompany")
	private void registerCompany(Users user,HttpServletResponse response, HttpServletRequest sesion, @RequestParam(required = false) MultipartFile imagen) throws IOException {
    	if(imagen != null) {
    		user.setUserimg(BlobProxy.generateProxy(imagen.getInputStream(), imagen.getSize()));
    	}
		user.setUserprofile(false);
		user.setCompanyprofile(true);
		System.out.println(user.getUserprofile());
		System.out.println(user.getCompanyprofile());
		user.setPass(encoder.encode(user.getPass()));
		userservice.save(user);
		Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found")));
		Roles r = new Roles();
		r.setIduser(use);
		r.setRol("USER");
		rolesRepository.save(r);
		response.sendRedirect("sign-in");
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
    
    @GetMapping("/moreUsers")
    public Page<Users> getMoreUsers(Pageable page){    	
    	return userRepository.findByuserprofile(true,page);
    }
    
    @GetMapping("/moreCompany")
    public Page<Users> getMoreCompany(Pageable page){    	
    	return userRepository.findBycompanyprofile(true,page);
    }
}
