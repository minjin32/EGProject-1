<%@ page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="notice.model.vo.NoticeComment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Notice notice = (Notice) request.getAttribute("notice");
	Member member = (Member)session.getAttribute("member");
	ArrayList<NoticeComment> commentList = (ArrayList<NoticeComment>) request.getAttribute("commentList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - EGProject</title>
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
					<h2 class="pb-2">공지사항</h2>
					<form class="p-4"
						style="border: 1px solid #789F6F; border-radius: 5px;">
						<input type="hidden" name="noticeNo" value="<%=notice.getNoNo()%>">
						<div class="mb-3">
							<div class="row">
								<div class="col">
									<b>작성자 </b> <span><%=notice.getMbId()%></span>
								</div>
								<div class="col gap-2 d-md-flex justify-content-md-end">
									<b>작성일시 </b> <span><%=notice.getNoDatetime()%></span>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<p class="form-control"><%=notice.getNoTitle()%></p>
						</div>
						<div class="mb-3">
							<img class="img-fluid rounded mx-auto d-block"
								src="<%=request.getContextPath()%>/upload/<%= notice.getImageName() %>"
								;
								style="max-width: 100%;" alt="첨부이미지">
						</div>
						<div class="mb-3">
							<p class="form-control">
								<%=notice.getNoContent()%>
							</p>
						</div>
						<div class="gap-2 d-md-flex justify-content-md-end">
							<% 
								if (member != null && member.getMbType() == '9') {
							%>
							<a href="/eco/notice/delete?noticeNo=<%=notice.getNoNo()%>"><button type="button" class="btn btn-danger">삭제</button></a> 
							<a href="/eco/notice/update?noticeNo=<%=notice.getNoNo()%>"><button type="button" class="btn btn-primary">수정</button></a> 
							<%
								}
							%>
							<a href="/eco/notice/list"><button type="button" class="btn btn-primary">목록</button></a>
						</div>
					</form>
				</div>

				<h4 class="mt-3 ps-2">댓글</h4>
				<div class="mt-2">
					<!-- 댓글 입력 start -->
					<form action="/eco/notice/comment/write" method="POST">
					<input type="hidden" name="noticeNo" value="<%=notice.getNoNo()%>">
						<div class="row p-2">
							<div class="row">
								<div class="col-md-9">
									<b class="ms-4"> <!-- 김길동 -->
									</b>
								</div>
								<div class="col-md-3">
									<p style="float: right;">
										<!-- 2021-04-16 20:30:48 -->
									</p>
								</div>
							</div>
							<div class="row ms-4">
								<div class="mb-3">
									<textarea rows="3" class="form-control"
										placeholder="댓글을 입력하세요." name="comment"></textarea>
								</div>
								<div class="col">
									<button type="submit" class="btn btn-primary"
										style="float: right;">댓글등록</button>
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- 댓글 입력 end -->

				<!-- 댓글 하나 start -->
				<% for (NoticeComment comment : commentList) { %>
				<div class="mt-2 ps-5">
					<div class="row p-2"  style="border: 1px solid #0e2c01; border-radius:0.5em; moz-border-radius: 0.5em; webkit-border-radius: 0.5em;">
						<div class="row">
							<div class="col-md-9">
								<b class="ms-4">작성자<%=comment.getMemberId()%></b>
							</div>
							<div class="col-md-3">
								<p style="float: right;"><%=comment.getCoDatetime()%></p>
							</div>
						</div>
						<div class="row ms-4">
							<div class="col-md-9">
								<%=comment.getCoContent()%>
							</div>
							<div class="col">
								<button type="button" class="btn btn-danger"
									style="float: right;">삭제</button>
							</div>
						</div>
					</div>
				</div>
				<% } %>
				<!-- 댓글 하나 end -->
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>