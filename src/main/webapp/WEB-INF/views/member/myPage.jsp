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
<h1>My Page</h1>

	<!-- jsp에 java의 data를 출력할땐 EL을 사용한다 ! ! -->
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
</body>
</html>