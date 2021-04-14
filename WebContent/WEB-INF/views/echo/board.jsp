<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에코게시판 - EGProject</title>
	<!-- Bootstrap & css-->
	<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class='container'>
		<div class="row">
			<div class="col-md-3">
				<div id="list-example" class="list-group">
				  <a class="list-group-item list-group-item-action" href="#list-item-1">Item 1</a>
				  <a class="list-group-item list-group-item-action" href="#list-item-2">Item 2</a>
				  <a class="list-group-item list-group-item-action" href="#list-item-3">Item 3</a>
				  <a class="list-group-item list-group-item-action" href="#list-item-4">Item 4</a>
				</div>
				<div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-offset="0" class="scrollspy-example" tabindex="0">
				  <h4 id="list-item-1">Item 1</h4>
				  <p>...</p>
				  <h4 id="list-item-2">Item 2</h4>
				  <p>...</p>
				  <h4 id="list-item-3">Item 3</h4>
				  <p>...</p>
				  <h4 id="list-item-4">Item 4</h4>
				  <p>...</p>
				</div>
			</div>
			<div class="col-md-9">
				md9
			</div>
			
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>