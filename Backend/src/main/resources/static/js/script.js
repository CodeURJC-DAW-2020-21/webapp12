let chatContainer;
let sendButtonMessage;
let messageText;
let listchat;
let stompClient;
let selectedUser;
let newMessages = new Map();
var pageusers;
var totalPages;
var notifynum = 0;
var useractual;
let token;
var pageprofile = 1;
var pagecompany = 1;
var pagepost = 1;
var pageproduct = 1;
var pagepostuser = 1;
var pageproductuser = 1;
var likes = [];
var bookmarks = [];
var products = [];
var follows = [];


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

//----------------------------------------------------------------------------UPLOAD IMAGE----------------------------------------------------------------

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

// -----------------------------------------------------------------------CHAT LOGIC-----------------------------------------------------------------
chatContainer = $('.chat-history');
sendButtonMessage = $('#sendBtn');
messageText = $('#message-to-send');
listchat = $('.chat-history').find('ul');


sendButtonMessage.on('click', function () { 
    let username = $('#userName').attr("placeholder");
    let message = messageText.val();
    stompClient.send("/app/chat/" + selectedUser, {}, JSON.stringify({
        fromLogin: username,
        message: message,
        time: "" + new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3")
    }));
    chatContainer.scrollTop(chatContainer[0].scrollHeight);
    if (message.trim() !== '') {
        var templateResponse = "<div class='media w-50 ml-auto mb-3'>";
        templateResponse = templateResponse.concat("<div class='media-body'>");
        templateResponse = templateResponse.concat("<div class='bg-primary rounded py-2 px-3 mb-2'>");
        templateResponse = templateResponse.concat("<p class='text-small mb-0 text-white'>" + message + "</p>");
        templateResponse = templateResponse.concat("</div>");
        templateResponse = templateResponse.concat("<p class='small text-muted'>" + new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3") + "</p>");
        templateResponse = templateResponse.concat("</div>");
        templateResponse = templateResponse.concat("</div>");
    };
    listchat.append(templateResponse);
    chatContainer.scrollTop(chatContainer[0].scrollHeight);
    messageText.val('');
 });






function connectToChat(user, to, tk) {
    token = tk;
    useractual = user;
    let socket = new SockJS('https://localhost:8443/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/message/"+useractual, function (response) {
            let data = JSON.parse(response.body);
            if (selectedUser == data.fromLogin) {
                chatContainer.scrollTop(chatContainer[0].scrollHeight);
                var template = "<div class='media w-50 mb-3'><img src='https://localhost:8443/imageprofile/" + data.fromLogin + "' alt='user' width='50' class='rounded-circle'>";
                template = template.concat("<div class='media-body ml-3'>");
                template = template.concat("<div class='bg-light rounded py-2 px-3 mb-2'>");
                template = template.concat("<p class='text-small mb-0 text-muted'>" + data.fromLogin + ": " + data.message + "</p>");
                template = template.concat("</div>");
                template = template.concat("<p class='small text-muted'>" + data.time + "</p>");
                template = template.concat("</div>");
                template = template.concat("</div>");
                setTimeout(function () {
                    listchat.append(template);
                    chatContainer.scrollTop(chatContainer[0].scrollHeight);
                }.bind(this), 1500);
            } else {
                if (notifynum + 1 < 4) {
                    notifynum++;
                    $(".nott-list").find(".view-all-nots").remove();
                    $(".nott-list").append('<a href="/messages?to='+ data.fromLogin + '" title=""><div id="new' + data.fromLogin + '" class="notfication-details"><div class="noty-user-img"><img src="https://localhost:8443/imageprofile/' + data.fromLogin + '" alt=""></div><div class="notification-info"><h3><a href="messages" title="">' + data.fromLogin + '</a> </h3><p>' + data.message + '</p><span>' + data.time + '</span></div><!--notification-info --></div></a>');
                    $(".nott-list").append('<div class="view-all-nots"><a href="messages" title="">View All Messsages</a></div>');
                }
            }
        });
    });
    $.get("https://localhost:8443/getUserPage?page=0&size=10&sort=username&direction=asc", function (response) {
        pageusers = response.number;
        totalPages = response.totalPages;
        let users = response.content;
        let usersTemplateHTML = "";
        for (let i = 0; i < users.length; i++) {
            if (users[i].username != user) {
                usersTemplateHTML = usersTemplateHTML.concat("<a onclick='selectUser( \"" + users[i].username + "\" )' class='list-group-item list-group-item-action list-group-item-light rounded-0'>");
                usersTemplateHTML = usersTemplateHTML.concat("<div class='media'><img src='https://localhost:8443/imageprofile/" + users[i].username + "' alt='user' width='50' class='rounded-circle'>");
                usersTemplateHTML = usersTemplateHTML.concat("<div class='media-body ml-4'>");
                usersTemplateHTML = usersTemplateHTML.concat("<div class='d-flex align-items-center justify-content-between mb-1'>");
                usersTemplateHTML = usersTemplateHTML.concat("<h6 class='mb-0'>" + users[i].username + "</h6><small class='small font-weight-bold'>14 Dec</small>");
                usersTemplateHTML = usersTemplateHTML.concat("</div>");
                usersTemplateHTML = usersTemplateHTML.concat("<p class='font-italic text-muted mb-0 text-small'>Lorem ipsum dolor sit amet, consectetur. incididunt ut labore.</p>");
                usersTemplateHTML = usersTemplateHTML.concat("</div>");
                usersTemplateHTML = usersTemplateHTML.concat(" </div>");
                usersTemplateHTML = usersTemplateHTML.concat(" </a><br>");
            }
        }
        $("#usersList").html(usersTemplateHTML);
    });
    if (to != "null") {
        selectedUser = to;
        listchat.empty();
        $.get("getChad", { from: $('#userName').attr("placeholder"), to: to }, function (data) {
            data.forEach(element => {
                if (selectedUser != element.iduser.username) {
                    var templateResponse = "<div class='media w-50 ml-auto mb-3'>";
                    templateResponse = templateResponse.concat("<div class='media-body'>");
                    templateResponse = templateResponse.concat("<div class='bg-primary rounded py-2 px-3 mb-2'>");
                    templateResponse = templateResponse.concat("<p class='text-small mb-0 text-white'>you:" + element.message + "</p>");
                    templateResponse = templateResponse.concat("</div>");
                    templateResponse = templateResponse.concat("<p class='small text-muted'>" + element.time + "</p>");
                    templateResponse = templateResponse.concat("</div>");
                    templateResponse = templateResponse.concat("</div>");
                    listchat.append(templateResponse);
                    chatContainer.scrollTop(chatContainer[0].scrollHeight);
                } else {
                    var template = "<div class='media w-50 mb-3'><img src='https://localhost:8443/imageprofile/" + selectedUser + "' alt='user' width='50' class='rounded-circle'>";
                    template = template.concat("<div class='media-body ml-3'>");
                    template = template.concat("<div class='bg-light rounded py-2 px-3 mb-2'>");
                    template = template.concat("<p class='text-small mb-0 text-muted'>" + selectedUser + ": " + element.message + "</p>");
                    template = template.concat("</div>");
                    template = template.concat("<p class='small text-muted'>" + element.time + "</p>");
                    template = template.concat("</div>");
                    template = template.concat("</div>");
                    listchat.append(template);
                    chatContainer.scrollTop(chatContainer[0].scrollHeight);
                }
            });
        });
    }
}


