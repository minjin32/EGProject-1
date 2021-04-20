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

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/eco/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/boardWrite.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";

		String uploadFilePath = request.getServletContext().getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,new DefaultFileRenamePolicy());
		System.out.println("=========multi"+multi.toString());
		File uploadFile = multi.getFile("upFile");
		String fileName = multi.getFilesystemName("upFile");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();

		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));

		HttpSession session = request.getSession();
//		if (session != null && (session.getAttribute("userId")) != null) {
			String userId = (String) session.getAttribute("userId");
			Board board = new Board();
			board.setBoardTitle(subject);
			board.setBoardContent(content);
			board.setMemberId(userId);
			board.setImageName(fileName);
			board.setImagePath(filePath);
			board.setImageSize(fileSize);

			int result = new BoardService().insertBoard(board);

			if (result > 0) {
				response.sendRedirect("/eco/board/list");
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String msg = "오류가 발생했습니다."; // 오류 메세지
				out.println("<script>");
				out.println("alert('" + msg + "');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
				out.close();
			}
//		} else {
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			String msg = "로그인을 해주세요."; // 오류 메세지
//			out.println("<script>");
//			out.println("alert('" + msg + "');");
//			out.println("history.back();");
//			out.println("</script>");
//			out.flush();
//			out.close();
//		}

	}

}
