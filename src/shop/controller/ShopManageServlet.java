package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;
import shop.model.service.ShopService;
import shop.model.vo.Shop;

@WebServlet("/shop/manage")
public class ShopManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopManageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = null;
		
		// 로그인 여부 확인
		if (request.getParameter("memberId") != null) {
			memberId = request.getParameter("memberId");
			
			// 비회원일 경우 오류메세지 출력, 뒤로가기
		} else {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "로그인을 해주세요."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("history.back();");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		
//		// ID로 member를 가져와서 사업자 여부 확인
//		Member member = new MemberService().selectOneById(memberId);
//		char memberType = member.getMbType();
//		
//		// 사업자가 아닌 경우 오류 메세지 출력, 뒤로가기
//		if (memberType != '1') { 
//			response.setContentType("text/html; charset=utf-8");
//            PrintWriter out = response.getWriter();
//            String msg = "사업자 회원이 아닙니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//            out.println("<script>");
//            out.println("alert('" + msg + "');");
//            out.println("history.back();");
//            out.println("</script>");
//            out.flush();
//            out.close();
//            return;
//		}
//		
//		// ID로 가게 가져오기
//		Shop shop = null;
//		if (request.getParameter("shopNumber") != null) {
//			
//		} else {
//			response.setContentType("text/html; charset=utf-8");
//            PrintWriter out = response.getWriter();
//            String msg = "가게 번호를 입력해주세요."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//            out.println("<script>");
//            out.println("alert('" + msg + "');");
//            out.println("history.back();");
//            out.println("</script>");
//            out.flush();
//            out.close();
//		}
		
		// 사업자 ID로 주문내역을 가져오기
		ArrayList<OrderList> orderList = new OrderListService().selectListByOwnerID(memberId);
		
		request.setAttribute("orderList", orderList);
		System.out.println(orderList.toString());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopManage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
