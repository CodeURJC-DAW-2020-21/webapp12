package undersociety.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.Product;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.services.UserService;

@RestController
@CrossOrigin
public class StoreController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private TagsRepository tagsrepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@PostMapping("/api/uploadProduct")
	private void uploadProduct(HttpServletResponse response, HttpServletRequest request, Product product, @RequestParam(required = false) MultipartFile imag0, @RequestParam(required = false) MultipartFile imag1, @RequestParam(required = false) MultipartFile imag2, @RequestParam(required = false) boolean tag, @RequestParam(required = false) boolean tagtwo, @RequestParam(required = false) boolean tagthree) throws IOException {
		Users s = (Users) userservice.findByUser_name(request.getUserPrincipal().getName());
		Page<Tags> listag = tagsrepo.findAll(PageRequest.of(0, 10,Sort.by("idtags").ascending()));
		if(imag0 != null) {
			product.setImage0(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
		}
		if(imag1 != null) {
			product.setImage1(BlobProxy.generateProxy(imag1.getInputStream(), imag1.getSize()));		
		}
		if(imag2 != null) {
			product.setImage2(BlobProxy.generateProxy(imag2.getInputStream(), imag2.getSize()));
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
		product.setStatus("in stock");
		productrepo.save(product);
		response.sendRedirect("/index");
	}
	
	@GetMapping("/api/getMoreProducts")
	private Page<Product> getMorePost(Pageable page){
		return productrepo.findAll(page);
	}
	
	
	@GetMapping("/api/imageProduct0/{idproduct}")
    private ResponseEntity<Object> downloadImagePost0( @PathVariable int idproduct) throws SQLException{
		Optional<Product> p = productrepo.findById(idproduct);
    	Resource file = new InputStreamResource(p.get().getImage0().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.get().getImage0().length())
				.body(file);
    }
	
	@GetMapping("/api/imageProduct1/{idproduct}")
    private ResponseEntity<Object> downloadImagePost1( @PathVariable int idproduct) throws SQLException{
		Optional<Product> p = productrepo.findById(idproduct);
    	Resource file = new InputStreamResource(p.get().getImage1().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.get().getImage1().length())
				.body(file);
    }
	
	@GetMapping("/api/imageProduct2/{idproduct}")
    private ResponseEntity<Object> downloadImagePost2( @PathVariable int idproduct) throws SQLException{
		Optional<Product> p = productrepo.findById(idproduct);
    	Resource file = new InputStreamResource(p.get().getImage2().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(p.get().getImage2().length())
				.body(file);
    }
}
