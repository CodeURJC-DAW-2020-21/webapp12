package undersociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.Users;
import undersociety.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



@RestController
@CrossOrigin
public class DataController {
	
	@Autowired
	private UserService userservice;

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
    	List<Users> users = userservice.load();
    	Set<String> set = new HashSet<String>();
    	for (Users u : users) {
			set.add(u.getUsername());
		}
        return set;
    }
}
