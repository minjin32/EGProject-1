package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDAO {
	
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE,1)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getUserId());
			pstmt.setString(2, notice.getSubject());
			pstmt.setString(3, notice.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Notice> selectAllList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> nList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NO_NO DESC)"
				+ " AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME,NO_STATUS FROM NOTICE)"
				+ "WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NO_NO"));
				notice.setUserId(rset.getString("MB_ID"));
				notice.setSubject(rset.getString("NO_TITLE"));
				notice.setContents(rset.getString("NO_CONTENT"));
				notice.setNo_status(rset.getInt("NO_STATUS"));
				nList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	

	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET NO_TITLE = ?, NO_CONTENT =?, NO_STATUS=? WHERE NO_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getSubject());
			pstmt.setString(2, notice.getContents());
			pstmt.setInt(3, notice.getNo_status());
			pstmt.setInt(4, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 셀렉트 one by no_no(pk) 하나 가져오는거 -> 사진 -> db쿼리가 notice_image 테이블이랑 join이 이루어져야해!
	// 조인문이 조금 힘들면 일단은 notice테이블에서 no_no로 가져오는것만 해도 99%완성
	public Notice selectOneByNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE INNER JOIN BOARD_IMAGE ON NO_NO = BO_NO WHERE NO_NO = ?";
//		String query = "SELECT * FROM NOTICE WHERE NO_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NO_NO"));
				notice.setSubject(rset.getString("MB_ID"));
				notice.setSubject(rset.getString("NO_TITLE"));
				notice.setContents(rset.getString("NO_CONTENT"));
				notice.setRegDate(rset.getDate("NO_DATETIME"));
				notice.setNo_status(rset.getInt("NO_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	

	public int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE";
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
		int startNavi = ((currentPage -1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > PageTotalCount) {
			endNavi = PageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == PageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/notice/list?currentPage=" + (startNavi-1)+ "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/list?currentPage=" + i + "'>" + i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/list?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}

	public ArrayList<Notice> selectSearchList(Connection conn, String search, int currentPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS FROM NOTICE WHERE NO_TITLE LIKE ?)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Notice> nList = null;
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NO_NO"));
				notice.setUserId(rset.getString("MB_ID"));
				notice.setSubject(rset.getString("NO_TITLE"));
				notice.setContents(rset.getString("NO_CONTENT"));
				notice.setNo_status(rset.getInt("NO_STATUS"));
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
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(startNavi-1)+"'> 이전 </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+i+"'>" + i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(endNavi+1)+"'> 다음 </a>");
		}
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE SUBJECT LIKE ?";
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
