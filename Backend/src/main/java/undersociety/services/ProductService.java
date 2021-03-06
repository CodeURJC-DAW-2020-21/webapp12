package undersociety.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.ListProducts;
import undersociety.models.Product;
import undersociety.models.ProductModel;
import undersociety.models.Tags;
import undersociety.models.Users;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.TagsRepository;
import undersociety.repositories.UserRepository;

@Service
public class ProductService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ListProductsRepository listproductrepo;

	@Autowired
	private TagsRepository tagsrepo;

	@Autowired
	private ProductRepository productrepo;

	@Autowired
	private ListProductsRepository bookmarkrepo;

/////////////////////////////////////////////////////API METHODS////////////////////////////////////////////////////////////////////////
	public List<Product> getAll() {

		return productrepo.findAll();

	}
	
	public Page<Product> getProductsByUser(int idUser, String page, int size){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return productrepo.findByiduser(user, PageRequest.of(Integer.parseInt(page), size));
	}
	
	public List<Product> getAllProductsByUser(int idUser){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return productrepo.findByiduser(user);
	}
	

	public Product getProduct(int idproduct) {
		return productrepo.findById(idproduct).orElseThrow(() -> new NoSuchElementException("Product not found"));
	}

	public Optional<Product> getProductById(int idproduct) {

		return productrepo.findById(idproduct);

	}

	public void deleteProductbyid(int id) {
		Product prev = productrepo.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));
		productrepo.deleteById(prev.getIdproduct());
		bookmarkrepo.deleteByIdproduct(prev);

	}


	public void saveProduct(Product newproduct) {
		productrepo.save(newproduct);

	}

	public List<ListProducts> getAllbookmarks() {

		return bookmarkrepo.findAll();

	}

	public void savebookmark(ListProducts bookmark) {
		Optional<Product> product = productrepo.findById(bookmark.getIdproduct().getIdproduct());
		Optional<Users> user = userRepository.findById(bookmark.getIduser().getIdusers());
		bookmarkrepo.save(new ListProducts(user.get(), product.get()));

	}

	public ListProducts getBookmarksapi(ListProducts bookmark) {
		ListProducts product = bookmarkrepo.findByiduserAndIdproduct(bookmark.getIduser(), bookmark.getIdproduct());
		return product;
	}

	public Optional<ListProducts> getBookmarksbyid(int id) {
		return bookmarkrepo.findById(id);
	}
	
	public void deletebookmarkbyid(int id) {
		bookmarkrepo.deleteById(id);

	}
	
	public boolean existsProduct(String title) {
		return productrepo.existsIdproductByTitle(title);
	}

	public boolean existsBookmark(ListProducts bookmark) {
		Optional<Product> product = productrepo.findById(bookmark.getIdproduct().getIdproduct());
		Optional<Users> user = userRepository.findById(bookmark.getIduser().getIdusers());
		return bookmarkrepo.existsIdproductlistByiduserAndIdproduct(user.get(),product.get());
	}

	public boolean existsProductById(Product idproduct) {
		Optional<Product> product = productrepo.findById(idproduct.getIdproduct());
		return product.isPresent();
	}

	public List<ListProducts> getBookmarksByUser(int id) {
		Optional<Users> user = userRepository.findById(id);
		if(user.isPresent()) {
			return bookmarkrepo.findByiduser(user.get());
		}else {
			return null;
		}
		
	}

	public List<Tags> getTags(){
		return tagsrepo.findAll();
	}
	
	public List<ProductModel> getPorductIndexApi(String username,int page) {
		Page<Product> products = productrepo.findAll(PageRequest.of(page, 10, Sort.by("idproduct").descending()));
		List<ListProducts> lp = listproductrepo.findByiduser(userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lp) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if (product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			} else {
				productmodel.setTypeUser("company");
			}
			if (product.getStatus().equalsIgnoreCase("in stock")) {
				productmodel.setColor("#228B22");
			}

			if (product.getStatus().equalsIgnoreCase("sold")) {
				productmodel.setColor("#DC143C");
			}

			if (product.getStatus().equalsIgnoreCase("reserved")) {
				productmodel.setColor("#FFD700");
			}

			if (bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			} else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		return productmodels;
	}
	
	
	public List<ProductModel> getProductUserPageApi(Users actual, Users follow, int page) {
		Page<Product> products = productrepo.findByiduser(follow,
				PageRequest.of(page, 10, Sort.by("idproduct").descending()));
		List<ListProducts> lproduct = listproductrepo.findByiduser(userRepository.findByusername(actual.getUsername())
				.orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lproduct) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if (product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			} else {
				productmodel.setTypeUser("company");
			}
			if (product.getStatus().equalsIgnoreCase("in stock")) {
				productmodel.setColor("#228B22");
			}

			if (product.getStatus().equalsIgnoreCase("sold")) {
				productmodel.setColor("#DC143C");
			}

			if (product.getStatus().equalsIgnoreCase("reserved")) {
				productmodel.setColor("#FFD700");
			}

			if (bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			} else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		return productmodels;
	}

	////////////////////////////////////////////////////// NORMAL
	////////////////////////////////////////////////////// METHODS////////////////////////////////////////////////////////////////////////
	public Page<Product> getProductsPage(Pageable page) {
		return productrepo.findAll(page);
	}

	public Page<Product> getProductsPageByUser(String username, Pageable page) {
		Users s = userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		return productrepo.findByiduser(s, page);
	}

	public void save(Product product) {
		productrepo.save(product);
	}

	public Product getProductByTitle(String title) {

		return productrepo.findBytitle(title);
	}

	public void saveProduct(String username, Product product, MultipartFile imag0, MultipartFile imag1,
			MultipartFile imag2, boolean tag, boolean tagtwo, boolean tagthree, boolean tagfour, boolean tagfive)
			throws IOException {
		Users s = userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		Page<Tags> listag = tagsrepo.findAll(PageRequest.of(0, 10, Sort.by("idtags").ascending()));
		if (imag0.isEmpty() == false) {
			product.setImage0(BlobProxy.generateProxy(imag0.getInputStream(), imag0.getSize()));
			product.setImg0(true);
		} else {
			product.setImg0(false);
		}
		if (imag1.isEmpty() == false) {
			product.setImage1(BlobProxy.generateProxy(imag1.getInputStream(), imag1.getSize()));
			product.setImg1(true);
		} else {
			product.setImg1(false);
		}
		if (imag2.isEmpty() == false) {
			product.setImage2(BlobProxy.generateProxy(imag2.getInputStream(), imag2.getSize()));
			product.setImg2(true);
		} else {
			product.setImg2(false);
		}
		product.setIduser(s);
		if (tag) {
			product.setIdtag(listag.getContent().get(0));
		}
		if (tagtwo) {
			product.setIdtagtwo(listag.getContent().get(1));
		}
		if (tagthree) {
			product.setIdtagthree(listag.getContent().get(2));
		}
		if (tagfour) {
			product.setIdtagfour(listag.getContent().get(3));
		}
		if (tagfive) {
			product.setIdtagfive(listag.getContent().get(4));
		}
		product.setStatus("in stock");
		productrepo.save(product);
	}

	public List<ListProducts> getBookmarks(String username) {
		Users s = userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		return listproductrepo.findByiduser(s);
	}

	public void addBookmark(String username, int idproduct) {
		Users s = userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new NoSuchElementException("Product not found"));
		ListProducts lp = new ListProducts();
		lp.setIdproduct(p);
		lp.setIduser(s);
		listproductrepo.save(lp);
	}

	public void dropBookmark(String username, int idproduct) {
		Users s = userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		Product p = productrepo.findById(idproduct).orElseThrow(() -> new NoSuchElementException("Product not found"));
		ListProducts lp = listproductrepo.findByiduserAndIdproduct(s, p);
		listproductrepo.deleteById(lp.getIdproductlist());
	}

	public List<ProductModel> getPorductIndex(String username) {
		Page<Product> products = productrepo.findAll(PageRequest.of(0, 10, Sort.by("idproduct").descending()));
		List<ListProducts> lp = listproductrepo.findByiduser(userRepository.findByusername(username)
				.orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lp) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if (product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			} else {
				productmodel.setTypeUser("company");
			}
			if (product.getStatus().equalsIgnoreCase("in stock")) {
				productmodel.setColor("#228B22");
			}

			if (product.getStatus().equalsIgnoreCase("sold")) {
				productmodel.setColor("#DC143C");
			}

			if (product.getStatus().equalsIgnoreCase("reserved")) {
				productmodel.setColor("#FFD700");
			}

			if (bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			} else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		return productmodels;
	}

	public List<ProductModel> getProductUserPage(Users actual, Users follow) {
		Page<Product> products = productrepo.findByiduser(follow,
				PageRequest.of(0, 10, Sort.by("idproduct").descending()));
		List<ListProducts> lproduct = listproductrepo.findByiduser(userRepository.findByusername(actual.getUsername())
				.orElseThrow(() -> new NoSuchElementException("User not found")));
		List<ProductModel> productmodels = new ArrayList<>();
		List<Integer> bookmarks = new ArrayList<>();
		for (ListProducts bookmark : lproduct) {
			bookmarks.add(bookmark.getIdproduct().getIdproduct());
		}
		for (Product product : products) {
			ProductModel productmodel = new ProductModel();
			if (product.getIduser().getUserprofile()) {
				productmodel.setTypeUser("user");
			} else {
				productmodel.setTypeUser("company");
			}
			if (product.getStatus().equalsIgnoreCase("in stock")) {
				productmodel.setColor("#228B22");
			}

			if (product.getStatus().equalsIgnoreCase("sold")) {
				productmodel.setColor("#DC143C");
			}

			if (product.getStatus().equalsIgnoreCase("reserved")) {
				productmodel.setColor("#FFD700");
			}

			if (bookmarks.contains(product.getIdproduct())) {
				productmodel.setBookamark("la la-check-circle");
			} else {
				productmodel.setBookamark("la la-bookmark");
			}
			productmodel.setProduct(product);
			productmodels.add(productmodel);
		}
		return productmodels;
	}

}
