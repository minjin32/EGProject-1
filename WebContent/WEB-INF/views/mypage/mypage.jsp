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
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container" style="margin-top: 40px">
		<div class="row g-4">
			<div class="col-md-3">
				<ul class="me-2"
					style="border-right: 1px solid #D1E9CA; list-style:none">
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link active" href="/mypage">마이페이지 홈</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="#">내 정보</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="/orderlist">주문 내역</a></li>
					<li class="nav-item"
						style="height: 50px; width: 80%; background-color: #D1E9CA; text-align: center; vertical-align: middle; margin-bottom: 10px"><a
						class="nav-link" href="#">Q&A 문의</a></li>
					<div style="width: 30%; height: 500px"></div>
					<ul class="nav flex colum" style="font-size: 3px">회원탈퇴
					</ul>
				</ul>
			</div>



			<div class="col-md-9">
				<ul class="list-group list-group-horizontal">
					<img src="/files/images/user.png" class="img-thumbnail"
						style="border-color: white; height: 50px; width: 50px; margin-bottom:10px; margin-right:10px" "alt="사용자 아이콘" />
					<h3>회원 님 안녕하세요!</h3>
				</ul>
				<ul class="list-group list-group-horizontal"
					style="border: 3px solid #D1E9CA; height: 200px; width: 100%; border-radius: 30px; vertical-align: center">
					<li class="list-group-item"
						style="width: 25%; height: 100px; margin: 25px; text-align: center; border-color: white">
						에코포인트 <a class="nav-link"
						style="font-size: 40px; margin-top: 15px">250</a>
					</li>
					<li class="list-group-item"
						style="width: 25%; height: 100px; margin: 25px; text-align: center; border-color: white">
						순위 <a class="nav-link" style="font-size: 40px; margin-top: 15px">7%</a>
					</li>
					<li class="list-group-item"
						style="width: 25%; height: 100px; margin: 25px; text-align: center; border-color: white">
						등급 <a class="nav-link" style="font-size: 40px; margin-top: 15px">열매</a>
					</li>
					<li class="list-group-item"
						style="width: 25%; height: 100px; margin: 25px; text-align: center; border-color: white">내가
						심은 나무 <a class="nav-link"
						style="font-size: 40px; margin-top: 15px">7그루</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>