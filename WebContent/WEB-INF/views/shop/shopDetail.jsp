<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세페이지</title>
	<!-- Bootstrap & css-->
	<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
	<style>
	.menubox {
		height: 200px;
	}
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>
	<div class="container" style="margin-top: 40px">
		<div class="col-lg-6 ps-5">
			<div class="row">
				<h1>매장명</h1>
			</div>
		</div>
		<br>
		<div id="carouselExampleSlidesOnly" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container-lg">
		<div class="row row-cols-1 row-cols-lg-2 g-4">
			<div class="col-lg-6 ps-5">
				<div class="row">
					<h5>매장정보</h5>
					<p class="ps-5 lh-1">전화번호 : 000-0000-0000</p>
					<p class="ps-5 lh-1">주소 : 서울특별시 종로구</p>
					<p class="ps-5 lh-1">대표자명 : 김길동</p>
					<p class="ps-5 lh-1">사업자등록번호 : 000-00-00000</p>
				</div>
			</div>
			<div class="col-lg-6 ps-5">
				<div class="row">
					<h5>매장소개</h5>
					<p class="ps-5 lh-1">안녕하세요. 맛집입니다.</p>
				</div>
			</div>
			<div class="col-lg-6 ps-5">
				<div class="row">
					<h5>영업시간</h5>
					<p class="ps-5 lh-1">월요일 ~ 금요일 9:00 ~ 21:00</p>
				</div>
			</div>
			<div class="col-lg-6 ps-5">
				<div class="row">
					<h5>원산지 정보</h5>
					<p class="ps-5 lh-1">사장님: 국내산, 쌀: 국내산, 돼지고기: 스페인산</p>
				</div>
			</div>
		</div>
		<br> <br>
		<!-- 메뉴 탭 start -->
		<div class="d-flex bd-highlight mb-3">
			<div class="p-2 bd-highlight">
				<button type="button" class="btn btn-outline-dark">추천메뉴</button>
			</div>
			<div class="p-2 bd-highlight">
				<button type="button" class="btn btn-outline-dark">전체메뉴</button>
			</div>
			<div class="ms-auto p-2 bd-highlight">
				<button type="button" class="btn btn-outline-dark">리뷰</button>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-lg">
				<div class="card m-4">
					<div class="row p-4">
						<div class="col-9">
							<h5>싱글세트</h5>
							<p>14,000원</p>
							<a href="#">장바구니 담기</a>
						</div>
						<div class="col-3">
							<img class="w-100"
								src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
								alt="메뉴 이미지">
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg">
				<div class="card m-4">
					<div class="row p-4">
						<div class="col-9">
							<h5>싱글세트</h5>
							<p>14,000원</p>
							<a href="#">장바구니 담기</a>
						</div>
						<div class="col-3">
							<img class="w-100"
								src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
								alt="메뉴 이미지">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg">
				<div class="card m-4">
					<div class="row p-4">
						<div class="col-9">
							<h5>싱글세트</h5>
							<p>14,000원</p>
							<a href="#">장바구니 담기</a>
						</div>
						<div class="col-3">
							<img class="w-100"
								src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
								alt="메뉴 이미지">
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg">
				<div class="card m-4">
					<div class="row p-4">
						<div class="col-9">
							<h5>싱글세트</h5>
							<p>14,000원</p>
							<a href="#">장바구니 담기</a>
						</div>
						<div class="col-3">
							<img class="w-100"
								src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
								alt="메뉴 이미지">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-lg">
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">리뷰작성</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3"></textarea>
		</div>
	</div>
	<div class="container-lg">
		<hr>
		<div class="row mt-0">
		
			<div class="col-lg-6 pe-1">
				<div class="row">
					<img class="me-3 py-1" style="border-radius: 50px; max-height: 250px;" src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" alt="">
				</div>
			</div>
			<div class="col-lg-6 ps-1">
				<div class="row">
					<div class="ms-3 py-1" style="border: 1px solid black; height: 220px; width: 95%; text-align: center">내용</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>