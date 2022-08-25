<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-7 mt-5">
		<h1 class="mb-5 fw-normal text-center">${requestScope.board}</h1>
		<table class="table table-striped mt-3 mb-5">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="dto">
					<tr>
						<td>${pageScope.dto.num }</td>
						<td><a href="./detail.iu?num=${pageScope.dto.num }">${pageScope.dto.title }</a></td>
						<td>${dto.writer }</td>
						<td>${dto.regDate }</td>
						<td>${dto.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example" class="text-align: center"  >
			<ul class="pagination" style="justify-content: center">
			<c:if test="${pager.pre }">
			<li class="page-item"><a class="page-link" href="list.iu?page=${pager.startNum-1 }" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
			</c:if>
			
				<c:forEach begin="${requestScope.pager.startNum }" end="${requestScope.pager.lastNum }" var="i">
					<li class="page-item"><a class="page-link" href="list.iu?page=${pageScope.i }">${pageScope.i }</a></li>
				</c:forEach>
				
<%-- 		<c:choose>
				<c:when test="${pager.next }"> <!-- if -->
					<li class="page-item ">
				</c:when> 
				<c:otherwise>
					<li class="page-item disabled"> <!-- 그외 나머지 -->
				</c:otherwise> 
			</c:choose> --%>

			<li class="page-item ${pager.next?'':'disabled' }"><a class="page-link" href="list.iu?page=${pager.lastNum+1 }" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>

			<c:if test="${not empty sessionScope.success}">
			<a class="btn btn-primary" href="./add.iu">글쓰기</a>
			</c:if>
		
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>