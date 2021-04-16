<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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
	<%@ include file="/WEB-INF/views/nav.jsp"%>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			
			<div class="col-lg-9 p-5">
				<div class="row">
					<div class="list-group list-group-horizontal">
						<img src="/files/images/user.png" class="img-thumbnail" style="border-color: white; height: 50px; width: 50px; margin-bottom: 10px; margin-right: 10px" alt="사용자 아이콘" />
						<h3 class="pt-2">김길동님 안녕하세요!</h3>
					</div>
				</div>
				<div class="row p-4" style="border: 4px solid #0e2c01; border-radius: 24px;">
					<div class="row">
						<div class="col-3" align="center">
							<h3>에코포인트</h3>
						</div>
						<div class="col-3" align="center">
							<h3>순위</h3>
						</div>
						<div class="col-3" align="center">
							<h3>등급</h3>
						</div>
						<div class="col-3" align="center">
							<h3>내가 심은 나무</h3>
						</div>
					</div>
					<div class="row pt-4">
						<div class="col-3" align="center">
							<h2>2000</h2>
						</div>
						<div class="col-3" align="center">
							<h2>상위 7%</h2>
						</div>
						<div class="col-3" align="center">
							<h2>5</h2>
						</div>
						<div class="col-3" align="center">
							<h2>7그루</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>