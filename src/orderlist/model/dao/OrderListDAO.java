package orderlist.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import orderlist.model.vo.OrderList;

public class OrderListDAO {

	public OrderList selectByOrderList(Connection conn, int orderNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderList oList = null;
		String query = "SELECT * FROM MENUORDER WHERE OR_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,orderNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				oList = new OrderList(); 
				oList.setOrderNo(rset.getInt("OR_NO"));
				oList.setShopNo(rset.getInt("SH_NO"));
				oList.setMemberId(rset.getString("MB_ID"));
				oList.setOrderPrice(rset.getInt("OR_PRICE"));
				oList.setOrderStatus(rset.getInt("OR_STATUS"));
				oList.setShopName(rset.getString("SH_NAME"));
				oList.setShopDateTime(rset.getDate("SH_DATETIME"));
				oList.setOrderReject(rset.getString("OR_REJECT"));
				oList.setShopRuntime(rset.getString("SH_RUNTIME"));
				
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

	public OrderList selectByMemberIdList(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderList oList = null;
		String query = "SELECT * FROM MENUORDER WHERE MB_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset =pstmt.executeQuery();
			if(rset.next()) {
				oList = new OrderList(); 
				oList.setOrderNo(rset.getInt("OR_NO"));
				oList.setShopNo(rset.getInt("SH_NO"));
				oList.setMemberId(rset.getString("MB_ID"));
				oList.setOrderPrice(rset.getInt("OR_PRICE"));
				oList.setOrderStatus(rset.getInt("OR_STATUS"));
				oList.setShopName(rset.getString("SH_NAME"));
				oList.setShopDateTime(rset.getDate("SH_DATETIME"));
				oList.setOrderReject(rset.getString("OR_REJECT"));
				oList.setShopRuntime(rset.getString("SH_RUNTIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return oList;
	}

	public int insertOrderList(Connection conn, OrderList orderList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MENUORDER VALUES(ORDERNO_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,orderList.getShopNo());
			pstmt.setString(2, orderList.getMemberId());
			pstmt.setInt(3,orderList.getOrderPrice());
			pstmt.setInt(4, orderList.getOrderStatus());
			pstmt.setString(5, orderList.getShopName());
			pstmt.setString(6, orderList.getOrderReject());
			pstmt.setString(7, orderList.getShopRuntime());
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int modifyOrderCancel(Connection conn, OrderList orderList) {
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
	
	//status가 0이면 조리시간,거절사유
	//status가 1이면 2로 변경
	public int modifyOrderList(Connection conn, OrderList orderList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		if(orderList.getOrderStatus() == 0) {			
			String query = "UPDATE MENUORDER SET OR_STATUS=?,OR_REJECT=?,SH_RUNTIME=? WHERE OR_NO=?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, orderList.getOrderStatus());
				pstmt.setString(2, orderList.getOrderReject());
				pstmt.setString(3, orderList.getShopRuntime());
				pstmt.setInt(4,orderList.getOrderNo());
				result =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
		} else {
			String query = "UPDATE MENUORDER SET OR_STATUS = 2";
			try {
				pstmt = conn.prepareStatement(query);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
		}
		return result;
	}
}
