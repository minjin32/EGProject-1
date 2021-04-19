<%@page import="admin.model.service.AdminService"%>
<%@page import="member.model.service.MemberService"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<!-- 메뉴 바 -->
	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/admin/subnav.jsp"%>
			</div>

			<div class="col-lg-9 p-4">
				<div class="row">
					<div class="list-group list-group-horizontal">
						<img src="/files/images/user.png" class="img-thumbnail" style="border-color: white; height: 50px; width: 50px; margin-bottom: 10px; margin-right: 10px" alt="사용자 아이콘" />
						<h3 class="pt-2">관리자님 안녕하세요!</h3>
					</div>
				</div>
				<div class="row p-4" style="border: 4px solid #0e2c01; border-radius: 24px;">
					<div class="row">
						<div class="col-3" align="center">
							<h3>사업자 등록 인증 요청</h3>
						</div>
						<div class="col-3" align="center">
							<h3>Q&A문의</h3>
						</div>
						<div class="col-3" align="center">
							<h3>누적 방문자 수</h3>
						</div>
						<div class="col-3" align="center">
							<h3>신규 가입</h3>
						</div>
					</div>
					<div class="row pt-4">
						<div class="col-3" align="center">
							<h2>8</h2>
						</div>
						<div class="col-3" align="center">
							<h2><% AdminService admin = new AdminService();
									int qCount = admin.selectQnACount();%>
									<%= qCount %></h2>
						</div>
						<div class="col-3" align="center">
							<h2>254,571</h2>
						</div>
						<div class="col-3" align="center">
							<h2><% MemberService service = new MemberService(); 
								int count= service.selectMemberList();%>
								<%= count %></h2>
						</div>
					</div>
				</div>
			</div>
			<!-- 			<div class="col-md-9"> -->
			<!-- 				<div class="row"> -->
			<!-- 					<div class="card border-success mb-3" -->
			<!-- 						style="max-width: 18rem; text-align: center"> -->
			<!-- 						<div class="card-header">사업자 등록 인증 요청</div> -->
			<!-- 						<div class="card-body text-success"> -->
			<!-- 							<h1 class="display-6" style="margin-top: 15px">8</h1> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 					<div class="card border-success mb-3" -->
			<!-- 						style="max-width: 18rem; text-align: center"> -->
			<!-- 						<div class="card-header">1:1 문의</div> -->
			<!-- 						<div class="card-body text-success"> -->
			<!-- 							<h1 class="display-6" style="margin-top: 15px">16</h1> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 				<div class="row"> -->
			<!-- 					<div class="card border-success mb-3" -->
			<!-- 						style="max-width: 18rem; text-align: center"> -->
			<!-- 						<div class="card-header">누적 방문자 수</div> -->
			<!-- 						<div class="card-body text-success"> -->
			<!-- 							<h1 class="display-6" style="margin-top: 15px">12K</h1> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 					<div class="card border-success mb-3" -->
			<!-- 						style="max-width: 18rem; text-align: center"> -->
			<!-- 						<div class="card-header">신규 가입</div> -->
			<!-- 						<div class="card-body text-success"> -->
			<!-- 							<h1 class="display-6" style="margin-top: 15px">50</h1> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>