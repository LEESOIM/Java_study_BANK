<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<!-- 
 	/member/login : GET -> 로그인 가입 양식을 보려 함
	/member/login : POST -> 입력한 ID PW로 로그인 판단
	 -->
	
	<form action="./login.iu" method="post">
		<h1>로그인</h1>
			    
		<div>
			<h3>아이디</h3>
			<input type="text" value="ㅇㅅㅇ" name="userName">
			
			<h3>비밀번호</h3>
			<input type="password" value="1234" name="password">
		</div>
			        
		<input type="submit" value="로그인">
		<a href="join.iu">회원가입</a>

	</form>
</body>
</html>