package order.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.dao.OrderDAO;
import order.model.vo.OrderVO;

public class OrderService {
	private JDBCTemplate factory;

	public OrderService() {
		factory = JDBCTemplate.getConnection();
	} 	
	
	public OrderVO selectAll(int orderNo) {
		Connection conn = null;
		OrderVO oList = null;
		try {
			conn = factory.createConnection();
			oList = new OrderDAO().selectByOrderList(conn, orderNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return oList;
	}

	public OrderVO selectByOrderList(int orderNo) {
		Connection conn = null;
		OrderVO oList = null;
		try {
			conn = factory.createConnection();
			oList = new OrderDAO().selectByOrderList(conn, orderNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return oList;
	}

	public OrderVO selectByMemberIdList(String memberId) {
		Connection conn = null;
		OrderVO oList = null;

		try {
			conn = factory.createConnection();
			oList = new OrderDAO().selectOneByMemberId(conn, memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return oList;
	}
	
	public int registerOrder(OrderVO order) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn=factory.createConnection();
			result = new OrderDAO().insertOrderList(conn, order);
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
	
	
	public int modifyOrderCancel(OrderVO orderList) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn= factory.createConnection();
			result = new OrderDAO().modifyOrderCancel(conn, orderList);
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
	
	public int modifyOrder(OrderVO orderVO) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn= factory.createConnection();
			result = new OrderDAO().modifyOrderList(conn,orderVO);
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

	public ArrayList<OrderVO> selectListByShopNumber(int shopNumber) {
		ArrayList<OrderVO> list = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new OrderDAO().selectListByShopNumber(conn, shopNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}

	public ArrayList<OrderVO> selectListByOwnerID(String memberId) {
		ArrayList<OrderVO> list = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new OrderDAO().selectListByOwnerId(conn, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}

	public ArrayList<OrderVO> selectListByMemberId(String memberId) {
		ArrayList<OrderVO> list = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new OrderDAO().selectListByMemberId(conn, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}

}
