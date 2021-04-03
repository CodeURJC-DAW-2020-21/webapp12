package undersociety.controller.api.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
}
