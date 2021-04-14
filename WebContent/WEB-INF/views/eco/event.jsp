<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에코마당 - EGProject</title>
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
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp"%>



	<div class="container-lg">
		<div class="row">
			<div class="col-md-3" align="center">
				<ul class="list-group list-group-flush">
					<li style="list-style: none; font-size: 30px">에코마당</li>
					<li class="list-group-item"><a href="/board/event"
						style="text-decoration: none">이벤트</a></li>
					<li class="list-group-item"><a href="/board/notice"
						style="text-decoration: none">공지사항</a></li>
					<li class="list-group-item"><a href="#"
						style="text-decoration: none">에코게시판</a></li>
				</ul>

			</div>
			<div class="col-md-6" style="margin-light: 200px; margin-top: 100px">
				<a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">이벤트페이지1</h4>
					<p class="list-group-item-text">...</p>
				</a> <br> <a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">이벤트페이지2</h4>
					<p class="list-group-item-text">...</p>
				</a><br> <a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">이벤트페이지3</h4>
					<p class="list-group-item-text">...</p>
				</a><br> <a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">이벤트페이지4</h4>
					<p class="list-group-item-text">...</p>
				</a><br> <a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">이벤트페이지5</h4>
					<p class="list-group-item-text">...</p>
				</a><br>
			</div>
		</div>

		<!-- footer -->
		<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>