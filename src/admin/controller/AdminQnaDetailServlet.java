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
import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;

@WebServlet("/admin/qna/detail")
public class AdminQnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminQnaDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qaNo = Integer.parseInt(request.getParameter("qaNo"));
		System.out.println(qaNo);
		MypageQaData mypageQaData = new MypageQaService().printOne(qaNo);
		String memberId = (String) request.getSession().getAttribute("memberId");
		int memberType = 0;
		System.out.println(qaNo);
		
		if (memberId == null) {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "로그인을 해주세요."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("location.href='/';");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		Member member = new MemberService().selectOneById(memberId);
		memberType = member.getMbType();
		
		if (memberType != '9') {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "권한이 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("location.href='/';");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		if (mypageQaData != null) {
			request.setAttribute("mypageQaData", mypageQaData);
			request.setAttribute("memberType", memberType);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminQnaDetail.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
