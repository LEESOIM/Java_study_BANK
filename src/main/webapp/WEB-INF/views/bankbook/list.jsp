<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
   //스크립틀릿 <% java code 작성 % >
   //표현식 <%= 자바 변수 또는 값 % > (html에 자바를 출력할 때)
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail jsp:detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rate</th>
			</tr>
		</thead>
		<tbody>
<%--  		<tr>
				<td>Name1</td>
				<td>0.012</td>
			</tr>
			<tr>
				<td>Name2</td>
				<td>3.14</td>
			</tr>
--%>			
			
			
<%-- 		<% for(BankBookDTO bankBookDTO:ar){ %>
			<tr>
				<td><a href="detail?booknum=<%= bankBookDTO.getBooknum()%>"> <%= bankBookDTO.getBookname() %></a></td>
				<td><%= bankBookDTO.getBookrate() %></td>
			</tr>
			<%} %> 
--%>

			<c:forEach items="${requestScope.list }" var="dto">
				<tr>
					<td><a href="./detail?booknum=${pageScope.dto.booknum }">${pageScope.dto.bookname }</a></td>
					<td>${pageScope.dto.bookrate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add">상품등록</a>
</body>
</html>