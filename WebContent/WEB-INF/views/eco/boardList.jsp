<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.model.vo.BoardPageData"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
	String pageNav = (String)request.getAttribute("pageNav");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<title>에코게시판</title>
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
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			
			<div class="col-lg-3 p-3" align="center">
				<!-- 서브 내비게이션 -->
				<%@ include file="/WEB-INF/views/eco/subnav.jsp"%>
			</div>

			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>에코게시판</h1>
				</div>
				<div>
					<a href="#"><button type="button" class="btn btn-primary mx-1" style="float: right;">검색</button></a>
					<input type="text" class="form-control mx-1" style="float: right; width:200px;" placeholder="검색어"> 
					<select class="form-select mx-1" style="float: right; max-width: 100px;" aria-label="Default select example">
						<option selected>--</option>
						<option value="1">제목</option>
						<option value="2">작성자</option>
						<option value="3">내용</option>
					</select>
				</div>
				<table class="table" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">작성자</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (boardList != null) {
							for (Board board : boardList) {
						%>
						<tr style="cursor: pointer;" onclick="window.location='/eco/board/detail?boardNumber=<%= board.getBoardNo() %>';">
							<th scope="row"><%= board.getBoardNo() %></th>
							<td><%= board.getMemberId() %></td>
							<td class="td-title"><%= board.getBoardTitle() %></td>
							<td><%= dateFormat.format(board.getBoardDate()) %></td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
				<div class="row">
					<div class="mx-auto" style="width: 300px;">
						<ul class="pagination">
							<%= pageNav %>
						</ul>
					</div>
				</div>
				<div>
					<a href="/eco/board/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">글쓰기</button></a>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>