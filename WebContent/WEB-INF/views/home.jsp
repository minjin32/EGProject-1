<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 - EGProject</title>
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

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="<%=request.getContextPath()%>/files/images/main1.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="<%=request.getContextPath()%>/files/images/main22.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="<%=request.getContextPath()%>/files/images/main3.jpg"
					class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<br>
	<div class="container-lg">
		<div class="row row-cols-1 row-cols-lg-2 g-4">
			<div class="col">
				<img class="rounded"
					src="<%=request.getContextPath()%>/files/images/mid2.jpg"
					alt="메인 이미지" width="100%">
			</div>
			<div class="col">
				<img class="rounded"
					src="<%=request.getContextPath()%>/files/images/mid1.jpg"
					alt="메인 이미지" width="100%">
			</div>
			<div class="col intro-img-grid g-0">
				<div class="row" align="center">
					<h2>이미지 리뷰</h2>
				</div>
				<div class="row">
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food1.png"
							class=" d-bloc0k w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food2.png"
							class=" d-block w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food3.png"
							class=" d-block w-100">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food4.png"
							class=" d-block w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food5.png"
							class=" d-block w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food6.png"
							class=" d-block w-100">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food7.png"
							class=" d-block w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food8.png"
							class=" d-block w-100">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food9.png"
							class=" d-block w-100">
					</div>
				</div>
			</div>
			<div class="col">
				<img class="rounded"
					src="<%=request.getContextPath()%>/files/images/mid3-001.jpg"
					alt="메인 이미지" width="100%">
			</div>
		</div>
	</div>

	<br>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>