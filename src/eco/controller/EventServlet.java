package eco.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;
import event.model.vo.Event;

@WebServlet("/eco/event")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/eco/event.jsp");
		//view.forward(request, response);
		
		ArrayList<Event> eList = new EventService().printAllList();
		if(eList != null) {
			request.setAttribute("eList", eList);
			RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/views/eco/event.jsp");
			view.forward(request, response);
		}else {
			System.out.println("표시할 내용이 없습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
