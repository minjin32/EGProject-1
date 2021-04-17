<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA문의 상세</title>
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
	<!-- navi -->
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/eco/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div>
					<h2 class="pb-2">이벤트 작성</h2>
					<form class="p-4"
						style="border: 1px solid #789F6F; border-radius: 5px;">
						<div class="mb-3">
							<input type="text" class="form-control" placeholder="제목을 입력하세요.">
						</div>
						<div class="mb-3">
							<textarea rows="12" class="form-control" placeholder="내용을 입력하세요."></textarea>
						</div>
						<p style="margin-bottom: 0;">첨부파일</p>
						<div class="mb-3">
							<input class="form-control" type="file">
						</div>
						<div class="gap-2 d-md-flex justify-content-md-end">
							<a href="/eco/event"><button type="button" class="btn btn-primary">취소</button></a>
							<button type="submit" class="btn btn-primary">완료</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>