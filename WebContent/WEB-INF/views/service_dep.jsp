<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서비스 - EGProject</title>
	<!-- Bootstrap & css-->
	<link href="./bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="content">
		<div>
			<img src="<%=request.getContextPath()%>/files/images/wireframe.jpg" style="max-height:520px" class="d-block w-100" alt="...">	
		</div>
	</div>
	<br>
	<div class="container-lg">
		<!--
		<div class="card-group">
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">1번 소제목 입니다.</h5>
					<p class="card-text">
						1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 
					</p>
				</div>
			</div>
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">2번 소제목 입니다.</h5>
					<p class="card-text">
						2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 
					</p>
				</div>
			</div>
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">3번 소제목 입니다.</h5>
					<p class="card-text">
						3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 
					</p>
				</div>
			</div>
		</div>
		 -->
		<div class="row row-cols-1 row-cols-md-3">
			<div class="col" style="padding: 60px;">
				<h5>1번 제목입니다.</h5>
				<p>1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. 1번 내용입니다. </p>
			</div>
			<div class="col" style="padding: 60px;">
				<h5>2번 제목입니다.</h5>
				<p>2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. 2번 내용입니다. </p>
			</div>
			<div class="col" style="padding: 60px;">
				<h5>3번 제목입니다.</h5>
				<p>3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. 3번 내용입니다. </p>
			</div>
		</div>
		<div class="row row-cols-1 row-cols-md-2">
			<div class="col" style="padding:60px;">
				<img src="<%=request.getContextPath()%>/files/images/wireframe.jpg" class="d-block w-100" style="max-height: 400px" alt="...">
			</div>
			<div class="col" style="padding:60px;">
				<div class="row align-items-center" style="padding:40px;">
					<h3>운영시간</h3>
					<br>
					<p>
						설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다.
					</p>
				</div>
				<div class="row align-items-center" style="padding:40px;">
					<h3>운영시간</h3>
					<br>
					<p>
						설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다.
					</p>
				</div>
			</div>
		</div>
		
	</div>
	
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>