package mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class Infomodify
 */
@WebServlet("/mypage/modify")
public class ModifyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public ModifyServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String memberId = (String)request.getSession().getAttribute("memberId");
	  Member member = new MemberService().selectOneById(memberId);
	  request.setAttribute("member",member);
	  RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/modify.jsp");
	  view.forward(request, response);

   }
   

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
      
      int result = new MemberService().modifyMember(member);
      if (0 < result) {
         response.sendRedirect("/mypage/info?memberId="+memberId);
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
         return;
      }
   }

}