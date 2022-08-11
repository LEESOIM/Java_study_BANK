<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
    <%
    BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
    %>
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td>${requestScope.dto.getBooknum()}</td>
			<td>${requestScope.dto.bookname}</td>
			<td>${dto.bookrate}</td>
			<td>
				
			</td>
		</tr>
	</table>
	
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>

	<a href="./list">리스트</a>
	<a href="update?booknum=${dto.booknum}">수정</a>
	<a href="delete?booknum=${dto.booknum}">삭제</a>
	
</body>
</html>