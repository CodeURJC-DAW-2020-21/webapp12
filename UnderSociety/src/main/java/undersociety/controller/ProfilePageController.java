package undersociety.controller;






import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import undersociety.models.Users;
import undersociety.repositories.UserRepository;

@RestController
@CrossOrigin
public class ProfilePageController {
	
	@Autowired
	 private UserRepository userRepository;
	
	@Modifying
    @PostMapping("/api/changeImageProfile")
    public void modifyimageThemeProfile(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile imageFile) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(imageFile != null) {
    		prev.setImageprofile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
    	}
    	userRepository.save(prev);
    	
    	response.sendRedirect("/my-profile-feed");
    }
	
	@Modifying
    @PostMapping("/api/changeUserImage")
    public void modifyUserImg(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile imageUserFile) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(imageUserFile != null) {
    		prev.setUserimg(BlobProxy.generateProxy(imageUserFile.getInputStream(), imageUserFile.getSize()));
    	}
    	userRepository.save(prev);
    	
    	response.sendRedirect("/my-profile-feed");
    }
	
	@Modifying
	@PostMapping("/api/changeUserInfo")
	public void modifyUserInfo(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) String userInfo) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(userInfo != null) {
    		prev.setUserinfo(userInfo);
    	}
    	userRepository.save(prev);
    	
    	response.sendRedirect("/my-profile-feed");
    }
	
	@Modifying
	@PostMapping("/api/changeUserCity")
	public void modifyUserCity(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) String userCity) throws IOException {
    	Users prev = userRepository.findByusername(request.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	if(userCity != null) {
    		prev.setCity(userCity);
    	}
    	userRepository.save(prev);
    	
    	response.sendRedirect("/my-profile-feed");
    }
	
	@GetMapping("/api/imageThemeProfile")
    private ResponseEntity<Object> downloadImage(HttpServletRequest sesion) throws SQLException{
    	Users s = userRepository.findByusername(sesion.getUserPrincipal().getName()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Resource file = new InputStreamResource(s.getImageprofile().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getImageprofile().length())
				.body(file);
    }
    

}
