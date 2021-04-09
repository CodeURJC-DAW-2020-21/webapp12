package undersociety.controller.api.products;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.ListProducts;
import undersociety.models.Product;
import undersociety.services.ProductService;

@RestController
@RequestMapping("api/bookmarks")
public class BookmarksRestController {
	
	private ProductService productService;
	
	
	
	
	@GetMapping("/")
	public List<ListProducts> getAllbookmarks(){
		
		
		return productService.getAllbookmarks();
	}
	
	
	@PostMapping("/")
	public ResponseEntity<ListProducts> registerbookmark(@RequestBody ListProducts bookmark) throws IOException{
		productService.savebookmark(bookmark);
		bookmark = productService.getBookmarksapi(bookmark);
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(bookmark.getIdproduct()).toUri();
		return ResponseEntity.created(location).body(bookmark);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListProducts> getbookmark (@PathVariable int id) throws IOException{
		Optional<ListProducts> bookmark = productService.getBookmarksbyid(id);
		if(!bookmark.isEmpty()) {
			return ResponseEntity.ok(bookmark.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ListProducts> deletebookmark(@PathVariable int id){
		Optional<Product> product = productService.getProductById(id);
		if(product.isPresent()){
			productService.deleteProduct(product.get().getDescription());
			return ResponseEntity.ok(product.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ListProducts> replacebookmark(@PathVariable int id,@RequestBody Product newproduct) throws IOException{
		Optional<Product> product = productService.getProductById(id);
		if(!product.isEmpty()) {
			newproduct.setIdproduct(id);
			productService.saveProduct(newproduct);
			newproduct = productService.getProductById(id).get();
			return ResponseEntity.ok(newproduct);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
