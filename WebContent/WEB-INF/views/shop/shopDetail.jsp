<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세페이지</title>
	<!-- Bootstrap & css-->
	<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
	</div>
	<div class="container">
		<div class="row">
			<div class="col">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"	data-toggle="tab" href="#recMenu">추천메뉴</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#menuAll">전체메뉴</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#review">리뷰</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="recMenu">
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
					<div class="tab-pane fade" id="menuAll">
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
					<div class="tab-pane fade" id="review">
						<div class="container-lg">
								<div class="member">
	      							<table border="0" width="100%" cellspacing="0" cellpadding="0" class="info_bg" style="table-layout:fixed;padding:0 0 0 0">
<!--     	       							<tbody> -->
    	       								<tr valign="top">
						                        <td class="info_bg" width="6px"></td>
						                        <td class="separator2" width="3px"></td>
						                        <td width="3px"></td>
						                        <td style=" padding:2px 4px 4px 5px;word-break:break-all;">
						                            
						                        <b>회원 ID</b>
						                        
						                        <div id="commentContent_1977088" class="over_hide link-point" style="position:relative;overflow:hidden;width:100%;padding:4px 0 0 0;color:#000;min-height: 40px;line-height: 18px;">
					                                존맛탱 족발은 무조건 여기서밖에 안먹음<br>
					                          		담주에 또 시킬게요~<br>
					                            </div>
					                            <div class="mt8 over_hide">
					                                <font class="eng-day" title="">12:01:30</font>
					                                <span class="comment-btn-layout">
					                               </span>
                            					</div>
                            					<nav class="navbar navbar-dark bg-dark">
												  <div class="container-fluid">
												    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
												      <span class="navbar-toggler-icon"></span>
												    </button>
												  </div>
												</nav>
												<div class="collapse" id="navbarToggleExternalContent">
												  <div class="bg-dark p-4">
												    <h5 class="text-white h4">Collapsed content</h5>
												    <span class="text-muted">이미지 넣어야하구 색깔도 바꿔야해</span>
												  </div>
												</div>
<!--     	       							</tbody> -->
    	       						</table>
    	       						<p style="border-bottom:1px solid #efefef;"></p>
								</div>
								<div class="Entrepreneur">
	      							<table border="0" width="100%" cellspacing="0" cellpadding="0" class="info_bg" style="table-layout:fixed;padding:0 0 0 0">
<!--     	       							<tbody> -->
    	       								<tr valign="top">
						                        <td width="100px" align="right" style="padding:0 0 0 0">
						                        <img class="w-100"
													src="<%=request.getContextPath()%>/files/images/earth.jpg" alt="답글 이미지">
												</td>
						                        <td class="info_bg" width="6px"></td>
						                        <td class="separator2" width="3px"></td>
						                        <td width="3px"></td>
						                        <td style=" padding:2px 4px 4px 5px;word-break:break-all;">
						                            
						                        <b>사장님 댓글</b>
						                        
						                        <div id="commentContent_1977088" class="over_hide link-point" style="position:relative;overflow:hidden;width:100%;padding:4px 0 0 0;color:#000;min-height: 40px;line-height: 18px;">
					                                감사합니다 고객님.<br>
					                          		앞으로도 좋은 음식으로 보답하겠습니다.<br>
					                            </div>
					                            <div class="mt8 over_hide">
					                                <font class="eng-day" title="">12:01:30</font>
					                                <span class="comment-btn-layout">
					                               </span>
                            					</div>
<!--     	       							</tbody> -->
    	       						</table>
    	       						<p style="border-bottom:1px solid #efefef;"></p>
								</div>
							</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>