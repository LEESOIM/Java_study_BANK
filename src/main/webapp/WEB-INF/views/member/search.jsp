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
<body class="text-center">
<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid col-lg-2 mt-5">
		<form action="search.iu" method="post">
			<h3 class="mb-3 fw-normal">아이디 찾기</h3>
			<div class="form-floating">
				<input type="text" class="form-control" name="search" id="floatingInput" placeholder="ID">
				<label for="floatingInput">ID</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary mt-4" type="submit">Sign in</button>
		</form>
	 </section>

	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>