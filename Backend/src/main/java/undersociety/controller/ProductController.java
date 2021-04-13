package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.ListProducts;
import undersociety.models.Product;
import undersociety.services.ProductService;

@RestController
@CrossOrigin
public class ProductController {
		
	@Autowired
	 private ProductService productService;
	
	@PostMapping("/uploadProduct")
	private void uploadProduct(HttpServletResponse response, HttpServletRequest request, Product product, @RequestParam(required = false) MultipartFile imag0, @RequestParam(required = false) MultipartFile imag1, @RequestParam(required = false) MultipartFile imag2, @RequestParam(required = false) boolean tag, @RequestParam(required = false) boolean tagtwo, @RequestParam(required = false) boolean tagthree, @RequestParam(required = false) boolean tagfour, @RequestParam(required = false) boolean tagfive) throws IOException {
		productService.saveProduct(request.getUserPrincipal().getName(), product, imag0, imag1, imag2, tag, tagtwo, tagthree, tagfour, tagfive);
		response.sendRedirect("/index");
	}
	
	@GetMapping("/getMoreProducts")
	private Page<Product> getMoreProduct(Pageable page){
		return productService.getProductsPage(page);
	}
	
	@GetMapping("/getMoreProductsUser")
	private Page<Product> getMoreProductsUser(Pageable page, @RequestParam String username){
		return productService.getProductsPageByUser(username, page);
	}
	
	@GetMapping("/getProducts")
	private Page<Product> getProducts(Pageable page){
		return productService.getProductsPage(page);
	}
	
	@GetMapping("/imageProduct0/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct0(@PathVariable int idproduct) throws SQLException{
		Product p = productService.getProduct(idproduct);
    	Resource file = new InputStreamResource(p.getImage0().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage0().length())
				.body(file);
    }
	
	@GetMapping("/imageProduct1/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct1( @PathVariable int idproduct) throws SQLException{
		Product p = productService.getProduct(idproduct);
		Resource file = new InputStreamResource(p.getImage1().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage1().length())
				.body(file);
    }
	
	@GetMapping("/imageProduct2/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct2( @PathVariable int idproduct) throws SQLException{
		Product p = productService.getProduct(idproduct);
		Resource file = new InputStreamResource(p.getImage2().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage2().length())
				.body(file);
    }
	
	@GetMapping("/getBookmark")
	public List<ListProducts> getLikes(HttpServletRequest request) {
		return productService.getBookmarks(request.getUserPrincipal().getName());
	}
	
	@PostMapping("/addProduct")
	public boolean addProduct(@RequestParam int idproduct, HttpServletRequest request) {
		boolean succes = true;
		productService.addBookmark(request.getUserPrincipal().getName(), idproduct);
		return succes;
	}
	
	@PostMapping("/dropProduct")
	public boolean dropProduct(@RequestParam int idproduct, HttpServletRequest request) {
		boolean succes = true;
		productService.dropBookmark(request.getUserPrincipal().getName(), idproduct);
		return succes;
	}
}
