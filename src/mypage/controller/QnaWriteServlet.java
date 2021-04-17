package mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;

@WebServlet("/mypage/qna/write")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/qnaWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		String qaTitle = request.getParameter("qaTitle");
		String qaContent = request.getParameter("qaContent");
		
		HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("mbId")) != null) {
			String mbId = (String) session.getAttribute("mbId");
			MypageQaData mypageQaData = new MypageQaData();
			mypageQaData.setQaTitle(qaTitle);
			mypageQaData.setQaContent(qaContent);
			mypageQaData.setMbId(mbId);
			int result = new MypageQaService().insertMypageQaData(mypageQaData);
			if(result > 0) {
				response.sendRedirect("/mypage/qna/list");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("#");
				view.forward(request, response);
			}
		}else {
			RequestDispatcher view = request.getRequestDispatcher("#");
			view.forward(request, response);
		}
	}

}
