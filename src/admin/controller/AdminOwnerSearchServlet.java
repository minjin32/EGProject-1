package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.MemberPageData;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminMemberSearchServlet
 */
@WebServlet("/admin/owner/search")
public class AdminOwnerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOwnerSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String usertype = "1";
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 검색어가 keyword에 담김
		String keyword = request.getParameter("searchKeyword");
		MemberPageData pd = new MemberService().selectSearchList(usertype, keyword, currentPage);
		
		//MemberPageData pd = new MemberService().selectMemberList(usertype, currentPage); // 이름은 대충 적은것. id로 찾기.
		
		//System.out.println(pd);
		// jsp에 출력할 회원리스트를 저장
		request.setAttribute("pd", pd);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminOwnerSearch.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
