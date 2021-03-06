<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Board board = (Board) request.getAttribute("board");
	Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에코게시판 - EGProject</title>
<!-- Bootstrap & css-->
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
</head>
<body>
	<!-- navi -->
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/eco/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div>
					<h2 class="pb-2">에코게시판</h2>
					<form class="p-4"
						style="border: 1px solid #789F6F; border-radius: 5px;">
						<div class="mb-3">
							<div class="row">
								<div class="col">
									<b>작성자 </b> <span><%= board.getMemberId() %></span>
								</div>
								<div class="col gap-2 d-md-flex justify-content-md-end">
									<b>작성일시 </b> <span>2021-04-16</span>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<p class="form-control"><%= board.getBoardTitle() %></p>
						</div>
						<div class="mb-3">
							<img class="img-fluid rounded mx-auto d-block"
								src="<%=request.getContextPath()%>/upload/<%= board.getImageName() %>"
								style="max-width: 100%;" alt="첨부이미지">
						</div>
						<div class="mb-3">
							<p class="form-control">
								<%= board.getBoardContent() %>
							</p>
						</div>
						<div class="gap-2 d-md-flex justify-content-md-end">
							<%
								if (member != null) {
									if (board.getMemberId() == session.getAttribute("memberId") || member.getMbType() == '9') {
							%>
							<a href="/eco/board/delete?boardNumber=<%= board.getBoardNo() %>"><button type="button" class="btn btn-danger">삭제</button></a>
							<a href="/eco/board/modify?boardNumber=<%= board.getBoardNo() %>"><button type="button" class="btn btn-primary">수정</button></a>
							<%
									}
								}
							%>
							<a href="/eco/board/list"><button type="button" class="btn btn-primary">목록</button></a>
						</div>
					</form>
				</div>
				<h4 class="mt-3 ps-2">댓글</h4>
				<div class="mt-2"><!-- 댓글 하나 start -->
				<!-- 
					<div class="row p-2">
						<div class="row">
							<div class="col-md-9">
								<b class="ms-4">김길동</b>
							</div>
							<div class="col-md-3">
								<p style="float: right;">2021-04-16 20:30:48</p>
							</div>
						</div>
						<div class="row ms-4">
							<div class="col-md-9">
								내가 그대를 만났다는건 어쩌면 흘러가는 흔한 인연이란 것일지 모르지만<br>
								오늘도 다시 또 다시 사랑해요.<br> 사랑 언제나 이번이 마지막이라며 처음인 듯 찾아오니까
							</div>
							<div class="col">
								<button type="button" class="btn btn-danger"
									style="float: right;">삭제</button>
							</div>
						</div>
					</div>
					 -->
				</div><!-- 댓글 하나 end -->
				
				<hr>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>