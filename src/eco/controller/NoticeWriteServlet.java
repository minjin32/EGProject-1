package eco.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.activation.FileDataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.service.MemberService;
import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/eco/notice/write")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
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
		
		// 멤버 ID로 멤버 객체를 가져옴
		Member member = new MemberService().selectOneById(memberId);
		
		System.out.println(member.getMbType());
		
		// 관리자 회원이 아닐경우 권한오류 및 뒤로가기
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
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
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
		
		// 멤버 ID로 멤버 객체를 가져옴
		Member member = new MemberService().selectOneById(memberId);
		
		System.out.println(member.getMbType());
		
		// 관리자 회원이 아닐경우 권한오류 및 뒤로가기
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
		
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";
		
		String uploadFilePath = request.getServletContext().getRealPath("upload");
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		File uploadFile = multi.getFile("upFile");
		String fileName = multi.getFilesystemName("upFile");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();
		
		
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		
		// 여기를 세션에서 multi로 바꿔줘야한다
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//		Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		
		Notice notice = new Notice();
		notice.setNoTitle(subject);
		notice.setNoContent(content);
		notice.setMbId(memberId);
		notice.setImageName(fileName);
		notice.setImagePath(filePath);
		notice.setImageSize(fileSize);
		
		int result = new NoticeService().insertNotice(notice);
		
		if (result > 0) {
			response.sendRedirect("/eco/notice/list");
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "공지사항 작성에 실패했습니다."; // 오류 메세지
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
