<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankmembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list"); %>
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
		<%for(BankMembersDTO dto:ar) {%>
			<tr>
				<td><%=dto.getUsername() %></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getEmail() %></td>
				<td><%=dto.getPhone() %></td>
			</tr>
		<%} %>
		</tbody>
	</table>
	

</body>
</html>