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
	<h1>글목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list }" var="dto">
				<tr>
					<td>${pageScope.dto.num }</td>
					<td><a href="./detail.iu?num=${pageScope.dto.num }">${pageScope.dto.title }</a></td>
					<td>${dto.writer }</td>
					<td>${dto.regDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add.iu">글쓰기</a>		
</body>
</html>