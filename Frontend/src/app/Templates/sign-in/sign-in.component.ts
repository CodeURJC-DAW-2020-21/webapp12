import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  /*Login*/ 
  username: string;
  password: string;
  /*Register User*/
  formDataUser: FormData;
  customer: Users = new Users();
  passrepcustomer: String;
  ccUser : Boolean;
  /*Register Company*/
  formDataCompany: FormData;
  company: Users = new Users();
  passrepCom: String;
  ccCom : Boolean;

  constructor(private userService: UsersService, private router: Router) {

  }

  ngOnInit(): void {

    //==================== Upload Image =========================
    $(document).on("click", "i.del", function () {
      var input = $(this).parent().children('label').children();
      var imagepreview = $(this).parent().children('div');
      input.val('');
      imagepreview.css("background-image", "url()");
    });


    $(function () {
      $(document).on("change", ".uploadFile", function () {
        var uploadFile = $(this);
        var files = !!this.files ? this.files : [];
        if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support

        if (/^image/.test(files[0].type)) { // only image file
          var reader = new FileReader(); // instance of the FileReader
          reader.readAsDataURL(files[0]); // read the local file

          reader.onloadend = function () { // set image data as background of div
            uploadFile.closest(".imgUp").find('.imagePreview').css("background-image", "url(" + this.result + ")");
          }
        }

      });
    });


    $(document).ready(function () {
      var readURL = function (input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.readAsDataURL(input.files[0]);
        }
        console.log(readURL);
      }


      $(".file-upload").on('change', function () {
        readURL(this);
      });

      $(".upload-button").on('click', function () {
        $(".file-upload").click();
      });
    });


    //  ============= SIGNIN CONTROL FUNCTION =========

    $('.sign-control li').on("click", function () {
      var tab_id = $(this).attr('data-tab');
      $('.sign-control li').removeClass('current');
      $('.sign_in_sec').removeClass('current');
      $(this).addClass('current animated fadeIn');
      $("#" + tab_id).addClass('current animated fadeIn');
      return false;
  });

  //  ============= SIGNIN TAB FUNCTIONALITY =========

  $('.signup-tab ul li').on("click", function () {
      var tab_id = $(this).attr('data-tab');
      $('.signup-tab ul li').removeClass('current');
      $('.dff-tab').removeClass('current');
      $(this).addClass('current animated fadeIn');
      $("#" + tab_id).addClass('current animated fadeIn');
      return false;
  });

  //  ============= SIGNIN SWITCH TAB FUNCTIONALITY =========

  $('.tab-feed ul li').on("click", function () {
      var tab_id = $(this).attr('data-tab');
      $('.tab-feed ul li').removeClass('active');
      $('.product-feed-tab').removeClass('current');
      $(this).addClass('active animated fadeIn');
      $("#" + tab_id).addClass('current animated fadeIn');
      return false;
  });

  }


  login() {
    this.userService.login(this.username, this.password).subscribe(
      response => {
        this.userService.getAllUsers().subscribe(
          response => {
            response.forEach(element => {
              if (element.username == this.username) {
                this.userService.getUser(""+element.idusers).subscribe(
                  response => {
                    this.userService.setUserInfo(response);
                    this.userService.getRoles(element.idusers).subscribe(
                      response => {
                        this.userService.setAdmin(false);
                        response.forEach(element => {
                          if (element.rol == "ADMIN") {
                            console.log(element.rol);
                            this.userService.setAdmin(true);
                          }
                        });
                        this.userService.setLogin(true);
                        console.log(this.userService.getUserInfo());
                        this.router.navigate(['/home']);
                      },
                      error => console.error(error)
                    );
                  },
                  error => console.error(error)
                );
              }
            });
          },
          error => console.error(error)
        );
      },
      error => console.error(error)
    );
  }

  imageSelectedUser(event){
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.formDataUser = formData;
  }

  imageSelectedCompany(event){
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.formDataCompany = formData;
  }

  deleteImageUser(){
    this.formDataUser = undefined;
  }

  deleteImageCompany(){
    this.formDataCompany = undefined;
  }

  registerUser(){
    this.customer.companyprofile = false;
    this.userService.registerUser(this.customer).subscribe(
      response =>  {
        console.log(response);
        this.router.navigate(['/index']);
      },
      error => {
        console.error(error);
        alert("Username is token");
      }
    );
  }

  registerCompany(){
    this.company.companyprofile = true;
    this.userService.registerUser(this.company).subscribe(
      response =>  {
        console.log(response);
        this.router.navigate(['/index']);
      },
      error => console.error(error)
    );
  }
}
