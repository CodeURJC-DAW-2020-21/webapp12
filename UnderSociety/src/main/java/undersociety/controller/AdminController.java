package undersociety.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.AdminData;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;

@RestController
public class AdminController {
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private RolesRepository rolrepo;
	
	
	
	@GetMapping("/admindata")
	public AdminData getAdminData() {
		AdminData d = new AdminData();
	
		d.setUsers(userRepository.findByuserprofile(true).size());
		d.setCompanies(userRepository.findBycompanyprofile(true).size());
		d.setProducts(productrepo.findAll().size());
		d.setPosts(postsrepo.findAll().size());
		d.setRoles(rolrepo.findAll().size());
		
		return d;
	}
}
