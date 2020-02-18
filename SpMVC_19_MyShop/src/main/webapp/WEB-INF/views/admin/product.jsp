<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<style>
.in-errors {
	color:red;
	font-size:8px;
}
/*
	col-md-7 col-12
	해상도가 768보다 크면 7칸만 차지하고
	그 이하이면 12칸을 차지하여 풀 width 로 보여라
*/

tr,td,th {
	white-space: nowrap;

}
.pro-list {
	overflow: auto;
}

.p_name {
 	display:inline-block;
 	width:150px;
 	padding: 0 5px;
 	overflow: hidden;
 	text-overflow: ellipsis;
 	white-space: nowrap;
}

</style>
<article class="mt-5 row">
	<article class="col-md-7 col-12 bg-light pro-input">
		<c:choose>
			<c:when test="${PRO_BODY == 'DETAIL' }">
				<%@ include file="/WEB-INF/views/admin/product_detail.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/admin/product_input.jsp" %>
			</c:otherwise>
		
		</c:choose>
	</article>
	
	<article class="col-md-4 col-12 bg-light pro-list">
		<%@ include file="/WEB-INF/views/admin/product_list.jsp" %>
	</article>

</article>


