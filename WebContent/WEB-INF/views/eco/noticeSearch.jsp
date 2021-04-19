<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Notice> nList = (ArrayList<Notice>)request.getAttribute("nList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - EGProject</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style>
	.page-link {
		color: darkgreen;
	}
	
	.td-title {
		text-align: left !important;
	}
</style>
</head>
<body>
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="container-lg">
		<div class="row">
			
			<div class="col-lg-3 p-3" align="center">
				<!-- 서브 내비게이션 -->
				<%@ include file="/WEB-INF/views/eco/subnav.jsp"%>
			</div>

			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>공지사항</h1>
				</div>
				<div>
					<form href="/eco/notice/search" method="get"><button type="submit" class="btn btn-primary mx-1" style="float: right;">검색</button>
					<input type="text" class="form-control mx-1" style="float: right; width:200px;" placeholder="검색어" name="search-keyword"> 
					<select class="form-select mx-1" style="float: right; max-width: 100px;" aria-label="Default select example" name="search-option">
						<option selected>--</option>
						<option value="subject">제목</option>
						<option value="content">내용</option>
					</select>
					</form>
				</div>
				<table class="table" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<% for(Notice notice : nList) { %>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail?noticeNo=<%= notice.getNoticeNo() %>';">
							<th scope="row"><%= notice.getNoticeNo() %></th>
							<td class="td-title"><%= notice.getSubject() %></td>
							<td><%= notice.getRegDate() %></td>
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
					<a href="/eco/notice/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">글쓰기</button></a>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>