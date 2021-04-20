package menu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import menu.model.vo.MenuVO;

public class MenuDAO {
	public ArrayList<MenuVO> selectListByShopNumber(Connection conn, int shopNumber) {
		ArrayList<MenuVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MENU WHERE SH_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNumber);
			rset = pstmt.executeQuery();
			list = new ArrayList<MenuVO>();
			while (rset.next()) {
				MenuVO menu = new MenuVO();
				menu.setBowlSize(rset.getString("bowl_size"));
				menu.setImageName(rset.getString("image_name"));
				menu.setImagePath(rset.getString("image_path"));
				menu.setImageSize(rset.getInt("image_size"));
				menu.setMenuNumber(rset.getInt("menu_no"));
				menu.setName(rset.getString("menu_name"));
				menu.setPrice(rset.getInt("menu_price"));
				menu.setShopNumber(rset.getInt("sh_no"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public MenuVO selectOneByMenuNumber(Connection conn, int menuNumber) {
		MenuVO menu = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MENU WHERE MENU_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menuNumber);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				menu = new MenuVO();
				menu.setBowlSize(rset.getString("bowl_size"));
				menu.setImageName(rset.getString("image_name"));
				menu.setImagePath(rset.getString("image_path"));
				menu.setImageSize(rset.getInt("image_size"));
				menu.setMenuNumber(rset.getInt("menu_no"));
				menu.setName(rset.getString("menu_name"));
				menu.setPrice(rset.getInt("menu_price"));
				menu.setShopNumber(rset.getInt("sh_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return menu;
	}
}
