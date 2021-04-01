package undersociety.controller.api.users;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.services.UserService;

@RestController
@RequestMapping("/api/relations")
public class RelationsRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<UsersRelations> getRelations(){
		return userService.getAllRelations();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersRelations> getRelationsId(@PathVariable int id){
		Optional<UsersRelations> relation = userService.getRelations(id);
		if(!relation.isEmpty()){
			return ResponseEntity.ok(relation.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/users/{id}/following")
	public List<UsersRelations> getUserRelations(@PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		return userService.getFollowing(user.get().getUsername());
	}
	
	@GetMapping("/users/{id}/followers")
	public List<UsersRelations> getRelationsUser(@PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		return userService.getFollowers(user.get().getUsername());
	}
	
	@PostMapping("/")
	public ResponseEntity<UsersRelations> registerRelation(@RequestBody UsersRelations relation) throws IOException{
		userService.saveRelation(relation);
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(relation.getIduserrelation()).toUri();
		return ResponseEntity.created(location).body(relation);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsersRelations> deleteRelation(@PathVariable int id){
		Optional<UsersRelations> relation = userService.getRelations(id);
		if(relation.isPresent()){
			userService.deleteRelation(relation.get());
			return ResponseEntity.ok(relation.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
