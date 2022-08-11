<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! 🎈🎀🎁🎡🎠
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
	<c:if test="${empty member }"> <%-- ${member eq null} --%>
		<a href="./member/login">로그인</a>
		<a href="./member/join">회원가입</a>
	</c:if>
	<c:if test="${not empty member }">
		<a href="#">로그아웃</a>
		<a href="#">마이페이지</a>
	</c:if>	
</div>
<div>
	<a href="./member/search">회원조회</a>
	<a href="./bankbook/list">상품리스트</a>
</div>
</body>
</html>
