<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- summernote jQuery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- summernote -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid col-lg-7 mt-5">
	<h1 class="mb-5 fw-normal text-center">${requestScope.board}</h1>
	
	<form action="update.iu" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${boardDTO.num }" >
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">글제목</label>
	  <input type="text" name=title class="form-control" id="exampleFormControlInput1" value="${boardDTO.title }">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
	  <textarea class="form-control" name="contents" id="contents" rows="10">${boardDTO.contents }</textarea>
	 
	  
		<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			<div class="mb-3">
				<span class="form-control">${fileDTO.oriName}</span>
				<button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>        
			</div>
		</c:forEach>


		<div id="addFiles">	
				<button type="button" id="fileAdd" class="btn btn-outline-dark btn-sm">파일추가</button>
		</div>

	</div>
	<button class="btn btn-primary" type="submit">글수정</button>
	</form>
	</section>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
<script>
	setCount(${boardDTO.boardFileDTOs.size()});
	$("#contents").summernote();
</script>
</body>
</html>