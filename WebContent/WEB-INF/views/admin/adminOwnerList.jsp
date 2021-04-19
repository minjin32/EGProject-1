<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 관리</title>
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
				<%@ include file="/WEB-INF/views/admin/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>사업자관리</h1>
				</div>
				<form action="/admin/owner/search">
					<a href="/admin/owner/search"><button type="submit"
							class="btn btn-primary mx-1" style="float: right;">검색</button></a> <input
						type="text" name="searchKeyword" class="form-control mx-1"
						style="float: right; width: 200px;" placeholder="검색어">
				</form>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">사업자아이디</th>
							<th scope="col" style="text-align: center;">닉네임</th>
							<th scope="col">가입일</th>
						</tr>
					</thead>
					<tbody>
					<% for(Member m : mList) { %>
						<tr style="cursor: pointer;">
							<th scope="row"><%= m.getMbNo() %></th>
							<td><%= m.getMbId() %></td>
							<td class="td-title"><%= m.getMbNickname() %></td>
							<td><%= m.getMbJoindate() %></td>
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
					<a href="/mypage/qna/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">승인하기</button></a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>