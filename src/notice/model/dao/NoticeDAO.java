package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;

public class NoticeDAO {
	
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NOTICE VALUES(SEQ_NOTICE.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getUserId());
			pstmt.setString(2, notice.getSubject());
			pstmt.setString(3, notice.getContents());
			pstmt.setInt(4, notice.getNoStatus());
			pstmt.setString(5, notice.getImageName());
			pstmt.setString(6, notice.getImagePath());
			pstmt.setLong(7, notice.getImageSize());
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
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS, IMAGE_NAME, IMAGE_PATH, IMAGE_SIZE FROM NOTICE) WHERE NUM BETWEEN ? AND ?";
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
				notice.setNoStatus(rset.getInt("NO_STATUS"));
				notice.setImageName(rset.getString("IMAGE_NAME"));
				notice.setImagePath(rset.getString("IMAGE_PATH"));
				notice.setImageSize(rset.getLong("IMAGE_SIZE"));
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
			pstmt.setInt(3, notice.getNoStatus());
			pstmt.setInt(4, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// ����Ʈ one by no_no(pk) �ϳ� �������°� -> ���� -> db������ notice_image ���̺��̶� join�� �̷��������!
	// ���ι��� ���� ����� �ϴ��� notice���̺��� no_no�� �������°͸� �ص� 99%�ϼ�
	public Notice selectOneByNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE WHERE NO_NO = ?";
		
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
				notice.setNoStatus(rset.getInt("NO_STATUS"));
				notice.setImageName(rset.getString("IMAGE_NAME"));
				notice.setImagePath(rset.getString("IMAGE_PATH"));
				notice.setImageSize(rset.getLong("IMAGE_SIZE"));
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

	public ArrayList<Notice> selectSearchList(Connection conn, String searchKeword, String searchOption, int currentPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="";
		if(searchOption.equals("subject")) {
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS, IMAGE_NAME, IMAGE_PATH, IMAGE_SIZE FROM NOTICE WHERE NO_TITLE LIKE ?)WHERE NUM BETWEEN ? AND ?";
			
		}
		if(searchOption.equals("content")) {
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS, IMAGE_NAME, IMAGE_PATH, IMAGE_SIZE FROM NOTICE WHERE NO_CONTENT LIKE ?)WHERE NUM BETWEEN ? AND ?";
		}
		ArrayList<Notice> nList = null;
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeword + "%");
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
				notice.setNoStatus(rset.getInt("NO_STATUS"));
				nList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("난 다오얌" + nList);
		return nList;
	}

	public String getsearchPageNavi(Connection conn, String searchKeword, String searchOption, int currentPage) {
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int recordTotalCount = searchTotalCount(conn, searchKeword, searchOption);
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
			sb.append("<a href='/notice/search?searchKeyword="+searchKeword+"&currentPage="+(startNavi-1)+"'> ���� </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/search?searchKeyword="+searchKeword+"&currentPage="+i+"'>" + i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/notice/search?searchKeyword="+searchKeword+"&currentPage="+(endNavi+1)+"'> ���� </a>");
		}
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String searchKeword, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="";
		if(searchOption.equals("subject")) {	
			query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE NO_TITLE LIKE ?";
		}
		if(searchOption.equals("content")) {
			query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE NO_CONTENT LIKE ?";
		}
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeword + "%");
			rset = pstmt.executeQuery();
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
	
	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NO_NO =?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int inserNoticeComment(Connection conn, NoticeComment noComment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NO_COMMENT(SEQ_BO_COMMENT.NEXTVAL,?,?,?,?,SYSDATE);";
		
		return 0;
	}
	
}