function selectUser(userName) {
    $("#userTo").text(userName);
    selectedUser = userName;
    listchat.empty();
    chatContainer.scrollTop(chatContainer[0].scrollHeight);
    $.get("getChad", { from: $('#userName').attr("placeholder"), to: userName }, function (data) {
        data.forEach(element => {
            if (selectedUser != element.iduser.username) {
                var templateResponse = "<div class='media w-50 ml-auto mb-3'>";
                templateResponse = templateResponse.concat("<div class='media-body'>");
                templateResponse = templateResponse.concat("<div class='bg-primary rounded py-2 px-3 mb-2'>");
                templateResponse = templateResponse.concat("<p class='text-small mb-0 text-white'>you: " + element.message + "</p>");
                templateResponse = templateResponse.concat("</div>");
                templateResponse = templateResponse.concat("<p class='small text-muted'>" + element.time + "</p>");
                templateResponse = templateResponse.concat("</div>");
                templateResponse = templateResponse.concat("</div>");
                listchat.append(templateResponse);
                chatContainer.scrollTop(chatContainer[0].scrollHeight);
            } else {
                var template = "<div class='media w-50 mb-3'><img src='https://localhost:8443/imageprofile/" + userName + "' alt='user' width='50' class='rounded-circle'>";
                template = template.concat("<div class='media-body ml-3'>");
                template = template.concat("<div class='bg-light rounded py-2 px-3 mb-2'>");
                template = template.concat("<p class='text-small mb-0 text-muted'>" + userName + ": " + element.message + "</p>");
                template = template.concat("</div>");
                template = template.concat("<p class='small text-muted'>" + element.time + "</p>");
                template = template.concat("</div>");
                template = template.concat("</div>");
                listchat.append(template);
                chatContainer.scrollTop(chatContainer[0].scrollHeight);
            }
        });
    });
}


