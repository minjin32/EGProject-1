package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import menu.model.service.MenuService;
import menu.model.vo.MenuVO;
import order.model.service.OrderService;
import order.model.vo.OrderVO;
import shop.model.service.ShopService;
import shop.model.vo.Shop;

@WebServlet("/shop/order.do")
public class ShopOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String orderMsg = request.getParameter("orderMsg");
		Member member = new MemberService().selectOneById(memberId);
		
		if (member == null) {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "로그인을 해주세요."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("location.href='/member/login'");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		if (member.getMbType() != '0') {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "구매자 회원만 주문 가능합니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("history.back()");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		int shopNumber = Integer.parseInt(request.getParameter("shopNumber"));
		int menuNumber = Integer.parseInt(request.getParameter("menuNumber"));
		
		Shop shop = new ShopService().selectOneByShopNo(shopNumber);
		MenuVO menuVO = new MenuService().selectMenuByNumber(menuNumber);
		
		OrderVO order = new OrderVO();
		
		order.setMemberId(memberId);
		order.setShopNo(shop.getShopNumber());
		order.setOrderPrice(menuVO.getPrice());
		order.setOrderStatus(0);
		order.setShopName(shop.getShopName());
		order.setOrderMenu(menuVO.getImageName());
		order.setOrderMessage(orderMsg);
		order.setPhone(member.getMbPhone());
		
		int result = new OrderService().registerOrder(order);
		
		if (0 < result) {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "주문에 성공하셨습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("location.href='/mypage/orderlist'");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		} else {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "주문에 실패하셨습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
