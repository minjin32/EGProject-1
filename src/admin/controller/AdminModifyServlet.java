package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminModifyServlet
 */
@WebServlet("/admin/modify")
public class AdminModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/modify.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = (String)request.getSession().getAttribute("memberId");
		
		Member member = new Member();
		member.setMbId(memberId);
		member.setMbPassword((String) request.getParameter("memberPw"));
		member.setMbName((String) request.getParameter("memberName"));
		member.setMbNickname((String) request.getParameter("memberNickName"));
		member.setMbAddress1((String)request.getParameter("memberAddress1"));
		member.setMbPhone((String)request.getParameter("memberPhone"));
		member.setMbEmail((String) request.getParameter("memberEmail"));
	}
}
