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
import com.oreilly.servlet.multipart.FileRenamePolicy;

import event.model.service.EventService;
import event.model.vo.Event;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EventWriteServlet
 */
@WebServlet("/eco/event/write")
public class EventWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/eventWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		int result = 0;
		
		if (memberId == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "로그인을 해주세요."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}

		// memberId 값으로 멤버 객체를 찾음
		Member member = new MemberService().selectOneById(memberId);
		// 관리자 회원인지 확인
		if (member.getMbType() != '9') {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "권한이 없습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}

		request.setCharacterEncoding("UTF-8");
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";

		String uploadFilePath = request.getServletContext().getRealPath("upload");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
				new DefaultFileRenamePolicy());


		File uploadFile = multi.getFile("upFile");

		// 첨부파일이 없을 경우 back
		if (uploadFile == null) {
			if (request.getAttribute("upFile") == null) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String msg = "이벤트 작성은 첨부파일이 필요합니다."; // 오류 메세지
				out.println("<script>");
				out.println("alert('" + msg + "');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
				out.close();
				return;
			}
		}
		String eventTitle = (String)request.getParameter("title");
		String fileName = multi.getFilesystemName("upFile");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();
		Event event = new Event();
		
		event.setEventTitle(eventTitle);
		event.setImagePath(filePath);
		event.setImageName(fileName);
		event.setImageSize(fileSize);
		event.setEventTitle(eventTitle);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		
		System.out.println(event.toString());

		result = new EventService().insertEvent(event);

		if (result > 0) {
			response.sendRedirect("/eco/event");
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
			return;
		}
	}
}

//	} else {
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		String msg = "로그인을 해주세요."; // 오류 메세지
//		out.println("<script>");
//		out.println("alert('" + msg + "');");
//		out.println("history.back();");
//		out.println("</script>");
//		out.flush();
//		out.close();
//	}
