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
<style>
body {
	background-color: #f7f5ed;
}

li.nav-item-1 {
	height: 50px;
	width: 100%;
	background-color: #e4e0d7;
	vertical-align: middle;
	margin-top: 1px; '
	margin-bottom: 1px;
	vertical-align: middle;
	margin-top: 1px;
	margin-top: 1px;
}

div.card-body {
	border: 1px;
	padding-top: 80px;
	padding-bottom: 80px;
	margin: 10px; text-align : center;
	vertical-align: middle;
	text-align: center;
	text-align: center;
}

img.icon {
	height: 100px;
	width: 100px;
	margin: 50px;
	float: left;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<!-- 메뉴 바 -->
	<div class="container" style="margin-top: 40px">
		<div class="row g-4">
			<div class="col-md-3">
				<ul class="me-2" style="list-style: none">
					<li class="nav-item"
						style="font-weight: bold; font-size: 30px; border-bottom: 2px solid #0e2c01; padding-bottom: 60px"><a
						class="nav-link active" href="/mypage">마이페이지</a></li>
					<li class="nav-item-1"><a class="nav-link" href="#">내 정보</a></li>
					<li class="nav-item-1"><a class="nav-link" href="/orderlist">주문
							내역</a></li>
					<li class="nav-item-1"><a class="nav-link" href="#">Q&A 문의</a></li>
					<div style="width: 30%; height: 500px"></div>
					<ul class="nav flex colum" style="font-size: 3px">회원탈퇴
					</ul>
				</ul>
			</div>


			<div class="col-md-9">
				<div class="card mb-3" style="width: 100%">
					<div class="row g-0">
						<div class="col-md-6">
							<div class="col-md-4">
								<img class="icon" src="/files/images/point.png" alt="포인트">
							</div>
							<div class="card-body">
								<div class="col-md-8">
									<h5 class="card-title">에코포인트</h5>
									<p class="card-text">250</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="col-md-4">
								<img class="icon" src="/files/images/rank.png" alt="순위">
							</div>
							<div class="card-body">
								<div class="col-md-8">
									<h5 class="card-title">순위</h5>
									<p class="card-text">7%</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- 			<div class="col-md-9"> -->
			<!-- 				<div class="row"> -->
			<!-- 					<ul class="list-group list-group-horizontal"> -->
			<!-- 						<img src="/files/images/user.png" class="img-thumbnail" -->
			<!-- 							style="border-color: white; height: 50px; width: 50px; margin-bottom: 10px; margin-right: 10px" -->
			<!-- 							"alt="사용자 아이콘" /> -->
			<!-- 						<h3>회원 님 안녕하세요!</h3> -->
			<!-- 					</ul> -->
			<!-- 				</div> -->
			<!-- 				<div class="row"> -->
			<!-- 					<ul class="list-group list-group-horizontal" -->
			<!-- 						style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center"> -->
			<!-- 						<div class="col-md-3"> -->
			<!-- 							<li class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								에코포인트 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">250</h1> -->
			<!-- 							</li> -->
			<!-- 						</div> -->
			<!-- 						<div class="col-md-3"> -->
			<!-- 							<li class="list-group-item" -->
			<!-- 								style="width: 100; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								순위 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">7%</h1> -->
			<!-- 							</li> -->
			<!-- 						</div> -->

			<!-- 						<div class="col-md-3"> -->
			<!-- 							<li class="list-group-item" -->
			<!-- 								style="width: 100; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								등급 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">열매</h1> -->
			<!-- 							</li> -->
			<!-- 						</div> -->

			<!-- 						<div class="col-md-3"> -->
			<!-- 							<li class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white">내가 -->
			<!-- 								심은 나무 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">7그루</h1> -->

			<!-- 							</li> -->
			<!-- 						</div> -->
			<!-- 					</ul> -->
			<!-- 				</div> -->
			<!-- 			</div> -->
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>