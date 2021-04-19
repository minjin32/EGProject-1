
package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;
import mypageqa.model.vo.PageData;

@WebServlet("/mypage/qna/list")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnaListServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		PageData pageData =  new MypageQaService().printAllList(currentPage);
		ArrayList<MypageQaData> mqList = pageData.getQaList();
		String PageNavi = pageData.getPageNavi();
		if(!mqList.isEmpty()) {
			request.setAttribute("mqList", mqList);
			request.setAttribute("pageNavi", PageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/qnaList.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("#");
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
