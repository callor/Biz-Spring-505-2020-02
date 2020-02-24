<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Heroic Features - Start Bootstrap Template</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>

<script>
/*
$(function(){
	
	$(".basket").click(function(){
		
		let id = $(this).attr('data-name')
		
		alert(id)
		document.location.href="${rootPath}/user/product/detail?id=" + id
		
	})
	
})
*/
$(function(){
	
	$(".search").keypress(function(key){
		if(key.keyCode == 13){
			let a = $(".search").val()
			
			if($.trim(a) == ""){
				alert("문자를 입력하세요")
				return false;
			}
			
			alert("입력한 검색어는 : " + a)
			document.location.href = "${rootPath}/user/product/search?search=" + a
		}
	})
	
})
</script>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">로그인</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">로그아웃</a></li>
					<li class="nav-item"><input type="text" name="search" class="search" >
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">클릭하고 주문하는데까지 1분</h1>
			<p class="lead">안사도 됩니다. 구경만 하고 가세요 !!</p>
			<a href="#" class="btn btn-primary btn-lg">추천상품 바로사기</a>
		</header>

		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach var="B2C" items="${B2C_LIST}" varStatus="i">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="http://placehold.it/500x325" alt="">
						<div class="card-body">
							<h4 class="card-title">Card title</h4>
							<div>
								<c:choose>
									<c:when test="${empty B2C_LIST}">
										<tr>
											<td colspan="6">상품 정보가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>

										<div class="B2C_LIST" >
											<div>상품이름 : ${B2C.p_name}</div>
											<div>상품가격 : ${B2C.p_iprice}</div>
										</div>

									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="card-footer">
							<a href="${rootPath}/user/product/detail?id=${B2C.id}" class="btn basket btn-primary">보러만 가기</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="${rootPath}/js/vendor/jquery/jquery.min.js"></script>
	<script
		src="${rootPath}/js/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>