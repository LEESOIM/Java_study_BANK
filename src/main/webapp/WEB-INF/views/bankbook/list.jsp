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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail jsp:detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<section class="container-fluid col-lg-7 mt-5">
	<h1 class="mb-5 fw-normal text-center">상품목록</h1>
	<table class="table table-striped mt-3 mb-3">
		<thead>
			<tr>
				<th>일련번호</th>
				<th>통장이름</th>
				<th>이자율</th>
				<th>판매여부</th>
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
				<td><a href="detail?bookNum=<%= bankBookDTO.getBookNum()%>"> <%= bankBookDTO.getBookName() %></a></td>
				<td><%= bankBookDTO.getBookRate() %></td>
			</tr>
			<%} %> 
--%>

			<c:forEach items="${requestScope.list }" var="dto">
				<tr>
					<td>${dto.bookNum }</td>
					<td><a href="./detail.iu?bookNum=${pageScope.dto.bookNum }">${pageScope.dto.bookName }</a></td>
					<td>${pageScope.dto.bookRate }</td>
					<td>${dto.bookSale }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary" href="./add.iu">상품등록</a>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>