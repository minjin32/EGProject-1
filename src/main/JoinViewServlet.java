package main;

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

@WebServlet("/member/join")
public class JoinViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/login/join.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Member member = new Member();
		member.setMbId((String)request.getParameter("memberId"));
		member.setMbPassword((String)request.getParameter("memberPw"));
		member.setMbName((String)request.getParameter("memberName"));
		member.setMbEmail((String)request.getParameter("memberEmail"));
		member.setMbPhone((String)request.getParameter("memberPhone"));
		int result = new MemberService().registerMember(member);
		
		if (0 < result) {
			response.sendRedirect("/index.jsp");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "가입에 실패했습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

}
