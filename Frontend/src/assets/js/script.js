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
    
    
        //  ================== Edit Options Function =================
    
    
        $(".ed-opts-open").on("click", function () {
            $(this).next(".ed-options").toggleClass("active");
            return false;
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
