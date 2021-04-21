package event.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import boardimg.model.dao.BoardImgDAO;
import common.JDBCTemplate;
import event.model.dao.EventDAO;
import event.model.vo.Event;

public class EventService {
		
	private JDBCTemplate factory;

	public EventService() {
		factory = JDBCTemplate.getConnection();
	}
	public int insertEvent(Event event) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn =factory.createConnection();
			result = new EventDAO().inserEvent(conn, event);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.commit(conn);
		}
		return result;
	}
	public ArrayList<Event> printAllList() {
		Connection conn = null;
		ArrayList<Event> list = null;
		
		try {
			conn=factory.createConnection();
			list = new EventDAO().printAllList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		System.out.println("서비스");
		return list;
	}
	}
	
	

