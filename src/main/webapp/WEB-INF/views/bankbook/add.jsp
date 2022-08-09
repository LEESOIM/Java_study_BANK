<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록</h1>
	
	<form action="./add" method="post">
	<div>
	<h3>통장이름</h3>
	<input type="text" name="name">
	<h3>이자율</h3>
	<input type="text" name="rate">
	</div>
	
	<input type="submit" value="상품등록">
	</form>
</body>
</html>