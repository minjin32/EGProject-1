<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String shopSearchKeyword = (String)request.getAttribute("shopSearchKeyword");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>스토어 검색 - EGProject</title>
	<!-- Bootstrap & css-->
	<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
	<!-- Bootstrap & css end -->
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<br><br>
	
	<div class="container-md">
		<div class="d-flex justify-content-center">
			<div class="row shop-search-selects" style="padding: 4rem 2rem 4em 2em; border-top: 1px solid green; border-bottom: 1px solid green;">
				<select class="col form-select ms-3" name="address1">
				  <option selected>시, 도</option>
				  <option value="1">서울특별시</option>
				  <option value="2">울산광역시</option>
				  <option value="3">안양시</option>
				</select>
				<select class="col form-select ms-3" name="address2">
				  <option selected>구, 군</option>
				  <option value="1">종로구</option>
				  <option value="2">중구</option>
				  <option value="3">만안구</option>
				</select>
				<select class="col form-select ms-3" name="address3">
				  <option selected>동, 면</option>
				  <option value="1">약사동</option>
				  <option value="2">연암동</option>
				  <option value="3">대연동</option>
				</select>
				<input type="submit" class="btn btn-primary col ms-2" value="검색">
			</div>
		</div>
		
		<br><br>
		
		<div class="shop-search-result">
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<br>
		
		<div align="center">
			<input class="btn btn-primary" value="더 불러오기">
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>