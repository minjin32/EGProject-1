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

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/eco/notice/update")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new NoticeService().printOnebyNo(noticeNo);
		if (notice != null) {
			request.setAttribute("notice", notice);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeUpdate.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "페이지를 불러오지 못했습니다."; // 오류 메세지
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "utf-8";

		String uploadFilePath = request.getServletContext().getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,new DefaultFileRenamePolicy());

		File uploadFile = multi.getFile("upFile");
		String fileName = "";
		String filePath = "";
		long fileSize = 0;
		if(uploadFile != null) {
			fileName = multi.getFilesystemName("upFile");          
			filePath = uploadFile.getPath();                       
			fileSize = uploadFile.length();                          
		}

		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		int noticeNo = 0;
		if(multi.getParameter("noticeNo") != null) {
			noticeNo = Integer.parseInt(multi.getParameter("noticeNo"));
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		
		HttpSession session = request.getSession();
		if (request.getSession().getAttribute("memberId") != null) {
			String memberId = (String) session.getAttribute("memberId");
			Notice notice = new Notice();
			notice.setNoTitle(subject);
			notice.setNoContent(content);
			notice.setMbId(memberId);
			notice.setNoNo(noticeNo);
			notice.setImageName(fileName);
			notice.setImagePath(filePath);
			notice.setImageSize(fileSize);
			int result = new NoticeService().updateNotice(notice);

			if (result > 0) {
				response.sendRedirect("/eco/notice/list");
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
			return;
		}
	}

}
