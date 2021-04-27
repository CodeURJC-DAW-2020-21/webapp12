import { Injectable } from '@angular/core';
declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root'
})
export class ChatServiceService {

  constructor() { 
    this.connect();
  }

  connect() {
    const sokect = new SockJS('/chat');
    let stompClient = Stomp.over(sokect);
    stompClient.connect({}, function(frame) {
      console.log(frame);
      stompClient.subscribe('/message/h', (message) => {
        if (message.body) {
          let data = JSON.parse(message.body);
          console.log(data);
        }
      });
    });
  }
}
