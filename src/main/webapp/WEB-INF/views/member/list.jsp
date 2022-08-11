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
<h1>Member LIST</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
		</thead>
		
		<tbody>
<%--	<!-- for(int i=0;i<=10;i=i+2) --> 
			<c:forEach begin="0" end="10" var="i" step="2">
				<h3>${pageScope.i}</h3>
			</c:forEach>
--%>			

			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.username }</td>
					<td>${pageScope.dto.name }</td>
					<td>${pageScope.dto.email }</td>
					<td>${pageScope.dto.phone }</td>
				</tr>
			</c:forEach>
		
		
<%-- 		<%for(BankMembersDTO dto:ar) {%>
			<tr>
				<td><%=dto.getUsername() %></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getEmail() %></td>
				<td><%=dto.getPhone() %></td>
			</tr>
		<%} %> --%>
		</tbody>
	</table>
	

</body>
</html>