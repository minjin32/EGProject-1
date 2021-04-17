package orderlist.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import orderlist.model.dao.OrderListDAO;
import orderlist.model.vo.OrderList;

public class OrderListService {
	private JDBCTemplate factory;

	public OrderListService() {
		factory = JDBCTemplate.getConnection();
	} 	

	public OrderList selectByOrderList(int orderNo) {
		Connection conn = null;
		OrderList oList = null;
		try {
			conn = factory.createConnection();
			oList = new OrderListDAO().selectByOrderList(conn, orderNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return oList;
	}

	public OrderList selectByMemberIdList(String memberId) {
		Connection conn = null;
		OrderList oList = null;

		try {
			conn = factory.createConnection();
			oList = new OrderListDAO().selectByMemberIdList(conn, memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return oList;
	}
	
	public int registerOrder(OrderList orderList) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn=factory.createConnection();
			result = new OrderListDAO().insertOrderList(conn,orderList);
			if(result >0) {
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
	
	
	public int modifyOrderCancel(OrderList orderList) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn= factory.createConnection();
			result = new OrderListDAO().modifyOrderCancel(conn, orderList);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int modifyOrderList(OrderList orderList) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn= factory.createConnection();
			result = new OrderListDAO().modifyOrderList(conn,orderList);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

}
