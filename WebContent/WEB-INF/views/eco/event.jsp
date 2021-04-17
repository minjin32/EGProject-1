<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에코마당 - EGProject</title>
<!-- Bootstrap & css-->
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
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
					<h1>이벤트</h1>
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
				<div class="row">
					<div class="row">
						<img src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" style="width:700px; height:200px;" alt="이벤트이미지">
					</div>
				</div>
				<div class="row">
					<button class="btn btn-primary mt-4 mx-auto" style="max-width: 320px;">더 불러오기</button>
				</div>
				<div>
					<a href="/eco/event/write"><button type="button" class="btn btn-primary mx-1 mt-5" style="float: right;">글쓰기</button></a>
				</div>
			</div>
		</div>
	</div>

		<!-- footer -->
		<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>