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
		Path imagePost= IMAGES_FOLDER.resolve("chicos-estan-dibujando-casa_36356-43.jpg");
		Resource imagepost = new UrlResource(imagePost.toUri());
		
		Path imagePost1= IMAGES_FOLDER.resolve("apple-keynote.jpg");
		Resource imagepost1 = new UrlResource(imagePost1.toUri());
		
		Path imagePost2= IMAGES_FOLDER.resolve("c593c42617a5935a5d15def89ee0b000.jpg");
		Resource imagepost2 = new UrlResource(imagePost2.toUri());
		
		Path imagePost3= IMAGES_FOLDER.resolve("580cc2da99c84a2ea9240cc0399b0be4.jpg");
		Resource imagepost3 = new UrlResource(imagePost3.toUri());
		
		Path imagePost4= IMAGES_FOLDER.resolve("NIVEA-Beach-Event-Germany-2000-Beiersdorf-e1468402388669.jpg");
		Resource imagepost4 = new UrlResource(imagePost4.toUri());
		
		Path imagePost5= IMAGES_FOLDER.resolve("3283b7f2e40f7e89eb9098c37d4578c4.jpg");
		Resource imagepost5 = new UrlResource(imagePost5.toUri());
		
		Path imagePost6= IMAGES_FOLDER.resolve("maraton-kiPH-U601127335038my-624x385@La Rioja.jpg");
		Resource imagepost6 = new UrlResource(imagePost6.toUri());
		
		Path imagePost7= IMAGES_FOLDER.resolve("SEAT-Arona-mirador-Toscana.jpg");
		Resource imagepost7 = new UrlResource(imagePost7.toUri());
		
		Path imagePost8= IMAGES_FOLDER.resolve("Legolas-in-Behind-the-Scenes-of-DOS-legolas-greenleaf-36864108-604-340.jpg");
		Resource imagepost8 = new UrlResource(imagePost8.toUri());
						
		Path imagePost9= IMAGES_FOLDER.resolve("graffiti-tour-madrid-mahou-wag1mag-5.jpg");
		Resource imagepost9 = new UrlResource(imagePost9.toUri());
		
		Path imagePost10= IMAGES_FOLDER.resolve("gollum2.jpg");
		Resource imagepost10 = new UrlResource(imagePost10.toUri());
		
		Path imagePost11= IMAGES_FOLDER.resolve("EabyGc_XYAAwSzB.jpg");
		Resource imagepost11 = new UrlResource(imagePost11.toUri());
		
		Path imagePost12= IMAGES_FOLDER.resolve("zara.jpeg");
		Resource imagepost12 = new UrlResource(imagePost12.toUri());
		
		Path imagePost13= IMAGES_FOLDER.resolve("gestion-documentos-teletrabajo3-scaled.jpg");
		Resource imagepost13 = new UrlResource(imagePost13.toUri());
		
		Path imagePost14= IMAGES_FOLDER.resolve("meme1-1280x720.jpg");
		Resource imagepost14 = new UrlResource(imagePost14.toUri());
		
		Path imagePost15= IMAGES_FOLDER.resolve("figwit__11346_orig.jpg");
		Resource imagepost15 = new UrlResource(imagePost15.toUri());
		
		Path imagePost16= IMAGES_FOLDER.resolve("DoYou_H2-750x421.jpg");
		Resource imagepost16 = new UrlResource(imagePost16.toUri());
		
		Path imagePost17= IMAGES_FOLDER.resolve("20057525635_0e97d61372_b.jpg");
		Resource imagepost17 = new UrlResource(imagePost17.toUri());
		
		Path imagePost18= IMAGES_FOLDER.resolve("maxresdefault.jpg");
		Resource imagepost18 = new UrlResource(imagePost18.toUri());
		
		Path imagePost19= IMAGES_FOLDER.resolve("DjSKyjtWsAAxYDO.jpg");
		Resource imagepost19 = new UrlResource(imagePost19.toUri());
		
		Blob imgpost = BlobProxy.generateProxy(imagepost.getInputStream(), imagepost.contentLength());
		Blob imgpost1 = BlobProxy.generateProxy(imagepost1.getInputStream(), imagepost1.contentLength());
		Blob imgpost2 = BlobProxy.generateProxy(imagepost2.getInputStream(), imagepost2.contentLength());
		Blob imgpost3 = BlobProxy.generateProxy(imagepost3.getInputStream(), imagepost3.contentLength());
		Blob imgpost4 = BlobProxy.generateProxy(imagepost4.getInputStream(), imagepost4.contentLength());
		Blob imgpost5 = BlobProxy.generateProxy(imagepost5.getInputStream(), imagepost5.contentLength());
		Blob imgpost6 = BlobProxy.generateProxy(imagepost6.getInputStream(), imagepost6.contentLength());
		Blob imgpost7 = BlobProxy.generateProxy(imagepost7.getInputStream(), imagepost7.contentLength());
		Blob imgpost8 = BlobProxy.generateProxy(imagepost8.getInputStream(), imagepost8.contentLength());
		Blob imgpost9 = BlobProxy.generateProxy(imagepost9.getInputStream(), imagepost9.contentLength());
		Blob imgpost10 = BlobProxy.generateProxy(imagepost10.getInputStream(), imagepost10.contentLength());
		Blob imgpost11 = BlobProxy.generateProxy(imagepost11.getInputStream(), imagepost11.contentLength());
		Blob imgpost12 = BlobProxy.generateProxy(imagepost12.getInputStream(), imagepost12.contentLength());
		Blob imgpost13 = BlobProxy.generateProxy(imagepost13.getInputStream(), imagepost13.contentLength());
		Blob imgpost14 = BlobProxy.generateProxy(imagepost14.getInputStream(), imagepost14.contentLength());
		Blob imgpost15 = BlobProxy.generateProxy(imagepost15.getInputStream(), imagepost15.contentLength());
		Blob imgpost16 = BlobProxy.generateProxy(imagepost16.getInputStream(), imagepost16.contentLength());
		Blob imgpost17 = BlobProxy.generateProxy(imagepost17.getInputStream(), imagepost17.contentLength());
		Blob imgpost18 = BlobProxy.generateProxy(imagepost18.getInputStream(), imagepost18.contentLength());
		Blob imgpost19 = BlobProxy.generateProxy(imagepost19.getInputStream(), imagepost19.contentLength());
		
		//Images Product
		
		Path imagePathProduct = IMAGES_FOLDER.resolve("wrc_spirit_disc_ultegra_2021_.jpeg");
		Resource imageProduct = new UrlResource(imagePathProduct.toUri());		
		Path imagePathProduct1 = IMAGES_FOLDER.resolve("wrc_spirit_disc_ultegra_2021._.jpg");
		Resource imageProduct1 = new UrlResource(imagePathProduct1.toUri());
		Path imagePathProduct2 = IMAGES_FOLDER.resolve("wrc_spirit_disc_ultegra_2021.jpg");
		Resource imageProduct2 = new UrlResource(imagePathProduct2.toUri());
		Path imagePathProduct3 = IMAGES_FOLDER.resolve("air-max-plus-zapatillas-v371c8.jpg");
		Resource imageProduct3 = new UrlResource(imagePathProduct3.toUri());		
		Path imagePathProduct4 = IMAGES_FOLDER.resolve("air-max-plus-zapatillas-v371c8 (1).jpg");
		Resource imageProduct4 = new UrlResource(imagePathProduct4.toUri());
		Path imagePathProduct5 = IMAGES_FOLDER.resolve("air-max-plus-zapatillas-v371c8 (2).jpg");
		Resource imageProduct5 = new UrlResource(imagePathProduct5.toUri());
		Path imagePathProduct6 = IMAGES_FOLDER.resolve("1_1_2.jpg");
		Resource imageProduct6 = new UrlResource(imagePathProduct6.toUri());		
		Path imagePathProduct7 = IMAGES_FOLDER.resolve("todos_accesorios.jpg");
		Resource imageProduct7 = new UrlResource(imagePathProduct7.toUri());
		Path imagePathProduct8 = IMAGES_FOLDER.resolve("s-l225.jpg");
		Resource imageProduct8 = new UrlResource(imagePathProduct8.toUri());
		Path imagePathProduct9 = IMAGES_FOLDER.resolve("hacha-cudeman-shark-159-m.jpg");
		Resource imageProduct9 = new UrlResource(imagePathProduct9.toUri());
		Path imagePathProduct10 = IMAGES_FOLDER.resolve("924ac8321142029691b185ab03e95b36.jpg");
		Resource imageProduct10 = new UrlResource(imagePathProduct10.toUri());
		Path imagePathProduct11 = IMAGES_FOLDER.resolve("il_570xN.1589575158_6pek.jpg");
		Resource imageProduct11 = new UrlResource(imagePathProduct11.toUri());
		Path imagePathProduct12 = IMAGES_FOLDER.resolve("D_NQ_NP_811459-MLM31216665088_062019-O.jpg");
		Resource imageProduct12 = new UrlResource(imagePathProduct12.toUri());
		Path imagePathProduct13 = IMAGES_FOLDER.resolve("hp-ordenador-portatil-250-g6.jpg");
		Resource imageProduct13 = new UrlResource(imagePathProduct13.toUri());	
		Path imagePathProduct14 = IMAGES_FOLDER.resolve("c06226445_209x189.jpg");
		Resource imageProduct14 = new UrlResource(imagePathProduct14.toUri());
		Path imagePathProduct15 = IMAGES_FOLDER.resolve("Disfraz-de-Halloween-del-mago-disfraz-personalizado-con-Peluca-de-sombrero-barba.jpg");
		Resource imageProduct15 = new UrlResource(imagePathProduct15.toUri());
		Path imagePathProduct16 = IMAGES_FOLDER.resolve("9554415517726.jpg");
		Resource imageProduct16 = new UrlResource(imagePathProduct16.toUri());
		Path imagePathProduct17 = IMAGES_FOLDER.resolve("91jf2m5BfTL._AC_SX679_.jpg");
		Resource imageProduct17 = new UrlResource(imagePathProduct17.toUri());
		Path imagePathProduct18 = IMAGES_FOLDER.resolve("s-l300.jpg");
		Resource imageProduct18 = new UrlResource(imagePathProduct18.toUri());
		Path imagePathProduct19 = IMAGES_FOLDER.resolve("s-l300 (1).jpg");
		Resource imageProduct19 = new UrlResource(imagePathProduct19.toUri());
		Path imagePathProduct20 = IMAGES_FOLDER.resolve("71DkgRbnuzL._AC_SX679_.jpg");
		Resource imageProduct20 = new UrlResource(imagePathProduct20.toUri());
		Path imagePathProduct21 = IMAGES_FOLDER.resolve("samsung-galaxy-a21s-0.jpg");
		Resource imageProduct21 = new UrlResource(imagePathProduct21.toUri());
		Path imagePathProduct22 = IMAGES_FOLDER.resolve("sizing-bwc.png");
		Resource imageProduct22 = new UrlResource(imagePathProduct22.toUri());
		Path imagePathProduct23 = IMAGES_FOLDER.resolve("s-l300 (2).jpg");
		Resource imageProduct23 = new UrlResource(imagePathProduct23.toUri());
		Path imagePathProduct24 = IMAGES_FOLDER.resolve("51UXFM1mrSL._AC_SX425_.jpg");
		Resource imageProduct24 = new UrlResource(imagePathProduct24.toUri());
		Path imagePathProduct25 = IMAGES_FOLDER.resolve("il_570xN.1638482480_p7u8.jpg");
		Resource imageProduct25 = new UrlResource(imagePathProduct25.toUri());
		Path imagePathProduct26 = IMAGES_FOLDER.resolve("146914715842684601227a9a325d67df4f17e52607.jpg");
		Resource imageProduct26 = new UrlResource(imagePathProduct26.toUri());
		Path imagePathProduct27 = IMAGES_FOLDER.resolve("42-alu-silver-sport-white-nc-s3-gallery1_GEO_ES.jpg");
		Resource imageProduct27 = new UrlResource(imagePathProduct27.toUri());
		Path imagePathProduct28 = IMAGES_FOLDER.resolve("anduril-sword-_-ranger-sword-of-aragorn.jpg");
		Resource imageProduct28 = new UrlResource(imagePathProduct28.toUri());
		Path imagePathProduct29 = IMAGES_FOLDER.resolve("Zapatilla_Hardcourt_Hi_Negro_FV5463_01_standard.jpg");
		Resource imageProduct29 = new UrlResource(imagePathProduct29.toUri());
		Path imagePathProduct30 = IMAGES_FOLDER.resolve("Zapatilla_Hardcourt_Hi_Negro_FV5463_010_hover_standard.jpg");
		Resource imageProduct30 = new UrlResource(imagePathProduct30.toUri());
		
		
		Blob imgproduct = BlobProxy.generateProxy(imageProduct.getInputStream(), imageProduct.contentLength());
		Blob imgproduct1 = BlobProxy.generateProxy(imageProduct1.getInputStream(), imageProduct1.contentLength());
		Blob imgproduct2 = BlobProxy.generateProxy(imageProduct2.getInputStream(), imageProduct2.contentLength());
		Blob imgproduct3 = BlobProxy.generateProxy(imageProduct3.getInputStream(), imageProduct3.contentLength());
		Blob imgproduct4 = BlobProxy.generateProxy(imageProduct4.getInputStream(), imageProduct4.contentLength());
		Blob imgproduct5 = BlobProxy.generateProxy(imageProduct5.getInputStream(), imageProduct5.contentLength());
		Blob imgproduct6 = BlobProxy.generateProxy(imageProduct6.getInputStream(), imageProduct6.contentLength());
		Blob imgproduct7 = BlobProxy.generateProxy(imageProduct7.getInputStream(), imageProduct7.contentLength());
		Blob imgproduct8 = BlobProxy.generateProxy(imageProduct8.getInputStream(), imageProduct8.contentLength());
		Blob imgproduct9 = BlobProxy.generateProxy(imageProduct9.getInputStream(), imageProduct9.contentLength());
		Blob imgproduct10 = BlobProxy.generateProxy(imageProduct10.getInputStream(), imageProduct10.contentLength());
		Blob imgproduct11 = BlobProxy.generateProxy(imageProduct11.getInputStream(), imageProduct11.contentLength());
		Blob imgproduct12 = BlobProxy.generateProxy(imageProduct12.getInputStream(), imageProduct12.contentLength());
		Blob imgproduct13 = BlobProxy.generateProxy(imageProduct13.getInputStream(), imageProduct13.contentLength());
		Blob imgproduct14 = BlobProxy.generateProxy(imageProduct14.getInputStream(), imageProduct14.contentLength());
		Blob imgproduct15 = BlobProxy.generateProxy(imageProduct15.getInputStream(), imageProduct15.contentLength());
		Blob imgproduct16 = BlobProxy.generateProxy(imageProduct16.getInputStream(), imageProduct16.contentLength());
		Blob imgproduct17 = BlobProxy.generateProxy(imageProduct17.getInputStream(), imageProduct17.contentLength());
		Blob imgproduct18 = BlobProxy.generateProxy(imageProduct18.getInputStream(), imageProduct18.contentLength());
		Blob imgproduct19 = BlobProxy.generateProxy(imageProduct19.getInputStream(), imageProduct19.contentLength());		
		Blob imgproduct20 = BlobProxy.generateProxy(imageProduct20.getInputStream(), imageProduct20.contentLength());
		Blob imgproduct21 = BlobProxy.generateProxy(imageProduct21.getInputStream(), imageProduct21.contentLength());
		Blob imgproduct22 = BlobProxy.generateProxy(imageProduct22.getInputStream(), imageProduct22.contentLength());
		Blob imgproduct23 = BlobProxy.generateProxy(imageProduct23.getInputStream(), imageProduct23.contentLength());
		Blob imgproduct24 = BlobProxy.generateProxy(imageProduct24.getInputStream(), imageProduct24.contentLength());
		Blob imgproduct25 = BlobProxy.generateProxy(imageProduct25.getInputStream(), imageProduct25.contentLength());
		Blob imgproduct26 = BlobProxy.generateProxy(imageProduct26.getInputStream(), imageProduct26.contentLength());
		Blob imgproduct27 = BlobProxy.generateProxy(imageProduct27.getInputStream(), imageProduct27.contentLength());
		Blob imgproduct28 = BlobProxy.generateProxy(imageProduct28.getInputStream(), imageProduct28.contentLength());
		Blob imgproduct29 = BlobProxy.generateProxy(imageProduct29.getInputStream(), imageProduct29.contentLength());
		Blob imgproduct30 = BlobProxy.generateProxy(imageProduct30.getInputStream(), imageProduct30.contentLength());
		
		
		
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
		Users user2 = new Users("Legolas@hotmail.com","Legolas",encoder.encode("h"),"Legolas Wind",img1, false,true, "Antanamaribo","","usuLegolas", "www.facebook.com","www.twitter.com","www.instagram.com",null );
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
		Users company19 = new Users("hp@hotmail.com","HP",encoder.encode("h"),"Hp",img38, true,false, "Madrid","","company19", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		Users company20 = new Users("MSI.crnt20@hotmail.com","MSI",encoder.encode("ms"),"MSI",img39, true,false, "Barcelona","","company20", "www.facebook.com","www.twitter.com","www.instagram.com",null );
		
		
		//Creation user role of user
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
		Product product1 = new Product(user1,"Bike Conor WRC Spirit"," He can be the great love of your life, so keep an eye out for this wonder of 2021 Conor WRC Spirit Disc Ultegra Bicycle."
				+ "You will want to spend your whole life on top of it pedaling"
			    , imgproduct, imgproduct1, imgproduct2, 40, tag1, tag2, tag3, null, null, "in stock", true, true, true);		
		Product product2 = new Product(company2,"Nike Air Max Plus", "Let your style soar with the Nike Air Max Plus, an updated Air experience that offers stability"
				+ "premium and incredible cushioning."
				, imgproduct3, imgproduct4, imgproduct5, 20, null, tag2, tag3, tag4, null, "in stock", true, true, true);		
		Product product3 = new Product(user2,"Hellbow Besra compound shooting bow", "With this initiation bow you can start training and learn how to shoot with the bow in no time."
				+ "time since you can regulate it as you learn", imgproduct6, imgproduct7, imgproduct8, 15, tag1, tag2, tag3, null, tag5, "sold", true, true, true);	
		Product product4 = new Product(user3,"Axe CUDEMAN SHARK", "The CUDEMAN SHARK ax has a hammer head, lever claw and bowdrill. Blade length: 7cm, ax weight: 380 / 431grams,"
				, imgproduct9, null, null, 45, tag1, null, tag3, null, null, "reserved", true, false, false);		
		Product product5 = new Product(company1,"Iguazu floor lamp", "Iguazu floor lamp with tripod base in solid pine wood with natural finish. The lampshade is made of white fabric, to give it more light."
				, imgproduct10, null, null, 60, tag1, tag2, tag3, tag4, null, "sold", true, false, false);			
		Product product6 = new Product(user5,"Shield from Boromir", "This supporting foam shield is styled on the one worn by Boromir of Gondor in The Lord of the Rings-The Fellowship of the Ring."
				+ " It is double lined in foam."
				, imgproduct11, null, null, 5, null, tag2, tag3, null, tag5, "in stock", true, false, true);
		Product product7 = new Product(user4,"Lord Of The Rings Ring","Unique Ring made of Tungsten. Black, Platinum Gold And Pink. "
				+ "They are made of Tungsten Carbide", imgproduct12, null, null, 8, tag1, tag2, null, null, null, "reserved", true, false, false);		
		Product product8 = new Product(company19,"HP 250 G6 Laptop", "HP 250 G6 Laptop. Product type: Portable, Form factor: Clamshell. "
				+ " Total storage capacity: 500 GB, Storage unit: HDD, Color of product: Black or blue", imgproduct13, imgproduct14, null, 12, tag1, tag2, tag3, tag4, null, "sold", true, true, false);		
		Product product9 = new Product(user9,"Gandalf Wizard Halloween Costume", "Character: Gandalf the gray, material: polyester, components: cape, beard, hat, warranty: 2 months"
				+ " Brand Name: fairy dreamer", imgproduct15, null, null, 15, tag1, null, tag3, null, tag5, "in stock", true, false, false);		
		Product product10 = new Product(company4,"Cooked and deep-frozen white prawns, large and medium", " Defrosting any food should be done in the fridge from one day to the next, and not at room temperature,"
				+ " in order to avoid contamination."
				, imgproduct16, imgproduct17, null, 100, tag1, tag2, tag3, null, null, "in stock", true, true, false);
		Product product11 = new Product(user10,"Funko Pop Sauron The Lord Of The Ring ", " A brand-new, unused, unopened and undamaged item. A Funko Pop figure of only 10 cm tall of the great Sauron."
				, imgproduct18, imgproduct19,null, 40, null, tag2, tag3, tag4, null, "reserved", true, false, true);		
		Product product12 = new Product(company12,"Samsung A21 Galaxy", "Immerse yourself in the large 6.5-inch Infinity-O display on the Galaxy A21s. Its wide aspect ratio fills your screen with content from side to side."
				, imgproduct20, imgproduct21, null, 140, tag1, tag2, null, null, null, "in stock", true, true, false);
		Product product13 = new Product(company8,"Gaming keyboard\n", "If you play with the lights off to better immerse yourself in the game or to avoid disturbing your roommate,"
				, imgproduct22, null, null, 12, tag1, null, null, null, tag5, "sold", true, false, false);
		Product product14 = new Product(user7,"LOTR Merry card from board game", "Condition: used. Character: Hobbit Merry from the ring company, 4 health points and 3"
				+ "both defense and attack", imgproduct23, null, null, 40, null, tag2, null, tag4, null, "reserved", true, false, false);
		Product product15 = new Product(company9,"NIVEA Moisturizing Cream for Hands, Face and Body", "Intensive hydration - This cream for face, body and hands intensively nourishes and hydrates,"
				+ "Multiple uses - NIVEA Creme canned nourishing cream is suitable for all skin types and all ages", imgproduct24, null, null, 18, tag1, null, tag3, null, null, "sold", true, false, false);
		Product product16 = new Product(user20,"Theoden King of Rohan Armor", "This costume is fully wearable and designed to be lightweight and comfortable, good for cosplay, larp, ​​and general use"
				+ "It is made of high-density EVA foam, each piece is handcrafted and carefully engraved to match Rohan's designs.", imgproduct25, null, null, 70, null, null, null, tag4, null, "in stock", true, false, false);
		Product product17 = new Product(user16,"STAFF OF SARUMAN™ THE WHITE", "Sharp-edged and unyielding, in contrast to the twisted timber of his fellow Wizards' staves, Saruman's black staff holds a single orb of white stone amid four projecting fingers at its crown, "
				, imgproduct26, null, null, 80, tag1, null, tag3, null, null, "sold", true, false, false);
		Product product18 = new Product(company5,"Apple Watch", "Apple Watch is a wearable smartwatch that allows users to accomplish a variety of tasks, including making phone calls, sending text messages and reading email. .."
				, imgproduct27, null, null, 82, null, tag2, tag3, null, tag5, "reserved", true, false, false);
		Product product19 = new Product(user6,"Anduril & Ranger Sword of Aragorn", "We are offering Replica Sword of Isildur and Aragorn Ranger Sword,It reforged again and turned into many pieces. Another sword that Aragorn has was Ranger Sword. You will be pleased that we have both blades at an affordable price. "
				, imgproduct28, null, null, 95, tag1, tag2, null, null, null, "in stock", true, false, false);
		Product product20 = new Product(company10,"sneakers HARDCOURT", "The classic basketball court style is updated with an eye-catching print. This high top sneaker features an oversized adidas logo and a leather upper that enhances its vintage essence."
				, imgproduct29, imgproduct30, null, 145, tag1, null,null, tag4, null, "reserved", true, false, false);
		
		
		
		
		
		
		//Creation Posts
		Post pos1 = new Post(user1, "Drawing =)", "We are making progress in the new draw it will be ready for the next week", imgpost);
		Post pos2 = new Post(company5, "Previus to the Exposition", "We are abaut to start the new conference,"
				+ " dont waste time and go for the online option in 10 mn!", imgpost1);
		Post pos3 = new Post(user6, "Accidents while recording dammm...", "We were filming the scene where we lost the hobbits Merry and Pippin, and I kicked a helmet.. well here we are", imgpost2);
		Post pos4 = new Post(user7, "15 years my friends!", "Its been 15 years since we finished The lord of the rings. Sucha a good work, i will miss it", imgpost3);
		Post pos5 = new Post(company9, "Beach ball", "The summer its close and we are going to give one free beach ball for every 3 nivea items that you buy", imgpost4);
		Post pos6 = new Post(user9, "Checking Email", "Even the wizards have to take a break and check the email, the wifi in the middle earth its at least good jajajaj", imgpost5);
		Post pos7 = new Post(company10, "Run Forest Run", "We hope that the winner in the future marathon, wears an adidas, lets go runners", imgpost6);
		Post pos8 = new Post(company13, "Wanna a trip?", "We spent a lot of time in the cities, we should leave them, take your seat and go!", imgpost7);
		Post pos9 = new Post(user2, "Training time", "Taking lessons before an action scene, really interesting we are going here all day, let's make it worth it", imgpost8);
		Post pos10 = new Post(company14, "Thirsty?", "Came on peopple there is now way you can miss a good cold beer, better if it is mahou trust us!", imgpost9);
		Post pos11 = new Post(user15, "CGI", "This is it, my secret revealed thats is how you bring gollum to live, I hope you like it =)", imgpost10);
		Post pos12 = new Post(user3, "which one is taller?", "well i am not gonna say, who could be taller me or the incredible Peter Jackson?!", imgpost11);
		Post pos13 = new Post(company7, "We are open people!", "We just open a new store in Madrid dont waste time and take a look to the material, we hope you like it", imgpost12);
		Post pos14 = new Post(company19, "New Printer", "The laptops are fine, but we have to keep making new produts, dont you think?", imgpost13);
		Post pos15 = new Post(user5, "Jajajaj I love it", "I could never have imagined that this scene would generate so many memes", imgpost14);
		Post pos16 = new Post(user11, "before the disaster", "Well we all know what is going to happen, at least I can't complain about the clothes, they were very comfortable", imgpost15);
		Post pos17 = new Post(company11, "New Slogan?", "We are looking for new slogans, model, marketing... for the next season of summer anyone interested?", imgpost16);
		Post pos18 = new Post(user10, "Comicon", "Fantastic Cosplay for the comiccon in San Diego this year, itsperfect keep bringing sucha pieces of art", imgpost17);
		Post pos19 = new Post(company6, "Messi with us", "Yes, we got it, we finallly arrive to an agreement and we are all very happy", imgpost18);
		Post pos20 = new Post(company4, "Sales", "We have new discounts this week dont miss them!!, we also have more 2x1 offers ", imgpost19);
		
		
		
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
