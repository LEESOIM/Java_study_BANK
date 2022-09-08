<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-7 mt-5">
		<h1 class="mb-5 fw-normal text-center">${requestScope.board}</h1>
		<table class="table table-striped mt-3 mb-4">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${requestScope.list }" var="dto">
					<tr>
						<td>${pageScope.dto.num }</td>
						 <td><c:catch> <!--노티스 에러방지 -->
								<!-- for(int i=0; i'<='end; i++) -->
								<c:forEach begin="1" end="${dto.depth }">
									 &ensp; <!--스페이스 2번 -->
								</c:forEach>
							</c:catch> <a href="./detail.iu?num=${pageScope.dto.num }">${pageScope.dto.title }</a></td>
						<td>${dto.writer }</td>
						<td>${dto.regDate }</td>
						<td>${dto.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example" class="text-align: center">
			<ul class="pagination" style="justify-content: center">
				<c:if test="${pager.pre }">
					<li class="page-item"><a class="page-link"
						href="list.iu?page=${pager.startNum-1 }&kind=${pager.kind }&search=${pager.search}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
				</c:if>

				<c:forEach begin="${requestScope.pager.startNum }"
					end="${requestScope.pager.lastNum }" var="i">
					<li class="page-item"><a class="page-link"
						href="list.iu?page=${pageScope.i }&kind=${pager.kind }&search=${pager.search}">${pageScope.i }</a></li>
				</c:forEach>

		<%--<c:choose>
				<c:when test="${pager.next }"> <!-- if -->
					<li class="page-item ">
				</c:when> 
				<c:otherwise>
					<li class="page-item disabled"> <!-- 그외 나머지 else-->
				</c:otherwise> 
			</c:choose> --%>

				<li class="page-item ${pager.next?'':'disabled' }"><a
					class="page-link"
					href="list.iu?page=${pager.lastNum+1 }&kind=${pager.kind }&search=${pager.search}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>

			</ul>
			
		</nav>


		<form action="list.iu" class="row gy-2 gx-3 align-items-center" style="justify-content: center">
			<div class="col-auto">
				<select name="kind" class="form-select">
					<option class="kinds" value="title">제목</option>
					<option class="kinds" value="contents">내용</option>
					<option class="kinds" value="writer">작성자</option>
				</select>
			</div>
			<div class="col-auto">
				<input type="text" class="form-control" id="autoSizingInput"
					name="search" value="${param.search}"> <!-- 파라미터 중에서 search인것을 꺼내쓴다 -->
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary" id="search">검색</button>
			</div>
		</form>
<%-- <c:if test="${not empty sessionScope.success}"> --%>
					<a class="btn btn-primary" href="./add.iu">글쓰기</a>
<%-- </c:if> --%>

	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script src="/resources/js/board.js"></script>
	<script>
		//파라미터로 받은값과 옵션에 있는 밸류값을 비교해서 같은걸 찾아서 selected값에 true를준다
		const kinds = document.getElementsByClassName('kinds');
		let k = '${param.kind}'; //title, writer, contents
		console.log(k)

		for(let i =0;i < kinds.length;i++){
  			if(k == kinds[i].value){
			kinds[i].selected = true;
			break;
 		 }
		}
	</script>	
</body>
</html>