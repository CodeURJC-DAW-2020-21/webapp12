package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.ListProducts;
import undersociety.models.Product;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.repositories.UserRepository;

@RestController
@CrossOrigin
public class StoreController {
		
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private ListProductsRepository listproductrepo;
	
	@Autowired
	private TagsRepository tagsrepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@PostMapping("/api/uploadProduct")
	private void uploadProduct(HttpServletResponse response, HttpServletRequest request, Product product, @RequestParam(required = false) MultipartFile imag0, @RequestParam(required = false) MultipartFile imag1, @RequestParam(required = false) MultipartFile imag2, @RequestParam(required = false) boolean tag, @RequestParam(required = false) boolean tagtwo, @RequestParam(required = false) boolean tagthree, @RequestParam(required = false) boolean tagfour, @RequestParam(required = false) boolean tagfive) throws IOException {
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Page<Tags> listag = tagsrepo.findAll(PageRequest.of(0, 10,Sort.by("idtags").ascending()));
		if(imag0.isEmpty() == false) {
			product.setImage0(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
			product.setImg0(true);
		}else {
			product.setImg0(false);
		}
		if(imag1.isEmpty() == false) {
			product.setImage1(BlobProxy.generateProxy(imag1.getInputStream(), imag1.getSize()));		
			product.setImg1(true);
		}else {
			product.setImg1(false);
		}
		if(imag2.isEmpty() == false) {
			product.setImage2(BlobProxy.generateProxy(imag2.getInputStream(), imag2.getSize()));
			product.setImg2(true);
		}else {
			product.setImg2(false);
		}
		product.setIduser(s);
		if(tag) {
			product.setIdtag(listag.getContent().get(0));
		}
		if(tagtwo) {
			product.setIdtagtwo(listag.getContent().get(1));		
		}
		if(tagthree) {
			product.setIdtagthree(listag.getContent().get(2));
		}
		if(tagfour) {
			product.setIdtagfour(listag.getContent().get(3));
		}
		if(tagfive) {
			product.setIdtagfive(listag.getContent().get(4));
		}
		product.setStatus("in stock");
		productrepo.save(product);
		response.sendRedirect("/index");
	}
	
	@GetMapping("/api/getMoreProducts")
	private Page<Product> getMoreProduct(Pageable page){
		return productrepo.findAll(page);
	}
	
	@GetMapping("/api/getProducts")
	private Page<Product> getProducts(Pageable page){
		return productrepo.findAll(page);
	}
	
	@GetMapping("/api/getBookmark")
	public List<ListProducts> getLikes(HttpServletRequest request) {
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<ListProducts> lp = listproductrepo.findByiduser(s);
		return lp;
	}
	
	@GetMapping("/api/imageProduct0/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct0( @PathVariable int idproduct) throws SQLException{
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new UsernameNotFoundException("Product not found"));
    	Resource file = new InputStreamResource(p.getImage0().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage0().length())
				.body(file);
    }
	
	@GetMapping("/api/imageProduct1/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct1( @PathVariable int idproduct) throws SQLException{
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new UsernameNotFoundException("Product not found"));
    	Resource file = new InputStreamResource(p.getImage1().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage1().length())
				.body(file);
    }
	
	@GetMapping("/api/imageProduct2/{idproduct}")
    private ResponseEntity<Object> downloadImageProduct2( @PathVariable int idproduct) throws SQLException{
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new UsernameNotFoundException("Product not found"));
    	Resource file = new InputStreamResource(p.getImage2().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.getImage2().length())
				.body(file);
    }
	
	@PostMapping("/api/addProduct")
	public boolean addProduct(@RequestParam int idproduct, HttpServletRequest request) {
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new UsernameNotFoundException("Product not found"));
		ListProducts lp = new ListProducts();
		lp.setIdproduct(p);
		lp.setIduser(s);
		return listproductrepo.save(lp) != null;
	}
	
	@PostMapping("/api/dropProduct")
	public boolean dropProduct(@RequestParam int idproduct, HttpServletRequest request) {
		Users s = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new UsernameNotFoundException("Product not found"));
		ListProducts lp = listproductrepo.findByiduserAndIdproduct(s, p);
		if(lp != null) {
			listproductrepo.deleteById(lp.getIdproductlist());
			return true;
		}else {
			return false;
		}
	}
}
