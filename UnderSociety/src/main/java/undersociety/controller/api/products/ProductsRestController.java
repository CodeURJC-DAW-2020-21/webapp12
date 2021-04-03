package undersociety.controller.api.products;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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

import undersociety.models.Product;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.services.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductsRestController {
	
	
	@Autowired
	private ProductService productService;
	public interface ProductDetails extends Product.Simple, Product.Multiple, Users.Basic, Tags.Simple{}
	
	
	
	@JsonView(ProductDetails.class)
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return productService.getAll();
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Product> registerProduct(@RequestBody Product product) throws IOException{
		productService.save(product); 
		product = productService.getProductByTitle(product.getTitle());
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(product.getIdproduct()).toUri();
		return ResponseEntity.created(location).body(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct (@PathVariable int id) throws IOException{
		Optional<Product> product = productService.getProductById(id);
		if(!product.isEmpty()) {
			return ResponseEntity.ok(product.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> DeleteProduct(@PathVariable int id,@RequestBody Users user) throws IOException{
		Optional<Users> use = userService.getUserId(id);
		if(!use.isEmpty()) {
			userService.saveUser(user);
			user = userService.getUserId(id).get();
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> replaceProduct(@PathVariable int id,@RequestBody Users user) throws IOException{
		Optional<Users> use = userService.getUserId(id);
		if(!use.isEmpty()) {
			userService.saveUser(user);
			user = userService.getUserId(id).get();
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
}
