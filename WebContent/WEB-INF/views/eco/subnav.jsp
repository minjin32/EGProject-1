<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	.font{
		color : #605759;
		font-weight:bold;
	}
	
	.m-color{
		background-color: #D1E9CA;
		color: #605759;
		font-weight:bold;
		margin : 3px;
	}
	</style>
</head>
	<body>
	<!-- PC 탭 start -->
	<div class="col-md-3 p-3 d-none d-lg-block"  align="center">
		<ul class="list-group list-group-flush">
						<li class="font" style="list-style:none; font-size:30px">에코마당</li>
						<li class="font list-group-item"><a href="#" style="text-decoration : none">이벤트</a></li>
						<li class="font list-group-item"><a href="/board/notice" style="text-decoration : none">공지사항</a></li>
						<li class="font list-group-item"><a href="#" style="text-decoration : none">에코게시판</a></li>
		</ul>
	</div>
	
	<!-- 모바일 탭 start -->
	<div class="row d-lg-none d-block py-3">
		<div class="row d-flex justify-content-around align-items-center mx-auto">
			<input type="button" class="btn btn-primary col m-color" value="이벤트" style="border: 1px solid gray;">
			<input type="button" class="btn btn-primary col m-color" value="공지사항" style="border: 1px solid gray;">
			<input type="button" class="btn btn-primary col m-color" value="에코게시판" style="border: 1px solid gray;">
		</div>
	</div>
	<!-- 모바일 탭 end -->
	</body>
</html>