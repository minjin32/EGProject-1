package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import member.model.vo.MemberPageData;

public class MemberService {

   private JDBCTemplate factory;

   public MemberService() {
      factory = JDBCTemplate.getConnection();
   }

   // JoinViewServlet.java
   // 아이디,패스워드에 맞는 정보 취득
   // Servlet → Member member = new MemberService().selectOneMember(userId,
   // userPwd);
   // 로그인
   public Member selectOneMember(String userId, String userPwd) {
      Member member = null;
      Connection conn = null;
      try {
         conn = factory.createConnection();
         member = new MemberDAO().selectOneMember(conn, userId, userPwd);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return member;
   }
   
   // 회원정보
   public Member selectOneById(String userId) {
      Member member = null;
      Connection conn = null;
      try {
         conn = factory.createConnection();
         member = new MemberDAO().selectOneById(conn, userId);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return member;
   }

   // JoinViewServlet.java
   // 유저 등록
   // Servlet → Member member = new MemberService().registerMember(member);
   // 회원가입
   public int registerMember(Member member) {
      int result = 0;
      Connection conn = null;

      try {
         conn = factory.createConnection();
         result = new MemberDAO().insertMember(conn, member);
         if (result > 0) {
            JDBCTemplate.commit(conn);
         } else {
            JDBCTemplate.rollback(conn);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return result;
   }

   // MyinfoServlet.java
   // 유저 등록시 ID중복 체크
   // 유저ID가 있으면 1 없으면 0 반환
//   public Member selectOneById(String userId) {
   // 아이디체크
   public int selectIdCheck(Member member) {
//      Member member = null;
      int result = 0;
      Connection conn = null;
      try {
         conn = factory.createConnection();
         result = new MemberDAO().selectIdCheck(conn, member);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return result;
   }

   // 회원수정
   public int modifyMember(Member member) {
	      Connection conn = null;
	      int result = 0;
	      try {
	         conn = factory.createConnection();
	         result = new MemberDAO().updateMember(conn, member);
	         if (result > 0) {
	            JDBCTemplate.commit(conn);
	         } else {
	            JDBCTemplate.rollback(conn);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(conn);
	      }
	      return result;
	   }


   // 회원 리스트
   public MemberPageData selectMemberList(String usertype, int currentPage) {
      Connection conn = null;
      MemberPageData pagedata = new MemberPageData();
      try {
         conn = factory.createConnection();
         pagedata.setMemberList(new MemberDAO().selectMemberList(conn, usertype, currentPage));
         pagedata.setPageNavi(new MemberDAO().getPageNavi(conn, usertype, currentPage));
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return pagedata;
   }

   // 회원 검색
   public MemberPageData selectByIdList(String usertype, String search, int currentPage) {
      Connection conn = null;
      MemberPageData pagedata = new MemberPageData();
      try {
         conn = factory.createConnection();
         pagedata.setMemberList(new MemberDAO().selectByIdList(conn, usertype,search, currentPage));
         pagedata.setPageNavi(new MemberDAO().getSearchPageNavi(conn, usertype,search, currentPage));
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      return pagedata;
   }
   
   public MemberPageData selectSearchList(String usertype, String keyword, int currentPage) {
		Connection conn = null;
		MemberPageData pd = new MemberPageData();
		System.out.println("서비스지롱" + usertype);
		try {
			conn = factory.createConnection();
			pd.setMemberList(new MemberDAO().selectSearchList(conn, usertype, keyword, currentPage));
			pd.setPageNavi(new MemberDAO().getSearchPageNavi(conn, usertype, keyword, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pd;
	}

  
}