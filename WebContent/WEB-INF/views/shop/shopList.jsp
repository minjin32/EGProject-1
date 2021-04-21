<%@page import="shop.model.vo.Shop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.model.vo.ShopPageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		$('#searchButton').click(function() {
			$.ajax({
				type: "GET",
				url: "/shop/search",
				Headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success : function(result) {
					var pd = $.parseJSON(result);
					var shopList;
					var pageData;
					for (var i = 0; i < pd; i ++) {
						
					}
				}
			})
		});
	});
</script>
<body style="background-color: #f7f5ed">
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<br><br>
	
	<div class="container-md">
		<div class="d-flex justify-content-center">
			<form class="row shop-search-selects" action="/shop/search" method="get" style="padding: 4rem 2rem 4em 2em; border-top: 1px solid #e4e0d7; border-bottom: 1px solid #e4e0d7;">
				<select class="col form-select ms-3" name="address1">
				  <option>시, 도</option>
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
				  <option>구, 군</option>
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
				  <option>동, 면</option>
				  <option value="다동">다동</option>
				  <option value="연암동">연암동</option>
				  <option value="대연동">대연동</option>
				  <option value="교남동">교남동</option>
				  <option value="가화동">가화동</option>
				  <option value="종로">종로1가동</option>
				  <option value="이화동">이화동</option>
				</select>
				<input type="submit" id="searchButton" class="btn btn-primary col ms-2" value="검색">
			</form>
		</div>
		<br>
	</div>
	
	<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>