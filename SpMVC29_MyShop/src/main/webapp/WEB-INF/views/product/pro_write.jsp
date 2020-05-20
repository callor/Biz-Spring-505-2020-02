<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>
#body {
	height: 1000px;
}

form{
	width:100%;
}

section {
	width:100%;
	display: flex;
	border:1px solid red;
}

article {
	flex: 1px;
	margin: 5px;
	border: 1px solid blue;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>

	<form:form modelAttribute="productVO">
		<section class="container body">

			<article>
				<h3>상품정보 등록</h3>

				<div>
					<form:input path="p_code" placeholder="상품코드" />
					<button>코드생성</button>
				</div>
				<div>
					<form:input path="p_name" placeholder="상품이름" />
				</div>
				<div>
					<form:input path="p_iprice" placeholder="판매가격" />
				</div>

			</article>
			<article>
				<h2>색상리스트</h2>
				<form:select path="p_color_list" class="form-control">
					<form:options items="${COLOR_LIST}"/> 
				</form:select>
				
			</article>
			<article>
				<h2>사이즈 리스트</h2>
				<form:select path="p_size_list" class="form-control">
					<form:options items="${SIZE_LIST}"/>
				</form:select>
			</article>

			<button>저장</button>
		</section>
		
	</form:form>

</body>
</html>