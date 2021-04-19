package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.model.dao.AdminDAO;
import common.JDBCTemplate;

public class AdminService {
	
	private JDBCTemplate factory;
	
	public AdminService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public int selectQnACount() {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().selectQnACount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

}
