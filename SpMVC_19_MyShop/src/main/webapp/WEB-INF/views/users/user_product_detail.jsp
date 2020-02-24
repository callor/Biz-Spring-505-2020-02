<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	height: 100%;
}

.detail-li {
	list-style: none;
}

.product-container-box {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.img-box {
	border: 1px solid black;
	width: 300px;
	height: 270px;
	margin: 3rem;
}

.btn-box {
	display: flex;
	justify-content: center;
	align-items: center;
}
#p-button{
	margin: 3px;
	width: 200px;
}
.producthtag{
	font-weight: bold;
}
p{
	white-space: pre-line;
}
</style>
<body>
	<div class="product-container-box">

		<div class="img-box">
			<img>
		</div>

		<div class="product-item-box">
			<div class="product-name">
				<h2 class="producthtag">${pVO.p_name}</h2>
				<hr />
			</div>
			<table>
				<tbody>
					<tr>
						<th>판매가</th>
						<td>${pVO.p_oprice}원</td>
					</tr>
					<tr>
						<th>상품코드</th>
						<td>${pVO.p_code}</td>
					</tr>
					<tr>
						<th>제조사/공급사</th>
						<td>${pVO.p_dcode}</td>
					</tr>
					<tr>
						<th>구매수량</th>
						<td><input type="number"> <a href="#a">증가</a> <a
							href="#a">감소</a></td>
					</tr>
				</tbody>
			</table>
			<hr/>
			<div class="btn-box">
				<button class="btn btn-primary" id="p-button">장바구니</button>
				<button class="btn btn-primary" id="p-button">바로구매</button>
			</div>
		</div>
	</div>
	
	<div class="container">
		<hr/>
		<p>
			${pVO.p_detail}
		</p>
	</div>