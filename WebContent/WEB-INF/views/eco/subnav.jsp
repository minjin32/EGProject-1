<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	.btn-submenu-pc {
		width: 90%;
		height: 4rem;
	}
	
	a {
		text-decoration: none;
	}
	
	a:hover {
		text-decoration: none;
	}
</style>
<!-- PC 서브내비 start -->
<div class="gy-5 d-none d-lg-block">
	<div class="row g-2">
		<ul class="list-group list-group-flush">
	      <li style="list-style:none; font-size:30px;"><a href="/eco/board/list">에코마당</a></li>
	      <li class="list-group-item"><a href="/eco/board/list" style="text-decoration : none">에코게시판</a></li>
	      <li class="list-group-item"><a href="/eco/event" style="text-decoration : none">이벤트</a></li>
	      <li class="list-group-item"><a href="/eco/notice/list" style="text-decoration : none">공지사항</a></li>
	   </ul>
	</div>
</div>

<!-- PC 서브내비 end -->
<!-- 모바일 서브내비 start -->
<div class="d-lg-none d-block pb-4">
	<div class="btn-group" role="group" style="width: 100%;">
		<button type="button" class="btn btn-primary">
			MyPage 홈
		</button>
		<button type="button" class="btn btn-primary">
			내 정보
		</button>
		<button type="button" class="btn btn-primary">
			주문 내역
		</button>
		<button type="button" class="btn btn-primary">
			QnA 문의
		</button>
	</div>
</div>
<!-- 모바일 서브내비 end -->