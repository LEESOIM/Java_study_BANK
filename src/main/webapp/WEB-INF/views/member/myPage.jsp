<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="container-fluid col-lg-8">
	<h1>My Page</h1>
	<div class="row">
		<table class="table table-dark">
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
 
	 	<thead>
	 		<tr>
	 			<th>ID</th><th>NAME</th><th>EMAIL</th><th>PHONE</th>
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
		
		<c:forEach items="${dto.bankAccountDTOs }" var="dto">
			<p>계좌번호 : ${pageScope.dto.accountNum }</p>
			<p>통장이름 : ${dto.bankBookDTO.bookName }</p>
			<p>통장개설일 : ${dto.accountDate }</p>
		</c:forEach>
		</table>	
	</div>
</section>
</body>
</html>