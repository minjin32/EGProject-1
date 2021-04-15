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
        <%@ include file="/WEB-INF/views/eco/ecosubnavi.jsp" %>

		<!-- 개인화면 부분 -->
		<div class="col p-5">
			<div style="height:900px">
				<div style="height:10%; width:100%;" ><h1>에코게시판</h1></div>
					<div class="container-lg">
		<div class="row row-cols-1 row-cols-lg-2 g-4" style="position: relative; top: 100px;">
			
			
			<div class="col intro-img-grid g-0" style="margin-left:100px">
				<div class="row">
					<div class="col" >
						<img
							src="<%=request.getContextPath()%>/files/images/food1.png"
							class=" d-bloc0k" style="width:120px; height:120px; ">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food2.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food3.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food4.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food5.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food6.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food7.png"
							class=" d-block" style="width:120px; height:120px;">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food8.png"
							class=" d-block" style="width:120px; height:120px; ">
					</div>
					<div class="col">
						<img
							src="<%=request.getContextPath()%>/files/images/food9.png"
							class=" d-block" style="width:120px; height:120px;">
					</div>
				</div>
			</div>
			
		</div>
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