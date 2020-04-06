<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>나의 홈페이지</title>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>	

<script>
	var socket = new SockJS('http://192.168.4.12:8080/socket/chat');
	
	// 소켓 서버에 접속 시작
	socket.onopen = function() {
		// socket.send('Hello');
	};

	// 서버로 부터 수신되는 이벤트
	socket.onmessage = function(e) {
		console.log('message', e.data);
		// alert(e.data)
		$("#message_list").append("FROM : "+ e.data + "<br/>" )
		// sock.close();
	};

	// 소켓 서버와 접속 종료
	//socket.onclose = function() {
	//	console.log('close');
	// };
$(function(){

	$(document).on("click","#btn_send",function(){
			let message = $("#message").val()
			
			$("#message_list").append("나 >> " + message + "<br/>")
			socket.send(message)	
	
	})
	
})


</script>
</head>
<body>
<header class="jumbotron bg-success">
	<h2 class="text-white text-center">MY CHAT SERVICE</h2>
</header>
<div>
	<input id="message" placeholder="메시지 입력">
	<button id="btn_send">전송</button>
</div>
<section class="container-fluid">
	<div id="user_list" class="col-3" >
	</div>
	<div id="message_list" class="col-8">
	</div>
</section>

</body>
</html>









