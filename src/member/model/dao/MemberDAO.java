package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDAO {
	
	// 암호화 없음 start
	public int register(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER KEYS (MB_ID, MB_NO, MB_PASSWORD, MB_NAME, MB_EMAIL, MB_PHONE, MB_STATUS) VALUES (?, USERNO_SEQ.NEXTVAL, ?, ?, ?, ?, 'Y')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMbId());
			pstmt.setString(2, member.getMbPassword());
			pstmt.setString(3, member.getMbName());
			pstmt.setString(4, member.getMbEmail());
			pstmt.setString(5, member.getMbPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member select(Connection conn, String memberId, String memberPw) {
//		PreparedStatement pstmt = null;
//		String sql = "SELECT * FROM MEMBER WHERE MB_ID = ? AND MB_PASSWORD = ?";
		Statement stmt = null;
		String sql = "SELECT * FROM MEMBER WHERE MB_ID = '" + memberId + "' " + "AND MB_PASSWORD = '" + memberPw + "'"; 
		ResultSet rset = null;
		Member member = null;
		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberId);
//			pstmt.setString(2, memberPw);
//			rset = pstmt.executeQuery();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next()) {
				member = new Member();
				member.setMbId(rset.getString("MB_ID"));
				member.setMbNo(rset.getInt("MB_NO"));
				member.setMbPassword(rset.getString("MB_PASSWORD"));
				member.setMbName(rset.getString("MB_NAME"));
				member.setMbNickname(rset.getString("MB_NICKNAME"));
				member.setMbEmail(rset.getString("MB_EMAIL"));
				member.setMbPhone(rset.getString("MB_PHONE"));
				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
//				member.setMbType(rset.getString("MB_TYPE").charAt(0));
				member.setShOwner(rset.getString("SH_OWNER"));
				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
				member.setMbStatus(rset.getString("MB_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(stmt);
		}
		return member;
	}
	// 암호화 없음 end

	public Member selectOneMember(Connection conn, String userId, String userPwd) {
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 패스워드 해쉬화
		String hashPwd = PasswordUtil.getHashedPassword(userId, userPwd);
//		String query = "SELECT * FROM MEMBER WHERE MB_ID ='" + userId + "' AND MB_PASSWORD ='" + hashPwd + "'";
		String query = "SELECT * FROM MEMBER WHERE MB_ID = ? AND MB_PASSWORD = ?";
		Member member = null;

		try {
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
//			rset = stmt.executeQuery(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, hashPwd);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new Member();
				member.setMbId(rset.getString("MB_ID"));
				member.setMbNo(rset.getInt("MB_NO"));
				member.setMbPassword(rset.getString("MB_PASSWORD"));
				member.setMbName(rset.getString("MB_NAME"));
				member.setMbNickname(rset.getString("MB_NICKNAME"));
				member.setMbEmail(rset.getString("MB_EMAIL"));
				member.setMbPhone(rset.getString("MB_PHONE"));
				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
				member.setMbType(rset.getString("MB_TYPE").charAt(0));
				member.setShOwner(rset.getString("SH_OWNER"));
				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
//			JDBCTemplate.close(stmt);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES(?,USERNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,'M')";
		String hashPwd = PasswordUtil.getHashedPassword(member.getMbId(), member.getMbPassword());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMbId());
			pstmt.setString(2, hashPwd);
			pstmt.setString(3, member.getMbName());
			pstmt.setString(4, member.getMbNickname());
			pstmt.setString(5, member.getMbEmail());
			pstmt.setString(6, member.getMbPhone());
			pstmt.setString(7, member.getMbAddress1());
			pstmt.setString(8, member.getMbAddress2());
			pstmt.setString(9, member.getMbAddress3());
			pstmt.setInt(10, member.getMbType());
			pstmt.setString(11, member.getShOwner());
			pstmt.setString(12, member.getShBusinessno());
			pstmt.setInt(13, member.getShEcopoint());
			pstmt.setString(14, member.getMbStatus());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

//	public member selectOneById(Connection conn, String userId) {
	public int selectIdCheck(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE MB_ID = ?";
//		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMbId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = 1;
//				member = new Member();
//				member.setMbId(rset.getString("MB_ID"));
//				member.setMbNo(rset.getInt("MB_NO"));
//				member.setMbPassword(rset.getString("MB_PASSWORD"));
//				member.setMbName(rset.getString("MB_NAME"));
//				member.setMbNickname(rset.getString("MB_NICKNAME"));
//				member.setMbEmail(rset.getString("MB_EMAIL"));
//				member.setMbPhone(rset.getString("MB_PHONE"));
//				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
//				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
//				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
//				member.setMbType(rset.getString("MB_TYPE").charAt(0));
//				member.setShOwner(rset.getString("SH_OWNER"));
//				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
//				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
//				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		return member;
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String hashPwd = PasswordUtil.getHashedPassword(member.getMbId(), member.getMbPassword());
		String query = "UPDATE MEMBER SET MB_NAME=?, MB_NICKNAME=?, MB_PASSWORD=?, MB_ADDRESS1=?, MB_ADDRESS2=?, "
				+ "MB_ADDRESS3=?, MB_PHONE=?, MB_EMAIL=? WHERE MB_ID=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMbName());
			pstmt.setString(2, member.getMbNickname());
			pstmt.setString(3, hashPwd);
			pstmt.setString(4, member.getMbAddress1());
			pstmt.setString(5, member.getMbAddress2());
			pstmt.setString(6, member.getMbAddress3());
			pstmt.setString(7, member.getMbPhone());
			pstmt.setString(8, member.getMbEmail());
			pstmt.setString(9, member.getMbId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectMemberList(Connection conn,String usertype, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> memberlist = null;		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY MB_NO DESC) AS MB_NO ,MB_ID ,MB_PASSWORD ,MB_NAME ,MB_NICKNAME ,MB_EMAIL ,MB_PHONE ,MB_ADDRESS1 ,MB_ADDRESS2 ,MB_ADDRESS3 ,MB_TYPE ,SH_OWNER ,SH_BUSINESS_NO ,SH_ECOPOINT ,MB_JOINDATE ,MB_STATUS FROM MEMBER WHERE MB_TYPE = ? AND MB_STATUS = 'Y') WHERE MB_NO BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usertype);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end); 
			rset = pstmt.executeQuery();
			memberlist = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setMbId(rset.getString("MB_ID"));
				member.setMbNo(rset.getInt("MB_NO"));
				member.setMbPassword(rset.getString("MB_PASSWORD"));
				member.setMbName(rset.getString("MB_NAME"));
				member.setMbNickname(rset.getString("MB_NICKNAME"));
				member.setMbEmail(rset.getString("MB_EMAIL"));
				member.setMbPhone(rset.getString("MB_PHONE"));
				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
				member.setMbType(rset.getString("MB_TYPE").charAt(0));
				member.setShOwner(rset.getString("SH_OWNER"));
				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
				member.setMbStatus(rset.getString("MB_STATUS"));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return memberlist;
	}

	public String getPageNavi(Connection conn, String usertype, int currentPage) {
		int recordCountPerPage = 10; // 한 페이지당 보여줄 게시물의 갯수
		int naviCountPerPage = 5; // 1 2 3 4 5 6 7 8 9 10, 1 2 3 4 5
		int recordTotalCount = totalCount(conn, usertype); // 전체 게시물의 갯수
		int pageTotalCount = 0; // 페이지의 갯수
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 안전장치
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
		// a 태그를 만드는 코드
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + (startNavi-1)+ "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + i + "'>"+ i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + (endNavi +1) + "'> > </a>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn, String usertype) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MEMBER WHERE MB_TYPE LIKE ? AND MB_STATUS = 'Y'";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usertype);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return recordTotalCount;
	}

	public ArrayList<Member> selectByIdList(Connection conn, String usertype, String search, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> memberlist = null;		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY MB_NO DESC) AS MB_NO,MB_ID,MB_PASSWORD ,MB_NAME ,MB_NICKNAME ,MB_EMAIL ,MB_PHONE ,MB_ADDRESS1 ,MB_ADDRESS2 ,MB_ADDRESS3 ,MB_TYPE ,SH_OWNER ,SH_BUSINESS_NO ,SH_ECOPOINT ,MB_JOINDATE ,MB_STATUS FROM MEMBER WHERE MB_TYPE = ? AND MB_STATUS = 'Y' AND MB_ID = ?) WHERE MB_NO BETWEEN ? AND ? ";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usertype);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end); 
			rset = pstmt.executeQuery();
			memberlist = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setMbId(rset.getString("MB_ID"));
				member.setMbNo(rset.getInt("MB_NO"));
				member.setMbPassword(rset.getString("MB_PASSWORD"));
				member.setMbName(rset.getString("MB_NAME"));
				member.setMbNickname(rset.getString("MB_NICKNAME"));
				member.setMbEmail(rset.getString("MB_EMAIL"));
				member.setMbPhone(rset.getString("MB_PHONE"));
				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
				member.setMbType(rset.getString("MB_TYPE").charAt(0));
				member.setShOwner(rset.getString("SH_OWNER"));
				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
				member.setMbStatus(rset.getString("MB_STATUS"));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("난다오얌"+memberlist);
		return memberlist;
	}

	public String getSearchPageNavi(Connection conn, String usertype, String search, int currentPage) {
		int recordCountPerPage = 10; // 한 페이지당 보여줄 게시물의 갯수
		int naviCountPerPage = 10; // 1 2 3 4 5 6 7 8 9 10, 1 2 3 4 5
		int recordTotalCount = searchTotalCount(conn,usertype, search); // 전체 게시물의 갯수
		// 123개의 게시물을 10개씩 보여준다라고 했을 때 페이지 갯수는 13개
		int pageTotalCount = 0; // 페이지의 갯수
		System.out.println("다오지롱" + usertype);
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 안전장치
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
		// a 태그를 만드는 코드
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + (startNavi-1)+ "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + i + "'>"+ i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/member/list?mb_type="+usertype+"currentPage=" + (endNavi +1) + "'> > </a>");
		}
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String usertype,String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MEMBER WHERE MB_ID LIKE ? AND MB_STATUS = 'Y' AND MB_TYPE = ? ";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, usertype);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return recordTotalCount;
	}

	public ArrayList<Member> selectSearchList(Connection conn, String usertype, String keyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY MB_NO DESC) AS NUM, MB_ID, MB_NO, MB_PASSWORD, MB_NAME, MB_NICKNAME, MB_EMAIL, MB_PHONE, MB_ADDRESS1, MB_ADDRESS2, MB_ADDRESS3, MB_TYPE, SH_OWNER, SH_BUSINESS_NO, SH_ECOPOINT, MB_JOINDATE, MB_STATUS FROM MEMBER WHERE MB_ID LIKE ? AND MB_TYPE= ?)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Member> mList = null;
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, usertype);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rset = pstmt.executeQuery();
			mList = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setMbId(rset.getString("MB_ID"));
				member.setMbNo(rset.getInt("MB_NO"));
				member.setMbPassword(rset.getString("MB_PASSWORD"));
				member.setMbName(rset.getString("MB_NAME"));
				member.setMbNickname(rset.getString("MB_NICKNAME"));
				member.setMbEmail(rset.getString("MB_EMAIL"));
				member.setMbPhone(rset.getString("MB_PHONE"));
				member.setMbAddress1(rset.getString("MB_ADDRESS1"));
				member.setMbAddress2(rset.getString("MB_ADDRESS2"));
				member.setMbAddress3(rset.getString("MB_ADDRESS3"));
				//member.setMbType(rset.getString("MB_TYPE").charAt(0));
				member.setShOwner(rset.getString("SH_OWNER"));
				member.setShBusinessno(rset.getString("SH_BUSINESS_NO"));
				member.setShEcopoint(rset.getInt("SH_ECOPOINT"));
				member.setMbJoindate(rset.getDate("MB_JOINDATE"));
				member.setMbStatus(rset.getString("MB_STATUS"));
				mList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}
	
	public int selectAmountByEnrollMonth(Connection conn) {
		int result = 0;
		ArrayList<Member> memberList = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "SELECT COUNT(*) as amount FROM MEMBER WHERE TO_CHAR(MB_JOINDATE, 'YYYY/MM') = TO_CHAR(sysdate, 'YYYY/MM')";
		
		try {
			pstmt = conn.prepareStatement(query);
			System.out.println(pstmt + "짜잔");
			rset = pstmt.executeQuery(query);
			// result가 0 보다 크면 성공했다는 뜻. 성공했으니까 rset의 길이를 return
			if (rset.next()) {
				System.out.println("asdfadsf");
				result = Integer.parseInt(rset.getString("amount"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}
	
	
}
