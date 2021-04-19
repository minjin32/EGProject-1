package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;

@WebServlet("/shop/manage")
public class ShopManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopManageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopNumber = Integer.parseInt(request.getParameter("shopNumber"));
		ArrayList<OrderList> orderList = new OrderListService().selectListByShopNumber(shopNumber);
		
		request.setAttribute("orderList", orderList);
		System.out.println(orderList.toString());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopManage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
