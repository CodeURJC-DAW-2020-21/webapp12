const url = 'http://localhost:8080';
let stompClient;
let selectedUser;
let newMessages = new Map();
var pageusers;
var totalPages;
var notifynum = 0;
var useractual;


function connectToChat(userName, to) {
    useractual = userName;
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stompClient.subscribe("/topic/messages/" + userName, function (response) {
            let data = JSON.parse(response.body);
            console.log(response.body);
            if (selectedUser === data.fromLogin) {
                render(data.message, data.fromLogin);
            } else {
                console.log("message recibido");
                if (notifynum + 1 < 4) {
                    notifynum++;
                    newMessages.set(data.fromLogin, data.message);
                    $(".nott-list").find(".view-all-nots").remove();
                    $(".nott-list").append('<div id="newMessage_' + data.fromLogin + '" class="notfication-details"><div class="noty-user-img"><img src="http://localhost:8080/api/imageprofile/' + data.fromLogin + '" alt=""></div><div class="notification-info"><h3><a href="messages" title="">' + data.fromLogin + '</a> </h3><p>' + data.message + '</p><span>' + data.time + '</span></div><!--notification-info --></div>');
                    $(".nott-list").append('<div class="view-all-nots"><a href="messages" title="">View All Messsages</a></div>');
                }
            }
        });
    });
    $.get(url + "/api/getUserPage?page=0&size=10&sort=username&direction=asc", function (response) {
        pageusers = response.number;
        totalPages = response.totalPages;
        let users = response.content;
        let usersTemplateHTML = "";
        for (let i = 0; i < users.length; i++) {
            if (users[i].username != userName) {
                usersTemplateHTML = usersTemplateHTML + '<a href="#" onclick="selectUser(\'' + users[i].username + '\')"><li class="clearfix">\n' +
                    '                <img src="http://localhost:8080/api/imageprofile/' + users[i].username + '" width="55px" height="55px" alt="avatar" />\n' +
                    '                <div class="about">\n' +
                    '                    <div id="userNameAppender_' + users[i].username + '" class="name">' + users[i].username + '</div>\n' +
                    '                    <div class="status">\n' +
                    '                        <i class="fa fa-circle offline"></i>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </li></a>';
            }
        }
        $('#usersList').html(usersTemplateHTML);
    });
    if (to != "null") {
        console.log("selecting users: " + to);
        $(".chat-header").children().attr("src", 'http://localhost:8080/api/imageprofile/' + to);
        selectedUser = to;
        let isNew = document.getElementById("newMessage_" + to) !== null;
        if (isNew) {
            let element = document.getElementById("newMessage_" + to);
            element.remove();
            notifynum--;
            render(newMessages.get(userName), to);
        }
        $('#selectedUserId').html('');
        $('#selectedUserId').append('Chat with ' + to);
        var ul = document.getElementById("messageList");
        ul.innerHTML = "";
        $.get("api/getChad", { from: $('#userName').attr("placeholder"), to: to }, function (data) {
            data.forEach(element => {
                console.log("FROM:" + element.iduser.username + " TO: " + element.iduserto.username + " message: " + element.message);
                if (selectedUser === element.iduser.username) {
                    console.log("jhon");
                    var templateResponse = Handlebars.compile($("#message-response-template").html());
                    var contextResponse = {
                        response: element.message,
                        time: element.time,
                        userName: element.iduser.username
                    };
                    $chatHistoryList.append(templateResponse(contextResponse));
                } else {
                    console.log("no jhon");
                    var template = Handlebars.compile($("#message-template").html());
                    var context = {
                        messageOutput: element.message,
                        time: element.time,
                        toUserName: element.iduser.username
                    };

                    $chatHistoryList.append(template(context));
                }
            });
        });
    }
}

function sendMsg(from, text) {
    stompClient.send("/app/chat/" + selectedUser, {}, JSON.stringify({
        fromLogin: from,
        message: text,
        time: "" + getCurrentTime()
    }));
}


function selectUser(userName) {
    console.log("selecting users: " + userName);
    $(".chat-header").children().attr("src", 'http://localhost:8080/api/imageprofile/' + userName);
    selectedUser = userName;
    let isNew = document.getElementById("newMessage_" + userName) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + userName);
        element.remove();
        notifynum--;
        render(newMessages.get(userName), userName);
    }
    $('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);
    var ul = document.getElementById("messageList");
    ul.innerHTML = "";
    $.get("api/getChad", { from: $('#userName').attr("placeholder"), to: userName }, function (data) {
        data.forEach(element => {
            console.log("FROM:" + element.iduser.username + " TO: " + element.iduserto.username + " message: " + element.message);
            if (selectedUser === element.iduser.username) {
                console.log("jhon");
                var templateResponse = Handlebars.compile($("#message-response-template").html());
                var contextResponse = {
                    response: element.message,
                    time: element.time,
                    userName: element.iduser.username
                };
                $chatHistoryList.append(templateResponse(contextResponse));
            } else {
                console.log("no jhon");
                var template = Handlebars.compile($("#message-template").html());
                var context = {
                    messageOutput: element.message,
                    time: element.time,
                    toUserName: element.iduser.username
                };

                $chatHistoryList.append(template(context));
            }
        });
    });
}

$("#clearbutton").on("click", function () {
    $(".nott-list").empty();
    $(".nott-list").append('<div class="view-all-nots"><a href="messages" title="">View All Messsages</a></div>');
    notifynum = 0;
});


$(".previous").on("click", function () {
    size = 10;
    sort = 'username';
    if (pageusers > 0) {
        pageusers--;
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: ('/api/getUserPage?page=' + pageusers + '&size=' + size + '&sort=' + sort + '&direction=asc'),
            success: function (response) {
                let users = response.content;
                let usersTemplateHTML = "";
                for (let i = 0; i < users.length; i++) {
                    if (users[i].username != useractual) {
                        usersTemplateHTML = usersTemplateHTML + '<a href="#" onclick="selectUser(\'' + users[i].username + '\')"><li class="clearfix">\n' +
                            '                <img src="http://localhost:8080/api/imageprofile/' + users[i].username + '" width="55px" height="55px" alt="avatar" />\n' +
                            '                <div class="about">\n' +
                            '                    <div id="userNameAppender_' + users[i].username + '" class="name">' + users[i].username + '</div>\n' +
                            '                    <div class="status">\n' +
                            '                        <i class="fa fa-circle offline"></i>\n' +
                            '                    </div>\n' +
                            '                </div>\n' +
                            '            </li></a>';
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
            url: ('/api/getUserPage?page=' + pageusers + '&size=' + size + '&sort=' + sort + '&direction=asc'),
            success: function (response) {
                let users = response.content;
                let usersTemplateHTML = "";
                for (let i = 0; i < users.length; i++) {
                    if (users[i].username != useractual) {
                        usersTemplateHTML = usersTemplateHTML + '<a href="#" onclick="selectUser(\'' + users[i].username + '\')"><li class="clearfix">\n' +
                            '                <img src="http://localhost:8080/api/imageprofile/' + users[i].username + '" width="55px" height="55px" alt="avatar" />\n' +
                            '                <div class="about">\n' +
                            '                    <div id="userNameAppender_' + users[i].username + '" class="name">' + users[i].username + '</div>\n' +
                            '                    <div class="status">\n' +
                            '                        <i class="fa fa-circle offline"></i>\n' +
                            '                    </div>\n' +
                            '                </div>\n' +
                            '            </li></a>';
                    }
                }
                $('#usersList').html(usersTemplateHTML);
            }
        });
    }
});
