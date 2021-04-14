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
        <%@ include file="/WEB-INF/views/mysubnavi.jsp" %>

		<!-- 개인화면 부분 -->
		<div class="col p-5">
			<div style="height:900px">
				<div style="height:10%; width:100%"><h1>내 정보</h1></div>
				<div style="height:40%; width:100%">
				<div>
               		<ul class="nav flex-column" style="padding:50px;" >
                  <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center; margin-bottom: 10px;">이름</li>
               <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center;  margin-bottom: 10px">닉네임</li>
                  <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center;  margin-bottom: 10px">생년월일</li>
                  <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center;  margin-bottom: 10px">주소</li>
                  <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center;  margin-bottom: 10px">휴대전화</li>
                  <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center; margin-bottom: 10px">이메일</li>
               <li class="nav-item"
                  style="height: 40px; width: 80px; background-color: #D1E9CA; text-align: center; position:relative; top:100px; left:90%">
					수정</li>
               </ul>
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