$(".previous").on("click", function () {
    size = 10;
    sort = 'username';
    if (pageusers > 0) {
        pageusers--;
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: ('/getUserPage?page=' + pageusers + '&size=' + size + '&sort=' + sort + '&direction=asc'),
            success: function (response) {
                let users = response.content;
                let usersTemplateHTML = "";
                for (let i = 0; i < users.length; i++) {
                    if (users[i].username != userName) {
                        usersTemplateHTML = usersTemplateHTML.concat("<a onclick='selectUser( \"" + users[i].username + "\" )' class='list-group-item list-group-item-action list-group-item-light rounded-0'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='media'><img src='https://localhost:8443/imageprofile/" + users[i].username + "' alt='user' width='50' class='rounded-circle'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='media-body ml-4'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='d-flex align-items-center justify-content-between mb-1'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<h6 class='mb-0'>" + users[i].username + "</h6><small class='small font-weight-bold'>14 Dec</small>");
                        usersTemplateHTML = usersTemplateHTML.concat("</div>");
                        usersTemplateHTML = usersTemplateHTML.concat("<p class='font-italic text-muted mb-0 text-small'>Lorem ipsum dolor sit amet, consectetur. incididunt ut labore.</p>");
                        usersTemplateHTML = usersTemplateHTML.concat("</div>");
                        usersTemplateHTML = usersTemplateHTML.concat(" </div>");
                        usersTemplateHTML = usersTemplateHTML.concat(" </a><br>");
                    }
                }
                $('#usersList').html(usersTemplateHTML);
            }
        });
    }
});

$(".next").on("click", function () {
    size = 10;
    sort = 'username';
    if (pageusers + 1 <= totalPages) {
        pageusers++;
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: ('/getUserPage?page=' + pageusers + '&size=' + size + '&sort=' + sort + '&direction=asc'),
            success: function (response) {
                let users = response.content;
                let usersTemplateHTML = "";
                for (let i = 0; i < users.length; i++) {
                    if (users[i].username != userName) {
                        usersTemplateHTML = usersTemplateHTML.concat("<a onclick='selectUser( \"" + users[i].username + "\" )' class='list-group-item list-group-item-action list-group-item-light rounded-0'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='media'><img src='https://localhost:8443/imageprofile/" + users[i].username + "' alt='user' width='50' class='rounded-circle'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='media-body ml-4'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<div class='d-flex align-items-center justify-content-between mb-1'>");
                        usersTemplateHTML = usersTemplateHTML.concat("<h6 class='mb-0'>" + users[i].username + "</h6><small class='small font-weight-bold'>14 Dec</small>");
                        usersTemplateHTML = usersTemplateHTML.concat("</div>");
                        usersTemplateHTML = usersTemplateHTML.concat("<p class='font-italic text-muted mb-0 text-small'>Lorem ipsum dolor sit amet, consectetur. incididunt ut labore.</p>");
                        usersTemplateHTML = usersTemplateHTML.concat("</div>");
                        usersTemplateHTML = usersTemplateHTML.concat(" </div>");
                        usersTemplateHTML = usersTemplateHTML.concat(" </a><br>");
                    }
                }
                $('#usersList').html(usersTemplateHTML);
            }
        });
    }
});

