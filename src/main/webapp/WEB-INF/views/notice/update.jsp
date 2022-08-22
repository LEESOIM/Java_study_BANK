<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글수정</h1>
	<form action="update.iu" method="post" >
		<input type="hidden" name="num" value="${dto.num }" >
		<div>
			제목 : <input type="text" name="title" value="${dto.title }">
		</div>
		<div>
			내용 : <input type="text" name="contents" value="${dto.contents }">
		</div>
		<input type="submit" value="수정">
	</form>
</body>
</html>