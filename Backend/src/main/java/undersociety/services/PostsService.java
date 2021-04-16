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

import undersociety.models.LikeAPost;
import undersociety.models.Post;
import undersociety.models.PostModel;
import undersociety.models.Users;
import undersociety.repositories.LikesRepository;
import undersociety.repositories.PostRepository;
import undersociety.repositories.UserRepository;

@Service
public class PostsService {
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private PostRepository postsrepo;
	
	@Autowired
	private LikesRepository likerepo;
	
/////////////////////////////////////////////////////API METHODS////////////////////////////////////////////////////////////////////////
	public List<Post> getAll() {
	
	return postsrepo.findAll();
	
	}
	
	public Page<Post> getPostsByUserRest(int idUser, String page, int size){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return postsrepo.findByiduser(user, PageRequest.of(Integer.parseInt(page), size));
	}
	
	public List<Post> getAllPostsByUserRest(int idUser){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return postsrepo.findByiduser(user);
	}
	

	public Post getPostRest(int idPost) {
		return postsrepo.findById(idPost).orElseThrow(() -> new NoSuchElementException("Post not found"));
	}

	public Optional<Post> getPostById(int idPost) {

		return postsrepo.findById(idPost);

	}

	public void deletePostbyid(int id) {
		Post prev = postsrepo.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
		postsrepo.deleteById(prev.getIdpost());
		likerepo.deleteByIdpost(prev);

	}


	public void savePost(Post newPost) {
		postsrepo.save(newPost);

	}
	

	public Post getPostByTitle(String title) {

		return postsrepo.findBytitle(title);
	}
	
	
	public List<LikeAPost> getAllLikes() {

		return likerepo.findAll();

	}

	public void saveLike(LikeAPost like) {
		likerepo.save(like);

	}

	public LikeAPost getLikesapi(LikeAPost like) {
		LikeAPost Post = likerepo.findByidpostAndIduser(like.getIdpost(), like.getIduser());
		return Post;
	}

	public Optional<LikeAPost> getLikesbyid(int id) {
		return likerepo.findById(id);
	}
	
	public void deleteLikesbyid(int id) {
		likerepo.deleteById(id);

	}
//////////////////////////////////////////////////////NORMAL METHODS/////////////////////////////////////////////////////////////////////
	
	public Post getPost(int idpost) {
		return postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("Post not found"));
	}
	
	public Page<Post> getPostsByUser(int idUser,String page, int size){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return postsrepo.findByiduser(user, PageRequest.of(Integer.parseInt(page), size));
	}
	
	public List<Post> getAllPostsByUser(int idUser){
		Users user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
		return postsrepo.findByiduser(user);
	}
	
	public Page<Post> getPosts(Pageable page){
		return postsrepo.findAll(page);
	}
	
	public Page<Post> getPostsByUsername(String username, Pageable page){
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		return postsrepo.findByiduser(s,page);
	}
	
	public void savePost(String username, Post post, MultipartFile image) throws IOException {
		Users user = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		if(image != null) {
			post.setImage(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		}
		post.setIduser(user);
		postsrepo.save(post);
	}
	
	public void likePost(String username,int idpost){
		Post p = postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("Post not found"));
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		LikeAPost lp = new LikeAPost();
		lp.setIdpost(p);
		lp.setIduser(s);
		likerepo.save(lp);
	}
	
	public void unLikePosts(String username,int idpost) {
		Post p = postsrepo.findById(idpost).orElseThrow(() -> new NoSuchElementException("	Post not found"));
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		LikeAPost lp = likerepo.findByidpostAndIduser(p, s);
		likerepo.deleteById(lp.getIdlike());
	}
	
	public List<LikeAPost> getLikes(String username){
		Users s = userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
		return likerepo.findByiduser(s);
	}
	
	public List<PostModel> getPostIndex(String username){
		Page<Post> p = postsrepo.findAll(PageRequest.of(0, 10,Sort.by("idpost").descending()));
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(username).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(post.getIduser().getUserprofile()) {
				postmodel.setTypeUser("user");
			}else {
				postmodel.setTypeUser("company");
			}
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		return postsmodels;
	}
	
	public List<PostModel> getPostUserPage(Users actual, Users follow){
		Page<Post> p = postsrepo.findByiduser(follow,PageRequest.of(0, 10,Sort.by("idpost").descending()));		
		List<LikeAPost> lp = likerepo.findByiduser(userRepository.findByusername(actual.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found")));
		List<PostModel> postsmodels = new ArrayList<>();
		List<Integer> likes = new ArrayList<>();
		for (LikeAPost like : lp) {
			likes.add(like.getIdpost().getIdpost());
		}
		for (Post post : p) {
			PostModel postmodel = new PostModel();
			if(post.getIduser().getUserprofile()) {
				postmodel.setTypeUser("user");
			}else {
				postmodel.setTypeUser("company");
			}
			if(likes.contains(post.getIdpost())) {
				postmodel.setLike("la la-heart");
			}else {
				postmodel.setLike("la la-heart-o");
			}
			postmodel.setPost(post);
			postsmodels.add(postmodel);
		}
		return postsmodels;
	}

	public boolean existsPost(String title) {
		return postsrepo.existsIdpostsByTitle(title);
	}
}
