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
	
	<form action="./add.iu" method="post">
		<div>
			Name : <input type="text" name="bookName">
		</div>
			
		<div>	
			Rate : <input type="text" name="bookRate">
		</div>
		
		<div>
			<input type="submit" value="상품등록">
			<button type="submit">상품등록</button>
		</div>
	</form>
</body>
</html>