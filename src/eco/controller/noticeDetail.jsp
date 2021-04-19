<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
	<h2>제목 : <%=notice.getSubject() %></h2>
	<h6>글번호 : <%= notice.getNoticeNo() %>/ 글쓴이 : <%= notice.getUserId() %>/ 작성일 : <%= notice.getRegDate() %></h6>
	<h3>글내용</h3>
	<div>
		<%= notice.getContents() %>
	</div>
	<a href="/notice/modify?noticeNo=<%= notice.getNoticeNo() %>">수정</a>
	<a href="#">목록</a>
	<!-- 쿼리문이 DELETE FROM NOTICE 하면 모든 데이터가 삭제가 되기 때문에
	특정 데이터만 삭제할 수 있도록 NOTICENO와 같은 식별자가 필요해요!! 맞아요!
	즉, 쿼리스트링으로 NOTICENO를 넘겨주어야 해요!
	 -->
	<a href="/notice/delete?noticeNo=<%=notice.getNoticeNo()%>">삭제</a>
	
	<form action="">
		comment : <input type="text" palceholder="댓글을 작성해보세요">
		<input type="submit" value="작성">
	</form>
	<!-- 댓글 출력 영역 -->
	<table>
		<tr>
			<th>댓글</th>
			<th>아이디</th>
			<th>날짜</th>
		</tr>
		<% for(;;){ %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<% } %>
	</table>
</body>
</html>