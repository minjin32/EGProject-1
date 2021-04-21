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
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		  RequestDispatcher view =
//		  request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberList.jsp");
//		  view.forward(request, response);
		 
		
		 HttpSession session = request.getSession(); // 로그인한 사용자니까 세션에서 정보 가져오기
		 if(session != null && (session.getAttribute("userId")) != null) {
			 
		 }
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		String usertype = request.getParameter("usertype");
		// 회원
		String usertype = "0";
//		String search = request.getParameter("searchKeyword");
		
//		if(search == null) {
			MemberPageData pageData = new MemberService().selectMemberList(usertype, currentPage);
			ArrayList<Member> mList = pageData.getMemberList();
			String pageNavi = pageData.getPageNavi();
			if (!mList.isEmpty()) {
				request.setAttribute("mList", mList);
				request.setAttribute("pageNavi", pageNavi);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberList.jsp");
				view.forward(request, response);
			} 
//			else {
//				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberList.jsp");
//				view.forward(request, response);
//			}
//		} else {
//			MemberPageData pageData = new MemberService().selectByIdList(usertype, search, currentPage);
//			ArrayList<Member> nList = pageData.getMemberList();
//			String pageNavi = pageData.getPageNavi();
//			if (!nList.isEmpty()) {
//				request.setAttribute("nList", nList);
//				request.setAttribute("pageNavi", pageNavi);
//				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberList.jsp");
//				view.forward(request, response);
//			} else {
//				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberList.jsp");
//				view.forward(request, response);
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
