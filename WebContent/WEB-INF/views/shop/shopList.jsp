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
<body style="background-color: #f7f5ed">
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<br><br>
	
	<div class="container-md">
		<div class="d-flex justify-content-center">
			<form class="row shop-search-selects" action="/shop/list" method="POST" style="padding: 4rem 2rem 4em 2em; border-top: 1px solid #e4e0d7; border-bottom: 1px solid #e4e0d7;">
				<select class="col form-select ms-3" name="address1">
				  <option selected>시, 도</option>
				  <option value="서울특별시">서울특별시</option>
				  <option value="부산광역시">부산광역시</option>
				  <option value="대구광역시">대구광역시</option>
				  <option value="인천광역시">인천광역시</option>
				  <option value="광주광역시">광주광역시</option>
				  <option value="대전광역시">대전광역시</option>
				  <option value="울산광역시">울산광역시</option>
				  <option value="부천시">부천시</option>
				  <option value="수원시">수원시</option>
				  <option value="성남시">성남시</option>
				  <option value="고양시">고양시</option>
				  <option value="용인시">용인시</option>
				  <option value="안산시">안산시</option>
				  <option value="안양시">안양시</option>
				  <option value="세종특별지차시">세종특별지차시</option>
				</select>
				<select class="col form-select ms-3" name="address2">
				  <option selected>구, 군</option>
				  <option value="중구">중구</option>
				  <option value="종로구">종로구</option>
				  <option value="용산구">용산구</option>
				  <option value="광진구">광진구</option>
				  <option value="성동구">성동구</option>
				  <option value="동대문구">동대문구</option>
				  <option value="중랑구">중랑구</option>
				  <option value="성북구">성북구</option>
				</select>
				<select class="col form-select ms-3" name="address3">
				  <option selected>동, 면</option>
				  <option value="다동">다동</option>
				  <option value="연암동">연암동</option>
				  <option value="대연동">대연동</option>
				  <option value="교남동">교남동</option>
				  <option value="가화동">가화동</option>
				  <option value="종로">종로1가동</option>
				  <option value="이화동">이화동</option>
				</select>
				<input type="submit" class="btn btn-primary col ms-2" value="검색">
			</form>
		</div>
		
		<br><br>
		
		<div class="shop-search-result">
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
					<a href="/shop/detail" style="text-decoration: none;">
						<div class="row g-4" >
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9" >
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
						</a>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
						        <p class="card-text">짬뽕이 비싸지만 맛있어요.</p>
						        <p class="card-text"><small class="text-muted">영업시간: 11:00 ~ 20:00</small></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg">
					<div class="card mb-3 p-4" style="background-color: #e4e0d7">
						<div class="row g-4">
							<div class="col-md-3">
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" class="img-thumbnail d-block w-100" alt="음식점 이미지">
							</div>
							<div class="col-md-9">
								<h5 class="card-title" style="color: #af8d2f">짬뽕지존</h5>
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