$("#clearbutton").on("click", function () {
    $(".nott-list").empty();
    $(".nott-list").append('<div class="view-all-nots"><a href="messages" title="">View All Messsages</a></div>');
    notifynum = 0;
});













//-------------------------------------------------------------------LOADS ITEMS-------------------------------------------------------------------------




function passToken(tk) {
    token = tk;
}

$.ajax({
    type: "GET",
    contentType: "data",
    url: ('/getBookmark'),
    success: function (result) {
        $.each(result, function (indexInArray, valueOfElement) {
            bookmarks.push(valueOfElement.idproduct.idproduct);
        });
    }
});


$.ajax({
    type: "GET",
    contentType: "data",
    url: ('/getLikes'),
    success: function (result) {
        $.each(result, function (indexInArray, valueOfElement) {
            likes.push(valueOfElement.idpost.idpost);
        });
    }
});

$.ajax({
    type: "GET",
    contentType: "data",
    url: ('/getFollows'),
    success: function (result) {
        $.each(result, function (indexInArray, valueOfElement) {
            follows.push(valueOfElement.usertwo.idusers);
        });
    }
});

$(".profile").on("click", function () {
    size = 10;
    sort = 'username';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/moreUsers?page=' + pageprofile + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='https://localhost:8443/imageprofile/" + value.username + "' alt=''><h3>" + value.username + "</h3><ul></ul></div><a href='/pageProfileUser?&username=" + value.username + "' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if (pageprofile + 1 <= result.totalPages) {
                pageprofile++;
            } else {
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
        url: ('/moreCompany?page=' + pagecompany + '&size=' + size + '&sort=' + sort + '&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                $(".row").append("<div class='col-lg-3 col-md-4 col-sm-6 col-12'> <div class='company_profile_info'><div class='company-up-info'><img src='https://localhost:8443/imageprofile/" + value.username + "' alt=''><h3>" + value.username + "</h3><ul></ul></div><a href='/pageProfileUser?&username=" + value.username + "' title='' class='view-more-pro'>View Profile</a></div><!--company_profile_info end--></div>");
            });
            if (pagecompany + 1 <= result.totalPages) {
                pagecompany++;
            } else {
                $(".process-comm").remove();
            }
        }
    });
});

function loadPosts() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getPosts?page=0&size=10&sort=idpost&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-heart-o";
                if (likes.includes(value.idpost)) {
                    icon = "la la-heart";
                }
                $(".posts-section").append("<div class='post-bar'><div class='post_topbar'><div class='row usy-dt'><div class='user-post-icon'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "' alt=''></div><div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>Empresa</span></li><li><img src='images/icon9.png' alt=''><span>Madrid</span></li></ul><ul class='bk-links'><li><a id='" + value.idpost + "' title=''><i onclick='like(" + value.idpost + ")' class='" + icon + "'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3><div class='row'><ul class='image-store'><li><img src='https://localhost:8443/imagepost/" + value.idpost + "' alt=''></li></ul></div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idpost + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idpost + ")' title=''>view more</a></div></div>");
            });
        }
    });
}

