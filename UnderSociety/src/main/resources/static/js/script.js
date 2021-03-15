$(window).on("load", function () {
    "use strict";



    //  ============= POST PROJECT POPUP FUNCTION =========

    $(".post_project").on("click", function () {
        $(".post-popup.pst-pj").addClass("active");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".post-project > a").on("click", function () {
        $(".post-popup.pst-pj").removeClass("active");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= POST JOB POPUP FUNCTION =========

    $(".post-jb").on("click", function () {
        $(".post-popup.job_post").addClass("active");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".post-project > a").on("click", function () {
        $(".post-popup.job_post").removeClass("active");
        $(".wrapper").removeClass("overlay");
        return false;
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

    //  ============= COVER GAP FUNCTION =========

    var gap = $(".container").offset().left;
    $(".cover-sec > a, .chatbox-list").css({
        "right": gap
    });

    //  ============= OVERVIEW EDIT FUNCTION =========

    $(".overview-open").on("click", function () {
        $("#overview-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#overview-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EXPERIENCE EDIT FUNCTION =========

    $(".exp-bx-open").on("click", function () {
        $("#experience-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#experience-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EDUCATION EDIT FUNCTION =========

    $(".ed-box-open").on("click", function () {
        $("#education-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#education-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= LOCATION EDIT FUNCTION =========

    $(".lct-box-open").on("click", function () {
        $("#location-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#location-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= SKILLS EDIT FUNCTION =========

    $(".skills-open").on("click", function () {
        $("#skills-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#skills-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= ESTABLISH EDIT FUNCTION =========

    $(".esp-bx-open").on("click", function () {
        $("#establish-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#establish-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= CREATE PORTFOLIO FUNCTION =========

    $(".gallery_pt > a").on("click", function () {
        $("#create-portfolio").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#create-portfolio").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  ============= EMPLOYEE EDIT FUNCTION =========

    $(".emp-open").on("click", function () {
        $("#total-employes").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#total-employes").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
    });

    //  =============== Ask a Question Popup ============

    $(".ask-question").on("click", function () {
        $("#question-box").addClass("open");
        $(".wrapper").addClass("overlay");
        return false;
    });
    $(".close-box").on("click", function () {
        $("#question-box").removeClass("open");
        $(".wrapper").removeClass("overlay");
        return false;
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

    //  ================== Edit Options Function =================


    $(".ed-opts-open").on("click", function () {
        $(this).next(".ed-options").toggleClass("active");
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
    $(".forum-links-btn > a, .forum-links").on("click", function () {
        e.stopPropagation();
    });

    //  ============= PORTFOLIO SLIDER FUNCTION =========

    $('.profiles-slider').slick({
        slidesToShow: 3,
        slck: true,
        slidesToScroll: 1,
        prevArrow: '<span class="slick-previous"></span>',
        nextArrow: '<span class="slick-nexti"></span>',
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
                //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
                uploadFile.closest(".imgUp").find('.imagePreview').css("background-image", "url(" + this.result + ")");
            }
        }

    });
});








$(document).ready(function () {


    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }


    $(".file-upload").on('change', function () {
        readURL(this);
    });

    $(".upload-button").on('click', function () {
        $(".file-upload").click();
    });
});


var pageprofile = 1;
var pagecompany = 1;
var pagepost = 1;
var pageproduct = 1;
var likes = [];
$(".profile").on("click", function () {
    size = 10;
    sort = 'username';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/moreUsers?page=' + pageprofile + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='http://localhost:8080/api/imageprofile/" + value.username + "' alt=''><h3>" + value.username + "</h3><ul><li><a href='#' title='' class='follow'>Follow</a></li><li><a href='./messages?to=" + value.username + "' title='' class='message-us'><i class='fa fa-envelope'></i></a></li></ul></div><a href='./user-profile' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if (pageprofile + 1 <= result.totalPages) {
                pageprofile++;
            }else{
                $(".process-comm").remove();
            }
        }
    });
});

$(".company").on("click", function () {
    size = 10;
    sort = 'username';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/moreCompany?page=' + pagecompany + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='http://localhost:8080/api/imageprofile/" + value.username + "' alt=''><h3>" + value.username + "</h3><ul><li><a href='#' title='' class='follow'>Follow</a></li><li><a href='./messages?to=" + value.username + "' title='' class='message-us'><i class='fa fa-envelope'></i></a></li></ul></div><a href='./user-profile' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if (pagecompany + 1 <= result.totalPages) {
                pagecompany++;
            }else{
                $(".process-comm").remove();
            }
        }
    });
});

function loadPosts() {
    $.ajax({
        type: "GET",
        contentType: "data",
        url: ('/api/getLikes'),
        success: function (result) {
            $.each(result, function (indexInArray, valueOfElement) { 
                likes.push(valueOfElement.idpost.idpost);
            });
        }
    });
    $.ajax({
        type: "GET",
        contentType: "data",
        url: ('/api/getPosts?page=0&size=10&sort=idpost&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-heart-o";
                if(likes.includes(value.idpost)){
                    icon = "la la-heart";
                }
                $(".posts-section").append("<div class='post-bar'><div class='post_topbar'><div class='row usy-dt'><div class='user-post-icon'><img src='http://localhost:8080/api/imageprofile/" + value.iduser.username + "' alt=''></div><div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>Empresa</span></li><li><img src='images/icon9.png' alt=''><span>Madrid</span></li></ul><ul class='bk-links'><li><a id='" + value.idpost + "' title=''><i onclick='like(" + value.idpost + ")' class='"+icon+"'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3><div class='row'><ul class='image-store'><li><img src='http://localhost:8080/api/imagepost/" + value.idpost + "' alt=''></li></ul></div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idpost + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idpost + ")' title=''>view more</a></div></div>");
            });
        }
    });
}

$(".posts").on("click", function () {
    size = 10;
    sort = 'idpost';
    console.log(likes);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/getMorePosts?page=' + pagepost + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-heart-o";
                if(likes.includes(value.idpost)){
                    icon = "la la-heart";
                }
                $(".posts-section").append("<div class='post-bar'><div class='post_topbar'><div class='row usy-dt'><div class='user-post-icon'><img src='http://localhost:8080/api/imageprofile/" + value.iduser.username + "' alt=''></div><div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>Empresa</span></li><li><img src='images/icon9.png' alt=''><span>Madrid</span></li></ul><ul class='bk-links'><li><a id='" + value.idpost + "' title=''><i onclick='like(" + value.idpost + ")' class='" +icon+ "'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3><div class='row'><ul class='image-store'><li><img src='http://localhost:8080/api/imagepost/" + value.idpost + "' alt=''></li></ul></div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idpost + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idpost + ")' title=''>view more</a></div></div>");
            });
            if (pagepost + 1 <= result.totalPages) {
                pagepost++;
            }else{
                $(".process-comm").remove();
            }
        }
    });
});

$(".products").on("click", function () {
    size = 2;
    sort = 'idproduct';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/api/getMoreProducts?page=' + pageproduct + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                console.log(value);
                var base = "<div class='post-bar'><div class='post_topbar'><div class='usy-dt'><img src='http://localhost:8080/api/imageprofile/" +value.iduser.username+ "' alt=''>";
                base = base.concat("<div class='usy-name'><h3>" +value.iduser.username+"</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>Empresa</span></li>");
                base = base.concat("<li><img src='images/icon9.png' alt=''><span>Madrid</span></li></ul><ul class='bk-links'><li><a id='product"+value.idproduct+"' title=''><i onclick='mark("+value.idproduct+")' class='la la-bookmark'></i></a></li><li><a href='./messages?to=" +value.iduser.username+"' title=''><i class='la la-envelope'></i></a></li>");
                base = base.concat("</ul></div><div class='job_descp'><h3>" +value.title+ "</h3><div class='row'>");
                base = base.concat("<div id='carouselExampleControls-" +value.idproduct+ "' class='carousel slide' data-ride='carousel'>");
                base = base.concat("<div class='carousel-inner'>");
                if(value.img0){
                    base = base.concat("<div class='carousel-item active'><img class='img-thumbnail' src='http://localhost:8080/api/imageProduct0/" +value.idproduct+ "' alt='First slide'></div>");
                }
                if(value.img1){
                    base = base.concat("div class='carousel-item'><img class='img-thumbnail ' src='http://localhost:8080/api/imageProduct1/" +value.idproduct+ "' alt='Second slide'></div>");
                }
                if(value.img2){
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='http://localhost:8080/api/imageProduct2/" +value.idproduct+ "' alt='Third slide'></div>");
                }
                base = base.concat("</div>");
                base = base.concat("<a class='carousel-control-prev' href='#carouselExampleControls-" +value.idproduct+ "' role='button' data-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='sr-only'>Previous</span></a><a class='carousel-control-next' href='#carouselExampleControls-" +value.idproduct+ "' role='button' data-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='sr-only'>Next</span></a>");
                base = base.concat("</div>");
                base = base.concat("</div><div class='row'><ul class='description-store'><li><p>" +value.description+ "</p></li></ul></div><br><a id='readmore" +value.idproduct+ "' class='btn btn-primary stretched-link' onclick='readmore(" +value.idproduct+ ")' title=''>view more</a>");
                base = base.concat("<ul class='skill-tags'>");
                if(value.idtag != null){
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" +value.idtag.description+ "</p></a></li>");
                }
                if(value.idtagtwo != null){
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" +value.idtagtwo.description+ "</p></a></li>");
                }
                if(value.idtagthree != null){
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" +value.idtagthree.description+ "</p></a></li>");
                }
                base = base.concat("</ul>");
                base = base.concat("</div><div class='job-status-bar' style='background-color:#ec887a;'><div class='col-lg-3'><h3>" +value.status+ "</h3></div><div class='col-lg-3'><h3> " +value.price+ " $ </h3></div></div></div><!--post-bar end-->");
                $(".posts-section").append(base);
            });
            if (pageproduct + 1 <= result.totalPages) {
                pageproduct++;
            }else{
                $(".process-comm").remove();
            }
        }
    });
});

function like(idpost) {
    var s = $("#" + idpost);
    if (s.children().attr("class") == "la la-heart") {
        $.post( "/api/unlikePost?idpost="+idpost, function( data ) {
            console.log(data);
        });
        s.children().attr("class", "la la-heart-o");
    } else {
        $.post( "/api/likePost?idpost="+idpost, function( data ) {
            console.log("Holaa"+data);
        });
        s.children().attr("class", "la la-heart");
    }
}

function mark(idproduct) {
    var s = $("#product" + idproduct);
    if (s.children().attr("class") == "la la-bookmark") {
        s.children().attr("class", "la la-check-circle");
    } else {
        s.children().attr("class", "la la-bookmark");
    }
}


function clearAllFilter() {
    document.getElementById('word').value = '';
    $('.selectall').attr('checked', false);
    $('.slider-input').attr('value', '5,50');
    $('.high').attr('style', 'left: 149px;');
    $('.pointer.low').attr('style', 'left: 9px;');
    $('.selected-bar').attr('style', 'width: 140px; left: 15.5px;');
    $('.pointer-label.high').text('50');
    $('.pointer-label.low').text('0');
    $('#menu option[value="0"]').attr('selected', true);
}


function clearSlider() {
    $('.slider-input').attr('value', '5,50');
    $('.high').attr('style', 'left: 149px;');
    $('.pointer.low').attr('style', 'left: 9px;')
    $('.selected-bar').attr('style', 'width: 140px; left: 15.5px;')
    $('.pointer-label.high').text('50')
    $('.pointer-label.low').text('0')

}

function readmore(idpost) {
    $("#readmore" + idpost).parent().children(".row").children(".description-store").toggleClass("show");
}

function searchBar() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName('post-bar');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
        console.log(a);
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarPosts() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName('post-bar');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
        console.log(a);
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarUsers() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName("col-lg-3 col-md-4 col-sm-6 col-12");

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("company_profile_info")[0];
        m = s.getElementsByClassName("company-up-info")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarCompany() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName("col-lg-3 col-md-4 col-sm-6");

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("company_profile_info")[0];
        m = s.getElementsByClassName("company-up-info")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function colorFollow(color) {
    $(".flww").css("background-color", color);
}

$("#follow").on("click", function () {
    let follow = $("#usernameto").text();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: ('/api/follow?username=' + follow),
        success: function (response) {
            if (response) {
                $(".flww").css("background-color", "#e44d3a");
            } else {
                $(".flww").css("background-color", "#53D690");
            }
        }
    });
});

function unfollow(idfollow) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: ('/api/unfollowlist?idrelation=' + idfollow),
        success: function (response) {
            if(response){
                $("#follower"+idfollow).remove();
            }
        }
    });
}

function initIndex(username) {
    loadPosts();
    connectToChat(username,"null");
}