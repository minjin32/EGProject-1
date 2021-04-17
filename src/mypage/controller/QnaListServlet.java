package mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		
// 보완이 필요한 search 부분
//	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object searchkeyword)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String mbId = (String)session.getAttribute("mbId");
//		request.setCharacterEncoding("UTF-8");
//
//		int currentPage = 0;
//		if (request.getParameter("currentPage") == null) {
//			currentPage = 1;
//		} else {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		// String search = request.getParameter("searchKeyword");
//		if (searchkeyword == null) { // 검색하지 않은 상황
//			// 일반회원이면 자기id 리스트만 출력
//			// selectListById
//			PageData pageData =  new MypageQaService().printListById(currentPage);
//			
//			// 관리자면 모든i 리스트 출력
//			// selectAllList
//			pageData =  new MypageQaService().printAllList(currentPage);
//			ArrayList<MypageQaData> mqList = pageData.getQaList();
//			String PageNavi = pageData.getPageNavi();
//			if(!mqList.isEmpty()) {
//				request.setAttribute("mqList", mqList);
//				request.setAttribute("pageNavi", PageNavi);
//				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/qnaList.jsp");
//				view.forward(request, response);
//			}else {
//				RequestDispatcher view = request.getRequestDispatcher("#");
//				view.forward(request, response);
//			}
//			
//		} else { // 검색한 상황
//			// 키워드 포함된 리스트만 출력
//			// 일반회원인 경우
//			// selectListByIdAndKeyword
//			
//			
//			// 관리자인 경우
//			// selectListByKeyword
//			String search = request.getParameter("searchKeyword");
//			PageData pageData = new MypageQaService().printSearchList(search, currentPage);
//			ArrayList<MypageQaData> mqList = pageData.getQaList();
//			String pageNavi = pageData.getPageNavi();
//			if (!mqList.isEmpty()) {
//				request.setAttribute("mqList", mqList);
//				request.setAttribute("pageNavi", pageNavi);
//				request.getRequestDispatcher("/WEB-INF/views/mypage/qnaList.jsp").forward(request, response);
//				currentPage = 1;
//			} else {
//				request.getRequestDispatcher("#").forward(request, response);
//
//			}
//
//		}
//		
//				
//		// >>>>>
//		// 특정 사용자의 Qna리스트만 긁어오기.
//		// 모든 사용자의 Qna리스트 긁어오기.
//		// 관리자가 : 전체 회원의 qna를 출력해야 // 사용자가: 자신의 qna만 출력 
//		HttpSession session = request.getSession();
//		String userId = (String)session.getAttribute("memberId");
//		// MemberVO memberVO = MemberService.selectOneById(userId);
//		// if (memberVO.getMemberType()) == '9') {
//			
//		//}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
