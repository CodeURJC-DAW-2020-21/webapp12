package undersociety.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import undersociety.services.SendMailService;

@RestController
public class EmailController {

	@Autowired
	private  SendMailService sendmail;
	
	@PostMapping("/forgotpasswordmail")
	public void forgotpasswordmail(@RequestParam String email, HttpServletResponse response) throws IOException {
		sendmail.sendMailTo("undersocietyprueba@gmail.com", email, "Forgot Password", "Forgot password prueba");
		response.sendRedirect("/");
	}
}
