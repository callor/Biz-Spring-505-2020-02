<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="col-md-4 col-12">
	<tr>
		<th>상품코드</th>
		<th>상품이름</th>
		<th>거래처</th>
		<th>품목</th>
		<th>매입가격</th>
		<th>판매가격</th>
	</tr>
	<c:choose>
		<c:when test="${empty PRO_LIST}">
			<tr>
				<td colspan="6">상품정보가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="PRO" items="${PRO_LIST}" varStatus="i">
			<tr>
				<td>${PRO.p_code}</td>
				<td><span class="p_name">${PRO.p_name}</span></td>
				<td>${PRO.p_bcode}</td>
				<td>${PRO.p_dcode}</td>
				<td>${PRO.p_iprice}</td>
				<td>${PRO.p_oprice}</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		<div>
			<a href="/list?pageno=1&search=${search}&text=${text}">1</a>
			<a href="/list?pageno=2&search=${search}&text=${text}">2</a>
			<a href="/list?pageno=3&search=${search}&text=${text}">3</a>
			<a href="/list?pageno=4&search=${search}&text=${text}">4</a>
			<a href="/list?pageno=5&search=${search}&text=${text}">5</a>
		</div>
	
</table>


