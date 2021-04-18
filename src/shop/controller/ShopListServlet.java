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

import shop.model.service.ShopService;
import shop.model.vo.Shop;
import shop.model.vo.ShopPageData;

@WebServlet("/shop/list")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		String add1 = request.getParameter("address1");
		String add2 = request.getParameter("address2");
		String add3 = request.getParameter("address3");
		
		ShopPageData shopPageData = new ShopService().selectListByAddress(add1, add2, add3, currentPage);
		ArrayList<Shop> sList = shopPageData.getShopList();
		String pageNavi = shopPageData.getPageNavi();
		if (!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.setAttribute("pageNavi", pageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/shop/shopList.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "검색 결과가 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

}
