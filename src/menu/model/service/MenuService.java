package menu.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import menu.model.dao.MenuDAO;
import menu.model.vo.MenuVO;

public class MenuService {
	
	private JDBCTemplate factory;
	
	public MenuService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<MenuVO> selectListByShopNumber(int shopNumber) {
		ArrayList<MenuVO> list = null;
		
		try {
			Connection conn = factory.createConnection();
			list = new MenuDAO().selectListByShopNumber(conn, shopNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
