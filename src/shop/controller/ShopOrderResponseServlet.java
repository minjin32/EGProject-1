package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.service.OrderService;
import order.model.vo.OrderVO;

@WebServlet("/shop/order/response")
public class ShopOrderResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopOrderResponseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주문 번호, 사업자의 응답을 가져옴
		int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
		int responseType = Integer.parseInt(request.getParameter("responseType"));
		
		// 주문 번호로 주문을 찾음
		OrderVO orderVo = new OrderService().selectByOrderList(orderNumber); 
		
		// 사업자의 응답을 반영함
		orderVo.setOrderStatus(responseType);
		
		// 조리완료 응답일 경우 완료시간을 기록함
		if (responseType == 2) {
			Date date = new Date();
			orderVo.setShopRuntime(date);
		}
		
		// update 처리
		int result = new OrderService().modifyOrder(orderVo);
		
		if (0 < result) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "접수 결과가 처리되었습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("location.reload();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "접수 처리에 실패하였습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
