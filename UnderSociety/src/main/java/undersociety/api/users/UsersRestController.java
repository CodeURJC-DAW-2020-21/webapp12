package undersociety.api.users;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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
	
	@JsonView(Users.Detailed.class)
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isEmpty()){
			return ResponseEntity.ok(user.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Users> registerUser(@RequestBody Users user) throws IOException{
		userService.registerUsers(user, null);
		user = userService.getUser(user.getUsername());
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdusers()).toUri();
		return ResponseEntity.created(location).body(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> replaceUser(@PathVariable int id,@RequestBody Users user) throws IOException{
		Optional<Users> use = userService.getUserId(id);
		if(!use.isEmpty()) {
			userService.modifyDataUser(user, use.get().getUsername(), null, null);
			user = userService.getUserId(id).get();
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
