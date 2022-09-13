<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body class="text-center">
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-7">
		<h1 class="mt-5 mb-5 fw-normal">My Page</h1>
		<div class="row">
			<!-- jsp에 java의 data를 출력할땐 EL을 사용한다 ! ! -->

			<%-- 
		<h1>${map }</h1>
		
		<p>ID : ${map.dto.userName }</p>
		<p>NAME : ${map.dto.name }</p>
		<p>EMAIL :${map.dto.email }</p>
		<p>PHONE : ${map.dto.phone }</p>
		
		<c:forEach items="${map.list }" var="dto">
			<p>계좌번호 : ${dto.accountNum }</p>
			<p>통장이름 : ${dto.bankBookDTO.bookName }</p>
			<p>통장개설일 : ${dto.accountDate }</p>
		</c:forEach>
	--%>

			<!-- 
requestScope : 작은영역부터 넓은영역까지 찾으러감(page<request<session<Application)
로그인할때 session에 담는 이유 : http는 연결 유지가 안되기 때문에 session을 cookie에 담아서 접속한 웹브라우저로 보낸다 
-->

			<%-- 
		<p>ID : ${requestScope.dto.userName }</p> 
		<p>NAME : ${dto.name }</p>
		<p>EMAIL :${dto.email }</p>
		<p>PHONE : ${dto.phone }</p>
		
		<c:forEach items="${list }" var="dto">
			<p>계좌번호 : ${pageScope.dto.accountNum }</p>
			<p>통장이름 : ${dto.bankBookDTO.bookName }</p>
			<p>통장개설일 : ${dto.accountDate }</p>
		</c:forEach>
	 --%>

	<div class="mb-5" style="margin-right: auto; margin-left: auto;">
        <img alt="" src="../resources/upload/member/${dto.membersFileDTO.fileName }" class="bd-placeholder-img rounded-circle" width="200" height="250">
	</div>

			<table class="table table-dark mb-5">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>EMAIL</th>
						<th>PHONE</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.dto.userName }</td>
						<td>${dto.name }</td>
						<td>${dto.email }</td>
						<td>${dto.phone }</td>
					</tr>
				</tbody>
			</table>

			<table class="table table-striped mt-3 mb-5">
				<thead>
					<tr>
						<th>계좌번호</th>
						<th>통장이름</th>
						<th>개설일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dto.bankAccountDTOs }" var="dto">
						<tr>
							<td>${pageScope.dto.accountNum }</td>
							<td>${dto.bankBookDTO.bookName }</td>
							<td>${dto.accountDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	<div>
		<c:forEach items="${sessionScope.success.roleDTOs }" var="roleDTO">
			<div>${pageScope.roleDTO.roleNum}, ${roleDTO.roleName}</div>
		</c:forEach>
		
		<h1>당신은 ${success.roleDTOs.get(0).roleName } 입니다.</h1>
		<h1>당신은 ${success.roleDTOs["0"].roleName } 입니다.</h1>
	</div>
	
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>