<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>스토어 영업중</title>
	<!-- Bootstrap & css-->
	<link href="/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- Bootstrap & css end -->
<style>
	.menubox {
		height: 200px;
	}
	
	.list-group-item {
		height: 120px;
	}
	.list-group-item.active {
		background-color: #605759;
		border-color: #605759;
	}
</style>
<script>
	window.addEventListener("DOMContentLoaded", function() {
		
		// 메인 탭 토글
		var mainTabs = document.getElementsByClassName("toggle-main-tab");
		var mainViews = document.getElementsByClassName("toggle-main-view");
		for (var i = 0; i < mainTabs.length; i ++) {
			mainTabs[i].addEventListener('click', toggleMainTabs);
		}
		function toggleMainTabs() {
			for (var i = 0; i < mainViews.length; i ++) {
				mainViews[i].style.display = "none";
				if (mainTabs[i] == this) {
					mainViews[i].style.display = "";
				}
			}
		};
		
		// 메뉴 탭 토글 (추천메뉴 <-> 전체메뉴)
		var menuTabs = document.getElementsByClassName("toggle-menu-tab");
		var menuViews = document.getElementsByClassName("toggle-menu-view");
		for (var i = 0; i < menuTabs.length; i ++) {
			menuTabs[i].addEventListener("click", toggleMenuTabs);
		}
		function toggleMenuTabs() {
			for (var i = 0; i < menuViews.length; i ++) {
				menuViews[i].style.display = "none";
				if (menuTabs[i] == this) {
					menuViews[i].style.display = "";
				}
			}
		} 
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="nav" style="height: 3rem; background-color: #605759;">
		<ul class="nav container tab-content">
			<li class="nav-item">
				<a class="nav-link toggle-main-tab" href="#" style="color:white;">주문 접수</a>
			</li>
			<li class="nav-item">
				<a class="nav-link toggle-main-tab" href="#" style="color:white;">매장 관리</a>
			</li>
		</ul>
	</div>
	
	<div class="container-lg">
		<div class="toggle-main-view" style="display: none;"><!-- 매장관리 start -->
			<div class="row mt-4">
				<div class="col-lg-6 ps-5">
					<div class="row">
						<h5>매장명</h5>
						<p class="ps-5 lh-1">맛집</p>
					</div>
					<div class="row">
						<h5>매장정보</h5>
						<p class="ps-5 lh-1">전화번호 : 000-0000-0000</p>
						<p class="ps-5 lh-1">주소 : 서울특별시 종로구</p>
						<p class="ps-5 lh-1">대표자명 : 김길동</p>
						<p class="ps-5 lh-1">사업자등록번호 : 000-00-00000</p>
					</div>
					<div class="row">
						<h5>영업시간</h5>
						<p class="ps-5 lh-1">월요일 ~ 금요일 9:00 ~ 21:00</p>
					</div>
					<div class="row">
						<h5>매장소개</h5>
						<p class="ps-5 lh-1">안녕하세요. 맛집입니다.</p>
					</div>
					<div class="row">
						<h5>원산지 정보</h5>
						<p class="ps-5 lh-1">사장님: 국내산, 쌀: 국내산, 돼지고기: 스페인산</p>
					</div>
				</div>
				<div class="col-lg-6 pe-5">
					<div class="row">
						<h5>매장 메인사진</h5>
					</div>
					<div class="row pe-5">
						<img class="ms-5 py-2" style="border-radius: 50px; max-height: 200px;" src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" alt="">
						<img class="ms-5 py-2" style="border-radius: 50px; max-height: 200px;" src="<%=request.getContextPath()%>/files/images/sample-horizontal.jpg" alt="">
					</div>
				</div>
			</div>
			
			<br>
			
			<!-- 메뉴 탭 start -->
			<div class="d-flex ">
				<div class="px-4 d-flex justify-content-start toggle-menu-tab"><a href="#">추천메뉴</a></div>
				<div class="px-4 d-flex justify-content-start toggle-menu-tab"><a href="#">전체메뉴</a></div>
			</div>
			<hr>
			<!-- 메뉴 탭 end -->
			
			
			<div class="toggle-menu-view"><!-- 추천메뉴 영역 start -->
				<div class="row">
					<div class="col-lg">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>추천메뉴세트</h5>
									<p>30,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>추천메뉴세트</h5>
									<p>30,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg">
						<div class="card m-4 box-menu">
							<div class="row p-4">
								<div class="col-9">
									<h5>추천메뉴세트</h5>
									<p>30,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg">
						<div class="card m-4 box-menu">
							<div class="row p-4">
								<img class="rounded mx-auto d-block" style="width: 25%;" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴추가">
							</div>
						</div>
					</div>
				</div>
			</div><!-- 추천메뉴 영역 end -->
			<div class="toggle-menu-view" style="display: none;"><!-- 전체메뉴 영역 start -->
				<div class="row">
					<div class="col-lg">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>전체메뉴세트</h5>
									<p>14,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>전체메뉴세트</h5>
									<p>14,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg">
						<div class="card m-4 box-menu">
							<div class="row p-4">
								<div class="col-9">
									<h5>전체메뉴세트</h5>
									<p>14,000원</p>
									<a href="#">장바구니 담기</a>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg">
						<div class="card m-4 box-menu">
							<div class="row p-4">
								<img class="rounded mx-auto d-block" style="width: 25%;" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴추가">
							</div>
						</div>
					</div>
				</div>
			</div><!-- 전체메뉴 영역 end -->
		</div><!-- 매장관리 end -->
		
		
		<div class="row toggle-main-view"><!-- 주문접수 start -->
		<div class="row d-lg-none d-block py-3"><!-- 모바일 탭 start -->
			<div class="row d-flex justify-content-around align-items-center mx-auto">
					<input type="button" class="btn btn-primary col" value="접수대기" style="border: 1px solid gray;">
					<input type="button" class="btn btn-primary col" value="처리중" style="border: 1px solid gray;">
					<input type="button" class="btn btn-primary col" value="완료" style="border: 1px solid gray;">
					<input type="button" class="btn btn-primary col" value="전체" style="border: 1px solid gray;">
			</div>
		</div><!-- 모바일 탭 end -->
		
			
			<div class="col-lg-3 pt-4 d-none d-lg-block"><!-- PC 탭 start -->
				<div class="list-group" id="list-tab" role="tablist">
			    	<div class="list-group-item list-group-item-action active" id="list-order-waiting-list" data-bs-toggle="list" href="#list-order-waiting" role="tab" aria-controls="order-waiting">
			    		<div class="row d-flex justify-content-center align-items-center" style="height: 100%;">
			    			<div class="col-8">
			    				<h3>접수대기</h3>
			    			</div>
			    			<div class="col-4">
			    				<h1>3</h1>
			    			</div>
			    		</div>
			    	</div>
			    	<div class="list-group-item list-group-item-action" id="list-order-progressing-list" data-bs-toggle="list" href="#list-order-progressing" role="tab" aria-controls="order-progressing">
			    		<div class="row d-flex justify-content-center align-items-center" style="height: 100%;">
			    			<div class="col-8">
			    				<h3>처리중</h3>
			    			</div>
			    			<div class="col-4">
			    				<h1>5</h1>
			    			</div>
			    		</div>
			    	</div>
			    	<div class="list-group-item list-group-item-action" id="list-order-completed-list" data-bs-toggle="list" href="#list-order-completed" role="tab" aria-controls="order-completed">
			    		<div class="row d-flex justify-content-center align-items-center" style="height: 100%;">
			    			<div class="col-8">
			    				<h3>완료</h3>
			    			</div>
			    			<div class="col-4">
			    				<h1>20</h1>
			    			</div>
			    		</div>
			    	</div>
			    	<div class="list-group-item list-group-item-action" id="list-order-all-list" data-bs-toggle="list" href="#list-order-all" role="tab" aria-controls="order-all">
			    		<div class="row d-flex justify-content-center align-items-center" style="height: 100%;">
			    			<div class="col-8">
			    				<h3>전체</h3>
			    			</div>
			    			<div class="col-4">
			    				<h1>28</h1>
			    			</div>
			    		</div>
			    	</div>
			    </div>
			</div><!-- PC 탭 end -->
			
			<div class="col-lg-9 pt-4">
				<div class="tab-content" id="nav-tabContent">
			    	<div class="tab-pane fade show active" id="list-order-waiting" role="tabpanel" aria-labelledby="list-order-home-list">
						<div class="row"><!-- 주문내역 시작 -->
							<div class="col-3 d-flex justify-content-center align-items-center">
								<h1>00 : 00</h1>
							</div>
							<div class="col-6">
								<h5>[메뉴 6개] 18,000원</h5>
								<p>김치찌개 1개 / 된장찌개 2개 / 공기밥 x 3</p>
								<h5>[요청사항]</h5>
								<p>김치찌개 안 맵게 해주세요.</p>
								<h5>[연락처]</h5>
								<p>010-0000-0000</p>
							</div>
							<div class="col-3">
								<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="접수하기">
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-3 d-flex justify-content-center align-items-center">
								<h1>00 : 00</h1>
							</div>
							<div class="col-6">
								<h5>[메뉴 6개] 18,000원</h5>
								<p>김치찌개 1개 / 된장찌개 2개 / 공기밥 x 3</p>
								<h5>[요청사항]</h5>
								<p>김치찌개 안 맵게 해주세요.</p>
								<h5>[연락처]</h5>
								<p>010-0000-0000</p>
							</div>
							<div class="col-3">
								<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="접수하기">
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-3 d-flex justify-content-center align-items-center">
								<h1>00 : 00</h1>
							</div>
							<div class="col-6">
								<h5>[메뉴 6개] 18,000원</h5>
								<p>김치찌개 1개 / 된장찌개 2개 / 공기밥 x 3</p>
								<h5>[요청사항]</h5>
								<p>김치찌개 안 맵게 해주세요.</p>
								<h5>[연락처]</h5>
								<p>010-0000-0000</p>
							</div>
							<div class="col-3">
								<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="접수하기">
							</div>
						</div>
					</div>
			    	<div class="tab-pane fade" id="list-order-progressing" role="tabpanel" aria-labelledby="list-order-progressing-list">처리중</div>
			    	<div class="tab-pane fade" id="list-order-completed" role="tabpanel" aria-labelledby="list-order-completed-list">완료</div>
			    	<div class="tab-pane fade" id="list-order-all" role="tabpanel" aria-labelledby="list-order-all-list">전체</div>
			    	<div class="row mt-4">
			    		<input type="button" class="btn btn-primary mx-auto" value="더 불러오기" style="width: 97.5%;">
			    	</div>
			    	
			    </div>
			</div>
		</div><!-- 주문접수 end -->
		
	</div><!-- container -->
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>