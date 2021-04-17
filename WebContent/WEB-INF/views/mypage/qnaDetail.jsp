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
				<%@ include file="/WEB-INF/views/mypage/subnav.jsp"%>
			</div>
			<div class="col-lg-9 p-5">
				<div>
					<h2 class="pb-2">QnA 내용</h2>
					<form class="p-4" style="border: 1px solid #789F6F; border-radius: 5px;">
						<div class="mb-3">
							<div class="row">
								<div class="col">
									<b>작성자 </b>
									<span>김길동</span>
								</div>
								<div class="col gap-2 d-md-flex justify-content-md-end">
									<b>작성일시  </b>
									<span>2021-04-16</span>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<input type="text" class="form-control" value="사업자 등록 요청합니다.">
						</div>
						<div class="mb-3">
							<p class="form-control">
								사업자 등록을 요청합니다.<br>
								사업자번호는 --- 입니다.<br>
								사업자등록증 사진을 첨부합니다.
							</p>
						</div>
						<div class="mb-3">
							<a href="<%=request.getContextPath()%>/files/images/sample-normal.jpg" download>
								<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" style="max-width: 120px;" alt="첨부파일">
							</a>
						</div>
						<!-- TODO 작성자만 보여야 하는 버튼 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
						<!-- TODO 답변이 달리기 전에만 취소버튼이 나타남 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
						<div class="gap-2 d-md-flex justify-content-md-end">
							<button type="reset" class="btn btn-primary">취소</button>
						</div>
					</form>
					<div class="row mt-4">
						<div class="col-1">
							<img src="<%=request.getContextPath()%>/files/images/sample-normal.jpg" style="width: 100%;" alt="답변">
						</div>
						<div class="col">
							<form class="p-4" style="border: 1px solid #789F6F; border-radius: 5px;">
								<div class="mb-3">
									<input type="text" class="form-control" value="RE: 사업자 등록 요청합니다.">
								</div>
								<!-- TODO 관리자만 보여야 하는 버튼 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< -->
								<div class="mb-3">
									<p class="form-control">
										요청이 확인되었습니다.<br>
										이용 가능합니다.<br>
									</p>
								</div>
								<div class="gap-2 d-md-flex justify-content-md-end">
									<button type="reset" class="btn btn-primary">취소</button>
									<button type="submit" class="btn btn-primary">완료</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<!-- 
	 <div class="row">
	     <div class="col-md-3 p-3" align="center">
				<ul class="list-group list-group-flush">
					<li style="list-style:none; font-size:30px">에코마당</li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">이벤트</a></li>
					<li class="list-group-item"><a href="/board/notice" style="text-decoration : none">공지사항</a></li>
					<li class="list-group-item"><a href="#" style="text-decoration : none">에코게시판</a></li>
				</ul>
	      </div>
	      <div class="col-md-9 p-5">
	      	<div  style="border:1px solid #789F6F; height:900px">
				<div style="top:10px; font-size: 30px; width:95%; margin-left:3%; margin-top:5%">제목</div><hr>
				<div style="margin-top:20px; margin-left:3%; height:400px; width:95%; margin-left:3%;">내용</div>
				
				
				<div style="border:1px solid #789F6F; margin-top:20px; margin-left:3%; height:300px; width:95%; margin-left:3%;">
					<div style="text-align:left; font-size: 20px; width:95%; margin-left:2%; margin-top:3%">관리자답변<hr></div>
					<div style="width:90%; height:70%; margin-left:5%;">내용</div>
				</div>
				
					<button type="submit" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:10px">수정</button>
					<button type="reset" class="btn btn-outline-success" style="float: right; margin-top:10px; margin-right:5px">삭제</button>
	      	</div>
	      </div>
      </div>
       -->
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>