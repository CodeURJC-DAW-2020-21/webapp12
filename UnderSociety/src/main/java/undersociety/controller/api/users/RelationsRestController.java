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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.services.UserService;

@RestController
@RequestMapping("/api/relations")
public class RelationsRestController {
	@Autowired
	private UserService userService;
	
	@Operation(summary = "Get a all relations users")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Users relations", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@GetMapping("/")
	public List<UsersRelations> getRelations(){
		return userService.getAllRelations();
	}
	
	@Operation(summary = "Get a relations by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Relations", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Relation not found", 
	 content = @Content
	 )  
	})
	@GetMapping("/{id}")
	public ResponseEntity<UsersRelations> getRelationsId( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<UsersRelations> relation = userService.getRelations(id);
		if(!relation.isEmpty()){
			return ResponseEntity.ok(relation.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Get a followings by id users")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the followings", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 )  
	})
	@GetMapping("/users/{id}/following")
	public List<UsersRelations> getUserRelations( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		return userService.getFollowing(user.get().getUsername());
	}
	
	@Operation(summary = "Get a followers by id users")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the followers", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "User not found", 
	 content = @Content
	 )  
	})
	@GetMapping("/users/{id}/followers")
	public List<UsersRelations> getRelationsUser( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		return userService.getFollowers(user.get().getUsername());
	}
	
	@Operation(summary = "Create relation")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful relation creation", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 )  
	})
	@PostMapping("/")
	public ResponseEntity<UsersRelations> registerRelation( @Parameter(description="Object Json Type UsersRelations") @RequestBody UsersRelations relation) throws IOException{
		userService.saveRelation(relation);
		relation.setIduserrelation( userService.getRelationId(relation) );
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(relation.getIduserrelation()).toUri();
		return ResponseEntity.created(location).body(relation);
	}
	
	@Operation(summary = "Delete a relation")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Successful relation delete", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Relation not found", 
	 content = @Content
	 ) 
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<UsersRelations> deleteRelation( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<UsersRelations> relation = userService.getRelations(id);
		if(relation.isPresent()){
			userService.deleteRelation(relation.get());
			return ResponseEntity.ok(relation.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
