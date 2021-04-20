package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.service.OrderService;
import order.model.vo.OrderVO;

/**
 * Servlet implementation class OrderListEnrollServlet
 */
@WebServlet("/mypage/orderlist/enroll")
public class OrderListEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListEnrollServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderVO orderlist = new OrderVO();
		orderlist.setOrderNo(Integer.parseInt(request.getParameter("shopNo")));
		orderlist.setShopNo(Integer.parseInt(request.getParameter("shopNo")));
		orderlist.setMemberId(request.getParameter("memberId"));
		orderlist.setOrderPrice(Integer.parseInt(request.getParameter("orderPirce")));
		orderlist.setOrderStatus(Integer.parseInt(request.getParameter("orderStatus")));
		orderlist.setShopName(request.getParameter("shopName"));
		orderlist.setOrderReject(request.getParameter("orderReject"));
//		orderlist.setShopRuntime(request.getParameter("runTime"));
		
		int result = new OrderService().registerOrder(orderlist);
		
		if(result> 0) {
			response.sendRedirect("");
		
		}else {
			response.sendRedirect("");
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
