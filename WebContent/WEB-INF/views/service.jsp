<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서비스 - EGProject</title>
	<!-- Bootstrap & css-->
	<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="content">
		<div class="my-5" align="center">
			<div class="py-3" style="max-width: 560px; border-top: 4px solid darkseagreen; border-bottom: 4px solid darkseagreen;">
				<img class="py-5" src="<%=request.getContextPath()%>/files/images/Logo.jpg" style="max-height: 480px;" class="d-block" alt="서비스 메인이미지">	
			</div>
		</div>
	</div>
	
	<br>
	
	<div class="container-lg">
		<!-- PC 중앙부 시작 -->
		<div class="row d-none d-md-block">
			<div class="card mb-3 p-4" style="border: none;">
				<div class="row g-4">
					<div class="col-md-4">
						<img src="<%=request.getContextPath()%>/files/images/int1.jpg" class=" d-block w-100" alt="음식점 이미지">
					</div>
					<div class="col-md-8" align="center">
						<h1 class="card-title" style="vertical-align:middle; margin-top:80px">내 주변 제로웨이스트</h1>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">주변에 있는 제로웨이스트 스토어를 찾아요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">내 주변에 Zero Waste를 실천하고 있는 가게를 알고 있나요?</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">원하는 지역을 검색하여 주변에 있는 제로웨이스트 샵을 찾을 수 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">내가 살고 있는 지역을 검색하여 주변에 있는 제로웨이스트 샵을 갈 수 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">제로웨이스트샵 뿐만 아니라 음식점에서도 환경을 위해 일회용품 사용을 줄이고 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">주변에 있는 제로웨이스트샵을 통해 가치있는 소비를 해요.</p>
				        
					</div>
				</div>
			</div>
			<div class="card mb-3 p-4" style="border: none;">
				<div class="row g-4">
					<div class="col-md-8" align="center">
						<h1 class="card-title" style="vertical-align:middle; margin-top:50px">용기 가져가서 포장하기</h1>
				        <p class="card-text">용기내서 음식을 가져가요</p>
				        <p class="card-text">제로웨이스트 음식점에서는 다회용기를 가져가면 가져온 용기에 포장을 해줘요</p>
				        <p class="card-text">일회용 포장 용기를 사용할 경우 많은 양의 일회용품 쓰레기가 나와요</p>
				        <p class="card-text">환경과 미래를 위해 다회용기를 챙겨요</p>
				        <p class="card-text">사장님과 손님 모두 절약할 수 있어요</p>
				        <p class="card-text">용기내서 포장하면 더 나은 미래를 만들 수 있어요.</p>
				        
					</div>
					<div class="col-md-4">
						<img src="<%=request.getContextPath()%>/files/images/int2.jpg" class=" d-block w-100" alt="음식점 이미지">
					</div>
				</div>
			</div>
		</div>
		<!-- PC 중앙부 끝 -->
		<!-- 모바일 중앙부 시작 -->
		<div class="row d-md-none d-block">
			<div class="card mb-3 p-4" style="border: none;">
				<div class="row g-4">
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/files/images/int1.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
					</div>
					<div class="col-md-9" align="center">
						<h1 class="card-title">내 주변 제로웨이스트</h1>
				        <p class="card-text">주변에 있는 제로웨이스트 스토어를 찾아요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">내 주변에 Zero Waste를 실천하고 있는 가게를 알고 있나요?</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">원하는 지역을 검색하여 주변에 있는 제로웨이스트 샵을 찾을 수 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">내가 살고 있는 지역을 검색하여 주변에 있는 제로웨이스트 샵을 갈 수 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">제로웨이스트샵 뿐만 아니라 음식점에서도 환경을 위해 일회용품 사용을 줄이고 있어요</p>
				        <p class="card-text" style="margin-top:10px; margin-bottom:10px">주변에 있는 제로웨이스트샵을 통해 가치있는 소비를 해요.</p>
				        
					</div>
				</div>
			</div>
			<hr>
			<div class="card mb-3 p-4" style="border: none;">
				<div class="row g-4">
					<div class="col-md-9" align="center">
						<h1 class="card-title">용기 가져가서 포장하기</h1>
				        <p class="card-text">용기내서 음식을 가져가요</p>
				        <p class="card-text">제로웨이스트 음식점에서는 다회용기를 가져가면 가져온 용기에 포장을 해줘요</p>
				        <p class="card-text">일회용 포장 용기를 사용할 경우 많은 양의 일회용품 쓰레기가 나와요</p>
				        <p class="card-text">환경과 미래를 위해 다회용기를 챙겨요</p>
				        <p class="card-text">사장님과 손님 모두 절약할 수 있어요</p>
				        <p class="card-text">용기내서 포장하면 더 나은 미래를 만들 수 있어요.</p>
				        
					</div>
					<div class="col-md-3">
						<img src="<%=request.getContextPath()%>/files/images/int2.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
					</div>
				</div>
			</div>
		</div>
		<!-- 모바일 중앙부 끝 -->
		
		<br><br>
		
		<!-- 하단부 -->
		<div class="row g-4" style="text-align: center;">
			<h1>함께하기</h1>
		</div>
		<div class="row">
			<div class="col-md-4 g-5">
				<img src="<%=request.getContextPath()%>/files/images/with1-001.jpg" class="rounded-circle d-block w-100" alt="에코 이미지">
			</div>
			<div class="col-md-4 g-5">
				<img src="<%=request.getContextPath()%>/files/images/with2-001.jpg" class="rounded-circle d-block w-100" alt="에코 이미지">
			</div>
			<div class="col-md-4 g-5">
				<img src="<%=request.getContextPath()%>/files/images/with3-001.jpg" class="rounded-circle d-block w-100" alt="에코 이미지">
			</div>
		</div>
		
	</div>
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>