package eco.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/eco/board/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardModifyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		if (memberId == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "로그인을 해주세요."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='/member/login';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
		
		Member member = new MemberService().selectOneById(memberId);
		
		// 본인의 글 혹은 관리자가 아닐 경우 오류메세지 출력 후 리스트로
		if (!(memberId == member.getMbName() || member.getMbType() == 9)) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "권한이 없습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='/eco/board/list';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/boardWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		
		if (memberId == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "로그인을 해주세요."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='/member/login';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
		
		String fileName = null;
		String filePath = null;
		long fileSize = 0l;
		
		
		// 첨부파일이 있을 경우에만 실행
		if (request.getParameter("upFile") != null) {
			int uploadFileSizeLimit = 5*1024*1024;
			String encType = "utf-8";
	
			String uploadFilePath = request.getServletContext().getRealPath("upload");
	
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,new DefaultFileRenamePolicy());
			System.out.println("=========multi"+multi.toString());
			File uploadFile = multi.getFile("upFile");
			fileName = multi.getFilesystemName("upFile");
			filePath = uploadFile.getPath();
			fileSize = uploadFile.length();
		}
		

		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setMemberId(memberId);
		board.setImageName(fileName);
		board.setImagePath(filePath);
		board.setImageSize(fileSize);
		
		int result = new BoardService().insertBoard(board);

		if (result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/boardList.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "글 작성에 실패했습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='/eco/board/list';");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}

	}

}
