const url = 'http://localhost:8080';
let stompClient;
let selectedUser;
let newMessages = new Map();

function connectToChat(userName) {
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stompClient.subscribe("/topic/messages/" + userName, function (response) {
            let data = JSON.parse(response.body);
<<<<<<< develop
<<<<<<< develop
=======
            console.log(response.body);
>>>>>>> Implemented chat function
=======
            console.log(response.body);
>>>>>>> fixes to posts and product
            if (selectedUser === data.fromLogin) {
                render(data.message, data.fromLogin);
            } else {
                newMessages.set(data.fromLogin, data.message);
                $('#userNameAppender_' + data.fromLogin).append('<span id="newMessage_' + data.fromLogin + '" style="color: red">+1</span>');
            }
        });
    });
    $.get(url + "/fetchAllUsers", function (response) {
        let users = response;
        let usersTemplateHTML = "";
        for (let i = 0; i < users.length; i++) {
            if(users[i] != userName){
                usersTemplateHTML = usersTemplateHTML + '<a href="#" onclick="selectUser(\'' + users[i] + '\')"><li class="clearfix">\n' +
                    '                <img src="https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg" width="55px" height="55px" alt="avatar" />\n' +
                    '                <div class="about">\n' +
                    '                    <div id="userNameAppender_' + users[i] + '" class="name">' + users[i] + '</div>\n' +
                    '                    <div class="status">\n' +
                    '                        <i class="fa fa-circle offline"></i>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </li></a>';
            }    
        }
        $('#usersList').html(usersTemplateHTML);
    });
}

function sendMsg(from, text) {
    stompClient.send("/app/chat/" + selectedUser, {}, JSON.stringify({
        fromLogin: from,
        message: text
    }));
}


function selectUser(userName) {
    console.log("selecting users: " + userName);
    selectedUser = userName;
    let isNew = document.getElementById("newMessage_" + userName) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + userName);
        element.parentNode.removeChild(element);
        render(newMessages.get(userName), userName);
    }
    $('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);
<<<<<<< develop
<<<<<<< develop
=======
=======
>>>>>>> fixes to posts and product
    var ul = document.getElementById("messageList");
    ul.innerHTML = "";
    $.get("getChad",{from: $('#userName').text(), to: userName},function(data){
        data.forEach(element => {
            console.log("FROM:"+element.iduser.user_name+" TO: "+element.iduserto.user_name+" message: "+element.message);
            if (selectedUser === element.iduser.user_name) {
                console.log("jhon");
                var templateResponse = Handlebars.compile($("#message-response-template").html());
                var contextResponse = {
                    response: element.message,
                    time: getCurrentTime(),
                    userName: element.iduser.user_name
                };
                $chatHistoryList.append(templateResponse(contextResponse));
            } else {
                console.log("no jhon");
                var template = Handlebars.compile($("#message-template").html());
                var context = {
                    messageOutput: element.message,
                    time: getCurrentTime(),
                    toUserName: element.iduser.user_name
                };

                $chatHistoryList.append(template(context));
            }
        });
    });
<<<<<<< develop
>>>>>>> Implemented chat function
=======
>>>>>>> fixes to posts and product
}
