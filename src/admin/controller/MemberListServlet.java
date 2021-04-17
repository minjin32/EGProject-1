package admin.controller;

import java.io.IOException;
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
import member.model.vo.MemberPageData;
/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/admin/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session = request.getSession(); // 로그인한 사용자니까 세션에서 정보 가져오기
		// if(session != null && (session.getAttribute("userId")) != null) {
		// 유저 타입
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		String usertype = request.getParameter("usertype");
		String search = request.getParameter("searchKeyword");
		
		if(search == null) {
			MemberPageData pageData = new MemberService().selectMemberList(usertype, currentPage);
			ArrayList<Member> nList = pageData.getMemberList();
			String pageNavi = pageData.getPageNavi();
			if (!nList.isEmpty()) {
				request.setAttribute("nList", nList);
				request.setAttribute("pageNavi", pageNavi);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp");
				view.forward(request, response);
			}
		} else {
			MemberPageData pageData = new MemberService().selectByIdList(usertype, search, currentPage);
			ArrayList<Member> nList = pageData.getMemberList();
			String pageNavi = pageData.getPageNavi();
			if (!nList.isEmpty()) {
				request.setAttribute("nList", nList);
				request.setAttribute("pageNavi", pageNavi);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp");
				view.forward(request, response);
			}
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
