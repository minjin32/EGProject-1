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
         <!-- 서브 내비게이션 -->
        <%@ include file="/WEB-INF/views/mypage/mysubnavi.jsp" %>

		<!-- 개인화면 부분 -->
		<div class="col p-5" style="border:1px solid black">
			<div class="col-md-5" style=" ">
				<input type="text">
				<input type="text">
         	</div>
         	<div class="col-md-7">
         		<input type="text">
         
         
			</div>
	</div>
    </div>
   </div>

		<!-- footer부분  -->
		<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>