function loadProducts(username) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getProducts?page=0&size=10&sort=idproduct&direction=asc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-bookmark";
                if (bookmarks.includes(value.idproduct)) {
                    icon = "la la-check-circle";
                }
                var base = "<div class='post-bar'><div class='post_topbar'><div class='usy-dt'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "' alt=''>";
                base = base.concat("<div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>Empresa</span></li>");
                base = base.concat("<li><img src='images/icon9.png' alt=''><span>Madrid</span></li></ul><ul class='bk-links'><li><a id='product" + value.idproduct + "' title=''><i onclick='mark(" + value.idproduct + ")' class='" + icon + "'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li>");
                base = base.concat("</ul></div><br><div class='job_descp'><h3>" + value.title + "</h3><div class='row'>");
                base = base.concat("<div id='carouselExampleControls-" + value.idproduct + "' class='carousel slide' data-ride='carousel'>");
                base = base.concat("<div class='carousel-inner'>");
                if (value.img0) {
                    base = base.concat("<div class='carousel-item active'><img class='img-thumbnail' src='https://localhost:8443/imageProduct0/" + value.idproduct + "' alt='First slide'></div>");
                }
                if (value.img1) {
                    base = base.concat("div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct1/" + value.idproduct + "' alt='Second slide'></div>");
                }
                if (value.img2) {
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct2/" + value.idproduct + "' alt='Third slide'></div>");
                }
                base = base.concat("</div>");
                base = base.concat("<a class='carousel-control-prev' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='sr-only'>Previous</span></a><a class='carousel-control-next' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='sr-only'>Next</span></a>");
                base = base.concat("</div>");
                base = base.concat("</div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idproduct + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idproduct + ")' title=''>view more</a>");
                base = base.concat("<ul class='skill-tags'>");
                if (value.idtag != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtag.description + "</p></a></li>");
                }
                if (value.idtagtwo != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagtwo.description + "</p></a></li>");
                }
                if (value.idtagthree != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagthree.description + "</p></a></li>");
                }
                if (value.idtagfour != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfour.description + "</p></a></li>");
                }
                if (value.idtagfive != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfive.description + "</p></a></li>");
                }
                base = base.concat("</ul>");
                base = base.concat("</div><div class='job-status-bar' style='background-color:#ec887a;'><div class='col-lg-3'><h3>" + value.status + "</h3></div><div class='col-lg-3'><h3> " + value.price + " $ </h3></div></div></div><!--post-bar end-->");
                products.push(base);
            });
            $.each(products, function (indexInArray, valueOfElement) {
                $(".posts-section").append(valueOfElement);
            });
            connectToChat(username, "null");
        }
    });
}

$(".posts").on("click", function () {
    size = 10;
    sort = 'idpost';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getMorePosts?page=' + pagepost + '&size=' + size + '&sort=' + sort + ',desc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-heart-o";
                var type = "company";
                if (value.iduser.userprofile) {
                    type = "user";
                }
                if (likes.includes(value.idpost)) {
                    icon = "la la-heart";
                }
                $(".posts-section").append("<div class='post-bar'><div class='post_topbar'><div class='row usy-dt'><div class='user-post-icon'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "' alt=''></div><div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>" + type + "</span></li><li><img src='images/icon9.png' alt=''><span>" + value.iduser.city + "</span></li></ul><ul class='bk-links'><li><a id='" + value.idpost + "' title=''><i onclick='like(" + value.idpost + ")' class='" + icon + "'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3><div class='row'><ul class='image-store'><li><img src='https://localhost:8443/imagepost/" + value.idpost + "' alt=''></li></ul></div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idpost + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idpost + ")' title=''>view more</a></div></div>");
            });
            if (pagepost + 1 <= result.totalPages) {
                pagepost++;
            } else {
                $(".process-comm").remove();
            }
        }
    });
});

