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
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new MenuDAO().selectListByShopNumber(conn, shopNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}

	public MenuVO selectMenuByNumber(int menuNumber) {
		MenuVO menu = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			menu = new MenuDAO().selectOneByMenuNumber(conn, menuNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return menu;
	}
}
