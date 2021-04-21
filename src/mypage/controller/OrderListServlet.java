package mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		
		if (memberId != null) {
			OrderService orderService = new OrderService();
			ArrayList<OrderVO> orderList = orderService.selectListByMemberId(memberId);
			
			if (orderList != null) {
				request.setAttribute("orderList", orderList);
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
			out.println("location.href='/member/login/';");
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
