package eventimg.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardimg.model.dao.BoardImgDAO;
import common.JDBCTemplate;
import eventimg.model.dao.EventImgDAO;
import eventimg.model.vo.EventImgData;

public class EventImgService {
		
	private JDBCTemplate factory;

	public EventImgService() {
		factory = JDBCTemplate.getConnection();
	}

	public int registerFileInfo(EventImgData eventImgData) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new EventImgDAO().insertFileInfo(conn, eventImgData);
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int updateFile(String imagePath, String imageName) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn=factory.createConnection();
			result = new BoardImgDAO().updateFile(conn, imagePath, imageName);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
}
