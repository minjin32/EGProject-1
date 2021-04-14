package shop.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import shop.model.dao.ShopDAO;
import shop.model.vo.ShopPageData;

public class ShopService {
	private JDBCTemplate factory;
	
	public ShopService () {
		factory = JDBCTemplate.getConnection();
	}
	
	public ShopPageData selectListByAddress(String add1, String add2, String add3, int targetPage) {
		Connection conn = null;
		ShopPageData pd = null;
		
		try {
			conn = factory.createConnection();
			pd.setShopList(new ShopDAO().selectListByAddress(conn, add1, add2, add3, targetPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pd;
	}
	
}
