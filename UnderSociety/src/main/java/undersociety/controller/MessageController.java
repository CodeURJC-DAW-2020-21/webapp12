package undersociety.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import undersociety.models.Message;
import undersociety.models.MessageModel;
import undersociety.models.Users;
import undersociety.repositories.MessageRepository;
import undersociety.repositories.PostRepository;
import undersociety.services.UserService;


@RestController
@CrossOrigin
public class MessageController {

	@Autowired
	private UserService userservice;

	@Autowired
	private MessageRepository messagedb;
	
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
        System.out.println("handling send message: " + message + " to: " + to);
        Users f = (Users) userservice.findByUser_name(message.getFromLogin());
    	Users t = (Users) userservice.findByUser_name(to);
    	System.out.println("from: "+ f.getId_users()+" to: " + t.getId_users());
    	Message m = new Message();
    	m.setIduser(f);
    	m.setIduserto(t);
    	m.setMessage(message.getMessage());
    	messagedb.save(m);
        boolean isExists = userservice.findByUser_nameExists(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
    
    @GetMapping("getChad")
    public List<Message> getChat(@RequestParam String from, @RequestParam String to) {
    	Users f = (Users) userservice.findByUser_name(from);
    	Users t = (Users) userservice.findByUser_name(to);
    	List<Message> m = messagedb.findByIduserAndIduserto(t, f);
    	List<Message> m2 = messagedb.findByIduserAndIduserto(f, t);
    	m.addAll(m2);
    	Collections.sort(m);
    	for (Message message : m) {
			System.out.println(message.getIdmessage());
		}
    	System.out.println(m);
    	return m;
    }
}
