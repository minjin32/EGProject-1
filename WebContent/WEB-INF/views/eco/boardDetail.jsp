<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세페이지</title>
<link href="../bootstrap/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="container-lg">
	 <div class="row">
	 
	    <!-- 서브 내비게이션 -->
        <%@ include file="/WEB-INF/views/ecosubnavi.jsp" %>
      
	      <div class="col p-5">
	      	<div  style="border:1px solid #789F6F; height:900px">
				<div style="border:1px solid black; margin-top:20px; margin-left:3%; height:500px; width:95%; text-align:center">사진</div>
				<div style="border:1px solid black; margin-top:20px; margin-left:3%; height:300px; width:95%; text-align:center">내용</div>
					<button type="submit" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:10px">완료</button>
					<button type="reset" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:5px">취소</button>
	      	</div>
	      </div>
      </div>
      </div>
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>