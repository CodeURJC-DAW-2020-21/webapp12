package undersociety.controller;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.Message;
import undersociety.models.MessageModel;
import undersociety.models.Users;
import undersociety.repositories.MessageRepository;
import undersociety.repositories.UserRepository;


@RestController
@CrossOrigin
public class MessageController {

	@Autowired
	 private UserRepository userRepository;

	@Autowired
	private MessageRepository messagedb;
	
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
        Users f =  userRepository.findByusername(message.getFromLogin()).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Users t =  userRepository.findByusername(to).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Message m = new Message();
    	m.setIduser(f);
    	m.setIduserto(t);
    	m.setMessage(message.getMessage());
    	m.setTime(message.getTime());
    	messagedb.save(m);
        simpMessagingTemplate.convertAndSend("/message/"+to, message);
    }
    
    @GetMapping("/api/getChad")
    public List<Message> getChat(@RequestParam String from, @RequestParam String to) {
    	Users f = userRepository.findByusername(from).orElseThrow(() -> new NoSuchElementException("User not found"));
    	Users t = userRepository.findByusername(to).orElseThrow(() -> new NoSuchElementException("User not found"));
    	List<Message> m = messagedb.findByIduserAndIduserto(t, f);
    	List<Message> m2 = messagedb.findByIduserAndIduserto(f, t);
    	m.addAll(m2);
    	Collections.sort(m);
    	return m;
    }
}
