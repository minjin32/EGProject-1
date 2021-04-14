<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA작성</title>
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
					<li style="list-style:none; font-size:30px">마이페이지 홈</li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">내정보</a></li>
					<li class="list-group-item"><a href="/qnawrite" style="text-decoration : none">주문 내역</a></li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">QnA 문의</a></li>
				</ul>
	      </div>
	      <div class="col-md-9 p-5">
	      <div  style="border:1px solid #789F6F; height:650px">
		      	<form>
					<input type="text" style="width:95%; margin-top:20px; margin-left:15px" placeholder="제목" name="subject"><br>
					<textarea rows="20" style="width:95%; margin-top:10px; margin-left:15px" placeholder="본문" name="content"></textarea><br>
					<button type="button" class="btn btn-outline-success" style="margin-left:15px">첨부파일</button>
					<input type="text" class="btn btn-outline-success"><br>
					<button type="submit" class="btn btn-outline-success" style="float: right; margin-bottom:10px; margin-right:10px">완료</button>
					<button type="reset" class="btn btn-outline-success" style="float: right; margin-right:5px">취소</button>
				</form>
	      </div>
	      </div>
      </div>
      </div>
	

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>