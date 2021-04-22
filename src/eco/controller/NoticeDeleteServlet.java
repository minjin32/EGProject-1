package eco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/eco/notice/delete")
public class NoticeDeleteServlet extends HttpServlet implements Servlet {
   private static final long serialVersionUID = 1L;

   public NoticeDeleteServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
      
      String memberId = (String)request.getSession().getAttribute("memberId");
      
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
      
      // 공지사항 번호로 공지사항을 가져옴
      Notice notice = new NoticeService().printOnebyNo(noticeNo);
      System.out.println(notice.getMbId());
      
      // 공지사항 작성자가 로그인한 사용자와 일치하는지 확인
      if (notice.getMbId().equals(memberId)) {
         System.out.println("게시물 아이디 : " +notice.getMbId() + "세션아이디" + memberId);
         
      } else {
//      if (!(memberId).equals(notice.getMbId())) {
         response.setContentType("text/html; charset=utf-8");
         PrintWriter out = response.getWriter();
         String msg = "삭제할 권한이 없습니다."; // 오류 메세지
         out.println("<script>");
         out.println("alert('" + msg + "');");
         out.println("history.back();");
         out.println("</script>");
         out.flush();
         out.close();
         return;
      }
      
      int result = new NoticeService().deleteNotice(noticeNo);
      
      if (0 < result) {
         response.sendRedirect("/eco/notice/list");
//         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/noticeList.jsp");
//         view.forward(request, response);
      } else {
         response.setContentType("text/html; charset=utf-8");
         PrintWriter out = response.getWriter();
         String msg = "삭제에 실패하였습니다."; // 오류 메세지
         out.println("<script>");
         out.println("alert('" + msg + "');");
         out.println("history.back();");
         out.println("</script>");
         out.flush();
         out.close();
         return;
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}