<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
	<!-- Example split danger button -->

	<!-- 로그인 메인 -->
	<div class="container" style= " height: 1000px;">
		
		<div class="d-flex justify-content-center" style="margin-top: 150px">
		
		<form style= "width:400px;">
			<div class="row"  >
					<!-- Email input --> 
					<h2 align="center">EGproject</h2>
					<div class="form-outline mb-4" >
						<label class="form-label" for="form2Example1" >ID</label>
						<input type="email" id="form2Example1" class="form-control" /> 
					</div>
			
					<!-- Password input -->
					<div class="form-outline mb-4">
						<label class="form-label" for="form2Example2">Password</label>
						<input type="password" id="form2Example2" class="form-control" />
					</div>

					<!-- 2 column grid layout for inline styling -->
					<div class="row mb-4">
						<div class="col d-flex justify-content-center">
							<a href="#!">ID / Pwd 찾기</a>
						</div>
					</div>

					<!-- Submit button -->
					<div align="center">
					<button type="submit" class="btn btn-primary btn-block mb-4" style="max-width: 80%; ">
					<a href="/introduce" style="text-decoration: none">로그인</a> </button>
					</div>
					<!-- Register buttons -->
					<div class="text-center">
						<p>
							회원이 아니신가요? <a href="/login/join">회원가입</a>
						</p>
					</div>
				</div>
		</form>
		</div>
	</div>

	<br>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>