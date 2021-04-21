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

/**
 * Servlet implementation class AdmininfoServlet
 */
@WebServlet("/admin/info")
public class AdmininfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmininfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String)request.getSession().getAttribute("memberId");
		
		Member member = new MemberService().selectOneById(memberId);
	      if(member != null) {
	         // 성공하면 DB데이터를 가져와서 화면에 뿌려줄거에요
	         request.setAttribute("member", member);
	         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminInfo.jsp");
	         // memberMyInfo.jsp 페이지 없으면 만들어주세요
	         // member폴더 우클릭 new -> jsp
	         view.forward(request, response);
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
