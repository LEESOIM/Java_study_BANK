<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h1 class="mb-5 fw-normal text-center">${requestScope.board} </h1>
	<table class="table table-striped mt-3 mb-5">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${requestScope.boardDTO.getNum()}</td>
			<td>${requestScope.boardDTO.title}</td>
			<td>${requestScope.boardDTO.writer}</td>
			<td>${requestScope.boardDTO.regDate}</td>
			<td>${requestScope.boardDTO.hit}</td>
		</tr>
	</table>
	<textarea class="form-control" name="contents" rows="13" readonly="readonly">${boardDTO.contents }</textarea>

	<div class="mt-4">
	<c:if test="${sessionScope.success.userName eq requestScope.boardDTO.writer}">
		<a class="btn btn-primary" href="./update.iu?num=${boardDTO.num}">글수정</a>
		<a class="btn btn-primary" href="./delete.iu?num=${boardDTO.num}">글삭제</a>
	</c:if>
	<a class="btn btn-primary" href="./list.iu">글목록</a>
	</div>
	</section>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>