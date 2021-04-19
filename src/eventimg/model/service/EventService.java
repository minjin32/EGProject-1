package eventimg.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardimg.model.dao.BoardImgDAO;
import common.JDBCTemplate;
import eventimg.model.dao.EventDAO;
import eventimg.model.vo.Event;

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
//	public Event printOneByNo(int eventNo) {
//		Connection conn = null;
//		Event event = null;
//		
//		try {
//			conn =factory.createConnection();
//			Event = new EventDAO().selectOneByNo(conn,EventNo);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return event;
//		
	}
	
	

