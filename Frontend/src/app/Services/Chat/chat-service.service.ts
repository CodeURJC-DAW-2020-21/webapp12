import { Injectable } from '@angular/core';
declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root'
})
export class ChatServiceService {

  stompClient;
  
  constructor() { 
    this.connect();
  }

  connect() {
    const sokect = new SockJS('/chat');
    this.stompClient = Stomp.over(sokect);
    this.stompClient.connect({}, function(frame) {
      this.stompClient.subscribe('/message/h', (message) => {
        if (message.body) {
          let data = JSON.parse(message.body);
          console.log(data);
        }
      });
    });
  }
}
