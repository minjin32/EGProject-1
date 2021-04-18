package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;

/**
 * Servlet implementation class OrderListModifyServlet
 */
@WebServlet("/mypage/orderlist/modify")
public class OrderListModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderList orderlist = new OrderList();
		orderlist.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
		
		int result= new OrderListService().modifyOrderCancel(orderlist);
		if(result>0) {
			response.sendRedirect("");
		}else {
			response.sendRedirect("");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
