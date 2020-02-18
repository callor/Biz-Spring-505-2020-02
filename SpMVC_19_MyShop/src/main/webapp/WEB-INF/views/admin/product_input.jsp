<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<form:form action="${rootPath}/admin/product/detail"
	modelAttribute="productVO">

	<div class="form-group">
		<div class="container-fluid row">
			<form:select path="p_bcode" class="custom-select-sm col-6">
				<form:option value="0">품목을 선택하세요</form:option>
				<form:option value="B0001">공산품</form:option>
				<form:option value="B0002">농산물</form:option>
				<form:option value="B0003">수산물</form:option>
			</form:select>
			<form:select path="p_dcode" class="custom-select-sm col-6">
				<form:option value="0">거래처를 선택하세요</form:option>
				<form:option value="D0001">대덕물산</form:option>
				<form:option value="D0002">삼성농산</form:option>
				<form:option value="D0003">목포수산</form:option>
			</form:select>
		</div>
		<div class="container-fluid row">
			<form:errors path="p_bcode" class="in-errors col-6" />
			<form:errors path="p_dcode" class="in-errors col-6" />
		</div>
	</div>
	<div class="form-group">
		<form:input path="p_code" class="form-control" placeholder="상품코드" />
		<form:errors path="p_code" class="in-errors" />
	</div>
	<div class="form-group">
		<form:input path="p_name" class="form-control" placeholder="상품이름" />
		<form:errors path="p_name" class="in-errors" />
	</div>
	<div class="container-fluid form-group row">
		<form:input path="p_iprice" class="form-control col-6"
			placeholder="매입단가" />
		<form:errors path="p_iprice" class="in-errors" />

		<form:input path="p_oprice" class="form-control col-6"
			placeholder="판매단가" />
		<form:errors path="p_oprice" class="in-errors" />
	</div>

	<div class="form-group">
		<button>상세정보 입력 &gt;&gt;</button>
	</div>
</form:form>
