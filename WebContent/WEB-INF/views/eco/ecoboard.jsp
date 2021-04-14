<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<title>에코게시판</title>
</head>
<body>
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	
	
		<div class="container-lg">
	  <div class="row">
	  
      <!-- 서브 내비게이션 -->
        <%@ include file="/WEB-INF/views/eco/ecosubnavi.jsp" %>
      
      
      <div class="col-md-9" style="margin-top: 100px">
  <div class="row g-2">
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" 
		class="img-thumbnail d-block w-100">    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" 
		class="img-thumbnail d-block w-100">    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" 
		class="img-thumbnail d-block w-100">    </div>
    <div class>
    	<dlv class></dlv>
    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">
    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">    </div>
    <div class>
    	<dlv class></dlv>
    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">
    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">
    </div>
    <div class="col-4">
		<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg"
		 class="img-thumbnail d-block w-100">
    </div>
    
  </div>

<div style="padding:10px"></div>
      </div> 
      
	<!-- 페이징처리 -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	    <li class="page-item disabled">
	      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">이전</a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item"><a class="page-link" href="#">2</a></li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item"><a class="page-link" href="#">4</a></li>
	    <li class="page-item"><a class="page-link" href="#">5</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#">다음</a>
	    </li>
	  </ul>
	</nav>
      </div>
    	</div>
	
	
	
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp" %>	

</body>
</html>