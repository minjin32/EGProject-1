package mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;

@WebServlet("/mypage/qna/detail")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qaNo = Integer.parseInt(request.getParameter("qaNo"));
		MypageQaData mypageQaData = new MypageQaService().printOne(qaNo);
		if (mypageQaData != null) {
			request.setAttribute("mypageQaData", mypageQaData);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/qnaDetail.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("#");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
