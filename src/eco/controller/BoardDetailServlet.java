package eco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/eco/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		Member member = new MemberService().selectOneById(memberId);
		
		Board board = new BoardService().printOneByNo(boardNumber);
		if (board == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "표시할 내용이 없습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='/eco/board/list';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("member", member);
		request.setAttribute("board", board);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/boardDetail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
