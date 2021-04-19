<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 - EGProject</title>
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

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-4">
				<div>
					<div style="height: 10%;">
						<h1>정보 수정</h1>
					</div>
					<form action="/mypage/modify" method="post">
						<div class="mb-3">
							<label for="id" class="form-label">아이디</label>
							<input type="text" class="form-control" id="id" value="<%=memberId%>" name="memberId" disabled>
							<div id="idHelp" class="form-text">아이디는 수정이 불가능합니다.</div>
						</div>
						<div class="mb-3">
							<label for="birthday" class="form-label">비밀번호</label>
							<input type="password" class="form-control" value="" name="memberPw">
						</div>
						<div class="mb-3">
							<label for="name" class="form-label">이름</label>
							<input type="text" class="form-control" value="" name="memberName">
						</div>
						<div class="mb-3">
							<label for="nickname" class="form-label">닉네임</label>
							<input type="text" class="form-control" value="" name="memberNickName">
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">주소</label>
							<input type="text" class="form-control" value="" name="memberAddress1">
						</div>
						<div class="mb-3">
							<label for="phone" class="form-label">휴대전화</label>
							<input type="text" class="form-control" value="" name="memberPhone">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">이메일</label>
							<input type="email" class="form-control" value="" name="memberEmail">
						</div>
						<button type="submit" class="btn btn-primary mx-1" style="float: right;">수정완료</button>
						<a href="/mypage/info"><button type="button" class="btn btn-primary mx-1" style="float: right; background-color: gray; border: 1px solid gray;">취소</button></a>
					</form>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>