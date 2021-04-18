package eco.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

@WebServlet("/notice/list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			if (session != null && (session.getAttribute("userId")) != null) {
				int currentPage = 0;
				if (request.getParameter("currentPage") == null) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				NoticePageData noPageData = new NoticeService().printAllList(currentPage);
				ArrayList<Notice> nList = noPageData.getNoticeList();
				String pageNavi = noPageData.getPageNavi();
				if (!nList.isEmpty()) {
					request.setAttribute("nList", nList);
					request.setAttribute("pageNavi", pageNavi);
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeList.jsp");
					view.forward(request, response);
				} else {
				}
			} else {
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
