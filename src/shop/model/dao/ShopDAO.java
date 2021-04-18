package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.scenario.effect.impl.prism.PrDrawable;

import common.JDBCTemplate;
import shop.model.vo.Menu;
import shop.model.vo.Product;
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
					shop.setShopBusinessNumber(rset.getString("sh_business_no"));
				}
			}
			System.out.println("리스트 : " + list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Shop seletOneByShopNo(Connection conn, int shopNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM SHOP WHERE SH_NO = ?";
		Shop shop = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shopNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				shop = new Shop();
				shop.setShopNumber(rset.getInt("SH_NO"));
				shop.setMemberId(rset.getString("MB_ID"));
				shop.setShopName(rset.getString("SH_NAME"));
				shop.setShopBusinessNumber(rset.getString("SH_BUSINESS_NO"));
				shop.setShopAddress1(rset.getString("SH_ADDRESS1"));
				shop.setShopAddress2(rset.getString("SH_ADDRESS2"));
				shop.setShopAddress3(rset.getString("SH_ADDRESS3"));
				shop.setShopPhone(rset.getString("SH_PHON"));
				shop.setShopAddress(rset.getString("SH_ADDRESS"));
				shop.setShopOwner(rset.getString("SH_OWNER"));
				shop.setShopOpenTime(rset.getDate("SH_OPENTIME"));
				shop.setShopCloseTime(rset.getDate("SH_CLOSETIME"));
				shop.setShopIntroduce(rset.getString("SH_INTRODUCE"));
				shop.setShopType(rset.getInt("SH_TYPE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return shop;
	}

	public int updateMember(Connection conn, Shop shop) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE SHOP SET SH_NAME=?, SH_BUSINESS_NO=?, SH_ADDRESS1=?, SH_ADDRESS2=?, SH_ADDRESS3=?, "
				+ "SH_PHON=?, SH_ADDRESS=?, SH_OWNER=?, SH_OPENTIME=?, SH_CLOSETIME=?, SH_INTRODUCE=?, SH_ORIGIN=?, SH_TYPE=?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, shop.getShopName());
			pstmt.setString(2, shop.getShopBusinessNumber());
			pstmt.setString(3, shop.getShopAddress1());
			pstmt.setString(4, shop.getShopAddress2());
			pstmt.setString(5, shop.getShopAddress3());
			pstmt.setString(6, shop.getShopPhone());
			pstmt.setString(7, shop.getShopAddress());
			pstmt.setString(8, shop.getShopOwner());
			pstmt.setDate(9, shop.getShopOpenTime());
			pstmt.setDate(10, shop.getShopCloseTime());
			pstmt.setString(11, shop.getShopIntroduce());
			pstmt.setString(12, shop.getShopOrigin());
			pstmt.setInt(13, shop.getShopType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int insertShop(Connection conn, Shop shop) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SHOP VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, shop.getShopNumber());
			pstmt.setString(2, shop.getMemberId());
			pstmt.setString(3, shop.getShopName());
			pstmt.setString(4, shop.getShopBusinessNumber());
			pstmt.setString(5, shop.getShopAddress1());
			pstmt.setString(6, shop.getShopAddress2());
			pstmt.setString(7, shop.getShopAddress3());
			pstmt.setString(8, shop.getShopPhone());
			pstmt.setString(9, shop.getShopAddress());
			pstmt.setString(10, shop.getShopOwner());
			pstmt.setDate(11, shop.getShopOpenTime());
			pstmt.setDate(12, shop.getShopCloseTime());
			pstmt.setString(13, shop.getShopIntroduce());
			pstmt.setString(14, shop.getShopOrigin());
			pstmt.setInt(15, shop.getShopType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public ArrayList<Menu> selectMenuList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = null;
		String query = "SELECT * FROM SHOP JOIN MENU USING(SH_NO) WHERE SH_NO =?;";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rset.getInt("SH_NO"));
			rset = pstmt.executeQuery();
			list = new ArrayList<Menu>();
			while(rset.next()) {
				Menu menu = new Menu();
				menu.setMenuNo(rset.getInt("MENU_NO"));
				menu.setShNo(rset.getInt("SH_NO"));
				menu.setMenuName(rset.getString("MENU_NAME"));
				menu.setMenuPrice(rset.getInt("MENU_PRICE"));
				menu.setBowlSize(rset.getInt("BOWL_SIZE"));
				menu.setMenuPlug(rset.getString("MENU_PLUG"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	
	public ArrayList<Product> selectProductList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM SHOP JOIN PRUDUCT USING(SH_NO) WHERE SH_NO =?;";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rset.getInt("SH_NO"));
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) 
			{
				Product product = new Product();
				product.setPrNo(rset.getInt("PR_NO"));
				product.setShNo(rset.getInt("SH_NO"));
				product.setPrName(rset.getString("PR_NAME"));
				product.setPrDescription(rset.getString("PR_DESCRIPTION"));
				product.setPrPrice(rset.getInt("PR_PRICE"));
				product.setPrStatus(rset.getString("PR_STATUS"));
				product.setPrPlug(rset.getInt("PR_PLUG"));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

}
