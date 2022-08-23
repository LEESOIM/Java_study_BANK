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
<section class="container-fluid col-lg-3 mt-5">
	<h1 class="mb-5 fw-normal text-center">상품 수정</h1>
	
	<form action="update.iu" method="post" >
	<input type="hidden" name="bookNum" value="${dto.bookNum }" >
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">통장이름</label>
	  <input type="text" name=bookName class="form-control" id="exampleFormControlInput1" value="${dto.bookName }">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">이자율</label>
	  <input type="text" name="bookRate" class="form-control" id="exampleFormControlTextarea1" value="${dto.bookRate }">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">상세설명</label>
	  <textarea class="form-control" name="bookContents" id="exampleFormControlTextarea1" rows="3">${dto.bookContents }</textarea>
	</div>
	<button class="btn btn-primary" type="submit">상품수정</button>
	</form>
	</section>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>