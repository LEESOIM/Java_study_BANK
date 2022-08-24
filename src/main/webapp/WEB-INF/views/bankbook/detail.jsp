<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
<%--     
    <% BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");%> 
--%>
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-7 mt-5">
	<h1 class="mb-5 fw-normal text-center">상품 상세정보</h1>
	<table class="table table-striped mt-3 mb-3">
		<tr>
			<th>일련번호</th>
			<th>통장이름</th>
			<th>메모</th>
			<th>이자율</th>
			<th>판매여부</th>
		</tr>
		<tr>
			<td>${requestScope.dto.getBookNum()}</td>
			<td>${requestScope.dto.bookName}</td>
			<td>${requestScope.dto.bookContents }</td>
			<td>${requestScope.dto.bookRate}</td>
			<td>${requestScope.dto.bookSale}</td>
		</tr>
	</table>
	
	<a class="btn btn-primary" href="update.iu?bookNum=${dto.bookNum}">상품수정</a>
	<a class="btn btn-primary" href="delete.iu?bookNum=${dto.bookNum}">상품삭제</a>
	<a class="btn btn-primary" href="./list.iu">상품목록</a>
	
	<c:if test="${not empty sessionScope.success }">
		<a class="btn btn-primary" href="../bankaccount/add.iu?bookNum=${dto.bookNum}">가입하기</a>
	</c:if>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>