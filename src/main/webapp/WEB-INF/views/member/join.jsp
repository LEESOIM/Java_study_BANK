<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	
	    <form action="./join" method="post">
        
        <h1>회원가입</h1>
        <div>
        <h3>아이디</h3>
        <input type="text" name="username"> 
        
        <h3>비밀번호</h3>
        <input type="password" name="password">
        
        <h3>이름</h3>
        <input type="text" name="name">
        
        <h3>이메일</h3>
        <input type="email" name="email">
        
        <h3>휴대전화</h3>
        <input type="text" name="phone">
        </div>
        
        <input type="submit" value="가입하기">
    </form>
    
</body>
</html>