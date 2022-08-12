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
			<input type="submit" value="Create">
			<button type="submit">ADD</button>
		</div>
	</form>
</body>
</html>