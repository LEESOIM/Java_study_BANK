<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
 	
 	<!-- 
 	/member/login : GET -> 로그인 가입 양식을 보려 함
	/member/login : POST -> 입력한 ID PW로 로그인 판단
	 -->
	
	<form action="./login.iu" method="post">
        
		<h1>로그인</h1>
			    
		<div>
			ID <input type="text" value="ㅇㅅㅇ" name="userName" placeholder="아이디"> 
		</div>
			
		<div>
			PW <input type="password" value="1234" name="password" placeholder="비밀번호">
		</div>
			        
		<input type="submit" value="로그인">
			
		<a href="../">Index</a>

	</form>
</body>
</html>