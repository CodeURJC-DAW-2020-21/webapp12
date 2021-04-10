package undersociety.controller.api.products;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import undersociety.models.ListProducts;
import undersociety.services.ProductService;

@RestController
@CrossOrigin
@RequestMapping("api/bookmarks")
public class BookmarksRestController {
	
	@Autowired
	private ProductService productService;
	
	
	@Operation(summary = "Get a all Bookmarks")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Bookmarks", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ) 
	})
	@JsonView(ListProducts.Basic.class)
	@GetMapping("/")
	public List<ListProducts> getAllbookmarks(){
		return productService.getAllbookmarks();
	}
	
	@Operation(summary = "Create Bookmark")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful Bookmark creation", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 )  
	})
	@JsonView(ListProducts.Basic.class)
	@PostMapping("/")
	public ResponseEntity<ListProducts> registerbookmark(@Parameter(description="Object Type ListProducts") @RequestBody ListProducts bookmark) throws IOException{
		productService.savebookmark(bookmark);
		bookmark = productService.getBookmarksapi(bookmark);
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(bookmark.getIdproduct()).toUri();
		return ResponseEntity.created(location).body(bookmark);
	}
	
	@Operation(summary = "Get a Bookmark by id")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Found the Bookmark", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Bookmark not found", 
	 content = @Content
	 )  
	})
	@JsonView(ListProducts.Basic.class)
	@GetMapping("/{id}")
	public ResponseEntity<ListProducts> getbookmark ( @Parameter(description="id of bookmark to be searched") @PathVariable int id) throws IOException{
		Optional<ListProducts> bookmark = productService.getBookmarksbyid(id);
		if(!bookmark.isEmpty()) {
			return ResponseEntity.ok(bookmark.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Delete a Bookmark")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "200", 
	 description = "Successful Bookmark delete", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Bookmark not found", 
	 content = @Content
	 ) 
	})
	@JsonView(ListProducts.Basic.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<ListProducts> deletebookmark( @Parameter(description="id of bookmark to be searched") @PathVariable int id){
		Optional<ListProducts> bookmark = productService.getBookmarksbyid(id);
		if(bookmark.isPresent()){
			productService.deletebookmarkbyid(id);
			return ResponseEntity.ok(bookmark.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Modify a Bookmark")
	@ApiResponses(value = { 
	@ApiResponse(
	 responseCode = "201", 
	 description = "Successful Bookmark modification", 
	 content = {@Content(
	 mediaType = "application/json"
	 )}
	 ),
	 @ApiResponse(
	 responseCode = "404", 
	 description = "Bookmark not found", 
	 content = @Content
	 ) 
	})
	@JsonView(ListProducts.Basic.class)
	@PutMapping("/{id}")
	public ResponseEntity<ListProducts> replacebookmark( @Parameter(description="id of bookmark to be searched") @PathVariable int id, @Parameter(description="Object Type ListProducts") @RequestBody ListProducts newbookmark) throws IOException{
		Optional<ListProducts> bookmark = productService.getBookmarksbyid(id);
		if(!bookmark.isEmpty()) {
			newbookmark.setIdproductlist(id);
			productService.savebookmark(newbookmark);
			newbookmark = productService.getBookmarksbyid(id).get();
			return ResponseEntity.ok(newbookmark);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
