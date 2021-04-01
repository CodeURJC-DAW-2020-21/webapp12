package undersociety.services;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.Message;
import undersociety.models.MessageModel;
import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.models.UsersRelations;
import undersociety.repositories.LikesRepository;
import undersociety.repositories.ListProductsRepository;
import undersociety.repositories.MessageRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.ProductRepository;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;
import undersociety.repositories.UsersRelationsRepository;

@Service
public class UserService {
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private LikesRepository likerepo;
	
	@Autowired
	private MessageRepository messagerepo;
	
	@Autowired
	private UsersRelationsRepository relationrepo;
	
	@Autowired
	private ListProductsRepository listproductrepo;
	
	@Autowired
	 private UserRepository userRepository;
		
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	public Optional<Users> getUserId(int id){
		return userRepository.findById(id);
	}
	
	public Users getUser(String username) {
		return (userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found")));
	}
	
	public Page<Users> getUsersPage(Pageable page){
		return userRepository.findAll(page);
	}
	
	public List<Users> getAll(){
        return userRepository.findAll();
	}
	
	public Page<Users> getAllUsersPage(){
        return userRepository.findAll(PageRequest.of(0, 10,Sort.by("username").ascending()));
	}
	
	public Page<Users> getUsersPage(){
        return userRepository.findByuserprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
	}
	
	public Page<Users> getCompaniesPage(){
        return userRepository.findBycompanyprofile(true, PageRequest.of(0, 10,Sort.by("username").ascending()));
	}
	
	public void registerUsers(Users user, MultipartFile image) throws IOException {

		if(userRepository.existsIdusersByUsername(user.getUsername())) {
			throw new NoSuchElementException("USERNAME IS TOKEN");
		}else {
			if(image != null) {
				user.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
			}
			user.setCity("");
			user.setUserinfo("");
			user.setUserprofile(true);
			user.setCompanyprofile(false);
			user.setPass(encoder.encode(user.getPass()));
			userRepository.save(user);
			Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
			Roles r = new Roles();
			r.setIduser(use);
			r.setRol("USER");
			rolesRepository.save(r);
		}

	}

	public void registerCompanies(Users user, MultipartFile image) throws IOException {
		if(userRepository.existsIdusersByUsername(user.getUsername())) {
			throw new NoSuchElementException("USERNAME IS TOKEN");
		}else {
			if(image != null) {
				user.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
			}
			user.setUserprofile(false);
			user.setCompanyprofile(true);
			user.setPass(encoder.encode(user.getPass()));
			userRepository.save(user);
			Users use =  (userRepository.findByusername(user.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
			Roles r = new Roles();
			r.setIduser(use);
			r.setRol("USER");
			rolesRepository.save(r);
		}
	}

	public Page<Users> getUsers(Pageable page){
		return userRepository.findByuserprofile(true,page);

	}

	public Page<Users> getCompanies(Pageable page){    	
		return userRepository.findBycompanyprofile(true,page);
	}

	public boolean follow(String user, String following) {
		Users follow = userRepository.findByusername(following).orElseThrow(() -> new NoSuchElementException("User not found"));
		Users actual = userRepository.findByusername(user).orElseThrow(() -> new NoSuchElementException("User not found"));
		UsersRelations save = new UsersRelations();
		save.setUserone(actual);
		save.setUsertwo(follow);
		UsersRelations s =  relationrepo.findByuseroneAndUsertwo(actual, follow);
		if(s != null) {
			save.setIduserrelation(s.getIduserrelation());
			relationrepo.delete(save);
			return false;
		}else {
			relationrepo.save(save);
			return true;
		}
	}

	public boolean unfollow(int idrelation) {
		relationrepo.deleteById(idrelation);
		return true;
	}

	public List<UsersRelations> getFollows(String username) {
		return relationrepo.findByuserone(userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found")));
	}

	public void usernameIsToken(String username) {
		if(userRepository.existsIdusersByUsername(username)) {
			throw new NoSuchElementException("USERNAME IS TOKEN");
		}
	}
	
	@Modifying
	public void modifyDataUser(Users user, String username, MultipartFile image, MultipartFile imageProfilePage) throws IOException {
		Users prev = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		if(image != null){
			if(!image.isEmpty()) {
				prev.setUserimg(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
			}
		}
		
		if(imageProfilePage != null){
			if(!imageProfilePage.isEmpty()) {
	    		prev.setImageprofile(BlobProxy.generateProxy(imageProfilePage.getInputStream(), imageProfilePage.getSize()));
	    	}
		}
		
		if(!user.getUsername().isEmpty()) {
			prev.setUsername(user.getUsername());
		}
		if(!user.getEmail().isEmpty()) {
			prev.setEmail(user.getEmail());
		}
		if(!user.getName().isEmpty()) {
			prev.setName(user.getName());
		}
		if(!user.getCity().isEmpty()) {
			prev.setCity(user.getCity());
		}
		if(!user.getLinkfacebook().isEmpty()) {
			prev.setLinkfacebook(user.getLinkfacebook());
		}
		if(!user.getLinkinstagram().isEmpty()) {
			prev.setLinkinstagram(user.getLinkinstagram());
		}
		if(!user.getLinktwitter().isEmpty()) {
			prev.setLinktwitter(user.getLinktwitter());
		}
		userRepository.save(prev);
	}

	@Modifying
	public void modifyPass(String username, String newpassword) {
		Users prev = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		prev.setPass(encoder.encode(newpassword));
		userRepository.save(prev);
	}
	
	@Transactional
	public void deleteUser(String username) {
    	Users prev = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		listproductrepo.deleteByIduser(prev);
    	relationrepo.deleteByUserone(prev);
    	relationrepo.deleteByUsertwo(prev);
    	messagerepo.deleteByIduser(prev);
    	messagerepo.deleteByIduserto(prev);
    	likerepo.deleteByIduser(prev);
    	postsrepo.deleteByIduser(prev);
    	productrepo.deleteByIduser(prev);
    	relationrepo.deleteByUserone(prev);
    	rolesRepository.deleteByIduser(prev);
    	userRepository.deleteById(prev.getIdusers());
	}
	
	public void saveMessage(String to , MessageModel message) {
		Users f =  userRepository.findByusername(message.getFromLogin()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Users t =  userRepository.findByusername(to).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Message m = new Message();
    	m.setIduser(f);
    	m.setIduserto(t);
    	m.setMessage(message.getMessage());
    	m.setTime(message.getTime());
    	messagerepo.save(m);
	}

	public List<Message> getChat(String from, String to) {
    	Users f = userRepository.findByusername(from).orElseThrow(() -> new NoSuchElementException("User not found"));
		Users t = userRepository.findByusername(to).orElseThrow(() -> new NoSuchElementException("User not found"));
    	List<Message> m = messagerepo.findByIduserAndIduserto(t, f);
    	List<Message> m2 = messagerepo.findByIduserAndIduserto(f, t);
    	m.addAll(m2);
    	Collections.sort(m);
    	return m;
	}
	
	public List<Users> getListMostFollowed(){
		return relationrepo.findMostFollowers(PageRequest.of(0, 5));
	}
	
	public List<UsersRelations> getFollowing(String username){
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		return relationrepo.findByuserone(s);
	}
	
	public List<UsersRelations> getFollowers(String username){
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		return relationrepo.findByusertwo(s);	
	}
	
	public String existsRealtion(Users actual,Users follow) {
		String color = "#53D690";
		UsersRelations s =  relationrepo.findByuseroneAndUsertwo(actual, follow);
    	if(s != null) {
    		color = "#e44d3a";
    	}
    	return color;
	}

	public void saveRelation(UsersRelations relation) {
		relationrepo.save(relation);
	}
	
	public List<UsersRelations> getAllRelations(){
        return relationrepo.findAll();
	}
	
	public Optional<UsersRelations> getRelations(int id){
        return relationrepo.findById(id);
	}

	public void deleteRelation(UsersRelations usersRelations) {
		relationrepo.delete(usersRelations);
	}
}
