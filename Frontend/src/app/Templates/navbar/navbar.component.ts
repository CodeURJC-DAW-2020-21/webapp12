import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Message } from 'src/app/Class/Messages/message';
import { Users } from 'src/app/Class/Users/users';
import { ChatServiceService } from 'src/app/Services/Chat/chat-service.service';
import { UsersService } from 'src/app/Services/Users/users.service';
declare var SockJS;
declare var Stomp;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: Users;
  admin: boolean = true;
  page: number = 0;
  public notifys: Message[] = [];

  constructor(private userService: UsersService, private router: Router) { 
    this.connect(userService.getUserInfo().username);
  }

  ngOnInit(): void {
    if (this.userService.getLogin() == false) {
      this.router.navigate(['new/signIn']);
    } else {
      this.user = this.userService.getUserInfo();
    }

    //  ============= COVER GAP FUNCTION =========

    var gap = $(".container").offset().left;
    $(".cover-sec > a, .chatbox-list").css({
      "right": gap
    });

    //  ============== ChatBox ============== 


    $(".chat-mg").on("click", function () {
      $(this).next(".conversation-box").toggleClass("active");
      return false;
    });
    $(".close-chat").on("click", function () {
      $(".conversation-box").removeClass("active");
      return false;
    });

    // ============== Menu Script =============

    $(".menu-btn > a").on("click", function () {
      $("nav").toggleClass("active");
      return false;
    });


    //  ============ Notifications Open =============

    $(".not-box-open").on("click", function () {
      $(this).next(".notification-box").toggleClass("active");
    }); 
  
      // ============= User Account Setting Open ===========
  
      $(".user-info").on("click", function () {
          $(this).next(".user-account-settingss").toggleClass("active");
      });
  
      //  ============= FORUM LINKS MOBILE MENU FUNCTION =========
  
      $(".forum-links-btn > a").on("click", function () {
          $(".forum-links").toggleClass("active");
          return false;
      });
      $("html").on("click", function () {
          $(".forum-links").removeClass("active");
      });

  }

  logout() {
    this.userService.logout().subscribe(
      response => {
        console.log(response);
        this.userService.setLogin(false);
        this.router.navigate(['new/signIn']);
      },
      error => console.log(error)
    );
  }

  connect(user: String){
    let that = this;
    let sokect = new SockJS('/chat');
    let stompClient = Stomp.over(sokect);
    stompClient.connect({}, function(frame) {
      console.log(frame);
      stompClient.subscribe('/message/'+user, (message) => {
        if (message.body) {
          that.page++;
          let data = JSON.parse(message.body);
          let messag = new Message();
          messag.fromLogin = data.fromLogin;
          messag.time = data.time;
          messag.message = data.message;
          if(that.page <= 3){
            that.notifys.push(messag);
          }else{
            that.notifys.shift();
            that.notifys.push(messag);
          }
        }
      });
    });
  }

  clearNotify(){
    this.notifys = [];
  }

}
