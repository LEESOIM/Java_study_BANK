<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- bootStrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-5 mt-5">
		<h1 class="mb-5 fw-normal text-center">${requestScope.board }</h1>

		<form action="./add.iu" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목</label>
				<input type="text" name="title" class="form-control"
					id="exampleFormControlInput1">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">내용</label>
				<textarea class="form-control" name="contents"
					id="contents" rows="5"></textarea>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control"
					id="exampleFormControlInput1" readonly="readonly"
					value="${sessionScope.success.userName }">
			</div>
			<button type="button" id="fileAdd" class="btn btn-outline-dark btn-sm">파일추가</button>
			<div id="addFiles">	
			</div>
			
			<div class="mt-3" style="text-align: right;">
				<button class="btn btn-primary" href="./add.iu">글쓰기</button>
			</div>
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
<!-- bootStrap -->
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
<script type="text/javascript">
	$("#contents").summernote();
	</script>
</body>
</html>