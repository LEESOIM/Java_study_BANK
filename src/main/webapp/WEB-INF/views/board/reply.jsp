<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-5 mt-5">
		<h1 class="mb-5 fw-normal text-center">${requestScope.board } Reply</h1>

		<form action="./reply.iu" method="post">
		<input type="hidden" name="num" value="${boardDTO.num }">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목</label>
				<input type="text" name="title" class="form-control"
					id="exampleFormControlInput1">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea class="form-control" name="contents"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control"
					id="exampleFormControlInput1" readonly="readonly"
					value="${sessionScope.success.userName }">
			</div>
			<button class="btn btn-primary" href="./add.iu">글쓰기</button>
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>