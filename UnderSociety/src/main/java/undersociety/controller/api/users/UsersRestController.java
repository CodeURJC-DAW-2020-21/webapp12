package undersociety.controller.api.users;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import undersociety.models.Message;
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable int id){
		Optional<Users> s = userService.getUserId(id);
		if(s.isPresent()){
			userService.deleteUser(s.get().getUsername());
			return ResponseEntity.ok(s.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/users")
	public Page<Users> getUsers( Pageable page){
		return userService.getUsersPage(page);
	}
	
	@GetMapping("/companies")
	public Page<Users> getCompanies( Pageable page){
		return userService.getCompanies(page);
	}
	
	@GetMapping("/{id}/imageProfile")
	public ResponseEntity<Object> getImageProfile(@PathVariable int id) throws SQLException{
		Optional<Users> s = userService.getUserId(id);
		if(s.isPresent()) {
			if(s.get().getUserimg() != null) {
				Resource file = new InputStreamResource(s.get().getUserimg().getBinaryStream());
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
						.contentLength(s.get().getUserimg().length())
						.body(file);
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}/imageThemeProfile")
	public ResponseEntity<Object> getImageThemeProfile(@PathVariable int id) throws SQLException{
		Optional<Users> s = userService.getUserId(id);
		if(s.isPresent()) {
			if(s.get().getImageprofile() != null) {
				Resource file = new InputStreamResource(s.get().getImageprofile().getBinaryStream());
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
						.contentLength(s.get().getImageprofile().length())
						.body(file);
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}/chats/{to}")
	public List<Message> getChat(@PathVariable int id, @PathVariable int to){
		Optional<Users> from = userService.getUserId(id);
		Optional<Users> destiny = userService.getUserId(to);
		return userService.getChat(from.get().getUsername(), destiny.get().getUsername());
	}
}