$(".products").on("click", function () {
    size = 10;
    sort = 'idproduct';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getMoreProducts?page=' + pageproduct + '&size=' + size + '&sort=' + sort + ',desc'),
        success: function (result) {
            $.each(result.content, function (index, value) {
                bookmarks.includes(value.idproduct)
                var icon = "la la-bookmark";
                var color = ("#228B22");
                var type = "company";
                if (value.iduser.userprofile) {
                    type = "user";
                }

                if (value.status == "sold") {
                    color = ("#DC143C");
                }

                if (value.status == "reserved") {
                    color = ("#FFD700");
                }
                if (bookmarks.includes(value.idproduct)) {
                    icon = "la la-check-circle";
                }
                var base = "<div class='post-bar'><div class='post_topbar'><div class='usy-dt'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "'alt=''>";
                base = base.concat("<div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>" + type + "</span></li>");
                base = base.concat("<li><img src='images/icon9.png' alt=''><span>" + value.iduser.city + "</span></li></ul><ul class='bk-links'>");
                base = base.concat("<li><a id='product" + value.idproduct + "' title=''><i onclick='mark(" + value.idproduct + ")' class='" + icon + "'></i></a></li>");
                base = base.concat("<li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3>");
                base = base.concat("<div class='row'>");
                base = base.concat("<div id='carouselExampleControls-" + value.idproduct + "' class='carousel slide' data-ride='carousel'>");
                base = base.concat("<div class='carousel-inner'>");
                if (value.img0) {
                    base = base.concat("<div class='carousel-item active'><img class='img-thumbnail' src='https://localhost:8443/imageProduct0/" + value.idproduct + "' alt='First slide'></div>");
                }
                if (value.img1) {
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct1/" + value.idproduct + "' alt='Second slide'></div>");
                }
                if (value.img2) {
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct2/" + value.idproduct + "' alt='Third slide'></div>");
                }
                base = base.concat("</div>");
                base = base.concat("<a class='carousel-control-prev' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='sr-only'>Previous</span></a><a class='carousel-control-next' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='sr-only'>Next</span></a>");
                base = base.concat("</div>");
                base = base.concat("</div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idproduct + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idproduct + ")' title=''>view more</a>");
                base = base.concat("<ul class='skill-tags'>");
                if (value.idtag != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtag.description + "</p></a></li>");
                }
                if (value.idtagtwo != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagtwo.description + "</p></a></li>");
                }
                if (value.idtagthree != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagthree.description + "</p></a></li>");
                }
                if (value.idtagfour != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfour.description + "</p></a></li>");
                }
                if (value.idtagfive != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfive.description + "</p></a></li>");
                }
                base = base.concat("</ul>");
                base = base.concat("</div><div class='job-status-bar' style='background-color:" + color + ";'><div class='col-lg-3'><h3>" + value.status + "</h3></div><div class='col-lg-3'><h3> " + value.price + " $ </h3></div></div></div><!--post-bar end-->");
                $(".posts-section").append(base);
            });
            if (pageproduct + 1 <= result.totalPages) {
                pageproduct++;
            } else {
                $(".process-comm").remove();
            }
        }
    });
});


$(".postsUser").on("click", function () {
    user = $("#usernameto").text();
    size = 10;
    sort = 'idpost';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getMorePostsUser?page=' + pagepostuser + '&size=' + size + '&sort=' + sort + ',desc' + '&username=' + user),
        success: function (result) {
            $.each(result.content, function (index, value) {
                var icon = "la la-heart-o";
                var type = "company";
                if (value.iduser.userprofile) {
                    type = "user";
                }
                if (likes.includes(value.idpost)) {
                    icon = "la la-heart";
                }
                $(".posts-section").append("<div class='post-bar'><div class='post_topbar'><div class='row usy-dt'><div class='user-post-icon'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "' alt=''></div><div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>" + type + "</span></li><li><img src='images/icon9.png' alt=''><span>" + value.iduser.city + "</span></li></ul><ul class='bk-links'><li><a id='" + value.idpost + "' title=''><i onclick='like(" + value.idpost + ")' class='" + icon + "'></i></a></li><li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3><div class='row'><ul class='image-store'><li><img src='https://localhost:8443/imagepost/" + value.idpost + "' alt=''></li></ul></div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idpost + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idpost + ")' title=''>view more</a></div></div>");
            });
            if (pagepostuser + 1 <= result.totalPages) {
                pagepostuser++;
            } else {
                $(".postSpinner").remove();
            }
        }
    });
});

