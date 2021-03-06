package undersociety.controller;






import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import undersociety.services.UserService;

@RestController
@CrossOrigin
public class ProfilePageController {
	
	@Autowired
	private UserService userService;
	
    @PostMapping("/changeImageProfile")
    public void modifyimageThemeProfile(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile imageFile) throws IOException {
		Users prev = userService.getUser(request.getUserPrincipal().getName());
    	userService.modifyDataUser(prev, request.getUserPrincipal().getName(), null, imageFile);
    	response.sendRedirect("/my-profile-feed");
    }
	
    @PostMapping("/changeUserImage")
    public void modifyUserImg(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) MultipartFile imageUserFile) throws IOException {
		Users prev = userService.getUser(request.getUserPrincipal().getName());
    	userService.modifyDataUser(prev, request.getUserPrincipal().getName(), imageUserFile, null);
    	response.sendRedirect("/my-profile-feed");
    }
	
	@PostMapping("/changeUserInfo")
	public void modifyUserInfo(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) String userInfo) throws IOException {
		Users prev = userService.getUser(request.getUserPrincipal().getName());
    	if(userInfo != null) {
    		prev.setUserinfo(userInfo);
    	}
    	userService.modifyDataUser(prev, request.getUserPrincipal().getName(), null, null);
    	response.sendRedirect("/my-profile-feed");
    }
	
	@Modifying
	@PostMapping("/changeUserCity")
	public void modifyUserCity(HttpServletResponse response, HttpServletRequest request, @RequestParam(required = false) String userCity) throws IOException {
    	Users prev = userService.getUser(request.getUserPrincipal().getName());
    	if(userCity != null) {
    		prev.setCity(userCity);
    	}
    	userService.modifyDataUser(prev, request.getUserPrincipal().getName(), null, null);
    	
    	response.sendRedirect("/my-profile-feed");
    }
	
	@GetMapping("/imageThemeProfile")
    private ResponseEntity<Object> downloadImage(HttpServletRequest request) throws SQLException{
    	Users s = userService.getUser(request.getUserPrincipal().getName());
    	Resource file = new InputStreamResource(s.getImageprofile().getBinaryStream());
    	return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
				.contentLength(s.getImageprofile().length())
				.body(file);
    }
    

}
