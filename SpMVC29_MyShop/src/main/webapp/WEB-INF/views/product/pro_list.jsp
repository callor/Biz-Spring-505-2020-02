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
<section class="container-fluid body">

	<h3>상품리스트</h3>
	<table class="table table-all">
		<thead>
			<tr>
				<th>상품코드</th>
				<th>상품이름</th>
				<th>매입가격</th>
				<th>판매가격</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${empty proList}">
				<tr><td cospan="4">상품정보가 없습니다</td>
			</c:when>
			<c:otherwise>
				<tbody>
				<c:forEach items="${proList}" var="proVO">
					<tr>
						<td>${proVO.p_code}</td>
						<td>${proVO.p_name}</td>
						<td>${proVO.p_iprice}</td>
						<td>${proVO.p_oprice}</td>
					</tr>
				</c:forEach>
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="text-right">
	   <button 
	   onclick="location.href='${rootPath}/product/insert' "
	   class="btn btn-primary text-right">상품정보 등록</button>
	</div>
	
</section>

</body>
</html>














