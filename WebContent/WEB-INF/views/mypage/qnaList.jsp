<%@page import="java.util.ArrayList"%>
<%@page import="mypageqa.model.vo.MypageQaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MypageQaData> mqList = (ArrayList<MypageQaData>)request.getAttribute("mqList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
</head>
<style>
.page-link {
	color: darkgreen;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>QnA</h1>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">작성자</th>
							<th scope="col" style="text-align: center;">제목</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<% for (MypageQaData qa : mqList) { %>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail?qaNumber=<%= qa.getQaNo() %>';">
							<th scope="row"><%= qa.getQaNo() %></th>
							<td><%= qa.getMbId() %></td>
							<td class="td-title"><%= qa.getQaTitle() %></td>
							<td><%= qa.getQaDateTime() %></td>
						</tr>
						<% } %>
					</tbody>
				</table>
				<div class="row">
					<div class="mx-auto" style="width: 300px;">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">4</a></li>
							<li class="page-item"><a class="page-link" href="#">5</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</div>
				</div>
				<div>
					<a href="/mypage/qna/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">문의하기</button></a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>