package eco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;


@WebServlet("/eco/notice/update")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeUpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new NoticeService().printOnebyNo(noticeNo);
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-IMF/views/eco/noticeDetail.jsp").forward(request, response);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "페이지를 불러오지 못했습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new Notice();
		notice.setSubject(subject);
		notice.setContents(content);
		notice.setNoticeNo(noticeNo);
		int result = new NoticeService().updateNotice(notice);
		if(result > 0) {
			response.sendRedirect("/eco/notice/list");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "오류가 발생했습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

}
