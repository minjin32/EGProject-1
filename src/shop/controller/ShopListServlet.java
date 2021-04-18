package shop.controller;

import java.io.IOException;
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
	      
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		String add3 = request.getParameter("add3");

		ShopPageData shopPageData = new ShopService().selectListByAddress(add1, add2, add3, currentPage);
		System.out.println("리스트페이지서블렛 : " +  shopPageData);
		ArrayList<Shop> sList = shopPageData.getShopList();
		String pageNavi = shopPageData.getPageNavi();
		if (!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.setAttribute("pageNavi", pageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/shop/shopList.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/shop/shopList.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
