package shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.service.ShopService;
import shop.model.vo.Shop;

@WebServlet("/shop/detail")
public class ShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Shop shop = new ShopService().selectOneByShopNo(Integer.parseInt(request.getParameter("shopNumber")));
		request.setAttribute("shop", shop);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopDetail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
