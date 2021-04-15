<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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

	<!-- 메뉴 바 -->
	<div class="container" style="margin-top: 40px">
		<div class="row g-4">
			<div class="col-md-3">
				<ul class="me-2"
					style="border-right: 1px solid #D1E9CA; list-style: none">
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link active" href="/admin">관리자 홈</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="#">회원 관리</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="#">사업자 관리</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="#">Q&A 문의</a></li>
					<div style="width: 30%; height: 500px"></div>
				</ul>
			</div>

<!-- 			<div class="col-md-9"> -->
<!-- 				<div class="card mb-3" style="max-width: 540px;"> -->
<!-- 					<div class="row g-0"> -->
<!-- 						<div class="col-md-4"> -->
<!-- 							<img src="..." alt="..."> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-8"> -->
<!-- 							<div class="card-body"> -->
<!-- 								<h5 class="card-title">Card title</h5> -->
<!-- 								<p class="card-text">This is a wider card with supporting -->
<!-- 									text below as a natural lead-in to additional content. This -->
<!-- 									content is a little bit longer.</p> -->
<!-- 								<p class="card-text"> -->
<!-- 									<small class="text-muted">Last updated 3 mins ago</small> -->
<!-- 								</p> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 			</div> -->


			<div class="col-md-9">
				<div class="row">
					<div class="card border-success mb-3"
						style="max-width: 40%; text-align: center; margin:10px">
						<div class="card-header">사업자 등록 인증 요청</div>
						<div class="card-body text-success">
							<h1 class="display-6" style="margin-top: 15px">8</h1>
						</div>
					</div>
					<div class="card border-success mb-3"
						style="max-width: 40%; text-align: center;  margin:10px">
						<div class="card-header">1:1 문의</div>
						<div class="card-body text-success">
							<h1 class="display-6" style="margin-top: 15px">16</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card border-success mb-3"
						style="max-width: 40%; text-align: center;  margin:10px">
						<div class="card-header">누적 방문자 수</div>
						<div class="card-body text-success">
							<h1 class="display-6" style="margin-top: 15px">12K</h1>
						</div>
					</div>
					<div class="card border-success mb-3"
						style="max-width: 40%; text-align: center;  margin:10px">
						<div class="card-header">신규 가입</div>
						<div class="card-body text-success">
							<h1 class="display-6" style="margin-top: 15px">50</h1>
						</div>
					</div>
				</div>
			</div>


			<!-- 			<div class="col-md-9"> -->
			<!-- 				<div class="row"> -->
			<!-- 					<div class="col-md-6"> -->
			<!-- 						<div class="card mb-3 p-4" -->
			<!-- 							style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center"> -->
			<!-- 							<div class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								사업자 등록 인증 요청 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">8</h1> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 					<div class="col-md-6"> -->
			<!-- 						<div class="card mb-3 p-4" -->
			<!-- 							style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center"> -->
			<!-- 							<div class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								1:1 문의 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">16</h1> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

			<!-- 			<div class="col-md-9"> -->
			<!-- 				<div class="row"> -->
			<!-- 					<div class="col-md-6"> -->
			<!-- 						<div class="card mb-3 p-4" -->
			<!-- 							style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center"> -->
			<!-- 							<div class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								누적 방문자 수 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">12K</h1> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 					<div class="col-md-6"> -->
			<!-- 						<div class="card mb-3 p-4" -->
			<!-- 							style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center"> -->
			<!-- 							<div class="list-group-item" -->
			<!-- 								style="width: 100%; height: 100px; margin-top: 40px; text-align: center; border-color: white"> -->
			<!-- 								신규 가입 -->
			<!-- 								<h1 class="display-6" style="margin-top: 15px">250</h1> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</div> -->


		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>