<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>소개 - EGProject</title>
	<!-- Bootstrap & css-->
	<link href="./bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="content">
		<div>
			<img src="<%=request.getContextPath()%>/files/images/main1.jpg" style="max-height:800px" class="d-block w-100" alt="...">	
		</div>
	</div>
	<br>
	<div class="container-lg">
		<!--
		<div class="card-group">
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">1번 소제목 입니다.</h5>
					<p class="card-text">
						1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 1번 세부내용 입니다. 
					</p>
				</div>
			</div>
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">2번 소제목 입니다.</h5>
					<p class="card-text">
						2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 2번 세부내용 입니다. 
					</p>
				</div>
			</div>
			<div class="card" style="border:none;">
				<div class="card-body">
					<h5 class="card-title">3번 소제목 입니다.</h5>
					<p class="card-text">
						3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 3번 세부내용 입니다. 
					</p>
				</div>
			</div>
		</div>
		 -->
		<div class="row row-cols-1 row-cols-md-3">
			<div class="col" style="padding: 60px;">
				<h5>변화를 추구합니다.</h5>
				<p>EG project는 제로 웨이스트(Zero-waste) 
				원칙에 초점을 맞춰 일상 생활 속에서 무분별하게 사용되는 일회용품을 줄이기 위해 많은 노력을 하고 있습니다. 쓰레기를 최소화하고
				제품의 closed-loop 순환을 위해 일회용품의 사용을 줄이고,가치있는 소비를 위해 일회용품을 줄이기 위해 노력하는 음식점과 제로웨이스트 상품을 판매하는 스토어를 소개하고, 용기를 가져가 음식을 포장할 수 있도록 예약하는 서비스를 제공합니다.
				지속 가능한 미래를 만들기 위해 EG project는 새로운 변화를 추구하기 위헤 노력하고 있습니다.</p>
			</div>
			<div class="col" style="padding: 60px;">
				<h5>자연스럽게 연결됩니다.</h5>
				<p>제로 웨이스트를 추구하는 사람들이 모여 같은 방향으로 나아가기 위해 노력합니다.
					생활 속에서 같은 방향을 나아가는 사람들을 함께하기 위해 접근성을 극대화하하여 모두가 참여할 수 있는 환경 운동을 만들기 위해 노력하고 있습니다.
					일회용품 사용을 줄이고 배출량을 줄여가는 하나의 목적을 위한 진정한 제로웨이스트를 추구하고 있습니다.
				
				</p>
			</div>
			<div class="col" style="padding: 60px;">
				<h5>생활 속에 스며듭니다.</h5>
				<p>제로웨이스트는 어렵지 않습니다. 대단하고 거창한 것만이 환경운동이 아닌 일상 속에서 작은 나의 행동이 환경운동이 될 수 있습니다.
					제로 웨이스트 음식점에서 일회용품 사용을 줄이고,제로 웨이스트 스토어에서 환경 오염을 줄이는 물건을 구매하는 것도
					환경을운동이 될 수 있습니다. 환경을 위한 작은 소비가 우리 일상 속에 스며들도록 다양한 노력을 하고 있습니다.</p>
			</div>
		</div>
		<div class="row row-cols-1 row-cols-md-2">
			<div class="col" style="padding:60px;">
				<img src="<%=request.getContextPath()%>/files/images/wireframe.jpg" class="d-block w-100" style="max-height: 400px" alt="...">
			</div>
			<div class="col" style="padding:60px;">
				<div class="row align-items-center" style="padding:40px;">
					<h3>운영시간</h3>
					<br>
					<p>
						설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다.
					</p>
				</div>
				<div class="row align-items-center" style="padding:40px;">
					<h3>운영시간</h3>
					<br>
					<p>
						설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다. 설명글 입니다.
					</p>
				</div>
			</div>
		</div>
		
	</div>
	
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>