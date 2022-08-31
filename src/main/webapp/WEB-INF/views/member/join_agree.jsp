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
	<h1 class="mb-5 fw-normal text-center">약관동의</h1>
	
	<div>
		<p><input type="checkbox" name="box" id="all">전체동의</p>
		<p><input type="checkbox" name="box" id="" class="cb req">이용약관 동의(필수)</p>
		<p><input type="checkbox" name="box" id="" class="cb req">개인정보 수집 및 이용 동의(필수)</p>
		<p><input type="checkbox" name="box" id="" class="cb">위치기반서비스 이용약관 동의(선택)</p>
		<p><input type="checkbox" name="box" id="" class="cb">프로모션 정보 수신 동의(선택)</p>
	</div>

	<form action="join.iu" id="frm"> <!-- 메서드 안쓰면 디폴트 get -->
	    <button type="button" id="join">회원가입</button> <!-- 타입 안쓰면 디폴트 submit -->
	</form>

</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/member.js"></script>
<script>
	check();
</script>
</body>
</html>