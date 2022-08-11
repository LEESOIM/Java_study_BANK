<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>UPDATE PAGE</h1>
	<form action="update" method="post" >
	
		<input type="hidden" name="booknum" value="${dto.booknum }" >
		
		<div>
			Name : <input type="text" name="bookname" value="${dto.bookname }">
		</div>
		<div>
			Rate : <input type="text" name="bookrate" value="${dto.bookrate }">
		</div>
		
		<input type="submit" value="수정">
		<button type="submit">수정</button>
	
	</form>

</body>
</html>