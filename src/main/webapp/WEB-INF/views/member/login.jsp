<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
	#error {
		color: red;
	}
</style>
</head>
<body class="text-center">
 	<!-- 
 	/member/login : GET -> 로그인 가입 양식을 보려 함
	/member/login : POST -> 입력한 ID PW로 로그인 판단
	 -->
	
	 <c:import url="../template/header.jsp"></c:import>

	 <section class="container-fluid col-lg-2 mt-5">
	 	<div class="row">
			<main class="form-signin w-80 m-auto">
				<form action="login.iu" method="post" id="frm">
				  <h1 class="mb-5 fw-normal text-center">로그인</h1>

				  <div class="form-floating mb-2">
					<input type="text" class="form-control" name="userName" id="userName" placeholder="ID" value="ㅇㅅㅇ">
					<label for="userName">ID</label>
				  </div>
				  <div class="form-floating">
					<input type="password" class="form-control" name="password" id="password" placeholder="Password" value="1234">
					<label for="password">Password</label>
				  </div>

				  <div id="error" ></div>

				  <button class="w-100 btn btn-lg btn-primary mt-4" type="button" id="btn">Sign in</button>
				</form>
			  </main>
	 	</div>
	 </section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/member.js"></script>
<script>
	loginCheck();
</script>
</body>
</html>