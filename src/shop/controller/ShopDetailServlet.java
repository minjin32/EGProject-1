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
import javax.servlet.http.HttpSession;

import menu.model.service.MenuService;
import menu.model.vo.MenuVO;
import shop.model.service.ShopService;
import shop.model.vo.Shop;

/**
 * Servlet implementation class ShopDetailServlet
 */
@WebServlet("/shop/detail")
public class ShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopNo = Integer.parseInt(request.getParameter("shopNumber"));
		Shop shop = new ShopService().selectOneByShopNo(shopNo);
		ArrayList<MenuVO> menuList = new ArrayList<>();
		menuList = new MenuService().selectListByShopNumber(shopNo);
		
		if (shop == null) {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "가게를 찾을 수 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("history.back();");
            out.println("</script>");
            out.flush();
            out.close();
		} else {
			request.setAttribute("shop", shop);
			request.setAttribute("menuList", menuList);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopDetail.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
