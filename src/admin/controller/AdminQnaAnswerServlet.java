package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;

@WebServlet("/admin/qna/answer")
public class AdminQnaAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminQnaAnswerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		int qaNo = Integer.parseInt(request.getParameter("qaNo"));
		int result = 0;
		
		MypageQaData qa = new MypageQaService().printOne(qaNo);
		qa.setQaNo(qaNo);
		qa.setAnswerContent(content);
		
		result = new MypageQaService().insertQaAnswer(qa);
		
		if (0 < result) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "답변 등록에 실패했습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("location.href='/admin/qna/list';");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
