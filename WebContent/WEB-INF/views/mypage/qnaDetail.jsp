<%@page import="mypageqa.model.vo.MypageQaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	MypageQaData mypageQaData = (MypageQaData) request.getAttribute("mypageQaData");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA문의 상세</title>
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
				<%@ include file="/WEB-INF/views/admin/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div>
					<h2 class="pb-2">QnA</h2>
					<form class="p-4"
						style="border: 1px solid #789F6F; border-radius: 5px;">
						<div class="mb-3">
							<div class="row">
								<div class="col">
									<b>작성자 </b>
									<%=mypageQaData.getMbId()%>
								</div>
								<div class="col gap-2 d-md-flex justify-content-md-end">
									<b>작성일시 </b>
									<%=mypageQaData.getQaDateTime()%>
								</div>
							</div>
						</div>
						<div class="mb-3">
							제목 
							<p class="form-control"><%=mypageQaData.getQaTitle()%></p>
						</div>
						<div class="mb-3">
							내용
							<p class="form-control">
								<%=mypageQaData.getQaContent()%>
							</p>
						</div>
						<%
							if (mypageQaData.getImage_path() != null) {
						%>
						<div class="mb-3">
							<img class="img-fluid rounded mx-auto d-block"
								src="<%=request.getContextPath()%>/upload/<%=mypageQaData.getImage_name()%>"
								style="max-width: 100%;" alt="첨부이미지">
						</div>
						<%
							}
						%>
						<!-- TODO 작성자만 보여야 하는 버튼 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
						<!-- TODO 답변이 달리기 전에만 취소버튼이 나타남 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
<!-- 						<div class="gap-2 d-md-flex justify-content-md-end"> -->
<!-- 							<button type="reset" class="btn btn-primary">취소</button> -->
<!-- 						</div> -->
					</form>
					<div class="row mt-4">
						<div class="col-1">
							<img src="<%=request.getContextPath()%>/files/images/reply.png"
								style="width: 100%;" alt="답변">
						</div>
						<div class="col">
							<form class="p-4"
								style="border: 1px solid #789F6F; border-radius: 5px;">
								<div class="mb-3">
								<p class="form-control">RE:<%=mypageQaData.getQaTitle()%></p>
								</div>
								<!-- TODO 관리자만 보여야 하는 버튼 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
								<div class="mb-3">
									<%
										if (mypageQaData.isAnswered()) {
									%>
									<p class="form-control">
										<%= mypageQaData.getAnswerContent() %>
									</p>
									<%
										} else {
									%>
									<p class="form-control">
										답변 대기중입니다.
									</p>
									<%
										}
									%>
								</div>
								<div class="gap-2 d-md-flex justify-content-md-end">
									<a href="/mypage/qna/list"><button type="button" class="btn btn-primary">뒤로</button></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>