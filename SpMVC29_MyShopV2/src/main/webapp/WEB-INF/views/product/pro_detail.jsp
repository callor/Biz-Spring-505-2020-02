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
<script>
</script>
<style>
div.p_detail_box {
	display: flex;
}

div.p_detail_label, div.p_detail_data {
	padding: 10px;
	margin: 5px;
}

div.p_detail_label {
	flex: 1;
	text-align: right;
	background-color: #FFE4C4;
	font-weight: bold;
}

div.p_detail_data {
	flex: 3;
	background-color: #FFF8DC;
}

div.p_detail_white
 {
 	flex:1;
 	text-align: right;
 	font-weight: bold;
 
 }
 
 </style>
 <script>
 $(function(){
	 $("button.size-add").click(function(){
		let size_standard = $("#m_size_list option:selected").val()
		let size_name = $("#m_size_list option:selected").text()
		
		$("#p_size_list").append(
				$( "<option/>",{value:size_standard,text:size_name} )
		)
	 })
	 
	 $("button.size-delete").click(function() {
		 $("#p_size_list option:selected").remove()
	 }) 
 })
 
 </script>
 
 
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section class="container-fluid body m-5">
		<article class="container p-5 bg-light">
			<div class="p_detail_box">
				<div class="p_detail_label">상품코드</div>
				<div class="p_detail_data">${productVO.p_code}</div>
			</div>
			<div class="p_detail_box">
				<div class="p_detail_label">상품이름</div>
				<div class="p_detail_data">${productVO.p_name}</div>
			</div>
			<div class="p_detail_box">
				<div class="p_detail_label">매입가격</div>
				<div class="p_detail_data">${productVO.p_iprice}</div>
			</div>
			<div class="p_detail_box">
				<div class="p_detail_label">판매가격</div>
				<div class="p_detail_data">${productVO.p_oprice}</div>
			</div>
			<div class="p_detail_box">
				<div class="p_detail_label">대표이미지</div>
				<div class="p_detail_data">
					<img width="100px" 
					src="${rootPath}/upload/${productVO.p_file}"></div>
			</div>
			<div class="p_detail_box">
				<div class="p_detail_white">
					<button 
						onclick="location.href='${rootPath}/product' " 
						class="btn btn-success">목록으로</button>
				</div>
			</div>
		</article>
		<article class="container p-5 bg-light">
			<form:form modelAttribute="productVO">
				<div class="p_detail_box">
					<div class="p_detail_white">
						<h5>사이즈 선택</h5>
						<form:select path="m_size_list" 
								class="form-control" multiple='false'>
							<form:options 
								items="${m_size_list}"
								itemLabel="o_name" itemValue="o_standard" />
						</form:select>
						
						<button type="button" 
						class="btn btn-primary size-add">▼ 추가</button>

						<button type="button" 
						class="btn btn-warning size-delete">▲ 삭제</button>

						<form:select path="p_size_list"
								class="form-control" />
					</div>
					
					<div class="p_detail_white">
						<h5>컬러 리스트 선택</h5>
						<form:select path="m_color_list" 
								class="form-control" multiple='false'>
							<form:options 
								items="${m_color_list}"
								itemLabel="o_name" itemValue="o_standard" />
						</form:select>
					</div>
				</div>



			</form:form>		
		</article>
	</section>
</body>
</html>








