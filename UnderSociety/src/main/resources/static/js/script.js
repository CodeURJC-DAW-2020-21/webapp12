$(window).on("load", function() {
    "use strict";

    

    //  ============= POST PROJECT POPUP FUNCTION =========

    $(".post_project").on("click", function(){
        $(".post-popup.pst-pj").addClass("active");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".post-project > a").on("click", function(){
        $(".post-popup.pst-pj").removeClass("active");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= POST JOB POPUP FUNCTION =========

    $(".post-jb").on("click", function(){
        $(".post-popup.job_post").addClass("active");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".post-project > a").on("click", function(){
        $(".post-popup.job_post").removeClass("active");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= SIGNIN CONTROL FUNCTION =========

    $('.sign-control li').on("click", function(){
        var tab_id = $(this).attr('data-tab');
        $('.sign-control li').removeClass('current');
        $('.sign_in_sec').removeClass('current');
        $(this).addClass('current animated fadeIn');
        $("#"+tab_id).addClass('current animated fadeIn');
        return false;
    });

    //  ============= SIGNIN TAB FUNCTIONALITY =========

    $('.signup-tab ul li').on("click", function(){
        var tab_id = $(this).attr('data-tab');
        $('.signup-tab ul li').removeClass('current');
        $('.dff-tab').removeClass('current');
        $(this).addClass('current animated fadeIn');
        $("#"+tab_id).addClass('current animated fadeIn');
        return false;
    });

    //  ============= SIGNIN SWITCH TAB FUNCTIONALITY =========

    $('.tab-feed ul li').on("click", function(){
        var tab_id = $(this).attr('data-tab');
        $('.tab-feed ul li').removeClass('active');
        $('.product-feed-tab').removeClass('current');
        $(this).addClass('active animated fadeIn');
        $("#"+tab_id).addClass('current animated fadeIn');
        return false;
    });

    //  ============= COVER GAP FUNCTION =========

    var gap = $(".container").offset().left;
    $(".cover-sec > a, .chatbox-list").css({
        "right": gap
    });

    //  ============= OVERVIEW EDIT FUNCTION =========

    $(".overview-open").on("click", function(){
        $("#overview-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#overview-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EXPERIENCE EDIT FUNCTION =========

    $(".exp-bx-open").on("click", function(){
        $("#experience-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#experience-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EDUCATION EDIT FUNCTION =========

    $(".ed-box-open").on("click", function(){
        $("#education-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#education-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= LOCATION EDIT FUNCTION =========

    $(".lct-box-open").on("click", function(){
        $("#location-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#location-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= SKILLS EDIT FUNCTION =========

    $(".skills-open").on("click", function(){
        $("#skills-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#skills-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= ESTABLISH EDIT FUNCTION =========

    $(".esp-bx-open").on("click", function(){
        $("#establish-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#establish-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= CREATE PORTFOLIO FUNCTION =========

    $(".gallery_pt > a").on("click", function(){
        $("#create-portfolio").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#create-portfolio").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EMPLOYEE EDIT FUNCTION =========

    $(".emp-open").on("click", function(){
        $("#total-employes").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#total-employes").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  =============== Ask a Question Popup ============

    $(".ask-question").on("click", function(){
        $("#question-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function(){
        $("#question-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });


    //  ============== ChatBox ============== 


    $(".chat-mg").on("click", function(){
        $(this).next(".conversation-box").toggleClass("active");
        return false;
    });
    $(".close-chat").on("click", function(){
        $(".conversation-box").removeClass("active");
        return false;
    });

    //  ================== Edit Options Function =================


    $(".ed-opts-open").on("click", function(){
        $(this).next(".ed-options").toggleClass("active");
        return false;
    });


    // ============== Menu Script =============

    $(".menu-btn > a").on("click", function(){
        $("nav").toggleClass("active");
        return false;
    });


    //  ============ Notifications Open =============

    $(".not-box-open").on("click", function(){
        $(this).next(".notification-box").toggleClass("active");
    });

    // ============= User Account Setting Open ===========

    $(".user-info").on("click", function(){
        $(this).next(".user-account-settingss").toggleClass("active");
    });

    //  ============= FORUM LINKS MOBILE MENU FUNCTION =========

    $(".forum-links-btn > a").on("click", function(){
        $(".forum-links").toggleClass("active");
        return false;
    });
    $("html").on("click", function(){
        $(".forum-links").removeClass("active");
    });
    $(".forum-links-btn > a, .forum-links").on("click", function(){
        e.stopPropagation();
    });

    //  ============= PORTFOLIO SLIDER FUNCTION =========

    $('.profiles-slider').slick({
        slidesToShow: 3,
        slck:true,
        slidesToScroll: 1,
        prevArrow:'<span class="slick-previous"></span>',
        nextArrow:'<span class="slick-nexti"></span>',
        autoplay: true,
        dots: false,
        autoplaySpeed: 2000,
        responsive: [
        {
          breakpoint: 1200,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 1,
            infinite: true,
            dots: false
          }
        },
        {
          breakpoint: 991,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 2
          }
        },
        {
          breakpoint: 768,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
        // You can unslick at a given breakpoint now by adding:
        // settings: "unslick"
        // instead of a settings object
      ]


    });





});

  $(document).on("click", "i.del" , function() {
        var input = $(this).parent().children('label').children();
        var imagepreview = $(this).parent().children('div');
        input.val('');
        imagepreview.css("background-image", "url()");
    });
  $(function() {
      $(document).on("change",".uploadFile", function()
      {
        var uploadFile = $(this);
          var files = !!this.files ? this.files : [];
          if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
   
          if (/^image/.test( files[0].type)){ // only image file
              var reader = new FileReader(); // instance of the FileReader
              reader.readAsDataURL(files[0]); // read the local file
   
              reader.onloadend = function(){ // set image data as background of div
                  //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
              uploadFile.closest(".imgUp").find('.imagePreview').css("background-image", "url("+this.result+")");
              }
          }
        
      });
  });








  $(document).ready(function() {

    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
});


var pageprofile = 1;
var pagecompany = 1;

$(".profile").on("click", function(){
    size = 10;
    sort = 'username';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/moreUsers?page=' + pageprofile + '&size=' + size +'&sort='+sort+'&direction=asc'),
        success: function(result) {
            $.each(result.content, function(index,value){
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='http://localhost:8080/api/imageprofile/"+value.username+"' alt=''><h3>"+value.username+"</h3><ul><li><a href='#' title='' class='follow'>Follow</a></li><li><a href='./messages' title='' class='message-us'><i class='fa fa-envelope'></i></a></li></ul></div><a href='./user-profile' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if(pageprofile+1 <= result.totalPages){
                pageprofile++;
            }
        }
    });
});

$(".company").on("click", function(){
    size = 10;
    sort = 'username';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/moreCompany?page=' + pagecompany + '&size=' + size +'&sort='+sort+'&direction=asc'),
        success: function(result) {
            $.each(result.content, function(index,value){
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='http://localhost:8080/api/imageprofile/"+value.username+"' alt=''><h3>"+value.username+"</h3><ul><li><a href='#' title='' class='follow'>Follow</a></li><li><a href='./messages' title='' class='message-us'><i class='fa fa-envelope'></i></a></li></ul></div><a href='./user-profile' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if(pagecompany+1 <= result.totalPages){
                pagecompany++;
            }
        }
    });
});