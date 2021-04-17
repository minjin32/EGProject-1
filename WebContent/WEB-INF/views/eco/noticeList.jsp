<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - EGProject</title>
<link href="<%=request.getContextPath()%>/bootstrap/bootstrap.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style>
	.page-link {
		color: darkgreen;
	}
	
	.td-title {
		text-align: left !important;
	}
</style>
</head>
<body>
	<!-- 내비게이션 -->
	<%@ include file="/WEB-INF/views/nav.jsp" %>
	
	<div class="container-lg">
		<div class="row">
			
			<div class="col-lg-3 p-3" align="center">
				<!-- 서브 내비게이션 -->
				<%@ include file="/WEB-INF/views/eco/subnav.jsp"%>
			</div>

			<div class="col-lg-9 p-5">
				<div class="row">
					<h1>공지사항</h1>
				</div>
				<div>
					<a href="#"><button type="button" class="btn btn-primary mx-1" style="float: right;">검색</button></a>
					<input type="text" class="form-control mx-1" style="float: right; width:200px;" placeholder="검색어"> 
					<select class="form-select mx-1" style="float: right; max-width: 100px;" aria-label="Default select example">
						<option selected>--</option>
						<option value="1">제목</option>
						<option value="2">내용</option>
					</select>
				</div>
				<table class="table" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">6</th>
							<td class="td-title">한 번도 못했던 공지사항 울면서 할 줄은 나 몰랐던 공지사항</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">5</th>
							<td class="td-title">오늘 했던 모든 말 저 하늘 위로</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">4</th>
							<td class="td-title">무슨 말을 하는지 공지</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">3</th>
							<td class="td-title">내게 왜 이러는지 공지사항</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">2</th>
							<td class="td-title">흐르지 못하게 또 활짝 웃어 공지사항 리스트</td>
							<td>2021-04-16</td>
						</tr>
						<tr style="cursor: pointer;" onclick="window.location='/eco/notice/detail';">
							<th scope="row">1</th>
							<td class="td-title">눈물이 차올라서 고갤들어 공지사항 리스트</td>
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
					<a href="/eco/notice/write"><button type="button" class="btn btn-primary mx-1" style="float: right;">글쓰기</button></a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp" %>	
</body>
</html>