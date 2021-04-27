import { Component, OnInit } from '@angular/core';
import { Messages } from 'src/app/Class/Models/messages';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';
declare var SockJS;
declare var Stomp;

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  to: String = "H";
  message: String;
  select: String;
  username: String;
  users: Users[] = [];
  messages: Messages[] = [];
  stompClient;
  page: number = 0;

  constructor(private userService: UsersService) {
    this.username = userService.getUserInfo().username;
    this.userService.getUsersPage(""+this.page).subscribe(
      response => this.users = response,
      error => console.error(error)
    );
  }

  ngOnInit(): void {
    let that = this;
    let sokect = new SockJS('/chat');
    this.stompClient = Stomp.over(sokect);
    this.stompClient.connect({}, function(frame) {
      console.log(frame);
      that.stompClient.subscribe('/message/'+that.userService.getUserInfo().username, (message) => {
        if (message.body) {
          let data = JSON.parse(message.body);
          let messag = new Messages();
          that.userService.getAllUsers().subscribe(
            response =>{
              response.forEach(element => {
                if(element.username == data.fromLogin){
                  messag.iduser = element;
                  messag.time = data.time;
                  messag.message = data.message;
                  if(that.select == data.fromLogin){
                    that.messages.push(messag);
                  }
                }
              });
            },
            error => console.error(error)
          );          
        }
      });
    });
  }

  send() {
    this.stompClient.send('/app/chat/' + this.select, {}, JSON.stringify({
      fromLogin: this.username,
      message: this.message,
      time: "" + new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3")
    }));
  }

  prev(){
    if( (this.page - 1) >= 0 ){
      this.page--;
      this.userService.getUsersPage(""+this.page).subscribe(
        response => this.users = response,
        error => console.error(error)
      );
    }
  }

  next(){
    this.page++;
    this.userService.getUsersPage(""+this.page).subscribe(
      response => this.users = response,
      error => console.error(error)
    );
  }

  selectUser(user: Users){
    this.select = user.username;
    this.to = user.username;
    this.userService.getChats(this.userService.getUserInfo().idusers,user.username).subscribe(
      response => this.messages = response,
      error => console.error(error)
    );
  }
}
