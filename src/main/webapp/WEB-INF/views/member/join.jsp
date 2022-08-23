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

	 <section class="container-fluid col-lg-2 mt-5">
	 <form action="./join.iu" method="post">
	 	<div class="row">
			<main class="form-signin w-80 m-auto">
				  <h1 class="mb-5 fw-normal text-center">회원가입</h1>

				  <div class="form-floating mb-3">
					<input type="text" class="form-control" name="userName" id="floatingInput" placeholder="ID">
					<label for="floatingInput">ID</label>
				  </div>
				  <div class="form-floating mb-3">
					<input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
					<label for="floatingPassword">Password</label>
				  </div>
				  <div class="form-floating mb-3">
					<input type="text" class="form-control" name="name" id="floatingPassword" placeholder="Password">
					<label for="floatingPassword">name</label>
				  </div>
				  <div class="form-floating mb-3">
					<input type="text" class="form-control" name="email" id="floatingPassword" placeholder="Password">
					<label for="floatingPassword">email</label>
				  </div>
				  <div class="form-floating mb-3">
					<input type="text" class="form-control" name="phone" id="floatingPassword" placeholder="Password">
					<label for="floatingPassword">phone</label>
				  </div>

				  <button class="w-100 btn btn-lg btn-primary mt-4" type="submit">가입하기</button>
			  </main>
	 	</div>
    	</form>
	 </section>
        
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>