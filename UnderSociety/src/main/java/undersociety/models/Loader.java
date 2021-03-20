package undersociety.models;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.password.PasswordEncoder;

import undersociety.repositories.LikesRepository;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.TagsRepository;
import undersociety.repositories.UserRepository;
import undersociety.repositories.UsersRelationsRepository;

public class Loader {

	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images/");
	
	@Autowired
	private ProductRepository productrepo;

	@Autowired
	private ListProductsRepository listproductrepo;

	@Autowired
	private PostRepository postsrepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TagsRepository tagrepo;	
	
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private PasswordEncoder encoder;

	
	
	

	public Loader() {
	
	}
	
	


	public Loader(LikesRepository likerepo, UsersRelationsRepository relationrepo, ProductRepository productrepo,
			ListProductsRepository listproductrepo, PostRepository postsrepo, UserRepository userRepository,
			TagsRepository tagrepo,  RolesRepository rolesRepository,
			PasswordEncoder encoder) {
		super();
		this.productrepo = productrepo;
		this.listproductrepo = listproductrepo;
		this.postsrepo = postsrepo;
		this.userRepository = userRepository;
		this.tagrepo = tagrepo;
		this.rolesRepository = rolesRepository;
		this.encoder = encoder;
	}




	@PostConstruct
	public void load() throws IOException {
		//Images User 
		Path imagePath = IMAGES_FOLDER.resolve("FOndo2.jpeg");
		Resource image = new UrlResource(imagePath.toUri());
		Blob img = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img1 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img2 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img3 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img4 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img5 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img6 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img7 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img8 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img9 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img10 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img11 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img12 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img13 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img14 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img15 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img16 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img17 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img18 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img19 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		
		
		//Images Companies 
		Blob img20 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img21 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img22 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img23 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img24 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img25 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img26 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img27 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img28 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img29 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img30 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img31 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img32 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img33 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img34 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img35 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img36 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img37 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img38 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img39 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		
		//Images Post
		Blob imgpost = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost1 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost2 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost3 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost4 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost5 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost6 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost7 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost8 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost9 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost10 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost11 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost12 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost13 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost14 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost15 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost16 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost17 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost18 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgpost19 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		
		//Images Post
		Blob imgproduct = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct1 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct2 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct3 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct4 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct5 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct6 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct7 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct8 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct9 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct10 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct11 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct12 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct13 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct14 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct15 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct16 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct17 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct18 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct19 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		
		Blob imgproduct20 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct21 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct22 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct23 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct24 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct25 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct26 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct27 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct28 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct29 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob imgproduct30 = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		
		
		
		//Tags Creations
		Tags tag1 = new Tags();
		Tags tag2 = new Tags();
		Tags tag3 = new Tags();
		Tags tag4 = new Tags();
		Tags tag5 = new Tags();
		tag1.setDescription("Electronics");
		tag2.setDescription("Furniture");
		tag3.setDescription("Appliance");
		tag4.setDescription("Books");
		tag5.setDescription("Clothes");
		
		
		
		//Users creations
		Users user1 = new Users("sr.crnt@hotmail.com","h",encoder.encode("h"),"h",img, false,true, "Madrid","","usu1", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user2 = new Users("sr.crnt2@hotmail.com","Cette02",encoder.encode("cette01"),"Cristian2",img1, false,true, "Barcelona","","usu2", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user3 = new Users("sr.crnt3@hotmail.com","Cette03",encoder.encode("cette01"),"Cristian3",img2, false,true, "Malaga","","usu3", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user4 = new Users("sr.crnt4@hotmail.com","Cette04",encoder.encode("cette01"),"Cristian4",img3, false,true, "Barcelona","","usu4", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user5 = new Users("sr.crnt5@hotmail.com","Cette05",encoder.encode("cette01"),"Cristian5",img4, false,true, "Madrid","","usu5", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user6 = new Users("sr.crnt6@hotmail.com","Cette06",encoder.encode("cette01"),"Cristian6",img5, false,true, "Barcelona","","usu6", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user7 = new Users("sr.crnt7@hotmail.com","Cette07",encoder.encode("cette01"),"Cristian7",img6, false,true, "Madrid","","usu7", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user8 = new Users("sr.crnt8@hotmail.com","Cette08",encoder.encode("cette01"),"Cristian8",img7, false,true, "Malaga","","usu8", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user9 = new Users("sr.crnt9@hotmail.com","Cette09",encoder.encode("cette01"),"Cristian9",img8, false,true, "Barcelona","","usu9", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user10 = new Users("sr.crnt10@hotmail.com","Cette10",encoder.encode("cette01"),"Cristian10",img9, false,true, "Madrid","","usu10", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user11 = new Users("sr.crnt11@hotmail.com","Cette11",encoder.encode("cette01"),"Cristian11",img10, false,true, "Barcelona","","usu11", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user12 = new Users("sr.crnt12@hotmail.com","Cette12",encoder.encode("cette01"),"Cristian12",img11, false,true, "Madrid","","usu12", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user13 = new Users("sr.crnt13@hotmail.com","Cette13",encoder.encode("cette01"),"Cristian13",img12, false,true, "Madrid","","usu13", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user14 = new Users("sr.crnt14@hotmail.com","Cette14",encoder.encode("cette01"),"Cristian14",img13, false,true, "Barcelona","","usu14", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user15 = new Users("sr.crnt15@hotmail.com","Cette15",encoder.encode("cette01"),"Cristian15",img14, false,true, "Malaga","","usu15", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user16 = new Users("sr.crnt16@hotmail.com","Cette16",encoder.encode("cette01"),"Cristian16",img15, false,true, "Madrid","","usu16", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user17 = new Users("sr.crnt17@hotmail.com","Cette17",encoder.encode("cette01"),"Cristian17",img16, false,true, "Barcelona","","usu17", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user18 = new Users("sr.crnt18@hotmail.com","Cette18",encoder.encode("cette01"),"Cristian18",img17, false,true, "Malaga","","usu18", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user19 = new Users("sr.crnt19@hotmail.com","Cette19",encoder.encode("cette01"),"Cristian19",img18, false,true, "Madrid","","usu19", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user20 = new Users("sr.crnt20@hotmail.com","cette20",encoder.encode("cette01"),"Cristian",img19, false,true, "Barcelona","","usu20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		
		Users company1 = new Users("ikea@hotmail.com","Ikea",encoder.encode("i"),"Ikea",img20, true,false, "Madrid","","company1", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company2 = new Users("nike@hotmail.com","Nike",encoder.encode("n"),"Nike",img21, true,false, "Barcelona","","company2", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company3 = new Users("golf@hotmail.com","Golf",encoder.encode("g"),"Golf",img22, true,false, "Malaga","","company3", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company4 = new Users("alcampo@hotmail.com","Alcampo",encoder.encode("a"),"Alcampo",img23, true,false, "Barcelona","","company4", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company5 = new Users("apple@hotmail.com","Apple",encoder.encode("a"),"Apple",img24, true,false, "Madrid","","company5", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company6 = new Users("hawkers@hotmail.com","Hawkers",encoder.encode("h"),"Hawkers",img25, true,false, "Barcelona","","company6", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company7 = new Users("zara@hotmail.com","Zara",encoder.encode("z"),"Zara",img26, true,false, "Madrid","","company7", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company8 = new Users("razer@hotmail.com","Razer",encoder.encode("r"),"Razer",img27, true,false, "Malaga","","company8", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company9 = new Users("nivea@hotmail.com","Nivea",encoder.encode("n"),"Nivea",img28, true,false, "Barcelona","","company9", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company10 = new Users("adidas@hotmail.com","Adidas",encoder.encode("a"),"Adidas",img29, true,false, "Madrid","","company10", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company11 = new Users("puma@hotmail.com","Puma",encoder.encode("p"),"Puma",img30, true,false, "Barcelona","","company11", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company12 = new Users("samsung@hotmail.com","Samsung",encoder.encode("s"),"Samsung",img31, true,false, "Madrid","","company12", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company13 = new Users("seat@hotmail.com","Seat",encoder.encode("se"),"Seat",img32, true,false, "Madrid","","company13", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company14 = new Users("mahou@hotmail.com","Mahou",encoder.encode("m"),"Mahou",img33, true,false, "Barcelona","","company14", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company15 = new Users("AOC@hotmail.com","AOC",encoder.encode("ao"),"AOC",img34, true,false, "Malaga","","company15", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company16 = new Users("GXT@hotmail.com","GXT",encoder.encode("g"),"GXT",img35, true,false, "Madrid","","company16", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company17 = new Users("bluebanana@hotmail.com","BlueBanana",encoder.encode("b"),"BlueBanana",img36, true,false, "Barcelona","","company17", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company18 = new Users("mango18@hotmail.com","Mango",encoder.encode("ma"),"Mango",img37, true,false, "Malaga","","company18", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company19 = new Users("hp@hotmail.com","HP",encoder.encode("h"),"Hp",img38, false,false, "Madrid","","company19", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company20 = new Users("MSI.crnt20@hotmail.com","MSI",encoder.encode("ms"),"MSI",img39, true,false, "Barcelona","","company20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		//Creation user rol of user
		Roles rol1 = new Roles("USER", user1);
		Roles rol2 = new Roles("USER", user2);
		Roles rol3 = new Roles("USER", user3);
		Roles rol4 = new Roles("USER", user4);
		Roles rol5 = new Roles("USER", user5);
		Roles rol6 = new Roles("USER", user6);
		Roles rol7 = new Roles("USER", user7);
		Roles rol8 = new Roles("USER", user8);
		Roles rol9 = new Roles("USER", user9);
		Roles rol10 = new Roles("USER", user10);
		Roles rol11 = new Roles("USER", user11);
		Roles rol12 = new Roles("USER", user12);
		Roles rol13 = new Roles("USER", user13);
		Roles rol14 = new Roles("USER", user14);
		Roles rol15 = new Roles("USER", user15);
		Roles rol16 = new Roles("USER", user16);
		Roles rol17 = new Roles("USER", user17);
		Roles rol18 = new Roles("USER", user18);
		Roles rol19 = new Roles("USER", user19);
		Roles rol20 = new Roles("USER", user20);
		
		//Creation user rol of company
		Roles rol21 = new Roles("USER", company1);
		Roles rol22 = new Roles("USER", company2);
		Roles rol23 = new Roles("USER", company3);
		Roles rol24 = new Roles("USER", company4);
		Roles rol25 = new Roles("USER", company5);
		Roles rol26 = new Roles("USER", company6);
		Roles rol27 = new Roles("USER", company7);
		Roles rol28 = new Roles("USER", company8);
		Roles rol29 = new Roles("USER", company9);
		Roles rol30 = new Roles("USER", company10);
		Roles rol31 = new Roles("USER", company11);
		Roles rol32 = new Roles("USER", company12);
		Roles rol33 = new Roles("USER", company13);
		Roles rol34 = new Roles("USER", company14);
		Roles rol35 = new Roles("USER", company15);
		Roles rol36 = new Roles("USER", company16);
		Roles rol37 = new Roles("USER", company17);
		Roles rol38 = new Roles("USER", company18);
		Roles rol39 = new Roles("USER", company19);
		Roles rol40 = new Roles("USER", company20);
		
		//Creation admin user
		Roles rol41 = new Roles("ADMIN", user1);
		Roles rol42 = new Roles("ADMIN", user2);
		Roles rol43 = new Roles("ADMIN", user3);
		Roles rol44 = new Roles("ADMIN", user4);
		Roles rol45 = new Roles("ADMIN", user5);
		Roles rol46 = new Roles("ADMIN", user6);
		Roles rol47 = new Roles("ADMIN", user7);
		Roles rol48 = new Roles("ADMIN", user8);
		Roles rol49 = new Roles("ADMIN", user9);
		Roles rol50 = new Roles("ADMIN", user10);
		
		//Creation products
		Product product1 = new Product(user1,"product 1", "description 1", imgproduct, imgproduct20, imgproduct21, 40, tag1, tag2, tag3, null, null, "in stock", true, true, true);
		Product product2 = new Product(company2,"product 2", "description 2", imgproduct1, imgproduct22, imgproduct23, 20, null, tag2, tag3, tag4, null, "in stock", true, true, true);
		Product product3 = new Product(user1,"product 3", "description 3", imgproduct2, imgproduct24, imgproduct25, 15, tag1, tag2, tag3, null, tag5, "sold", true, true, true);
		Product product4 = new Product(user2,"product 4", "description 4", imgproduct3, null, null, 45, tag1, null, tag3, null, null, "reserved", true, false, false);
		Product product5 = new Product(company1,"product 5", "description 5", imgproduct4, null, null, 60, tag1, tag2, tag3, tag4, null, "sold", true, false, false);
		Product product6 = new Product(user1,"product 6", "description 6", imgproduct5, null, imgproduct26, 5, null, tag2, tag3, null, tag5, "in stock", true, false, true);
		Product product7 = new Product(user4,"product 7", "description 7", imgproduct6, null, null, 8, tag1, tag2, null, null, null, "reserved", true, false, false);
		Product product8 = new Product(company1,"product 8", "description 8", imgproduct7, imgproduct27, null, 12, tag1, tag2, tag3, tag4, null, "sold", true, true, false);
		Product product9 = new Product(user9,"product 9", "description 9", imgproduct8, null, null, 15, tag1, null, tag3, null, tag5, "in stock", true, false, false);
		Product product10 = new Product(user2,"product 10", "description 10", imgproduct9, imgproduct28, null, 100, tag1, tag2, tag3, null, null, "in stock", true, true, false);
		Product product11 = new Product(user10,"product 11", "description 11", imgproduct10, null, imgproduct29, 40, null, tag2, tag3, tag4, null, "reserved", true, false, true);
		Product product12 = new Product(company12,"product 12", "description 12", imgproduct11, imgproduct30, null, 140, tag1, tag2, null, null, null, "in stock", true, true, false);
		Product product13 = new Product(company8,"product 13", "description 13", imgproduct12, null, null, 12, tag1, null, null, null, tag5, "sold", true, false, false);
		Product product14 = new Product(user7,"product 14", "description 14", imgproduct13, null, null, 40, null, tag2, null, tag4, null, "reserved", true, false, false);
		Product product15 = new Product(company9,"product 15", "description 15", imgproduct14, null, null, 18, tag1, null, tag3, null, null, "sold", true, false, false);
		Product product16 = new Product(user4,"product 16", "description 16", imgproduct15, null, null, 70, null, null, null, tag4, null, "in stock", true, false, false);
		Product product17 = new Product(user2,"product 17", "description 17", imgproduct16, null, null, 80, tag1, null, tag3, null, null, "sold", true, false, false);
		Product product18 = new Product(company5,"product 18", "description 18", imgproduct17, null, null, 82, null, tag2, tag3, null, tag5, "reserved", true, false, false);
		Product product19 = new Product(user6,"product 19", "description 19", imgproduct18, null, null, 95, tag1, tag2, null, null, null, "in stock", true, false, false);
		Product product20 = new Product(company10,"product 20", "description 20", imgproduct19, null, null, 145, tag1, null,null, tag4, null, "reserved", true, false, false);
		
		
		//Creation list product
		ListProducts lista1 = new ListProducts(user1, product1);
		ListProducts lista2 = new ListProducts(user2, product11);
		ListProducts lista3 = new ListProducts(user3, product12);
		ListProducts lista4 = new ListProducts(user4, product1);
		ListProducts lista5 = new ListProducts(user5, product15);
		ListProducts lista6 = new ListProducts(user6, product1);
		ListProducts lista7 = new ListProducts(user7, product18);
		ListProducts lista8 = new ListProducts(user8, product17);
		ListProducts lista9 = new ListProducts(user9, product7);
		ListProducts lista10 = new ListProducts(user10, product1);
		ListProducts lista11 = new ListProducts(user11, product14);
		ListProducts lista12 = new ListProducts(user12, product1);
		ListProducts lista13 = new ListProducts(user13, product12);
		ListProducts lista14 = new ListProducts(user14, product8);
		ListProducts lista15 = new ListProducts(user15, product15);
		ListProducts lista16 = new ListProducts(user16, product2);
		ListProducts lista17 = new ListProducts(user17, product1);
		ListProducts lista18 = new ListProducts(user18, product6);
		ListProducts lista19 = new ListProducts(user19, product1);
		ListProducts lista20 = new ListProducts(user20, product9);
		ListProducts lista21 = new ListProducts(company1, product7);
		ListProducts lista22 = new ListProducts(company2, product1);
		ListProducts lista23 = new ListProducts(company3, product1);
		ListProducts lista24 = new ListProducts(company4, product3);
		ListProducts lista25 = new ListProducts(company5, product1);
		ListProducts lista26 = new ListProducts(company6, product4);
		ListProducts lista27 = new ListProducts(company7, product1);
		ListProducts lista28= new ListProducts(company8, product6);
		ListProducts lista29 = new ListProducts(company9, product1);
		ListProducts lista30 = new ListProducts(company10, product7);
		ListProducts lista31 = new ListProducts(company11, product1);
		ListProducts lista32 = new ListProducts(company12, product8);
		ListProducts lista33 = new ListProducts(company13, product1);
		ListProducts lista34 = new ListProducts(company14, product1);
		ListProducts lista35 = new ListProducts(company15, product12);
		ListProducts lista36 = new ListProducts(company16, product12);
		ListProducts lista37 = new ListProducts(company17, product15);
		ListProducts lista38 = new ListProducts(company18, product18);
		ListProducts lista39 = new ListProducts(company19, product17);
		ListProducts lista40 = new ListProducts(company20, product1);
		
		
		
		//Creation Posts
		Post pos1 = new Post(user1, "title 1", "description 1", imgpost);
		Post pos2 = new Post(company5, "title 2", "description 2", imgpost1);
		Post pos3 = new Post(user1, "title 3", "description 3", imgpost2);
		Post pos4 = new Post(user7, "title 4", "description 4", imgpost3);
		Post pos5 = new Post(company9, "title 5", "description 5", imgpost4);
		Post pos6 = new Post(user17, "title 6", "description 6", imgpost5);
		Post pos7 = new Post(user12, "title 7", "description 7", imgpost6);
		Post pos8 = new Post(user1, "title 8", "description 8", imgpost7);
		Post pos9 = new Post(company18, "title 9", "description 9", imgpost8);
		Post pos10 = new Post(user1, "title 10", "description 10", imgpost9);
		Post pos11 = new Post(user13, "title 11", "description 11", imgpost10);
		Post pos12 = new Post(user1, "title 12", "description 12", imgpost11);
		Post pos13 = new Post(user1, "title 13", "description 13", imgpost12);
		Post pos14 = new Post(user12, "title 14", "description 14", imgpost13);
		Post pos15 = new Post(company3, "title 15", "description 15", imgpost14);
		Post pos16 = new Post(user11, "title 16", "description 16", imgpost15);
		Post pos17 = new Post(company1, "title 17", "description 17", imgpost16);
		Post pos18 = new Post(user10, "title 18", "description 18", imgpost17);
		Post pos19 = new Post(user4, "title 19", "description 19", imgpost18);
		Post pos20 = new Post(user12, "title 20", "description 20", imgpost19);
		
		
		
		//Data introduction 
		if(tagrepo.findAll().isEmpty()) {
			tagrepo.save(tag1);
			tagrepo.save(tag2);
			tagrepo.save(tag3);
			tagrepo.save(tag4);
			tagrepo.save(tag5);
		}
		
		if(userRepository.findAll().isEmpty()) {
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);
			userRepository.save(user6);
			userRepository.save(user7);
			userRepository.save(user8);
			userRepository.save(user9);
			userRepository.save(user10);
			userRepository.save(user11);
			userRepository.save(user12);
			userRepository.save(user13);
			userRepository.save(user14);
			userRepository.save(user15);
			userRepository.save(user16);
			userRepository.save(user17);
			userRepository.save(user18);
			userRepository.save(user19);
			userRepository.save(user20);
			
			
			userRepository.save(company1);
			userRepository.save(company2);
			userRepository.save(company3);
			userRepository.save(company4);
			userRepository.save(company5);
			userRepository.save(company6);
			userRepository.save(company7);
			userRepository.save(company8);
			userRepository.save(company9);
			userRepository.save(company10);
			userRepository.save(company11);
			userRepository.save(company12);
			userRepository.save(company13);
			userRepository.save(company14);
			userRepository.save(company15);
			userRepository.save(company16);
			userRepository.save(company17);
			userRepository.save(company18);
			userRepository.save(company19);
			userRepository.save(company20);
			
			
		}
		
		if(rolesRepository.findAll().isEmpty()) {
			rolesRepository.save(rol1);
			rolesRepository.save(rol2);
			rolesRepository.save(rol3);
			rolesRepository.save(rol4);
			rolesRepository.save(rol5);
			rolesRepository.save(rol6);
			rolesRepository.save(rol7);
			rolesRepository.save(rol8);
			rolesRepository.save(rol9);
			rolesRepository.save(rol10);
			rolesRepository.save(rol11);
			rolesRepository.save(rol12);
			rolesRepository.save(rol13);
			rolesRepository.save(rol14);
			rolesRepository.save(rol15);
			rolesRepository.save(rol16);
			rolesRepository.save(rol17);
			rolesRepository.save(rol18);
			rolesRepository.save(rol19);
			rolesRepository.save(rol20);
			rolesRepository.save(rol21);
			rolesRepository.save(rol22);
			rolesRepository.save(rol23);
			rolesRepository.save(rol24);
			rolesRepository.save(rol25);
			rolesRepository.save(rol26);
			rolesRepository.save(rol27);
			rolesRepository.save(rol28);
			rolesRepository.save(rol29);
			rolesRepository.save(rol30);
			rolesRepository.save(rol31);
			rolesRepository.save(rol32);
			rolesRepository.save(rol33);
			rolesRepository.save(rol34);
			rolesRepository.save(rol35);
			rolesRepository.save(rol36);
			rolesRepository.save(rol37);
			rolesRepository.save(rol38);
			rolesRepository.save(rol39);
			rolesRepository.save(rol40);
			rolesRepository.save(rol41);
			rolesRepository.save(rol42);
			rolesRepository.save(rol43);
			rolesRepository.save(rol44);
			rolesRepository.save(rol45);
			rolesRepository.save(rol46);
			rolesRepository.save(rol47);
			rolesRepository.save(rol48);
			rolesRepository.save(rol49);
			rolesRepository.save(rol50);
		}
		
		if(productrepo.findAll().isEmpty()) {
			productrepo.save(product1);
			productrepo.save(product2);
			productrepo.save(product3);
			productrepo.save(product4);
			productrepo.save(product5);
			productrepo.save(product6);
			productrepo.save(product7);
			productrepo.save(product8);
			productrepo.save(product9);
			productrepo.save(product10);
			productrepo.save(product11);
			productrepo.save(product12);
			productrepo.save(product13);
			productrepo.save(product14);
			productrepo.save(product15);
			productrepo.save(product16);
			productrepo.save(product17);
			productrepo.save(product18);
			productrepo.save(product19);
			productrepo.save(product20);
			
		}
		
		if(listproductrepo.findAll().isEmpty()) {
			listproductrepo.save(lista1);
			listproductrepo.save(lista2);
			listproductrepo.save(lista3);
			listproductrepo.save(lista4);
			listproductrepo.save(lista5);
			listproductrepo.save(lista6);
			listproductrepo.save(lista7);
			listproductrepo.save(lista8);
			listproductrepo.save(lista9);
			listproductrepo.save(lista10);
			listproductrepo.save(lista11);
			listproductrepo.save(lista12);
			listproductrepo.save(lista13);
			listproductrepo.save(lista14);
			listproductrepo.save(lista15);
			listproductrepo.save(lista16);
			listproductrepo.save(lista17);
			listproductrepo.save(lista18);
			listproductrepo.save(lista19);
			listproductrepo.save(lista20);
			listproductrepo.save(lista21);
			listproductrepo.save(lista22);
			listproductrepo.save(lista23);
			listproductrepo.save(lista24);
			listproductrepo.save(lista25);
			listproductrepo.save(lista26);
			listproductrepo.save(lista27);
			listproductrepo.save(lista28);
			listproductrepo.save(lista29);
			listproductrepo.save(lista30);
			listproductrepo.save(lista31);
			listproductrepo.save(lista32);
			listproductrepo.save(lista33);
			listproductrepo.save(lista34);
			listproductrepo.save(lista35);
			listproductrepo.save(lista36);
			listproductrepo.save(lista37);
			listproductrepo.save(lista38);
			listproductrepo.save(lista39);
			listproductrepo.save(lista40);
		}
		
		if(postsrepo.findAll().isEmpty()) {
			postsrepo.save(pos1);
			postsrepo.save(pos2);
			postsrepo.save(pos3);
			postsrepo.save(pos4);
			postsrepo.save(pos5);
			postsrepo.save(pos6);
			postsrepo.save(pos7);
			postsrepo.save(pos8);
			postsrepo.save(pos9);
			postsrepo.save(pos10);
			postsrepo.save(pos11);
			postsrepo.save(pos12);
			postsrepo.save(pos13);
			postsrepo.save(pos14);
			postsrepo.save(pos15);
			postsrepo.save(pos16);
			postsrepo.save(pos17);
			postsrepo.save(pos18);
			postsrepo.save(pos19);
			postsrepo.save(pos20);
			
		}
		
	}

	
	
	
}
