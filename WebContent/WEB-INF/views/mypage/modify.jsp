<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
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
	<!-- header부분  -->
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			<!-- 개인화면 부분 -->
			<div class="col p-5">
				<div style="height: 900px;">
					<div style="height: 10%; width: 100%;">
						<h1>정보 수정</h1>
					</div>
					<div
						style="height: 40%; width: 100%; padding: 50px; backgorund-color: red">

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">이름</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" style="width: 50px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-defaultl"
								style="width: 130px; background-color: #D1E9CA">닉네임</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">비밀번호</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">비밀번호 확인</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">생일</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">주소</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">휴대전화</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="input-group mb-3" style="width: 350px">
							<span class="input-group-text" id="inputGroup-sizing-default"
								style="width: 130px; background-color: #D1E9CA">이메일</span> <input
								type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default"
								style="width: 100px">
						</div>

						<div class="control-group">
							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success" style="float: right;">수정완료</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
		<!-- footer부분  -->
		<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>