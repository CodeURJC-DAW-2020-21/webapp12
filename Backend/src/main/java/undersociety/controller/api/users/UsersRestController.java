package undersociety.controller.api.users;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import undersociety.models.LikeAPost;
import undersociety.models.ListProducts;
import undersociety.models.Message;
import undersociety.models.Post;
import undersociety.models.PostModel;
import undersociety.models.Product;
import undersociety.models.ProductModel;
import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.services.PostsService;
import undersociety.services.ProductService;
import undersociety.services.UserService;

@RestController
@CrossOrigin
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
	public List<Users> getAllUsers(@RequestParam(required = false) String page){
		if(page != null) {
			return userService.getUsersPage(PageRequest.of(Integer.parseInt(page), 10 , Sort.by("username").ascending())).getContent();
		}
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
					responseCode = "406 ", 
					description = "Not Acceptable user creation the username or email is token", 
					content = {@Content(
							mediaType = "application/json"
							)}
					)
	})
	@JsonView(Users.Detailed.class)
	@PostMapping("/")
	public ResponseEntity<Users> registerUser(@Parameter(description="Object Json Type Users") @RequestBody Users user) throws IOException{
		if(user.getEmail() != null) {
			if(userService.existEmail(user.getEmail())) {
				return new ResponseEntity<>(user,HttpStatus.NOT_ACCEPTABLE);
			}
		}
		if(!userService.existsUser(user.getUsername())) {
			Resource imagedefault = new ClassPathResource("/static/images/avatar.png");
			user.setUserimg(BlobProxy.generateProxy(imagedefault.getInputStream(), imagedefault.contentLength()));
			Resource imageThemedefault = new ClassPathResource("/static/images/1600x400.png");
			user.setImageprofile(BlobProxy.generateProxy(imageThemedefault.getInputStream(), imageThemedefault.contentLength()));
			userService.regsiterUser(user);
			user = userService.getUser(user.getUsername());
			URI location = fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdusers()).toUri();
			return ResponseEntity.created(location).body(user);
		}else {
			return new ResponseEntity<>(user,HttpStatus.NOT_ACCEPTABLE);
		}
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
					),
			@ApiResponse(
					responseCode = "406 ", 
					description = "Not Acceptable user creation the username or email is token", 
					content = {@Content(
							mediaType = "application/json"
							)}
					)
	})
	@JsonView(Users.Detailed.class)
	@PutMapping("/{id}")
	public ResponseEntity<Users> replaceUser(@Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="Object Json Type Users") @RequestBody Users user) throws IOException{
		Optional<Users> use = userService.getUserId(id);
		if(!use.isEmpty()) {
			if(user.getEmail() != null) {
				if(userService.existEmail(user.getEmail())) {
					return new ResponseEntity<>(user,HttpStatus.NOT_ACCEPTABLE);
				}
			}
			if(user.getUsername() == null) {
				user.setUsername(use.get().getUsername());
				user.setIdusers(id);
				userService.modifyDataUser(user, use.get().getUsername(),null,null);
				if(user.getPass() != null) {
					userService.modifyPass(user.getUsername(), user.getPass());
				}
				user = userService.getUserId(id).get();
				return ResponseEntity.ok(user);
			}else {
				if(!userService.existsUser(user.getUsername())) {
					user.setIdusers(id);
					userService.modifyDataUser(user, use.get().getUsername(),null,null);
					if(user.getPass() != null) {
						userService.modifyPass(user.getUsername(), user.getPass());
					}
					user = userService.getUserId(id).get();
					return ResponseEntity.ok(user);
				}else {
					return new ResponseEntity<>(user,HttpStatus.NOT_ACCEPTABLE);
				}
			}
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
	@JsonView(Users.Detailed.class)
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
			return userService.getCustomers(PageRequest.of(Integer.parseInt(page), 10,Sort.by("username").ascending())).getContent();
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
			return userService.getCompanies(PageRequest.of(Integer.parseInt(page), 10,Sort.by("username").ascending())).getContent();
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
					),
			@ApiResponse(
					responseCode = "204", 
					description = "Image not found", 
					content = @Content
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
					)
	})
	@GetMapping("/{id}/imageProfile")
	public ResponseEntity<Object> getImageProfile(@Parameter(description="id of user to be searched") @PathVariable int id) throws SQLException{
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
					),
			@ApiResponse(
					responseCode = "204", 
					description = "Image not found", 
					content = @Content
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
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
					),
			@ApiResponse(
					responseCode = "204", 
					description = "Image not found", 
					content = @Content
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
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
					),
			@ApiResponse(
					responseCode = "204", 
					description = "Image not found", 
					content = @Content
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
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
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
					)
	})
	@JsonView(Post.PostDetails.class)
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> getAllPost( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = false) String page){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(page != null) {
			return ResponseEntity.ok(postsService.getPostsByUser(id,page,10).getContent());
		}else {
			return ResponseEntity.ok(postsService.getAllPostsByUser(id));
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
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
					)
	})
	@JsonView(Product.Simple.class)
	@GetMapping("/{id}/products")
	public ResponseEntity<List<Product>> getAllProducts( @Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = false) String page){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(page != null) {
			return ResponseEntity.ok( productsService.getProductsByUser(id,page,10).getContent() );
		}else {
			return ResponseEntity.ok(productsService.getAllProductsByUser(id));
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
					),
			@ApiResponse(
					responseCode = "404", 
					description = "User not found", 
					content = @Content
					)
	})
	@JsonView(UsersRelations.Basic.class)
	@GetMapping("/{id}/followings")
	public ResponseEntity<List<UsersRelations>> getUserRelations( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(userService.getFollowing(user.get().getUsername()));
		}else {
			return ResponseEntity.notFound().build();
		}
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
	@JsonView(UsersRelations.Basic.class)
	@GetMapping("/{id}/followers")
	public ResponseEntity<List<UsersRelations>> getRelationsUser( @Parameter(description="id of relation to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(user.isPresent()) {
			return  ResponseEntity.ok(userService.getFollowers(user.get().getUsername()));
		}else {
			return  ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Get a Bookmarks by id users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the bookmarks", 
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
	@GetMapping("/{id}/bookmarks")
	public ResponseEntity<List<ListProducts>> getBookmarks(@Parameter(description="id of user to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productsService.getBookmarksByUser(id));
	}
	
	@Operation(summary = "Get a Likes by id users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the likes", 
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
	@GetMapping("/{id}/likes")
	public ResponseEntity<List<LikeAPost>> getLike(@Parameter(description="id of user to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postsService.getLikesByUser(id));
	}

	@Operation(summary = "Get a Roles by id users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the Roles", 
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
	@JsonView(Roles.Basic.class)
	@GetMapping("/{id}/rols")
	public ResponseEntity<List<Roles>> getRoles(@Parameter(description="id of user to be searched") @PathVariable int id){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userService.getRoles(user.get()));
	}

	@Operation(summary = "Get a posts model by id users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the posts model", 
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
	@GetMapping("/{id}/models/posts")
	public ResponseEntity<List<PostModel>> getPostsModels(@Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = true) int page, @Parameter(description="username") @RequestParam(required = false) String username){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(username != null) {
			Optional<Users> follow = userService.getUserUsername(username);
			if(!follow.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(postsService.getPostUserPageApi(user.get(), follow.get(), page));
		}else {
			return ResponseEntity.ok(postsService.getPostIndexApi(user.get().getUsername(),page));
		}
	}
	
	@Operation(summary = "Get a products model by id users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the products model", 
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
	@GetMapping("/{id}/models/products")
	public ResponseEntity<List<ProductModel>> getProductsModels(@Parameter(description="id of user to be searched") @PathVariable int id, @Parameter(description="page") @RequestParam(required = true) int page, @Parameter(description="username") @RequestParam(required = false) String username){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(username != null) {
			Optional<Users> follow = userService.getUserUsername(username);
			if(!follow.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(productsService.getProductUserPageApi(user.get(), follow.get(), page));
		}else {
			return ResponseEntity.ok(productsService.getPorductIndexApi(user.get().getUsername(),page));
		}
	}
	
	@Operation(summary = "Get a chat users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the chat Users", 
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
	@GetMapping("/{id}/chat")
	public ResponseEntity<List<Message>> getChats(@Parameter(description="id of user to be searched") @PathVariable int id,  @Parameter(description="username") @RequestParam(required = true) String username){
		Optional<Users> user = userService.getUserId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userService.getChat(user.get().getUsername(), username));
	}
	
	@Operation(summary = "Get a most followed users")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", 
					description = "Found the most followed Users", 
					content = {@Content(
							mediaType = "application/json"
							)}
					)
	})
	@GetMapping("/ranking")
	public ResponseEntity<List<Users>> getRanking(){
		return ResponseEntity.ok(userService.getListMostFollowed());
	}
}
