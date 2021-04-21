package notice.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import common.JDBCTemplate;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;

public class NoticeDAO {
	
	// 공지사항 전체 리스트
	public ArrayList<Notice> selectAllList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> noticeList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NO_NO DESC) AS COUNT, NO_NO ,MB_ID ,NO_TITLE ,NO_CONTENT ,NO_DATETIME ,NO_STATUS ,IMAGE_NAME ,IMAGE_PATH ,IMAGE_SIZE FROM NOTICE) A LEFT JOIN (SELECT ROW_NUMBER() OVER(ORDER BY NO_NO ASC) AS NUM, NO_NO FROM NOTICE) B ON A.No_No = B.No_No WHERE COUNT BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			noticeList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNum(rset.getInt("NUM"));
				notice.setNoNo(rset.getInt("NO_NO"));
				notice.setMbId(rset.getString("MB_ID"));
				notice.setNoTitle(rset.getString("NO_TITLE"));
				notice.setNoContent(rset.getString("NO_CONTENT"));
				notice.setNoDatetime(rset.getDate("NO_DATETIME"));
				notice.setNoStatus(rset.getInt("NO_STATUS"));
				notice.setImageName(rset.getString("IMAGE_NAME"));
				notice.setImagePath(rset.getString("IMAGE_PATH"));
				notice.setImageSize(rset.getLong("IMAGE_SIZE"));
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return noticeList;
	}
	
	public String getPageNavi(Connection conn, int currentPage) {
		int recordTotalCount = totalCount(conn);
		int recordCountPerPage = 10;
		int PageTotalCount = 0;
		if (recordTotalCount % recordCountPerPage > 0) {
			PageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			PageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > PageTotalCount) {
			currentPage = PageTotalCount;
		}
		// 페이지 개수 처리 변수
		int naviCountPerPage = 5;
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		// 오류방지
		if (endNavi > PageTotalCount) {
			endNavi = PageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == PageTotalCount) {
			needNext = false;
		}
//		if (needPrev) {
//			sb.append("<a href='/eco/notice/list?currentPage=" + (startNavi - 1) + "'> < </a>");
//		}
//		for (int i = startNavi; i <= endNavi; i++) {
//			sb.append("<a href='/eco/notice/list?currentPage=" + i + "'>" + i + " </a>");
//		}
//		if (needNext) {
//			sb.append("<a href='/eco/notice/list?currentPage=" + (endNavi + 1) + "'> > </a>");
//		}
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/list?"
					+ "&currentPage=" + (startNavi - 1) + "\"\r\n"
					+ "			aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		</a></li>");
		} 
		for (int i = startNavi; i <= endNavi; i ++) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/list?"
					+ "&currentPage=" + i + "\">" + i + "</a></li>");
		}
		if (needNext) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/list?"
					+ "&currentPage=" + (endNavi + 1) + "\"\r\n"
					+ "			aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "		</a></li>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE";
		int recordTotalCount = 0;

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
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
	
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		// status : 0 표시 / 1 비표시
		int status = 0;
		String query = "INSERT INTO NOTICE VALUES(SEQ_NOTICE.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getMbId());
			pstmt.setString(2, notice.getNoTitle());
			pstmt.setString(3, notice.getNoContent());
			pstmt.setInt(4, status);
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
	
	// 공지사항 정보 확인
	public Notice selectOneByNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE WHERE NO_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				notice = new Notice();
				notice.setNoNo(rset.getInt("NO_NO"));
				notice.setMbId(rset.getString("MB_ID"));
				notice.setNoTitle(rset.getString("NO_TITLE"));
				notice.setNoContent(rset.getString("NO_CONTENT"));
				notice.setNoDatetime(rset.getDate("NO_DATETIME"));
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
	

	public ArrayList<Notice> selectSearchList(Connection conn, String searchKeword, String searchOption,
			int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if (searchOption.equals("subject")) {
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS, IMAGE_NAME, IMAGE_PATH, IMAGE_SIZE FROM NOTICE WHERE NO_TITLE LIKE ?)WHERE NUM BETWEEN ? AND ?";

		}
		if (searchOption.equals("content")) {
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO_NO DESC) AS NUM, NO_NO, MB_ID, NO_TITLE, NO_CONTENT, NO_DATETIME, NO_STATUS, IMAGE_NAME, IMAGE_PATH, IMAGE_SIZE FROM NOTICE WHERE NO_CONTENT LIKE ?)WHERE NUM BETWEEN ? AND ?";
		}
		ArrayList<Notice> nList = null;
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeword + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Notice>();
			while (rset.next()) {
				Notice notice = new Notice();
				notice.setNum(rset.getInt("NUM"));
				notice.setNoNo(rset.getInt("NO_NO"));
				notice.setMbId(rset.getString("MB_ID"));
				notice.setNoTitle(rset.getString("NO_TITLE"));
				notice.setNoContent(rset.getString("NO_CONTENT"));
				notice.setNoStatus(rset.getInt("NO_STATUS"));
				notice.setNoDatetime(rset.getDate("NO_DATETIME"));
				notice.setImageName(rset.getString("IMAGE_NAME"));
				notice.setImagePath(rset.getString("IMAGE_PATH"));
				notice.setImageSize(rset.getInt("IMAGE_SIZE"));
				nList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public String getsearchPageNavi(Connection conn, String searchKeword, String searchOption, int currentPage) {
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int recordTotalCount = searchTotalCount(conn, searchKeword, searchOption);
		int pageTotalCount = 0;

		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/search?"
					+ "search-keyword=" + searchKeword + "&search-option=" + searchOption + "&currentPage=" + (startNavi - 1) + "\"\r\n"
					+ "			aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		</a></li>");
		} 
		for (int i = startNavi; i <= endNavi; i ++) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/search?"
					+ "search-keyword=" + searchKeword + "&search-option=" + searchOption + "&currentPage=" + i + "\">" + i + "</a></li>");
		}
		if (needNext) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"/eco/notice/search?"
					+ "search-keyword=" + searchKeword + "&search-option=" + searchOption + "&currentPage=" + (endNavi + 1) + "\"\r\n"
					+ "			aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		</a></li>");
		} 
		return sb.toString();
	}
	

	private int searchTotalCount(Connection conn, String searchKeword, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if (searchOption.equals("subject")) {
			query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE NO_TITLE LIKE ?";
		}
		if (searchOption.equals("content")) {
			query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE NO_CONTENT LIKE ?";
		}
		int recordTotalCount = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeword + "%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
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

	// 댓글등록
	public int insertNoticeCommnet(Connection conn, NoticeComment noComment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NO_COMMENT VALUES(SEQ_NO_COMMENT.NEXTVAL,?,?,null,?,SYSDATE)";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, noComment.getMemberId());
			pstmt.setInt(2, noComment.getNoticeNo());
			pstmt.setString(3, noComment.getCoContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 댓글수정
	public int updateNoticeComment(Connection conn, NoticeComment noComment) {
		System.out.println("updateNoticeCommentstart");
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NO_COMMENT SET CO_CONTENT=?, CO_DATETIME=SYSDATE WHERE CO_NO = ? AND MB_ID = ? AND NO_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, noComment.getCoContent());
			pstmt.setInt(2, noComment.getCommentNo());
			pstmt.setString(3, noComment.getMemberId());
			pstmt.setInt(4, noComment.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}
	
	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET NO_TITLE = ?, NO_CONTENT =?, NO_STATUS=?, IMAGE_NAME=?, IMAGE_PATH=? WHERE NO_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoTitle());
			pstmt.setString(2, notice.getNoContent());
			pstmt.setInt(3, notice.getNoStatus());
			pstmt.setString(4, notice.getImageName());
			pstmt.setString(5, notice.getImagePath());
			// pstmt.setLong(6, notice.getImageSize());
			pstmt.setInt(6, notice.getNoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {      
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NO_NO = ?";

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

	public ArrayList<NoticeComment> selectListComent(Connection conn, int noticeNo) {
		ArrayList<NoticeComment> clist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM NO_COMMENT WHERE NO_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			clist = new ArrayList<NoticeComment>();
			while (rset.next()) {
				NoticeComment nComment = new NoticeComment();
				nComment.setCommentNo(rset.getInt("CO_NO"));
				nComment.setMemberId(rset.getString("MB_ID"));				
				nComment.setNoticeNo(rset.getInt("NO_NO"));
				nComment.setCoParentNo(rset.getInt("CO_PARENT_NO"));
				nComment.setCoContent(rset.getString("CO_CONTENT"));
				nComment.setCoDatetime(rset.getDate("CO_DATETIME"));
				clist.add(nComment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return clist;
	}
	
}
