<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(function(){

	$(".pro_tr").click(function(){
		
		let id = $(this).data("id") // attr("data-id")
		let c = $(this).attr("class")

		// document.location.href="${rootPath}/admin/product/update?id=" + id
		document.location.href="${rootPath}/admin/product/update/" + id
		
	})
	
})

</script>
<table class="col-md-4 col-12">
	<tr>
		<th>거래처코드</th>
		<th>거래처명</th>
		<th>대표</th>
		<th>사업자번호</th>
		<th>대표전화</th>
		<th>담당자</th>
		<th>담당자 연락처</th>
	</tr>
	<c:choose>
		<c:when test="${empty DEPT_LIST}">
			<tr>
				<td colspan="7">거래처 정보가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="DEPT" items="${DEPT_LIST}" varStatus="i">
			<tr class="dept_tr" data-id="${DEPT.id}">
				<td>${DEPT.d_code}</td>
				<td>${DEPT.d_name}</td>
				<td>${DEPT.d_ceo}</td>
				<td>${DEPT.d_sid}</td>
				<td>${DEPT.d_tel}</td>
				<td>${DEPT.d_manager}</td>
				<td>${DEPT.d_mtel}</td>
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


