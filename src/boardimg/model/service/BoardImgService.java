package boardimg.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardimg.model.dao.BoardImgDAO;
import boardimg.model.vo.BoardImgData;
import common.JDBCTemplate;

public class BoardImgService {
		
	private JDBCTemplate factory;

	public BoardImgService() {
		factory = JDBCTemplate.getConnection();
	}

	public int registerFileInfo(BoardImgData boardImgData) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new BoardImgDAO().insertFileInfo(conn, boardImgData);
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
