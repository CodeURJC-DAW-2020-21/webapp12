package undersociety.controller;

import java.util.List;

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
import undersociety.services.UserService;


@RestController
@CrossOrigin
public class MessageController {
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
       userService.saveMessage(to, message);
       simpMessagingTemplate.convertAndSend("/message/"+to, message);
    }
    
    @GetMapping("/getChad")
    public List<Message> getChat(@RequestParam String from, @RequestParam String to) {
    	return userService.getChat(from, to);
    }
}
