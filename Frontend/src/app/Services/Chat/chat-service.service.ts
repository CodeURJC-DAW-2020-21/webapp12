import { Injectable } from '@angular/core';
import { UsersService } from '../Users/users.service';
declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root'
})
export class ChatServiceService {

  constructor(private userService: UsersService) { 
    this.connect(this.userService.getUserInfo().username);
  }

  connect(user: String) {
    const sokect = new SockJS('/chat');
    let stompClient = Stomp.over(sokect);
    stompClient.connect({}, function(frame) {
      console.log(frame);
      stompClient.subscribe('/message/'+user, (message) => {
        if (message.body) {
          let data = JSON.parse(message.body);
          console.log(data.fromLogin);
          
        }
      });
    });
  }
}
