package board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardPageData;
import common.JDBCTemplate;

public class BoardService {

	private JDBCTemplate factory;
	
	public BoardService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public int insertBoard(Board board) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BoardDAO().insertBoard(conn, board);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.commit(conn);
		}
		return result;
	}
	
	public int updateBoard(Board board) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BoardDAO().updateNotice(conn, board);
			if(result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// select by number 
	public Board printOneByNo(int boardNo) {
		Connection conn = null;
		Board board = null;
		
		try {
			conn = factory.createConnection();
			board = new BoardDAO().selectOneByNo(conn, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return board;
	}
	
	public BoardPageData printALLlist(int currentPage) {
		Connection conn = null;
		ArrayList<Board> nList = null;
		String pageNavi = null;
		BoardPageData pd = new BoardPageData();
		
		try {
			conn = factory.createConnection();
			pd.setBoardList(new BoardDAO().selectAllList(conn, currentPage));
			pd.setPageNavi(new BoardDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public BoardPageData printSearchList(String search, int currentPage) {
		Connection conn = null;
		BoardPageData pd = new BoardPageData();
		
		try {
			conn = factory.createConnection();
			pd.setBoardList(new BoardDAO().selectSearchList(conn, search, currentPage));
			pd.setPageNavi(new BoardDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}
	
}
