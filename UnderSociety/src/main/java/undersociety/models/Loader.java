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
		Path imagePathUser1 = IMAGES_FOLDER.resolve("legolas_z9w5.jpg");
		Resource imageUser1 = new UrlResource(imagePathUser1.toUri());
		Path imagePathUser2 = IMAGES_FOLDER.resolve("maxresdefault-1-e1510939930531-1024x663.jpg.webp");
		Resource imageUser2 = new UrlResource(imagePathUser2.toUri());
		Path imagePathUser3 = IMAGES_FOLDER.resolve("frodo_smc7.jpg");
		Resource imageUser3 = new UrlResource(imagePathUser3.toUri());
		Path imagePathUser4 = IMAGES_FOLDER.resolve("lord-of-the-rings-sean-bean-boromir-1584636601.jpg");
		Resource imageUser4 = new UrlResource(imagePathUser4.toUri());
		Path imagePathUser5 = IMAGES_FOLDER.resolve("unnamed.jpg");
		Resource imageUser5 = new UrlResource(imagePathUser5.toUri());
		Path imagePathUser6 = IMAGES_FOLDER.resolve("201b8814bc242568936940c34180eb6e--lotr-quotes-frodo-baggins.jpg");
		Resource imageUser6 = new UrlResource(imagePathUser6.toUri());
		Path imagePathUser7 = IMAGES_FOLDER.resolve("Pippinprintscreen.jpg");
		Resource imageUser7 = new UrlResource(imagePathUser7.toUri());
		Path imagePathUser8 = IMAGES_FOLDER.resolve("ian-mckellen-hobbit-an-unexpected-journey-gandalf.jpg");
		Resource imageUser8 = new UrlResource(imagePathUser8.toUri());
		Path imagePathUser9 = IMAGES_FOLDER.resolve("tipos-magia3_1.jpg");
		Resource imageUser9 = new UrlResource(imagePathUser9.toUri());
		Path imagePathUser10 = IMAGES_FOLDER.resolve("4a08dfec8bfb49ef9565217ffe22cbda.jpg");
		Resource imageUser10 = new UrlResource(imagePathUser10.toUri());
		Path imagePathUser11 = IMAGES_FOLDER.resolve("Faramir-movie.jpg");
		Resource imageUser11 = new UrlResource(imagePathUser11.toUri());
		Path imagePathUser12 = IMAGES_FOLDER.resolve("martin-freeman-hobbit.jpg");
		Resource imageUser12 = new UrlResource(imagePathUser12.toUri());
		Path imagePathUser13 = IMAGES_FOLDER.resolve("64aab6e1c836e7d79b132ab1cf66df1e.jpg");
		Resource imageUser13 = new UrlResource(imagePathUser13.toUri());
		Path imagePathUser14 = IMAGES_FOLDER.resolve("the-lord-of-the-rings-the-return-of-the-king-gollum-1553685731.jpg");
		Resource imageUser14 = new UrlResource(imagePathUser14.toUri());
		Path imagePathUser15 = IMAGES_FOLDER.resolve("1366055.jpg");
		Resource imageUser15 = new UrlResource(imagePathUser15.toUri());
		Path imagePathUser16 = IMAGES_FOLDER.resolve("Radagast_the_Brown.jpg");
		Resource imageUser16 = new UrlResource(imagePathUser16.toUri());
		Path imagePathUser17 = IMAGES_FOLDER.resolve("unnamed (1).jpg");
		Resource imageUser17 = new UrlResource(imagePathUser17.toUri());
		Path imagePathUser18 = IMAGES_FOLDER.resolve("8da0f0135b32ac6c26067c09498685f8.jpg");
		Resource imageUser18 = new UrlResource(imagePathUser18.toUri());
		Path imagePathUser19 = IMAGES_FOLDER.resolve("f3d3931074bef5d59f3639e55818dbea.jpg");
		Resource imageUser19 = new UrlResource(imagePathUser19.toUri());
		
		
				
		Blob img = BlobProxy.generateProxy(image.getInputStream(), image.contentLength());
		Blob img1 = BlobProxy.generateProxy(imageUser1.getInputStream(), imageUser1.contentLength());
		Blob img2 = BlobProxy.generateProxy(imageUser2.getInputStream(), imageUser2.contentLength());
		Blob img3 = BlobProxy.generateProxy(imageUser3.getInputStream(), imageUser3.contentLength());
		Blob img4 = BlobProxy.generateProxy(imageUser4.getInputStream(), imageUser4.contentLength());
		Blob img5 = BlobProxy.generateProxy(imageUser5.getInputStream(), imageUser5.contentLength());
		Blob img6 = BlobProxy.generateProxy(imageUser6.getInputStream(), imageUser6.contentLength());
		Blob img7 = BlobProxy.generateProxy(imageUser7.getInputStream(), imageUser7.contentLength());
		Blob img8 = BlobProxy.generateProxy(imageUser8.getInputStream(), imageUser8.contentLength());
		Blob img9 = BlobProxy.generateProxy(imageUser9.getInputStream(), imageUser9.contentLength());
		Blob img10 = BlobProxy.generateProxy(imageUser10.getInputStream(), imageUser10.contentLength());
		Blob img11 = BlobProxy.generateProxy(imageUser11.getInputStream(), imageUser11.contentLength());
		Blob img12 = BlobProxy.generateProxy(imageUser12.getInputStream(), imageUser12.contentLength());
		Blob img13 = BlobProxy.generateProxy(imageUser13.getInputStream(), imageUser13.contentLength());
		Blob img14 = BlobProxy.generateProxy(imageUser14.getInputStream(), imageUser14.contentLength());
		Blob img15 = BlobProxy.generateProxy(imageUser15.getInputStream(), imageUser15.contentLength());
		Blob img16 = BlobProxy.generateProxy(imageUser16.getInputStream(), imageUser16.contentLength());
		Blob img17 = BlobProxy.generateProxy(imageUser17.getInputStream(), imageUser17.contentLength());
		Blob img18 = BlobProxy.generateProxy(imageUser18.getInputStream(), imageUser18.contentLength());
		Blob img19 = BlobProxy.generateProxy(imageUser19.getInputStream(), imageUser19.contentLength());
		
		
		//Images Companies 
		Path imagePathCompania20 = IMAGES_FOLDER.resolve("3rgMnSKT_400x400_1.png");
		Resource imageCompania20 = new UrlResource(imagePathCompania20.toUri());
		Path imagePathCompania21 = IMAGES_FOLDER.resolve("nike12.jpg");
		Resource imageCompania21 = new UrlResource(imagePathCompania21.toUri());
		Path imagePathCompania22 = IMAGES_FOLDER.resolve("png-transparent-volkswagen-group-car-volkswagen-emissions-scandal-volkswagen-golf-germany-emblem-trademark-logo.png");
		Resource imageCompania22 = new UrlResource(imagePathCompania22.toUri());
		Path imagePathCompania23 = IMAGES_FOLDER.resolve("descarga1.jpg");
		Resource imageCompania23 = new UrlResource(imagePathCompania23.toUri());
		Path imagePathCompania24 = IMAGES_FOLDER.resolve("apple-logo.jpg");
		Resource imageCompania24 = new UrlResource(imagePathCompania24.toUri());
		Path imagePathCompania25 = IMAGES_FOLDER.resolve("ff8080814dd21b23014de3186e4701aa-large.png");
		Resource imageCompania25 = new UrlResource(imagePathCompania25.toUri());
		Path imagePathCompania26 = IMAGES_FOLDER.resolve("zara-new-logo-06022019in2.png");
		Resource imageCompania26 = new UrlResource(imagePathCompania26.toUri());
		Path imagePathCompania27 = IMAGES_FOLDER.resolve("PFJP6V4AWNEFFEVBLJ6WGX3L2I.jpg");
		Resource imageCompania27 = new UrlResource(imagePathCompania27.toUri());
		Path imagePathCompania28 = IMAGES_FOLDER.resolve("366201-1596732976821.jpg");
		Resource imageCompania28 = new UrlResource(imagePathCompania28.toUri());
		Path imagePathCompania29 = IMAGES_FOLDER.resolve("adidas-logo.jpg");
		Resource imageCompania29 = new UrlResource(imagePathCompania29.toUri());
		Path imagePathCompania30 = IMAGES_FOLDER.resolve("186153b44d408d68738794ee51704837.jpg");
		Resource imageCompania30 = new UrlResource(imagePathCompania30.toUri());
		Path imagePathCompania31 = IMAGES_FOLDER.resolve("thumb-1920-588106.png");
		Resource imageCompania31 = new UrlResource(imagePathCompania31.toUri());
		Path imagePathCompania32 = IMAGES_FOLDER.resolve("seat-logo.jpg");
		Resource imageCompania32 = new UrlResource(imagePathCompania32.toUri());
		Path imagePathCompania33 = IMAGES_FOLDER.resolve("mahou-logo.jpg");
		Resource imageCompania33 = new UrlResource(imagePathCompania33.toUri());
		Path imagePathCompania34 = IMAGES_FOLDER.resolve("descarga.png");
		Resource imageCompania34 = new UrlResource(imagePathCompania34.toUri());
		Path imagePathCompania35 = IMAGES_FOLDER.resolve("images.png");
		Resource imageCompania35 = new UrlResource(imagePathCompania35.toUri());
		Path imagePathCompania36 = IMAGES_FOLDER.resolve("42367_24102018081432778016_opt_520.jpg");
		Resource imageCompania36 = new UrlResource(imagePathCompania36.toUri());
		Path imagePathCompania37 = IMAGES_FOLDER.resolve("mango-1541664133.jpg");
		Resource imageCompania37 = new UrlResource(imagePathCompania37.toUri());
		Path imagePathCompania38 = IMAGES_FOLDER.resolve("thumb-hp-logo-hewlett-packard-black-background-minimal-lines-texture.jpg");
		Resource imageCompania38 = new UrlResource(imagePathCompania38.toUri());
		Path imagePathCompania39 = IMAGES_FOLDER.resolve("flat,750x1000,075,f.jpg");
		Resource imageCompania39 = new UrlResource(imagePathCompania39.toUri());
			
		
		
		Blob img20 = BlobProxy.generateProxy(imageCompania20.getInputStream(), imageCompania20.contentLength());
		Blob img21 = BlobProxy.generateProxy(imageCompania21.getInputStream(), imageCompania21.contentLength());
		Blob img22 = BlobProxy.generateProxy(imageCompania22.getInputStream(), imageCompania22.contentLength());
		Blob img23 = BlobProxy.generateProxy(imageCompania23.getInputStream(), imageCompania23.contentLength());
		Blob img24 = BlobProxy.generateProxy(imageCompania24.getInputStream(), imageCompania24.contentLength());
		Blob img25 = BlobProxy.generateProxy(imageCompania25.getInputStream(), imageCompania25.contentLength());
		Blob img26 = BlobProxy.generateProxy(imageCompania26.getInputStream(), imageCompania26.contentLength());
		Blob img27 = BlobProxy.generateProxy(imageCompania27.getInputStream(), imageCompania27.contentLength());
		Blob img28 = BlobProxy.generateProxy(imageCompania28.getInputStream(), imageCompania28.contentLength());
		Blob img29 = BlobProxy.generateProxy(imageCompania29.getInputStream(), imageCompania29.contentLength());
		Blob img30 = BlobProxy.generateProxy(imageCompania30.getInputStream(), imageCompania30.contentLength());
		Blob img31 = BlobProxy.generateProxy(imageCompania31.getInputStream(), imageCompania31.contentLength());
		Blob img32 = BlobProxy.generateProxy(imageCompania32.getInputStream(), imageCompania32.contentLength());
		Blob img33 = BlobProxy.generateProxy(imageCompania33.getInputStream(), imageCompania33.contentLength());
		Blob img34 = BlobProxy.generateProxy(imageCompania34.getInputStream(), imageCompania34.contentLength());
		Blob img35 = BlobProxy.generateProxy(imageCompania35.getInputStream(), imageCompania35.contentLength());
		Blob img36 = BlobProxy.generateProxy(imageCompania36.getInputStream(), imageCompania36.contentLength());
		Blob img37 = BlobProxy.generateProxy(imageCompania37.getInputStream(), imageCompania37.contentLength());
		Blob img38 = BlobProxy.generateProxy(imageCompania38.getInputStream(), imageCompania38.contentLength());
		Blob img39 = BlobProxy.generateProxy(imageCompania39.getInputStream(), imageCompania39.contentLength());
		
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
		Users user2 = new Users("Legolas@hotmail.com","Legolas",encoder.encode("h"),"Cristian2",img1, false,true, "Antanamaribo","","usuLegolas", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user3 = new Users("Gimly@hotmail.com","Gimli",encoder.encode("h"),"Gimli Stone",img2, false,true, "Atenas","","usuGimli", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user4 = new Users("Frodo@hotmail.com","Frodo",encoder.encode("h"),"Frodo Hole",img3, false,true, "Estambul","","usuFrodo", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user5 = new Users("Boromir@hotmail.com","Boromir",encoder.encode("h"),"Boromir Dawn",img4, false,true, "Katmandú","","usuBoromir", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user6 = new Users("Aragorn@hotmail.com","Aragorn",encoder.encode("h"),"Aragorn Gondor",img5, false,true, "Dhaka","","usuAragorn", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user7 = new Users("Merry@hotmail.com","Merry",encoder.encode("h"),"Merry Mess",img6, false,true, "Hanoi","","usuMerry", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user8 = new Users("Pippin@hotmail.com","Pippin",encoder.encode("h"),"Pippin Mass",img7, false,true, "Bangkok","","usuPippin", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user9 = new Users("Gandalf@hotmail.com","Gandalf",encoder.encode("h"),"Gandalf Grey",img8, false,true, "Manila","","usuGandalf", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user10 = new Users("Sauron@hotmail.com","Sauron",encoder.encode("h"),"Sauron Ringout",img9, false,true, "Yakarta","","usuSauron", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user11 = new Users("Denethor@hotmail.com","Denethor",encoder.encode("h"),"Denethor Law",img10, false,true, "Singapur","","usuDenethor", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user12 = new Users("Faramir@hotmail.com","Faramir",encoder.encode("h"),"Faramir river",img11, false,true, "Perth","","usuFaramir", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user13 = new Users("Bilbo@hotmail.com","Bilbo",encoder.encode("h"),"Bilbo Bolson",img12, false,true, "Sidney","","usuBilbo", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user14 = new Users("Barbol@hotmail.com","Barbol",encoder.encode("h"),"Barbol Tree",img13, false,true, "Melbourne","","usuBarbol", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user15 = new Users("Gollum@hotmail.com","Gollum",encoder.encode("h"),"Gollum Gollum",img14, false,true, "Canberra","","usuGollum", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user16 = new Users("Saruman@hotmail.com","Saruman",encoder.encode("h"),"Saruman Mad",img15, false,true, "Hobart","","usuSaruman", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user17 = new Users("Radagast@hotmail.com","Radagast",encoder.encode("h"),"Radagast Pard",img16, false,true, "Wellington","","usuRadagast", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user18 = new Users("Arwen@hotmail.com","Arwen",encoder.encode("h"),"Arwen Water",img17, false,true, "Honolulu","","usuArwen", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user19 = new Users("Sam@hotmail.com","Sam",encoder.encode("h"),"Sam SagazGamyi",img18, false,true, "Denver","","usuSam", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users user20 = new Users("Theoden@hotmail.com","Theoden",encoder.encode("h"),"Theoden King",img19, false,true, "Los angeles","","usuTheoden", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		
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
