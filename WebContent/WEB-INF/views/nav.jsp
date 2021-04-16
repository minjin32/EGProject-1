<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
   header{
      position:sticky;
      z-index: 9999;
      top:0;
      
   }
   
   a:hover{
      color:#af8d2f;
      font-weight: bold;
      
   }
   
   a{
      color:#333;
      font-weight: bold;
   }
</style>

<header>
	<nav class="navbar navbar-expand-lg bg-primary" style="background-color:white !important;">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/introduce" style="color: #333;">EGProject</a>
	    <div class="collapse navbar-collapse">
	       <!-- nav 왼쪽 -->
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"  id="navi">
	        <li class="nav-item"  id="navi">
	          <a class="nav-link active" href="/introduce">소개</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/service">서비스</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/shop/list">가게 찾기
	          </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/ecoboard">에코마당</a>
	        </li>
	      </ul>
	      <!-- nav 왼쪽 끝 -->
	      <!-- nav 오른쪽 -->
	      <ul class="navbar-nav mr-auto mb-2 mb-lg-0"  id="navi">
	         <% if (session.getAttribute("userId") != null) { %>
	          <li class="nav-item">
	             <a class="nav-link active" href="#">마이페이지</a>
	          </li>
	          <% } else { %>
	          <li class="nav-item">
	             <a class="nav-link active" href="#">로그인</a>
	          </li>
	       <% } %>
	      </ul>
	      <!-- nav 오른쪽 끝 -->
	    </div>
	  </div>
	</nav>
</header>
