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
	<c:if test="${empty sessionScope.member }"> <%-- ${member eq null} --%>
		<a href="./member/login.iu">로그인</a>
		<a href="./member/join.iu">회원가입</a>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
	
	<h3>${sessionScope.member.name}님 환영합니다</h3>
		<a href="./member/logout.iu">로그아웃</a>
		<a href="./member/mypage.iu">마이페이지</a>
	</c:if>	
</div>
<div>
	<a href="./member/search.iu">회원조회</a>
	<a href="./bankbook/list.iu">상품리스트</a>
</div>
</body>
</html>
