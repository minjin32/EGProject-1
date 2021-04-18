package eco.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/notice/write")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/eco/boardWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("userId")) != null) {
			String userId = (String)session.getAttribute("userId");
			Notice notice = new Notice();
			notice.setSubject(subject);
			notice.setContents(content);
			notice.setUserId(userId);
			int result = new NoticeService().insertNotice(notice);
			if(result > 0) {
				response.sendRedirect("notice/list");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("");
				view.forward(request, response);
			}
		}else {
			RequestDispatcher view = request.getRequestDispatcher("");
			view.forward(request, response);
		}
	}
}
