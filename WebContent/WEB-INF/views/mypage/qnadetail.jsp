<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA문의 상세</title>
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
	<!-- navi -->
	<%@ include file="/WEB-INF/views/nav.jsp"%>
	
	<div class="container-lg">
	 <div class="row">
	     <div class="col-md-3 p-3" align="center">
				<ul class="list-group list-group-flush">
					<li style="list-style:none; font-size:30px">에코마당</li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">이벤트</a></li>
					<li class="list-group-item"><a href="/board/notice" style="text-decoration : none">공지사항</a></li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">에코게시판</a></li>
				</ul>
	      </div>
	      <div class="col-md-9 p-5">
	      	<div  style="border:1px solid #789F6F; height:900px">
				<div style="top:10px; font-size: 30px; width:95%; margin-left:3%; margin-top:5%">제목</div><hr>
				<div style="margin-top:20px; margin-left:3%; height:400px; width:95%; margin-left:3%;">내용</div>
				
				
				<div style="border:1px solid #789F6F; margin-top:20px; margin-left:3%; height:300px; width:95%; margin-left:3%;">
					<div style="text-align:left; font-size: 20px; width:95%; margin-left:2%; margin-top:3%">관리자답변<hr></div>
					<div style="width:90%; height:70%; margin-left:5%;">내용</div>
				</div>
				
					<button type="submit" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:10px">수정</button>
					<button type="reset" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:5px">삭제</button>
	      	</div>
	      </div>
      </div>
      </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>