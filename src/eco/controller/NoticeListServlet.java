package eco.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

@WebServlet("/eco/notice/list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("memberId") != null) {
			String memberId = (String)session.getAttribute("memberId");
			Member member = new MemberService().selectOneById(memberId);
			request.setAttribute("member", member);
		}
		
		// 페이징 처리
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		// 공지사항 전체 리스트
		NoticePageData noPageData = new NoticeService().printAllList(currentPage);
		ArrayList<Notice> nList = noPageData.getNoticeList();
		String pageNavi = noPageData.getPageNavi();
		if (!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeList.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "표시할 내용이 없습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
