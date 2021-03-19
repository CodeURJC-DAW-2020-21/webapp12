package undersociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import undersociety.services.SendMailService;

@Controller
public class EmailController {

	@Autowired
	private  SendMailService sendmail;
	
	@PostMapping("forgotpasswordmail")
	public String sendMail(@RequestParam String email) {
		sendmail.sendMail("undersocietyprueba@gmail.com", email, "Forgot Password", "Forgot password prueba");
		return "sign-in";
	}
}
