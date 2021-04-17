package mypageqa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import mypageqa.model.vo.MypageQaData;

public class MypageQaDAO {

	public ArrayList<MypageQaData> selectAllList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MypageQaData> mqList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY QA_NO DESC) AS NUM, QA_NO, QA_TITLE, QA_CONTENT, MB_ID, QA_DATETIME FROM QNA) WHERE NUM BETWEEN ? AND ?";

		int recordCountPerPage = 5;
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			mqList = new ArrayList<MypageQaData>();
			while (rset.next()) {
				MypageQaData mypageQaData = new MypageQaData();
				mypageQaData.setQaNo(rset.getInt("QA_NO"));
				mypageQaData.setQaTitle(rset.getString("QA_TITLE"));
				mypageQaData.setQaContent(rset.getString("QA_CONTENT"));
				mypageQaData.setMbId(rset.getString("MB_ID"));
				mypageQaData.setQaDateTime(rset.getDate("QA_DATETIME"));
				mqList.add(mypageQaData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mqList;
	}

	public MypageQaData selectOne(Connection conn, int qaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MypageQaData mypageQaData = null;
		String query = "SELECT * FROM QNA WHERE QA_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qaNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				mypageQaData = new MypageQaData();
				mypageQaData.setQaNo(rset.getInt("QA_NO"));
				mypageQaData.setMbId(rset.getString("MB_ID"));
				mypageQaData.setQaTitle(rset.getString("QA_TITLE"));
				mypageQaData.setQaContent(rset.getString("QA_CONTENT"));
				mypageQaData.setQaDateTime(rset.getDate("QA_DATETIME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mypageQaData;
	}

	public int insertMypageQaData(Connection conn, MypageQaData mypageQaData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO QNA VALUES(MYPAGEQADATA_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mypageQaData.getMbId());
			pstmt.setString(2, mypageQaData.getQaTitle());
			pstmt.setString(3, mypageQaData.getQaContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int updateMypageQaData(Connection conn, MypageQaData mypageQaData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE QNA SET QA_TITLE = ?, QA_CONTENT = ? WHERE QA_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mypageQaData.getQaTitle());
			pstmt.setString(2, mypageQaData.getQaContent());
			pstmt.setInt(3, mypageQaData.getQaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int recordTotalCount = totalCount(conn);
		int recordCountPerPage = 5;
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
		int naviCountPerPage = 5;
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
			sb.append("<a href='/mypage/qna/list?currentPage=" + (startNavi - 1) + "'> < </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/mypage/qna/list?currentPage=" + i + "'>" + i + " </a>");
		}
		if (needNext) {
			sb.append("<a href='/mypage/qna/list?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}

	private int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNA";
		int recordTotalCount = 0;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}

		
//	public ArrayList<MypageQaData> selectSearchList(Connection conn, String search, int currentPage) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY QA_NO DESC) AS NUM, QA_NO, QA_TITLE, QA_CONTENT, MB_ID, QA_DATETIME FROM QNA WHERE QA_TITLE LIKE ?) WHERE NUM BETWEEN ? AND ?";
//		ArrayList<MypageQaData> mqList = null;
//		int recordCountPerPage = 5;
//		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
//		int end = currentPage * recordCountPerPage;
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, "%" + search + "%");
//			pstmt.setInt(2, start);
//			pstmt.setInt(3, end);
//			rset = pstmt.executeQuery();
//			mqList = new ArrayList<MypageQaData>();
//			while (rset.next()) {
//				MypageQaData mypageQaData = new MypageQaData();
//				mypageQaData.setQaNo(rset.getInt("QA_NO"));
//				mypageQaData.setQaTitle(rset.getString("QA_TITLE"));
//				mypageQaData.setQaContent(rset.getString("QA_CONTENT"));
//				mypageQaData.setMbId(rset.getString("MB_ID"));
//				mypageQaData.setQaDateTime(rset.getDate("QA_DATETIME"));
//				mqList.add(mypageQaData);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(rset);
//		}
//		return mqList;
//	}
//
//	public String getSearchPageNavi(Connection conn, String search, int currentPage) {
//		int recordCountPerPage = 5;
//		int naviCountPerPage = 5;
//		int recordTotalCount = searchTotalCount(conn, search);
//		int pageTotalCount = 0;
//		if (recordTotalCount % recordCountPerPage > 0) {
//			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
//		} else {
//			pageTotalCount = recordTotalCount / recordCountPerPage;
//		}
//		if (currentPage < 1) {
//			currentPage = 1;
//		} else if (currentPage > pageTotalCount) {
//			currentPage = pageTotalCount;
//		}
//		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
//		int endNavi = startNavi + naviCountPerPage - 1;
//		if (endNavi > pageTotalCount) {
//			endNavi = pageTotalCount;
//		}
//		boolean needPrev = true;
//		boolean needNext = true;
//		if (startNavi == 1) {
//			needPrev = false;
//		}
//		if (endNavi == pageTotalCount) {
//			needNext = false;
//		}
//		StringBuilder sb = new StringBuilder();
//		if (needPrev) {
//			sb.append("<a href='/mypage/qna/list?searchKeyword=" + search + "&currentPage=" + (startNavi - 1)
//					+ "'> 이전 </a>");
//		}
//		for (int i = startNavi; i <= endNavi; i++) {
//			sb.append("<a href='/mypage/qna/list?searchKeyword=" + search + "&currentPage=" + i + "'>" + i + "</a>");
//		}
//		if (needNext) {
//			sb.append("<a href='/mypage/qna/list?searchKeyword=" + search + "&currentPage=" + (endNavi + 1)
//					+ "'> 다음 </a>");
//		}
//		return sb.toString();
//	}
//
//	private int searchTotalCount(Connection conn, String search) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNA WHERE QA_TITLE LIKE ?";
//		int recordTotalCount = 0;
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, "%" + search + "%");
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				recordTotalCount = rset.getInt("TOTALCOUNT");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		return recordTotalCount;
//	}

}
