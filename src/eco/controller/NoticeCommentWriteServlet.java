package eco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

@WebServlet("/eco/notice/comment/write/")
public class NoticeCommentWriteServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public NoticeCommentWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String memberId = (String) request.getSession().getAttribute("memberId");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int coParentNo = Integer.parseInt(request.getParameter("coParentNo"));
		String coContent = request.getParameter("coContent");

		NoticeComment noComment = new NoticeComment();
		noComment.setMemberId(memberId);
		noComment.setBoardNo(noticeNo);
		noComment.setCoParentNo(coParentNo);
		noComment.setCoContents(coContent);

//		int result = new NoticeService().registerNoticeCommnet(noComment);

//		if (0 < result) {
//			response.sendRedirect("/noticeDetail.jsp");
//		} else {
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			String msg = "댓글 입력에 실패했습니다."; // 오류 메세지
//			out.println("<script>");
//			out.println("alert('" + msg + "');");
//			out.println("history.back();");
//			out.println("</script>");
//			out.flush();
//			out.close();
//		}

	}
}
