package undersociety.api.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import undersociety.models.Users;
import undersociety.services.UserService;

@RestController
@RequestMapping("api/users")
public class UsersRestController {
	
	@Autowired
	private UserService userService;
	
	@JsonView(Users.Detailed.class)
	@GetMapping("/")
	public List<Users> getAllUsers(){
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isEmpty()){
			return ResponseEntity.ok(user.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
