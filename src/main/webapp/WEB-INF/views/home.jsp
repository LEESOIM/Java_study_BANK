<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello SOIM World! ππππ‘π </h1>
	<P>The time on the server is ${serverTime}.</P>

	<div>
		<c:if test="${empty sessionScope.success }">
			<%-- ${member eq null} --%>
			<a href="./member/login.iu">λ‘κ·ΈμΈ</a>
			<a href="./member/join.iu">νμκ°μ</a>
		</c:if>

		<c:if test="${not empty sessionScope.success }">
			<h3>${sessionScope.success.name}λνμν©λλ€</h3>
			<a href="./member/logout.iu">λ‘κ·Έμμ</a>
			<a href="./member/myPage.iu">λ§μ΄νμ΄μ§</a>
		</c:if>
	</div>

	<div>
		<a href="./member/search.iu">μμ΄λ μ°ΎκΈ°</a> <a href="./bankbook/list.iu">μνλͺ©λ‘</a>
		<a href="./notice/list.iu">κΈλͺ©λ‘</a>
	</div>
</body>
</html>
