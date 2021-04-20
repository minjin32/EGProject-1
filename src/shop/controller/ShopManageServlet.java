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
import menu.model.service.MenuService;
import menu.model.vo.MenuVO;
import orderlist.model.service.OrderListService;
import orderlist.model.vo.OrderList;
import shop.model.service.ShopService;
import shop.model.vo.Menu;
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
		if (request.getSession().getAttribute("memberId") != null) {
			memberId = (String) request.getSession().getAttribute("memberId");
			
			// 입력한 ID로 member객체를 가져옴
			Member member = new MemberService().selectOneById(memberId);
			
			// member type 확인 후 사업자가 아니면 오류메세지 출력, 뒤로가기
			if (member.getMbType() != '1') {
				response.setContentType("text/html; charset=utf-8");
	            PrintWriter out = response.getWriter();
	            String msg = "사업자 회원이 아닙니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	            out.println("<script>");
	            out.println("alert('" + msg + "');");
	            out.println("history.back();");
	            out.println("</script>");
	            out.flush();
	            out.close();
	            return;
			}
			
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
		
		// 사업자 ID로 가게를 가져오기
		Shop shop = new ShopService().selectOneByOwnerId(memberId);
		
		// 가게 번호로 메뉴 리스트 가져오기
		ArrayList<MenuVO> menuList = new MenuService().selectListByShopNumber(shop.getShopNumber());
		
		// 사업자 ID로 주문내역을 가져오기
		ArrayList<OrderList> orderList = new OrderListService().selectListByOwnerID(memberId);
		
		request.setAttribute("shop", shop);
		request.setAttribute("orderList", orderList);
		request.setAttribute("menuList", menuList);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopManage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
