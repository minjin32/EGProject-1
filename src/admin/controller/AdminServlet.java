package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import mypageqa.model.vo.PageData;
import notice.model.service.NoticeService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = null;
		
		//로그인 여부 확인
		if(request.getSession().getAttribute("memberId") != null) {
			memberId = (String)request.getSession().getAttribute("memberId");
			
			Member member = new MemberService().selectOneById(memberId);
			
			if (member.getMbType() == '9') {
				
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
				view.forward(request, response);
				System.out.println(member.getMbType());

			} else if (member.getMbType() != '9') {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String msg = "관리자 회원이 아닙니다."; // 오류 메세지
				out.println("<script>");
				out.println("alert('" + msg + "');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
				out.close();
				return;
			} else {
				 response.setContentType("text/html; charset=utf-8");
		         PrintWriter out = response.getWriter();
		         String msg = "로그인을 해주세요."; // 오류 메세지
		         out.println("<script>");
		         out.println("alert('" + msg + "');");
		         out.println("history.back();");
		         out.println("</script>");
		         out.flush();
		         out.close();
		         return;
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
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
