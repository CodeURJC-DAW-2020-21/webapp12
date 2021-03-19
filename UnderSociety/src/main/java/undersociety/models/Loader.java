package undersociety.models;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import undersociety.repositories.LikesRepository;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.MessageRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.TagsRepository;
import undersociety.repositories.UserRepository;
import undersociety.repositories.UsersRelationsRepository;

public class Loader {

	@Autowired
	private LikesRepository likerepo;

	@Autowired
	private UsersRelationsRepository relationrepo;

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
	private MessageRepository messagerepo;
	
	
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
		this.likerepo = likerepo;
		this.relationrepo = relationrepo;
		this.productrepo = productrepo;
		this.listproductrepo = listproductrepo;
		this.postsrepo = postsrepo;
		this.userRepository = userRepository;
		this.tagrepo = tagrepo;
		this.rolesRepository = rolesRepository;
		this.encoder = encoder;
	}




	@PostConstruct
	public void load() {
		
		
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
		Users user1 = new Users("sr.crnt@hotmail.com","h",encoder.encode("h"),"h",null, false,true, "Madrid","","usu1", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user2 = new Users("sr.crnt2@hotmail.com","Cette02",encoder.encode("cette01"),"Cristian2",null, false,true, "Barcelona","","usu2", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user3 = new Users("sr.crnt3@hotmail.com","Cette03",encoder.encode("cette01"),"Cristian3",null, false,true, "Malaga","","usu3", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user4 = new Users("sr.crnt4@hotmail.com","Cette04",encoder.encode("cette01"),"Cristian4",null, false,true, "Barcelona","","usu4", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user5 = new Users("sr.crnt5@hotmail.com","Cette05",encoder.encode("cette01"),"Cristian5",null, false,true, "Madrid","","usu5", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user6 = new Users("sr.crnt6@hotmail.com","Cette06",encoder.encode("cette01"),"Cristian6",null, false,true, "Barcelona","","usu6", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user7 = new Users("sr.crnt7@hotmail.com","Cette07",encoder.encode("cette01"),"Cristian7",null, false,true, "Madrid","","usu7", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user8 = new Users("sr.crnt8@hotmail.com","Cette08",encoder.encode("cette01"),"Cristian8",null, false,true, "Malaga","","usu8", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user9 = new Users("sr.crnt9@hotmail.com","Cette09",encoder.encode("cette01"),"Cristian9",null, false,true, "Barcelona","","usu9", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user10 = new Users("sr.crnt10@hotmail.com","Cette10",encoder.encode("cette01"),"Cristian10",null, false,true, "Madrid","","usu10", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user11 = new Users("sr.crnt11@hotmail.com","Cette11",encoder.encode("cette01"),"Cristian11",null, false,true, "Barcelona","","usu11", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user12 = new Users("sr.crnt12@hotmail.com","Cette12",encoder.encode("cette01"),"Cristian12",null, false,true, "Madrid","","usu12", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user13 = new Users("sr.crnt13@hotmail.com","Cette13",encoder.encode("cette01"),"Cristian13",null, false,true, "Madrid","","usu13", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user14 = new Users("sr.crnt14@hotmail.com","Cette14",encoder.encode("cette01"),"Cristian14",null, false,true, "Barcelona","","usu14", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user15 = new Users("sr.crnt15@hotmail.com","Cette15",encoder.encode("cette01"),"Cristian15",null, false,true, "Malaga","","usu15", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user16 = new Users("sr.crnt16@hotmail.com","Cette16",encoder.encode("cette01"),"Cristian16",null, false,true, "Madrid","","usu16", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user17 = new Users("sr.crnt17@hotmail.com","Cette17",encoder.encode("cette01"),"Cristian17",null, false,true, "Barcelona","","usu17", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user18 = new Users("sr.crnt18@hotmail.com","Cette18",encoder.encode("cette01"),"Cristian18",null, false,true, "Malaga","","usu18", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user19 = new Users("sr.crnt19@hotmail.com","Cette19",encoder.encode("cette01"),"Cristian19",null, false,true, "Madrid","","usu19", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user20 = new Users("sr.crnt20@hotmail.com","cette20",encoder.encode("h"),"Cristian",null, false,true, "Barcelona","","usu20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		
		Users company1 = new Users("ikea@hotmail.com","Ikea",encoder.encode("i"),"Ikea",null, true,false, "Madrid","","company1", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company2 = new Users("nike@hotmail.com","Nike",encoder.encode("n"),"Nike",null, true,false, "Barcelona","","company2", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company3 = new Users("golf@hotmail.com","Golf",encoder.encode("g"),"Golf",null, true,false, "Malaga","","company3", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company4 = new Users("alcampo@hotmail.com","Alcampo",encoder.encode("a"),"Alcampo",null, true,false, "Barcelona","","company4", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company5 = new Users("apple@hotmail.com","Apple",encoder.encode("a"),"Apple",null, true,false, "Madrid","","company5", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company6 = new Users("hawkers@hotmail.com","Hawkers",encoder.encode("h"),"Hawkers",null, true,false, "Barcelona","","company6", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company7 = new Users("zara@hotmail.com","Zara",encoder.encode("z"),"Zara",null, true,false, "Madrid","","company7", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company8 = new Users("razer@hotmail.com","Razer",encoder.encode("r"),"Razer",null, true,false, "Malaga","","company8", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company9 = new Users("nivea@hotmail.com","Nivea",encoder.encode("n"),"Nivea",null, true,false, "Barcelona","","company9", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company10 = new Users("adidas@hotmail.com","Adidas",encoder.encode("a"),"Adidas",null, true,false, "Madrid","","company10", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company11 = new Users("puma@hotmail.com","Puma",encoder.encode("p"),"Puma",null, true,false, "Barcelona","","company11", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company12 = new Users("samsung@hotmail.com","Samsung",encoder.encode("s"),"Samsung",null, true,false, "Madrid","","company12", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company13 = new Users("seat@hotmail.com","Seat",encoder.encode("se"),"Seat",null, true,false, "Madrid","","company13", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company14 = new Users("mahou@hotmail.com","Mahou",encoder.encode("m"),"Mahou",null, true,false, "Barcelona","","company14", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company15 = new Users("AOC@hotmail.com","AOC",encoder.encode("ao"),"AOC",null, true,false, "Malaga","","company15", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company16 = new Users("GXT@hotmail.com","GXT",encoder.encode("g"),"GXT",null, true,false, "Madrid","","company16", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company17 = new Users("bluebanana@hotmail.com","BlueBanana",encoder.encode("b"),"BlueBanana",null, true,false, "Barcelona","","company17", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company18 = new Users("mango18@hotmail.com","Mango",encoder.encode("ma"),"Mango",null, true,false, "Malaga","","company18", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company19 = new Users("hp@hotmail.com","HP",encoder.encode("h"),"Hp",null, false,false, "Madrid","","company19", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company20 = new Users("MSI.crnt20@hotmail.com","MSI",encoder.encode("ms"),"MSI",null, true,false, "Barcelona","","company20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
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
		Product product1 = new Product(user1,"product 1", "description 1", null, null, null, 40, tag1, tag2, tag3, null, null, "in stock", false, false, false);
		Product product2 = new Product(company2,"product 2", "description 2", null, null, null, 20, null, tag2, tag3, tag4, null, "in stock", false, false, false);
		Product product3 = new Product(user1,"product 3", "description 3", null, null, null, 15, tag1, tag2, tag3, null, tag5, "sold", false, false, false);
		Product product4 = new Product(user2,"product 4", "description 4", null, null, null, 45, tag1, null, tag3, null, null, "reserved", false, false, false);
		Product product5 = new Product(company1,"product 5", "description 5", null, null, null, 60, tag1, tag2, tag3, tag4, null, "sold", false, false, false);
		Product product6 = new Product(user1,"product 6", "description 6", null, null, null, 5, null, tag2, tag3, null, tag5, "in stock", false, false, false);
		Product product7 = new Product(user4,"product 7", "description 7", null, null, null, 8, tag1, tag2, null, null, null, "reserved", false, false, false);
		Product product8 = new Product(company1,"product 8", "description 8", null, null, null, 12, tag1, tag2, tag3, tag4, null, "sold", false, false, false);
		Product product9 = new Product(user9,"product 9", "description 9", null, null, null, 15, tag1, null, tag3, null, tag5, "in stock", false, false, false);
		Product product10 = new Product(user2,"product 10", "description 10", null, null, null, 100, tag1, tag2, tag3, null, null, "in stock", false, false, false);
		Product product11 = new Product(user10,"product 11", "description 11", null, null, null, 40, null, tag2, tag3, tag4, null, "reserved", false, false, false);
		Product product12 = new Product(company12,"product 12", "description 12", null, null, null, 140, tag1, tag2, null, null, null, "in stock", false, false, false);
		Product product13 = new Product(company8,"product 13", "description 13", null, null, null, 12, tag1, null, null, null, tag5, "sold", false, false, false);
		Product product14 = new Product(user7,"product 14", "description 14", null, null, null, 40, null, tag2, null, tag4, null, "reserved", false, false, false);
		Product product15 = new Product(company9,"product 15", "description 15", null, null, null, 18, tag1, null, tag3, null, null, "sold", false, false, false);
		Product product16 = new Product(user4,"product 16", "description 16", null, null, null, 70, null, null, null, tag4, null, "in stock", false, false, false);
		Product product17 = new Product(user2,"product 17", "description 17", null, null, null, 80, tag1, null, tag3, null, null, "sold", false, false, false);
		Product product18 = new Product(company5,"product 18", "description 18", null, null, null, 82, null, tag2, tag3, null, tag5, "reserved", false, false, false);
		Product product19 = new Product(user6,"product 19", "description 19", null, null, null, 95, tag1, tag2, null, null, null, "in stock", false, false, false);
		Product product20 = new Product(company10,"product 20", "description 20", null, null, null, 145, tag1, null,null, tag4, null, "reserved", false, false, false);
		
		
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
		Post pos1 = new Post(user1, "title 1", "description 1", null);
		Post pos2 = new Post(company5, "title 2", "description 2", null);
		Post pos3 = new Post(user1, "title 3", "description 3", null);
		Post pos4 = new Post(user7, "title 4", "description 4", null);
		Post pos5 = new Post(company9, "title 5", "description 5", null);
		Post pos6 = new Post(user17, "title 6", "description 6", null);
		Post pos7 = new Post(user12, "title 7", "description 7", null);
		Post pos8 = new Post(user1, "title 8", "description 8", null);
		Post pos9 = new Post(company18, "title 9", "description 9", null);
		Post pos10 = new Post(user1, "title 10", "description 10", null);
		Post pos11 = new Post(user13, "title 11", "description 11", null);
		Post pos12 = new Post(user1, "title 12", "description 12", null);
		Post pos13 = new Post(user1, "title 13", "description 13", null);
		Post pos14 = new Post(user12, "title 14", "description 14", null);
		Post pos15 = new Post(company3, "title 15", "description 15", null);
		Post pos16 = new Post(user11, "title 16", "description 16", null);
		Post pos17 = new Post(company1, "title 17", "description 17", null);
		Post pos18 = new Post(user10, "title 18", "description 18", null);
		Post pos19 = new Post(user4, "title 19", "description 19", null);
		Post pos20 = new Post(user12, "title 20", "description 20", null);
		
		
		
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
