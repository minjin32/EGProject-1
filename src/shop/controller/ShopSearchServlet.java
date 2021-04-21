package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import shop.model.service.ShopService;
import shop.model.vo.Shop;
import shop.model.vo.ShopPageData;

@WebServlet("/shop/search")
public class ShopSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		
		if (address1 == "" || address2 == "" || address3 == "") {
            PrintWriter out = response.getWriter();
            String msg = "주소를 정확히 입력해주세요."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("history.back();");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ShopPageData shopPd = new ShopService().selectListByAddress(address1, address2, address3, page);
		 
		if (shopPd == null) {
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            String msg = "표시할 내역이 없습니다."; // 오류 메세지 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            out.println("<script>");
            out.println("alert('" + msg + "');");
            out.println("history.back();");
            out.println("</script>");
            out.flush();
            out.close();
            return;
		}
		
		request.setAttribute("shopList", shopPd.getShopList());
		request.setAttribute("pageNav", shopPd.getPageNavi());
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/shopSearch.jsp");
		view.forward(request, response);
		
//		PrintWriter out = response.getWriter();
//		Gson gson = new Gson();
//		out.print(gson.toJson(shopPd));
//		out.flush();
//		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
