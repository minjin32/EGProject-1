<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
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
				<ul class="list-group list-group-horizontal">
					<div class="card mb-3" style="width: 80%">
						<div class="row g-0">
							<div class="card-body" style="float: left">
								<img src="/files/images/dumpling.jpg"
									style="height: 100px; margin: 20px; float: left" alt="군만두" />
								<h5 class="card-title" style="margin-top: 20px">군만두
									A세트(야채군만두+콜라1.25리터)</h5>
								<p class="card-text">짭짤이만두</p>
								<p class="card-text" style="float: left">15000원</p>
								<p class="card-text" style="text-align: right">
									<small class="text-muted">2021.4.13 19:30</small>
								</p>
							</div>
						</div>
					</div>
					<div class="card-body-right" style="margin-left: 20px">
						<button type="button" class="btn btn-outline-success"
							style="height: 90%; width: 150px;">주문취소</button>
					</div>
				</ul>

				<br>

				<ul class="list-group list-group-horizontal">
					<div class="card mb-3" style="width: 80%">
						<div class="row g-0">
							<div class="card-body" style="float: left">
								<img src="/files/images/dumpling.jpg"
									style="height: 100px; margin: 20px; float: left" alt="군만두" />
								<h5 class="card-title" style="margin-top: 20px">군만두
									A세트(야채군만두+콜라1.25리터)</h5>
								<p class="card-text">짭짤이만두</p>
								<p class="card-text" style="float: left">15000원</p>
								<p class="card-text" style="text-align: right">
									<small class="text-muted">2021.4.13 19:30</small>
								</p>
							</div>
						</div>
					</div>
					<div class="card-body-right" style="margin-left: 20px">
						<button type="button" class="btn btn-outline-success"
							style="height: 90%; width: 150px;">주문취소</button>
					</div>
				</ul>

				<br>

				<ul class="list-group list-group-horizontal">
					<div class="card mb-3" style="width: 80%">
						<div class="row g-0">
							<div class="card-body" style="float: left">
								<img src="/files/images/dumpling.jpg"
									style="height: 100px; margin: 20px; float: left" alt="군만두" />
								<h5 class="card-title" style="margin-top: 20px">군만두
									A세트(야채군만두+콜라1.25리터)</h5>
								<p class="card-text">짭짤이만두</p>
								<p class="card-text" style="float: left">15000원</p>
								<p class="card-text" style="text-align: right">
									<small class="text-muted">2021.4.13 19:30</small>
								</p>
							</div>
						</div>
					</div>
					<div class="card-body-right" style="margin-left: 20px">
						<button type="button" class="btn btn-outline-success"
							style="height: 90%; width: 150px;">주문취소</button>
					</div>
				</ul>

			</div>


		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>