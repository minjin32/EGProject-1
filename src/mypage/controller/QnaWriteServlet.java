package mypage.controller;

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

import boardimg.model.service.BoardImgService;
import boardimg.model.vo.BoardImgData;
import mypageqa.model.service.MypageQaService;
import mypageqa.model.vo.MypageQaData;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/mypage/qna/write")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnaWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/qnaWrite.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String uploadFilePath = request.getServletContext().getRealPath("upload"); // server에 option : serve check해주기 그래야 내가 진행하는 프로젝트에 저장
		int uploadFileSizeLimit = 5*1024*1024; // 5백만 바이트 , 백만바이트면 5MB임
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(
									request, 
									uploadFilePath, 
									uploadFileSizeLimit, 
									encType, 
									new DefaultFileRenamePolicy()); // 중복된 이름의 파일이 올라갔을 때 자동으로 1붙여서 업로드 가능하게 하는 메소드
		
		String qaTitle = multi.getParameter("qaTitle");
		String qaContent = multi.getParameter("qaContent");
		String fileName = multi.getFilesystemName("upFile");
		File uploadFile = multi.getFile("upFile");
		String filePath = null;
		long fileSize = 0;
		if(fileName != null && uploadFile != null) {
			filePath = uploadFile.getPath();
			fileSize = uploadFile.length();
		}

		HttpSession session = request.getSession(); 
//		if (session != null && (session.getAttribute("userId")) != null) {
			String mbId = (String) session.getAttribute("memberId");
			MypageQaData mypageQaData = new MypageQaData();
			mypageQaData.setQaTitle(qaTitle);
			mypageQaData.setQaContent(qaContent);
			mypageQaData.setMbId(mbId);
			mypageQaData.setImage_name(fileName);
			mypageQaData.setImage_path(filePath);
			mypageQaData.setImage_size(fileSize);
			int result = new MypageQaService().insertMypageQaData(mypageQaData);
			if (result > 0) {
				response.sendRedirect("/mypage/qna/list"); 
			} else {
				RequestDispatcher view = request.getRequestDispatcher("#");
				view.forward(request, response);
			}
//		}else {
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/serviceFailed.html");
//			view.forward(request, response);
//		}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response, Timestamp uploadTime)
//			throws ServletException, IOException {
//		doGet(request, response);
//		request.setCharacterEncoding("UTF-8");
//		int uploadFileSizeLimit = 5 * 1024 * 1024;
//		String encType = "utf-8";
//
//		String uploadFilePath = request.getServletContext().getRealPath("upload");
//
//		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
//				new DefaultFileRenamePolicy());
//
//		File uploadFile = multi.getFile("upFile");
//		String fileName = multi.getFilesystemName("upFile");
//		String filePath = uploadFile.getPath();
//		long fileSize = uploadFile.length();
//
//		String qaTitle = multi.getParameter("qaTitle");
//		String qaContent = multi.getParameter("qaContent");
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//		uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
//
//		HttpSession session = request.getSession();
////		if(session != null && (session.getAttribute("mbId")) != null) {
//		String mbId = (String) session.getAttribute("mbId");
//		MypageQaData mypageQaData = new MypageQaData();
//		mypageQaData.setQaTitle(qaTitle);
//		mypageQaData.setQaContent(qaContent);
//		mypageQaData.setMbId(mbId);
//
//		// 파일부분
//		BoardImgData boardimg = new BoardImgData();
//		boardimg.setImageName(fileName);
//		boardimg.setImagePath(filePath);
//		boardimg.setImageSize(fileSize);
//		boardimg.setUploadTime(uploadTime);
//
//		int result = new MypageQaService().insertMypageQaData(mypageQaData);
//		int fileResult = new BoardImgService().registerFileInfo(boardimg);
//
//		if (result > 0 && fileResult > 0) {
//			response.sendRedirect("/mypage/qna/list");
//		} else {
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			String msg = "표시할 내용이 없습니다."; // 오류 메세지
//			out.println("<script>");
//			out.println("alert('" + msg + "');");
//			out.println("history.back();");
//			out.println("</script>");
//			out.flush();
//			out.close();
//		}

//		}else {
//			RequestDispatcher view = request.getRequestDispatcher("#");
//			view.forward(request, response);
//		}
	}

}
