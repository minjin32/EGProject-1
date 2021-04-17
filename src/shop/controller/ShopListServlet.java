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

@WebServlet("/shop/list")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Shop> shopList = new ShopService().selectAll();
		request.setAttribute("shopList", shopList);
		
		if (shopList != null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopList.jsp");
			view.forward(request, response);
		} else {
			// 오류
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
