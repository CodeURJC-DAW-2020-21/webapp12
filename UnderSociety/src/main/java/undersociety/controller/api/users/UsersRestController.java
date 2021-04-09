package undersociety.controller.api.users;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import undersociety.models.Post;
import undersociety.models.Product;
import undersociety.models.Users;
import undersociety.services.PostsService;
import undersociety.services.ProductService;
import undersociety.services.UserService;

@RestController
@RequestMapping("api/users")
public class UsersRestController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private ProductService productsService;
	
	@Operation(summary = "Get a all users")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Users", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(Users.Detailed.class)
	@GetMapping("/")
	public List<Users> getAllUsers(){
		return userService.getAll();
	}
	
	@Operation(summary = "Get a user by its id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the User", 
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
	@JsonView(Users.Detailed.class)
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsersById(@Parameter(description="id of user to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isEmpty()){
			return ResponseEntity.ok(user.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Create a user")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful user creation", 
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
	@PostMapping("/")
	public ResponseEntity<Users> registerUser(@Parameter(description="Object Json Type Users") @RequestBody Users user) throws IOException{
		userService.saveUser(user);
		user = userService.getUser(user.getUsername());
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdusers()).toUri();
		return ResponseEntity.created(location).body(user);
	}
	
	@Operation(summary = "Modify a user")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful user modification", 
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
	@PutMapping("/{id}")
	public ResponseEntity<Users> replaceUser(@Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="Object Json Type Users") @RequestBody Users user) throws IOException{
		Optional<Users> use = userService.getUserId(id);
		if(!use.isEmpty()) {
			userService.saveUser(user);
			user = userService.getUserId(id).get();
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Delete a user")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Successful user delete", 
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
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteUser(@Parameter(description="id of user to be searched") @PathVariable int id){
		Optional<Users> s = userService.getUserId(id);
		if(s.isPresent()){
			userService.deleteUserById(id);
			return ResponseEntity.ok(s.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Get a all users type customers")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Users type customers", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(Users.Detailed.class)
	@GetMapping("/customers")
	public List<Users> getUsers( @Parameter(description="page") @RequestParam(required = false) String page){
		if(page != null) {
			return userService.getUsersPage(PageRequest.of(Integer.parseInt(page), 5)).getContent();
		}else {
			return userService.getAllUsers();
		}
	}
	
	@Operation(summary = "Get a all users type companies")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Users type companies", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(Users.Detailed.class)
	@GetMapping("/companies")
	public List<Users> getCompanies( @Parameter(description="page") @RequestParam(required = false) String page){
		if(page != null) {
			return userService.getCompanies(PageRequest.of(Integer.parseInt(page), 5)).getContent();
		}else {
			return userService.getAllCompanies();
		}
	}
	
	@Operation(summary = "Get a profile image user by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Image Profile", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
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
	
	@Operation(summary = "Get a profile theme image user by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Image Profile Theme", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@GetMapping("/{id}/imageThemeProfile")
	public ResponseEntity<Object> getImageThemeProfile( @Parameter(description="id of user to be searched") @PathVariable int id) throws SQLException{
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
	
	@Operation(summary = "create a profile image user by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Create the ImageProfile", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@PostMapping("/{id}/imageProfile")
	public ResponseEntity<Object> uploadImageProfile( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="user profile picture") @RequestParam MultipartFile image) throws SQLException, IOException{
		Optional<Users> user = userService.getUserId(id);
		if(user.isPresent()) {
			if(image != null) {
				user.get().setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
				userService.saveUser(user.get());
				URI location = fromCurrentRequest().build().toUri();
				return ResponseEntity.created(location).build();
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "create a profile image theme user by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Create the ImageProfile Theme", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@PostMapping("/{id}/imageThemeProfile")
	public ResponseEntity<Object> uploadImageThemeProfile( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="user theme page picture") @RequestParam MultipartFile image) throws SQLException, IOException{
		Optional<Users> user = userService.getUserId(id);
		if(user.isPresent()) {
			if(image != null) {
				user.get().setImageprofile(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
				userService.saveUser(user.get());
				URI location = fromCurrentRequest().build().toUri();
				return ResponseEntity.created(location).build();
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "get all posts by user")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "found all posts by user id", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@GetMapping("/{id}/posts")
	public List<Post> getAllPost( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = false) String page){
		if(page != null) {
			return postsService.getPostsByUser(id,page,5).getContent();
		}else {
			return postsService.getAllPostsByUser(id);
		}
	}
	
	@Operation(summary = "get all Products by user")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "found all products by user id", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(Product.Simple.class)
	@GetMapping("/{id}/products")
	public List<Product> getAllProducts( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = false) String page){
		if(page != null) {
			return productsService.getProductsByUser(id,page,5).getContent();
		}else {
			return productsService.getAllProductsByUser(id);
		}
	}
	
}
