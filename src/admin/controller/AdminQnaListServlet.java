package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.MemberPageData;
import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;
import mypageqa.model.vo.PageData;

@WebServlet("/admin/qna/list")
public class AdminQnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminQnaListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int page = 0;
		if (request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageData pageData = new MypageQaService().printAllList(page);
		ArrayList<MypageQaData> mqList = pageData.getQaList();
		String pageNavi = pageData.getPageNavi();
		
		request.setAttribute("mqList", mqList);
		request.setAttribute("pageNav", pageNavi);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminQnaL.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
