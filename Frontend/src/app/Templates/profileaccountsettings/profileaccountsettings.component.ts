import { Component, OnInit } from '@angular/core';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Relations } from 'src/app/Class/Relations/relations';
import { Users } from 'src/app/Class/Users/users';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-profileaccountsettings',
  templateUrl: './profileaccountsettings.component.html',
  styleUrls: ['./profileaccountsettings.component.css']
})
export class ProfileaccountsettingsComponent implements OnInit {
  userpage: Users;
  bookmarks : Bookmarks[] = [];
  followers : Relations[] = [];
  imageProfile: FormData;
  newUser: Users = new Users();
  email: String;
  password: String;

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.userpage = this.userService.getUserInfo();
    this.newUser.idusers = this.userpage.idusers;
    this.userService.getBookmarks(""+this.userpage.idusers).subscribe(
      response => this.bookmarks = response,
      error => console.log(error)
    );
    this.userService.getUserFollowers(""+this.userpage.idusers).subscribe(
      response => this.followers = response,
      error => console.log(error)
    );

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
  }


  imageSelectedUser(event){
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageProfile = formData;
    console.log(this.imageProfile);
  }

  deleteImageProfile(){
    this.imageProfile = undefined;
    console.log(this.imageProfile);
  }

  modify(){
    console.log(this.newUser);
  }

  unfollow(id: Number){
    console.log(id);
  }

  dropProduct(id: Number){
    console.log(id);
  }

  deleteAccount(id: Number){
    console.log(id);
  }
}
