package undersociety.models;

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
	
	private void load() {
		
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
		
		
		Users user1 = new Users("sr.crnt@hotmail.com","Cette01",encoder.encode("cette01"),"Cristian1",null, false,true, "Madrid","","usu1", "www.facebook.com","www.twitter.com","www.instagram.com",null );
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
		Users user20 = new Users("sr.crnt20@hotmail.com","h",encoder.encode("h"),"Cristian",null, false,true, "Barcelona","","usu20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		
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
		
	}

	
	
	
}