$(".productsUser").on("click", function () {
    user = $("#usernameto").text();
    size = 10;
    sort = 'idproduct';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ('/getMoreProductsUser?page=' + pageproductuser + '&size=' + size + '&sort=' + sort + ',desc' + '&username=' + user),
        success: function (result) {
            $.each(result.content, function (index, value) {
                bookmarks.includes(value.idproduct)
                var icon = "la la-bookmark";
                var color = ("#228B22");
                var type = "company";
                if (value.iduser.userprofile) {
                    type = "user";
                }

                if (value.status == "sold") {
                    color = ("#DC143C");
                }

                if (value.status == "reserved") {
                    color = ("#FFD700");
                }
                if (bookmarks.includes(value.idproduct)) {
                    icon = "la la-check-circle";
                }
                var base = "<div class='post-bar'><div class='post_topbar'><div class='usy-dt'><img src='https://localhost:8443/imageprofile/" + value.iduser.username + "'alt=''>";
                base = base.concat("<div class='usy-name'><h3>" + value.iduser.username + "</h3></div></div></div><div class='epi-sec'><ul class='descp'><li><img src='images/icon8.png' alt=''><span>" + type + "</span></li>");
                base = base.concat("<li><img src='images/icon9.png' alt=''><span>" + value.iduser.city + "</span></li></ul><ul class='bk-links'>");
                base = base.concat("<li><a id='product" + value.idproduct + "' title=''><i onclick='mark(" + value.idproduct + ")' class='" + icon + "'></i></a></li>");
                base = base.concat("<li><a href='./messages?to=" + value.iduser.username + "' title=''><i class='la la-envelope'></i></a></li></ul></div><div class='job_descp'><h3>" + value.title + "</h3>");
                base = base.concat("<div class='row'>");
                base = base.concat("<div id='carouselExampleControls-" + value.idproduct + "' class='carousel slide' data-ride='carousel'>");
                base = base.concat("<div class='carousel-inner'>");
                if (value.img0) {
                    base = base.concat("<div class='carousel-item active'><img class='img-thumbnail' src='https://localhost:8443/imageProduct0/" + value.idproduct + "' alt='First slide'></div>");
                }
                if (value.img1) {
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct1/" + value.idproduct + "' alt='Second slide'></div>");
                }
                if (value.img2) {
                    base = base.concat("<div class='carousel-item'><img class='img-thumbnail ' src='https://localhost:8443/imageProduct2/" + value.idproduct + "' alt='Third slide'></div>");
                }
                base = base.concat("</div>");
                base = base.concat("<a class='carousel-control-prev' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='sr-only'>Previous</span></a><a class='carousel-control-next' href='#carouselExampleControls-" + value.idproduct + "' role='button' data-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='sr-only'>Next</span></a>");
                base = base.concat("</div>");
                base = base.concat("</div><div class='row'><ul class='description-store'><li><p>" + value.description + "</p></li></ul></div><br><a id='readmore" + value.idproduct + "' class='btn btn-primary stretched-link' onclick='readmore(" + value.idproduct + ")' title=''>view more</a>");
                base = base.concat("<ul class='skill-tags'>");
                if (value.idtag != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtag.description + "</p></a></li>");
                }
                if (value.idtagtwo != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagtwo.description + "</p></a></li>");
                }
                if (value.idtagthree != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagthree.description + "</p></a></li>");
                }
                if (value.idtagfour != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfour.description + "</p></a></li>");
                }
                if (value.idtagfive != null) {
                    base = base.concat("<li><a href='#' title=''><p style='color:#040500' ;>" + value.idtagfive.description + "</p></a></li>");
                }
                base = base.concat("</ul>");
                base = base.concat("</div><div class='job-status-bar' style='background-color:" + color + ";'><div class='col-lg-3'><h3>" + value.status + "</h3></div><div class='col-lg-3'><h3> " + value.price + " $ </h3></div></div></div><!--post-bar end-->");
                $(".posts-section").append(base);
            });
            if (pageproductuser + 1 <= result.totalPages) {
                pageproductuser++;
            } else {
                $(".productSpinner").remove();
            }
        }
    });
});


