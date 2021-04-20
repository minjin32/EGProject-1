package mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.service.OrderService;
import order.model.vo.OrderVO;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/mypage/orderlist")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String) request.getSession().getAttribute("memberId");
		int orderNo = 0;
		if (memberId != null) {
			OrderService orderlistservice = new OrderService();
			OrderVO orderlist = orderlistservice.selectByMemberIdList(memberId);
			
			if (orderlist != null) {
				request.setAttribute("orderlist", orderlist);
				request.getRequestDispatcher("/WEB-INF/views/mypage/orderList.jsp").forward(request, response);
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String msg = "표시할 내역이 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				out.println("<script>");
				out.println("alert('" + msg + "');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
				out.close();
				return;
			}
			// memberId 이걸로 조회
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
		
		// orderNo는 상세정보를 불러올 때 필요할텐데 여기 왜 있을까요?
//		if (request.getParameter("orderNo") != null) {
//			orderNo = Integer.parseInt(request.getParameter("orderNo"));
//			OrderListService orderlistservice = new OrderListService();
//			OrderList orderlist = orderlistservice.selectByOrderList(orderNo);
//			if (orderlist != null) {
//				request.setAttribute("orderlist", orderlist);
//				request.getRequestDispatcher("/WEB-INF/views/mypage/orderlist.jsp").forward(request, response);
//
//			} else {
//				response.setContentType("text/html; charset=utf-8");
//				PrintWriter out = response.getWriter();
//				String msg = "표시할 내역이 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//				out.println("<script>");
//				out.println("alert('" + msg + "');");
//				out.println("history.back();");
//				out.println("</script>");
//				out.flush();
//				out.close();
//			}
//			 // orderNo 이걸로 조회
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
