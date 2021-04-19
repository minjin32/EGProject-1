<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="orderlist.model.vo.OrderList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<OrderList> orderList = (ArrayList<OrderList>) request.getAttribute("orderList");
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일 ");
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
%>
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
	.btn-secondary {
		background-color: lightgray;
		color: black;
		width: 100%;
	}

	.list-group-item {
		height: 120px;
	}
	.list-group-item.active {
		background-color: #605759;
		border-color: #605759;
	}

	.menubox {
		height: 200px;
	}
	
	.modal-header {
		background-color: #605759;
		color: white;
	}
	
	.nav{
		height:100%;
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
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="modal fade" id="modal-accept" tabindex="-1"><!-- 주문 모달 start -->
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-accept-label">접수대기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
				</div>
				<div class="modal-body" style="display: none;"><!-- 조리시간 start -->
					<div class="row">
						<p align="center">조리 예상시간을 선택하세요.</p>
					</div>
					<div class="row row-cols-2 row-cols-lg-3 g-2 g-lg-3">
						<div class="col">
					    	<div class="p-3 border bg-light">5분 이내</div>
					    </div>
					    <div class="col">
					    	<div class="p-3 border bg-light">10분 이내</div>
					    </div>
					    <div class="col">
					    	<div class="p-3 border bg-light">15분 이내</div>
					    </div>
					    <div class="col">
					    	<div class="p-3 border bg-light">20분 이내</div>
					    </div>
					    <div class="col">
					    	<div class="p-3 border bg-light">30분 이내</div>
					    </div>
					    <div class="col">
					    	<div class="p-3 border bg-light">30분 이상</div>
					    </div>
					</div>
					<div class="row mt-4">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="예상시간 직접입력 (분)">
							<button class="btn btn-primary" type="button">입력</button>
						</div>
					</div>
				</div><!-- 조리시간 end -->
				<div class="modal-body"><!-- 거부사유 start -->
					<div class="row">
						<p align="center">거부 사유를 선택하세요.</p>
					</div>
					<div class="row row-cols-2 row-cols-lg-2 g-2 g-lg-3">
						<div class="col">
							<input type="radio" class="btn-check" name="reject-reason" id="reject1" autocomplete="off">
							<label class="btn btn-secondary" for="reject1">영업종료</label>
						</div>
						<div class="col">
							<input type="radio" class="btn-check" name="reject-reason" id="reject2" autocomplete="off">
							<label class="btn btn-secondary" for="reject2">재료소진</label>
						</div>
						<div class="col">
							<input type="radio" class="btn-check" name="reject-reason" id="reject3" autocomplete="off">
							<label class="btn btn-secondary" for="reject3">주문폭주</label>
						</div>
						<div class="col">
							<input type="radio" class="btn-check" name="reject-reason" id="reject4" autocomplete="off">
							<label class="btn btn-secondary" for="reject4">고객정보 오류</label>
						</div>
					</div>
					<div class="row mt-4">
						<div class="input-group">
							<input type="text" class="form-control" id="reject-text" placeholder="거절사유 직접입력">
							<button class="btn btn-primary" type="button">입력</button>
						</div>
					</div>
				</div><!-- 거부사유 end -->
				<div class="row">
					<div class="d-flex justify-content-around align-items-center mx-auto">
						<button class="btn btn-primary col" type="button" id="btn-accept" style="border: 1px solid gray; background-color: #605759; height: 48px;">주문거부</button>
						<button class="btn btn-primary col" type="button" id="btn-reject" style="border: 1px solid gray; height: 48px;">주문접수</button>
					</div>
				</div>
			</div>
		</div>
	</div><!-- 주문 모달 end -->
	<div class="modal fade" id="modal-eco" tabindex="-1"><!-- 에코 모달 start -->
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-accept-label">포인트 적립</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<p align="center">핸드폰 번호를 입력하세요.</p>
					</div>
					<div class="row mt-4">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="핸드폰 번호">
							<button class="btn btn-primary" type="button">입력</button>
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="d-flex justify-content-around align-items-center mx-auto">
						<button class="btn btn-primary col" type="button" id="btn-reject" style="border: 1px solid gray; height: 48px;">적립하기</button>
					</div>
				</div>
			</div>
		</div>
	</div><!-- 에코 모달 end -->
	
	<div class="nav" style="background-color: #f7f5ed;">
		<div class="container submn">
			<ul class="nav tab-content">
				<li class="nav-item">
					<a class="nav-link toggle-main-tab" href="#" style="color:#f7f5ed; background-color:#0e2c01; height:100%">매장 관리</a>
				</li>
				<li class="nav-item">
					<a class="nav-link toggle-main-tab" href="#" style="color:black;">주문 접수</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" data-bs-target="#modal-accept" data-bs-toggle="modal" style="color:black;">테스트(주문접수)</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" data-bs-target="#modal-eco" data-bs-toggle="modal" style="color:black;">테스트(번호입력)</a>
				</li>
			</ul>
		</div>
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
				<div class="px-4 d-flex justify-content-start toggle-menu-tab"><a href="#">전체메뉴</a></div>
			</div>
			<hr>
			<!-- 메뉴 탭 end -->
			<div class="toggle-menu-view"><!-- 전체메뉴 영역 start -->
				<div class="row">
					<div class="col-lg-6">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>전체메뉴세트</h5>
									<p>14,000원</p>
									<p>25x25cm</p>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card m-4">
							<div class="row p-4">
								<div class="col-9">
									<h5>전체메뉴세트</h5>
									<p>14,000원</p>
									<p>14,000원</p>
								</div>
								<div class="col-3">
									<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="메뉴 이미지">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
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
			    	<div class="list-group-item list-group-item-action active" id="list-order-waiting-list"data-bs-toggle="list" href="#list-order-waiting"  role="tab" aria-controls="order-waiting">
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
			    		<% for (OrderList order : orderList) { %>
						<div class="row"><!-- 주문내역 시작 -->
							<div class="col-3 d-flex justify-content-center align-items-center">
								<div class="row pe-1">
									<h4><%= dateFormat.format(order.getOrderDateTime()) %></h4>
								</div>
								<div class="row">
									<h4><%= timeFormat.format(order.getOrderDateTime()) %></h4>
								</div>
							</div>
							<div class="col-6">
								<h5><%= order.getMemberId() %></h5>
								<p><%= order.getOrderMenu() %></p>
								<h5>[요청사항]</h5>
								<p><%= order.getOrderMessage() %></p>
								<h5>[연락처]</h5>
								<p><%= order.getPhone() %></p>
							</div>
							<div class="col-3">
								<img class="w-100" src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" alt="접수하기">
							</div>
						</div><!-- 주문내역 끝 -->
						<hr>
						<% } %>
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