//------------------------------------------------------------------OTHER SYSTEM-------------------------------------------------------------------------

function readmore(idpost) {
    $("#readmore" + idpost).parent().children(".row").children(".description-store").toggleClass("show");
}


function colorFollow(color) {
    $(".flww").css("background-color", color);
}

$("#follow").on("click", function () {
    let follow = $("#usernameto").text();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: ('/follow?username=' + follow + "&_csrf=" + token),
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
        url: ('/unfollowlist?idrelation=' + idfollow + "&_csrf=" + token),
        success: function (response) {
            if (response) {
                $("#follower" + idfollow).remove();
            }
        }
    });
}

function dropProduct(idproduct) {
    $.post("/dropProduct?idproduct=" + idproduct + "&_csrf=" + token, function (response) {
        if (response) {
            $("#product" + idproduct).remove();
        }
    });
}

function like(idpost) {
    var s = $("#" + idpost);
    if (s.children().attr("class") == "la la-heart") {
        $.post("/unlikePost?idpost=" + idpost + "&_csrf=" + token, function (data) {
        });
        s.children().attr("class", "la la-heart-o");
    } else {
        $.post("/likePost?idpost=" + idpost + "&_csrf=" + token, function (data) {
        });
        s.children().attr("class", "la la-heart");
    }
}

function mark(idproduct) {
    if ($("#product" + idproduct).children().attr("class") == "la la-bookmark") {
        $.post("/addProduct?idproduct=" + idproduct + "&_csrf=" + token, function (data) {
            $("#product" + idproduct).children().attr("class", "la la-check-circle");
        });
    } else {
        $.post("/dropProduct?idproduct=" + idproduct + "&_csrf=" + token, function (data) {
            $("#product" + idproduct).children().attr("class", "la la-bookmark");
        });
    }
}

//------------------------------------------------------BAR SEARCH-------------------------------------------------------------------------

function searchBarProducts() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
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
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
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

//-----------------------------------------------------------------------FILTER----------------------------------------------------------

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

function SearchKeyWords() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('word');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        m = s.getElementsByClassName("skill-tags")[0];
        p = m.getElementsByTagName("li");
        for (x = 0; x < p.length; x++) {
            q = p[x].getElementsByTagName("a")[0];
            a = q.getElementsByTagName("p")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
}


function SearchStatus1() {
    var input, filter, ul, li, a, i, txtValue;
    input = "in stock";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function SearchStatus2() {
    var input, filter, ul, li, a, i, txtValue;
    input = "reserved";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function SearchStatus3() {
    var input, filter, ul, li, a, i, txtValue;
    input = "sold";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchCity() {
    var input, filter, ul, li, a, i, txtValue;
    input = $("#menu").val();
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("epi-sec")[0];
        m = s.getElementsByClassName("descp")[0];
        j = m.getElementsByTagName("li")[1];
        a = j.getElementsByTagName("span")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchSlider() {
    var input, filter, ul, li, a, i, txtValue, limits;
    input = $("#sliderInput").val();
    limits = input.split(',');
    filter = range(limits[0], limits[1]);
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[1];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (filter.includes(txtValue.split(' ')[1])) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function range(start, end) {
    var ans = [];
    for (let i = start; i <= end; i++) {
        ans.push('' + i);
    }
    return ans;
}