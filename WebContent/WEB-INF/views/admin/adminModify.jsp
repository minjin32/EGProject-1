<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
<style>
	.form-control:disabled {
		background-color: white;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/admin/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-4">
				<div>
					<div style="height: 10%;">
						<h1>회원 정보</h1>
					</div>
					<div>
					<form action="/admin/modify" method="post">
						<div class="mb-3">
							<label for="id" class="form-label">아이디</label>
							<input type="text" class="form-control" id="id" value="<%= member.getMbId() %>" name="memberId" disabled>
							<div id="idHelp" class="form-text">아이디는 수정이 불가능합니다.</div>
						</div>
						<div class="mb-3">
							<label for="name" class="form-label">이름</label>
							<input type="text" class="form-control" id="name" value="<%=member.getMbName()%>" name="memberName" disabled>
						</div>
						<div class="mb-3">
							<label for="nickname" class="form-label">닉네임</label>
							<input type="text" class="form-control" value="<%=member.getMbNickname() %>" id="nickname" name="memberNickName"disabled>
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">주소</label>
							<input type="text" class="form-control" value="<%=member.getMbAddress1() %>" id="address" name="memberAddress1"disabled>
						</div>
						<div class="mb-3">
							<label for="phone" class="form-label">휴대전화</label>
							<input type="text" class="form-control" value="<%=member.getMbPhone() %>" id="phone" name="memberPhone" disabled>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">이메일</label>
							<input type="email" class="form-control" value="<%=member.getMbEmail() %>" id="email" name="memberEmail"disabled>
						</div>
						<a href="/admin/modify"><button type="button" class="btn btn-primary mx-1" style="float: right; action="/admin/modify" method="post"">수정하기</button></a>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>