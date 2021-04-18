package mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = "";
		int orderNo = 0;
		if (request.getParameter("memberId") != null) {
			memberId = request.getParameter("memberId");
			OrderListService orderlistservice = new OrderListService();
			OrderList orderlist = orderlistservice.selectByMemberIdList(memberId);
			if (orderlist != null) {
				request.setAttribute("orderlist", orderlist);
				request.getRequestDispatcher("/WEB-INF/views/mypage/orderlist.jsp").forward(request, response);
			} else {
				System.out.println("죄송합니다..");
			}
			// memberId 이걸로 조회
		}
		if (request.getParameter("orderNo") != null) {
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
			OrderListService orderlistservice = new OrderListService();
			OrderList orderlist = orderlistservice.selectByOrderList(orderNo);
			if(orderlist !=null) {
				request.setAttribute("orderlist", orderlist);
				request.getRequestDispatcher("/WEB-INF/views/mypage/orderlist.jsp").forward(request, response);

			}else {
			
			}
			// orderNo 이걸로 조회
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
