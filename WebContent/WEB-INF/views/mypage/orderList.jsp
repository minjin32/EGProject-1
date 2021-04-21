<%@page import="java.text.SimpleDateFormat"%>
<%@page import="order.model.vo.OrderVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<OrderVO> orderList = (ArrayList<OrderVO>) request.getAttribute("orderList");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-hh:mm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
<style>
	.btn-cancel-order {
		width: 100%;
	}
	
	.menu-pic {
		object-fit: cover;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-4">
				<div>
					<div style="height: 10%;">
						<h1>주문내역</h1>
					</div>
					<div class="pt-4">
						<% 
							for (OrderVO order : orderList) {
						%>
						<div class="row order-history"><!-- 주문 한개 start -->
							<div class="col-lg-2">
								<img src="<%=request.getContextPath()%>/files/images/dumpling.jpg" class="rounded mx-auto d-block w-100" alt="메뉴사진">
							</div>
							<div class="col-lg-8 mt-2">
								<h5><%= order.getOrderMenu() %></h5>
								<p><%= order.getOrderMessage() %></p>
								<div class="row">
									<div class="col">
										<p><%= order.getOrderPrice() %></p>
									</div>
									<div class="col">
										<div class="gap-2 d-md-flex justify-content-md-end">
											<p ><%= dateFormat.format(order.getOrderDateTime()) %></p>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-2">
								<% if (order.getOrderStatus() == 0) { %>
								<input type="button" class="btn btn-primary btn-cancel-order" value="수락 대기중">
								<% } else if (order.getOrderStatus() == 1) { %>
								<input type="button" class="btn btn-primary btn-cancel-order" value="조리중" disabled>
								<% } else if (order.getOrderStatus() == 2) { %>
								<input type="button" class="btn btn-primary btn-cancel-order" value="완료" disabled>
								<% } %>
							</div>
						</div><!-- 주문 한개 end -->
						<hr>
						<%
							}
						%>
					</div>
					<!-- 
					<div class="row">
						<button class="btn btn-primary mt-4">더 불러오기</button>
					</div>
					 -->
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>