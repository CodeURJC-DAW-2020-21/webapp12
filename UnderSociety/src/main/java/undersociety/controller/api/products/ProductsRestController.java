package undersociety.controller.api.products;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
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
	public ResponseEntity<Product> deleteProduct(@PathVariable int id){
		Optional<Product> product = productService.getProductById(id);
		if(product.isPresent()){
			productService.deleteProduct(product.get().getDescription());
			return ResponseEntity.ok(product.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> replaceProduct(@PathVariable int id,@RequestBody Product newproduct) throws IOException{
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
	
	@GetMapping("/{id}/image0")
	public ResponseEntity<Object> getImage0(@PathVariable int id) throws SQLException{
		Optional<Product> product = productService.getProductById(id);
		if(product.isPresent()) {
			if(product.get().getImage0() != null) {
				Resource file = new InputStreamResource(product.get().getImage0().getBinaryStream());
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
						.contentLength(product.get().getImage0().length())
						.body(file);
	    	}else {
	    		return ResponseEntity.noContent().build();
	    	}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}/image1")
	public ResponseEntity<Object> getImage1(@PathVariable int id) throws SQLException{
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
	
	@GetMapping("/{id}/image2")
	public ResponseEntity<Object> getImage2(@PathVariable int id) throws SQLException{
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
	
	
	
	
	
}
