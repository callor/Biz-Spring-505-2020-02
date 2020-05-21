<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
			prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
			
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section class="container body">
	<form:form modelAttribute="productVO">
		<fieldset>
			<legend>상품정보 등록</legend>
			<div class="form-group">
				<form:input path="p_code" 
						class="form-control" 
						placeholder="상품코드"/>
			</div>		
			<div class="form-group">
				<form:input path="p_name" 
						class="form-control" 
						placeholder="상품이름"/>
			</div>		
			<div class="form-group">
				<form:input path="p_oprice" 
						class="form-control" 
						placeholder="판매가격"/>
			</div>
			<div class="button-group">
				<button class="btn btn-primary text-right">저장</button>
				<button type="button" 
					class="btn btn-success text-right">상품목록으로</button>
			</div>		
		</fieldset>	
	</form:form>
</section>


</body>
</html>




