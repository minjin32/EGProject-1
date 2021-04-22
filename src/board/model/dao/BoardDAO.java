package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;
import common.JDBCTemplate;

public class BoardDAO {

	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getMemberId());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getNoStatus());
			pstmt.setString(5, board.getImageName());
			pstmt.setString(6, board.getImagePath());
			pstmt.setLong(7, board.getImageSize());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateNotice(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="UPDATE BOARD SET MB_ID=?, BO_TITLE=?, BO_CONTENT=?, BO_IMAGEPATH=? WHERE BO_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getMemberId());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getImagePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	public Board selectOneByNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		String query = "SELECT * FROM BOARD WHERE BO_NO = ?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = new Board();
				board.setBoardNo(rset.getInt("BO_NO"));
				board.setMemberId(rset.getString("MB_ID"));
				board.setBoardTitle(rset.getString("BO_TITLE"));
				board.setBoardContent(rset.getString("BO_CONTENT"));
				board.setImageName(rset.getNString("BO_IMAGENAME"));
				board.setBoardDate(rset.getDate("BO_DATETIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return board;
	}
	
	public ArrayList<Board> selectAllList(Connection conn, int currentPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> nList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY BO_NO DESC) AS NUM, BO_NO, MB_ID, BO_TITLE, BO_CONTENT, BO_DATETIME, BO_IMAGEPATH FROM BOARD) WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Board>();
			while(rset.next()) {
				Board board = new Board();
				board.setBoardNo(rset.getInt("BO_NO"));
				board.setMemberId(rset.getString("MB_ID"));
				board.setBoardTitle(rset.getString("BO_TITLE"));
				board.setBoardContent(rset.getString("BO_CONTENT"));
				board.setBoardDate(rset.getDate("BO_DATETIME"));
				board.setImagePath(rset.getString("BO_IMAGEPATH"));
				
				nList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public String getPageNavi(Connection conn, int currentPage) {
		int recordTotalCount = totalCount(conn);
		int recordCountPerPage = 10;
		int PageTotalCount = 0;
		if( recordTotalCount % recordCountPerPage > 0) {
			PageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			PageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > PageTotalCount) {
			currentPage = PageTotalCount;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1 ) / naviCountPerPage) * naviCountPerPage +1;
		int endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > PageTotalCount) {
			endNavi = PageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1 ) {
			needPrev = false;
		}
		if(endNavi == PageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/board/list?"
					+ "page=" + (startNavi - 1) + "\"\r\n"
					+ "			aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		</a></li>");
		} 
		for (int i = startNavi; i <= endNavi; i ++) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/board/list?"
					+ "page=" + i + "\">" + i + "</a></li>");
		}
		if (needNext) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/board/list?"
					+ "page=" + (endNavi + 1) + "\"\r\n"
					+ "			aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "		</a></li>");
		}
//		if(needPrev) {
//			sb.append("<a href='/notice/list?currentPage=" + (startNavi-1)+ "'> < </a>");
//		}
//		for(int i = startNavi; i <= endNavi; i++) {
//			sb.append("<a href='/notice/list?currentPage=\" + i + \"'>\" + i + \" </a>");
//		}
//		if(needNext) {
//			sb.append("<a href='/notice/list?currentPage=" + (endNavi + 1) + "'> > </a>");
//		}
		return sb.toString();
	}

	private int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOARD";
		int recordTotalCount = 0;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}
	
	public ArrayList<Board> selectSearchList(Connection conn, String search, int currentPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY BO_NO DESC) AS NUM, BO_NO, MB_ID, BO_TITLE, BO_CONTENT, BO_DATETIME, BO_IMAGEPATH FROM BOARD WHERE BO_TITLE LIKE ?)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Board> nList = null;
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Board>();
			while(rset.next()) {
				Board board = new Board();
				board.setBoardNo(rset.getInt("BO_NO"));
				board.setMemberId(rset.getString("MB_ID"));
				board.setBoardTitle(rset.getString("BO_TITLE"));
				board.setBoardContent(rset.getString("BO_CONTENT"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public String getsearchPageNavi(Connection conn, String search, int currentPage) {
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int recordTotalCount = searchTotalCount(conn, search);
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1 ) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(startNavi-1)+"'> ���� </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+i+"'>" + i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(endNavi+1)+"'> ���� </a>");
		}
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOARD WHERE BO_TITLE LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	
}
