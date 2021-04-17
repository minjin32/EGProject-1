package shopimg.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardimg.model.dao.BoardImgDAO;
import boardimg.model.vo.BoardImgData;
import common.JDBCTemplate;
import shopimg.model.dao.ShopImgDAO;
import shopimg.model.vo.ShopImgData;

public class ShopImgService {
		
	private JDBCTemplate factory;

	public ShopImgService() {
		factory = JDBCTemplate.getConnection();
	}

	public int registerFileInfo(ShopImgData shopImgData) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new ShopImgDAO().insertFileInfo(conn, shopImgData);
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
