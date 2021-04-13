package undersociety.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String from, String to, String Subject, String body) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(Subject);
		email.setText(body);
		javaMailSender.send(email);
	}
}
