<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 QnA관리</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<!-- <link href="./css/egproject.css" rel="stylesheet"> -->
<!-- Bootstrap & css end -->
</head>
<style>
.page-link {
	color: darkgreen;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp"%>

	<div class="container-lg">
		<div class="row">
			<div class="col-lg-3 p-3" align="center">
				<%@ include file="/WEB-INF/views/admin/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>QnA 관리</h1>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">작성자</th>
							<th scope="col" style="text-align: center;">제목</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">6</th>
							<td>이효정</td>
							<td class="td-title">한 번도 못했던 말 울면서 할 줄은 나 몰랐던 말</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">5</th>
							<td>박은영</td>
							<td class="td-title">오늘 했던 모든 말 저 하늘 위로</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">4</th>
							<td>김나혜</td>
							<td class="td-title">무슨 말을 하는지</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">3</th>
							<td>김민진</td>
							<td class="td-title">내게 왜 이러는지</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">2</th>
							<td>오우철</td>
							<td class="td-title">흐르지 못하게 또 활짝 웃어</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/mypage/qna/detail';">
							<th scope="row">1</th>
							<td>김동현</td>
							<td class="td-title">눈물이 차올라서 고갤들어</td>
							<td>2021-04-16</td>
						</tr>
					</tbody>
				</table>
				<div class="row">
					<div class="mx-auto" style="width: 300px;">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">4</a></li>
							<li class="page-item"><a class="page-link" href="#">5</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</div>
				</div>
				<div>
					<a href="/mypage/qna/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">문의하기</button></a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>