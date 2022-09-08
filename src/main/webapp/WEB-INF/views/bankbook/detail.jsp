<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
<%--     
    <% BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");%> 
--%>
-->
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
		<h1 class="mb-5 fw-normal text-center">상품 상세정보</h1>
		<table class="table table-striped mt-3 mb-3">
			<tr>
				<th>일련번호</th>
				<th>통장이름</th>
				<th>메모</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
			<tr>
				<td>${requestScope.dto.getBookNum()}</td>
				<td>${requestScope.dto.bookName}</td>
				<td>${requestScope.dto.bookContents }</td>
				<td>${requestScope.dto.bookRate}</td>
				<td>${requestScope.dto.bookSale}</td>
			</tr>
		</table>
		<div style="text-align: right;">
			<a class="btn btn-primary" href="update.iu?bookNum=${dto.bookNum}">수정</a>
			<a class="btn btn-primary" href="delete.iu?bookNum=${dto.bookNum}">삭제</a>
			<a class="btn btn-primary" href="./list.iu">목록</a>

			<c:if test="${not empty sessionScope.success }">
				<a class="btn btn-primary"
					href="../bankaccount/add.iu?bookNum=${dto.bookNum}">가입하기</a>
			</c:if>
		</div>

		<!-- Comment -->
		<div class="row">
			<div class="mb-3">
				<label for="writer" class="form-label">USERNAME</label>
				<input type="text" class="form-control" id="writer">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">COMMENT</label>
				<textarea class="form-control" id="contents" rows="3"></textarea>
			</div>
			<div class="mb-3">
				<button type="button" class="btn btn-primary" id="btn" data-booknum="${dto.bookNum}">댓글등록</button>
			</div>
		</div>

		<!-- Comment 출력 -->
		<div>
			<table id="commentList" class="table table-striped">

			</table>
		</div>
		<button id="more" class="btn btn-primary">더보기</button>

		<div>
			<button type="button" class="btn btn-primary" style="display: none;" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo" id="up">수정</button>
			
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
				<div class="modal-content">
				  <div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">댓글 수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				  </div>
				  <div class="modal-body">
					<form>
						<input type="hidden" id="num">
					  	<div class="mb-3">
							<label for="updateWriter" class="col-form-label">Writer:</label>
							<input type="text" class="form-control" id="updateWriter">
					  	</div>
					  	<div class="mb-3">
							<label for="updateContents" class="col-form-label">Contents:</label>
							<textarea class="form-control" id="updateContents"></textarea>
					  	</div>
					</form>
				  </div>
				  <div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="update">확인</button>
				  </div>
				</div>
			  </div>
			</div>
		</div>

	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>