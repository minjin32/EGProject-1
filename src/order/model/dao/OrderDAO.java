package order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import menu.model.vo.MenuVO;
import order.model.vo.OrderVO;
import shop.model.vo.Shop;

public class OrderDAO {
	
	public ArrayList<OrderVO> selectListByShopNumber(Connection conn, int shopNumber) {
		ArrayList<OrderVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MENUORDER WHERE SH_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNumber);
			rset = pstmt.executeQuery();
			list = new ArrayList<OrderVO>();
			while (rset.next()) {
				OrderVO order = new OrderVO();
				order.setOrderNo(rset.getInt("OR_NO"));
				order.setShopNo(rset.getInt("SH_NO"));
				order.setMemberId(rset.getString("MB_ID"));
				order.setOrderPrice(rset.getInt("OR_PRICE"));
				order.setOrderStatus(rset.getInt("OR_STATUS"));
				order.setShopName(rset.getString("SH_NAME"));
				order.setOrderDateTime(rset.getDate("OR_DATETIME"));
				order.setOrderReject(rset.getString("OR_REJECT"));
				order.setShopRuntime(rset.getDate("SH_RUNTIME"));
				order.setOrderMenu(rset.getString("OR_MENU"));
				order.setPhone(rset.getString("OR_PHONE"));
				order.setOrderMessage(rset.getString("OR_MESSAGE"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public OrderVO selectByOrderList(Connection conn, int orderNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderVO oList = null;
		String query = "SELECT * FROM MENUORDER WHERE OR_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,orderNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				oList = new OrderVO(); 
				oList.setOrderNo(rset.getInt("OR_NO"));
				oList.setShopNo(rset.getInt("SH_NO"));
				oList.setMemberId(rset.getString("MB_ID"));
				oList.setOrderPrice(rset.getInt("OR_PRICE"));
				oList.setOrderStatus(rset.getInt("OR_STATUS"));
				oList.setShopName(rset.getString("SH_NAME"));
				oList.setOrderDateTime(rset.getDate("OR_DATETIME"));
				oList.setOrderReject(rset.getString("OR_REJECT"));
				oList.setShopRuntime(rset.getDate("SH_RUNTIME"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return oList;
	}

	public OrderVO selectByMemberIdList(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderVO oList = null;
		String query = "SELECT * FROM MENUORDER WHERE MB_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset =pstmt.executeQuery();
			if(rset.next()) {
				oList = new OrderVO(); 
				oList.setOrderNo(rset.getInt("OR_NO"));
				oList.setShopNo(rset.getInt("SH_NO"));
				oList.setMemberId(rset.getString("MB_ID"));
				oList.setOrderPrice(rset.getInt("OR_PRICE"));
				oList.setOrderStatus(rset.getInt("OR_STATUS"));
				oList.setShopName(rset.getString("SH_NAME"));
				oList.setOrderMenu(rset.getString("OR_MENU"));
				oList.setOrderMessage(rset.getString("OR_MESSAGE"));
				oList.setOrderDateTime(rset.getDate("OR_DATETIME"));
				oList.setOrderReject(rset.getString("OR_REJECT"));
				oList.setShopRuntime(rset.getDate("SH_RUNTIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return oList;
	}

	public int insertOrderList(Connection conn, OrderVO order) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MENUORDER VALUES(ORDERNO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE,?,SYSDATE, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			// or_no seq
			pstmt.setInt(1, order.getShopNo());
			pstmt.setString(2, order.getMemberId());
			pstmt.setInt(3, order.getOrderPrice());
			pstmt.setInt(4, 0);
			pstmt.setString(5, order.getShopName());
			// or_datetime sysdate
			pstmt.setString(6, "");
			// sh_runtime sysdate
			pstmt.setString(7, order.getOrderMenu());
			pstmt.setString(8, order.getOrderMessage());
			pstmt.setString(9, order.getPhone());
			
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int modifyOrderCancel(Connection conn, OrderVO orderList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MENUORDER SET OR_STATUS = 99 WHERE OR_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderList.getOrderNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int modifyOrderList(Connection conn, OrderVO orderVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MENUORDER SET OR_STATUS = ? WHERE OR_NO = ?";
			
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderVO.getOrderStatus());
			pstmt.setInt(2, orderVO.getOrderNo());
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<OrderVO> selectListByOwnerId(Connection conn, String memberId) {
		ArrayList<OrderVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from (select m.mb_id, s.sh_no from member m join shop s on m.mb_id = s.mb_id where m.mb_id = ?) s join menuorder o on s.sh_no = o.sh_no";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			list = new ArrayList<OrderVO>();
			while (rset.next()) {
				OrderVO order = new OrderVO();
				order.setOrderNo(rset.getInt("OR_NO"));
				order.setShopNo(rset.getInt("SH_NO"));
				order.setMemberId(rset.getString("MB_ID"));
				order.setOrderPrice(rset.getInt("OR_PRICE"));
				order.setOrderStatus(rset.getInt("OR_STATUS"));
				order.setShopName(rset.getString("SH_NAME"));
				order.setOrderDateTime(rset.getDate("OR_DATETIME"));
				order.setOrderReject(rset.getString("OR_REJECT"));
				order.setShopRuntime(rset.getDate("SH_RUNTIME"));
				order.setOrderMenu(rset.getString("OR_MENU"));
				order.setPhone(rset.getString("OR_PHONE"));
				order.setOrderMessage(rset.getString("OR_MESSAGE"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
}
