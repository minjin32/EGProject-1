package mypage.controller;

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
 * Servlet implementation class MyinfoServlet
 */
@WebServlet("/mypage/info")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyinfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String)request.getSession().getAttribute("memberId");
		
		Member member = new MemberService().selectOneById(memberId);
	      if(member != null) {
	         // 성공하면 DB데이터를 가져와서 화면에 뿌려줄거에요
	         request.setAttribute("member", member);
	         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/info.jsp");
	         // memberMyInfo.jsp 페이지 없으면 만들어주세요
	         // member폴더 우클릭 new -> jsp
	         view.forward(request, response);
	      }else {
	    	  response.setContentType("text/html; charset=utf-8");
	          PrintWriter out = response.getWriter();
	          String msg = "회원정보 조회에 실패했습니다."; // 오류 메세지
	          out.println("<script>");
	          out.println("alert('" + msg + "');");
	          out.println("history.back();");
	          out.println("</script>");
	          out.flush();
	          out.close();
	      }
		
		
		
		RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/views/mypage/info.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
