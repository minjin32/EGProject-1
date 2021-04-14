<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA문의 기본페이지</title>
<link href="../bootstrap/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="container-lg">
	  <div class="row">
	      <div class="col-md-3 p-3"  align="center">
	          <ul class="list-group list-group-flush">
					<li style="list-style:none; font-size:30px">에코마당</li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">이벤트</a></li>
					<li class="list-group-item"><a href="/board/notice" style="text-decoration : none">공지사항</a></li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">에코게시판</a></li>
				</ul>
	      </div>
	        <div class="col-md-9 p-5">
      	<button type="button" class="btn btn-outline-success" style="float: right; margin-left: 5px;"">ID로 검색</button>
      	<input type="text" class="btn btn-outline-success" style="float: right; margin-left: 5px;"">
      	<button type="button" class="btn btn-outline-success" style="float: right">검색</button><br>
      	<table border="1px" class="table" style="margin-top: 30px">
			<tr>
				<th class="table-success" style="text-align:center; width:15%">번호</th>
				<th class="table-success" style="text-align:center; width:20%">작성자</th>
				<th class="table-success" style="text-align:center; width:50%">제목</th>
				<th class="table-success" style="text-align:center; width:15%">작성일</th>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr style="height:40px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</table>
			<form action="/board/noticewrite" method="get">
			<button type="submit" class="btn btn-outline-success" style="float: right">글쓰기</button>
			</form>
      	  </div>
	      	<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center" style="margin-left:250px">
       <li class="page-item disabled">
         <a class="page-link" href="#" tabindex="-1" aria-disabled="true">이전</a>
       </li>
       <li class="page-item"><a class="page-link" href="#">1</a></li>
       <li class="page-item"><a class="page-link" href="#">2</a></li>
       <li class="page-item"><a class="page-link" href="#">3</a></li>
       <li class="page-item"><a class="page-link" href="#">4</a></li>
       <li class="page-item"><a class="page-link" href="#">5</a></li>
       <li class="page-item">
         <a class="page-link" href="#">다음</a>
       </li>
       </ul>
   </nav>
	      </div>
      </div>
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>