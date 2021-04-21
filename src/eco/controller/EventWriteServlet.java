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
		
		request.setCharacterEncoding("UTF-8");
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";

		String uploadFilePath = request.getServletContext().getRealPath("upload");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
				new DefaultFileRenamePolicy());
		
		String eventTitle = multi.getParameter("eventTitle");
		String subject = multi.getParameter("subject");

		File uploadFile = multi.getFile("upFile");
		String fileName = multi.getFilesystemName("upFile");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));

		 HttpSession session = request.getSession();
	      if(request.getSession().getAttribute("memberId") != null) {
	      String userId = (String)session.getAttribute("userId");

		Event event = new Event();
		event.setEventTitle(eventTitle);
		event.setImagePath(filePath);
		event.setImageName(fileName);
		event.setImageSize(fileSize);
		 
		int result =new EventService().insertEvent(event);
			
		if(result>0) {
			response.sendRedirect("/eco/event");
		}else {
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
	}else {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String msg = "로그인을 해주세요."; // 오류 메세지
		out.println("<script>");
		out.println("alert('" + msg + "');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
		out.close();
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
	

	
