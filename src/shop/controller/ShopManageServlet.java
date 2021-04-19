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

import member.model.vo.Member;
import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;

@WebServlet("/shop/manage")
public class ShopManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopManageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopNumber = 1;
		
//		if (request.getParameter("shopNumber") != null) {
//			shopNumber = Integer.parseInt(request.getParameter("shopNumber"));
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
