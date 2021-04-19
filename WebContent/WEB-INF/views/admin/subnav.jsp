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
	      <li style="list-style:none; font-size:30px;"><a href="/admin">관리자페이지</a></li>
	      <li class="list-group-item"><a href="/admin/member/list" style="text-decoration : none">회원 관리</a></li>
	      <li class="list-group-item"><a href="/admin/owner/list" style="text-decoration : none">사업자관리</a></li>
	      <li class="list-group-item"><a href="/admin/qna" style="text-decoration : none">QnA문의</a></li>
	   </ul>
	</div>
</div>
<!-- PC 서브내비 end -->
<!-- 모바일 서브내비 start -->
<div class="d-lg-none d-block pb-4">
	<div class="btn-group" role="group" style="width: 100%;">
		<button type="button" class="btn btn-primary">
			관리자 홈
		</button>
		<button type="button" class="btn btn-primary">
			회원 관리
		</button>
		<button type="button" class="btn btn-primary">
			사업자 관리
		</button>
		<button type="button" class="btn btn-primary">
			QnA 문의
		</button>
	</div>
</div>
<!-- 모바일 서브내비 end -->
