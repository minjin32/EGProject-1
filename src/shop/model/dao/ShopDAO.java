package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.model.vo.Shop;

public class ShopDAO {

	public ArrayList<Shop> selectListByAddress(Connection conn, String add1, String add2, String add3, int targetPage) {
		ArrayList<Shop> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM SHOP WHERE SH_ADDRESS1 = ? AND SH_ADDRESS2 = ? AND SH_ADDRESS3 = ? AND SH_NO BETWEEN ? AND ? ORDER BY SH_NO";
		int amountPerPage = 10;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, add1);
			pstmt.setString(2, add2);
			pstmt.setString(3, add3);
			pstmt.setInt(4, ((targetPage - 1) * amountPerPage) + 1);
			pstmt.setInt(5, ((targetPage - 1) * amountPerPage) + amountPerPage);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				list = new ArrayList<Shop>();
				while (rset.next()) {
					Shop shop = new Shop();
					shop.setShopName(rset.getString("sh_name"));
					shop.setBusinessNumber(rset.getInt("sh_business_no"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
