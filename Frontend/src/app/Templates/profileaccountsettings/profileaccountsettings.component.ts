import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bookmarks } from 'src/app/Class/Bookmarks/bookmarks';
import { Relations } from 'src/app/Class/Relations/relations';
import { Users } from 'src/app/Class/Users/users';
import { BookmarkService } from 'src/app/Services/Bookmarks/bookmark.service';
import { RelationsService } from 'src/app/Services/Relations/relations.service';
import { UsersService } from 'src/app/Services/Users/users.service';

@Component({
  selector: 'app-profileaccountsettings',
  templateUrl: './profileaccountsettings.component.html',
  styleUrls: ['./profileaccountsettings.component.css']
})
export class ProfileaccountsettingsComponent implements OnInit {
  userpage: Users;
  bookmarks: Bookmarks[] = [];
  followers: Relations[] = [];
  imageProfile: FormData;
  imageThemeProfile: FormData;
  newUser: Users = new Users();
  email: String;
  password: String;

  constructor(private userService: UsersService, private relationService: RelationsService, private bookmarkService: BookmarkService, private router: Router) { }

  ngOnInit(): void {
    this.userpage = this.userService.getUserInfo();
    this.newUser.idusers = this.userpage.idusers;
    this.userService.getBookmarks("" + this.userpage.idusers).subscribe(
      response => this.bookmarks = response,
      error => console.error(error)
    );
    this.userService.getUserFollowers("" + this.userpage.idusers).subscribe(
      response => this.followers = response,
      error => console.error(error)
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


  imageSelectedUser(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageProfile = formData;
    this.userService.uploadImageProfile("" + this.userService.getUserInfo().idusers, this.imageProfile).subscribe(
      response =>  console.log(response),
      error => console.error(error)
    );
  }

  deleteImageProfile() {
    this.imageProfile = undefined;
    console.log(this.imageProfile);
  }

  imageThemeSelectedUser(event) {
    let formData = new FormData();
    formData.append("image", event.target.files[0]);
    this.imageThemeProfile = formData;
    this.userService.uploadThemeProfile("" + this.userService.getUserInfo().idusers, this.imageThemeProfile).subscribe(
      response =>  console.log(response),
      error => console.error(error)
    );
  }

  deleteImageThemeProfile() {
    this.imageThemeProfile = undefined;
    console.log(this.imageThemeProfile);
  }

  modify() {
    this.userService.replaceUser("" + this.userService.getUserInfo().idusers, this.newUser).subscribe(
      response => {
        this.userService.setUserInfo(response);
        this.userService.logout().subscribe(
          response => {
            console.log(response);
            this.router.navigate(['new/signIn']);
          },
          error => console.error(error)
        ); 
      },
      error => console.error(error)
    );

  }

  unfollow(id: Number, follow: Relations) {
    this.relationService.deleteRelations("" + id).subscribe(
      response => {
        console.log(response);
        let index = this.followers.indexOf(follow);
        this.followers.splice(index, 1);
      },
      error => console.error(error)
    );
  }

  dropProduct(id: Number, bookmark: Bookmarks) {
    this.bookmarkService.deleteBookmark("" + id).subscribe(
      response => {
        console.log(response);
        let index = this.bookmarks.indexOf(bookmark);
        this.bookmarks.splice(index, 1);
      },
      error => console.error(error)
    );
  }

  deleteAccount(id: Number) {
    this.userService.deleteUser("" + id).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }
}
