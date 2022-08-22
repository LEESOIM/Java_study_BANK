<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${requestScope.dto.num }</td>
			<td>${requestScope.dto.title }</td>
			<td>${dto.contents }</td>
			<td>${dto.writer }</td>
			<td>${dto.regDate }</td>
			<td>${dto.hit }</td>
		</tr>
	</table>
	
<a href="./list.iu">글목록</a>	
<a href="./update.iu?num=${dto.num }">글수정</a>	
<a href="./delete.iu?num=${dto.num }">글삭제</a>
</body>
</html>