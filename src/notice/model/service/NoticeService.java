package notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

public class NoticeService {
	
	private JDBCTemplate factory;
	
	public NoticeService() {
		factory = JDBCTemplate.getConnection();
	}

	// 셀렉트 올 (리스트 ) 전체 내역 가져오기 메소드
	public NoticePageData printAllList(int currentPage) {
		Connection conn = null;
		ArrayList<Notice> nList = null;
		String pageNavi = null;
		NoticePageData pd = new NoticePageData();
		
		try {
			conn = factory.createConnection();
			pd.setNoticeList(new NoticeDAO().selectAllList(conn, currentPage));
			pd.setPageNavi(new NoticeDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	
		// insert
	public int insertNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().insertNotice(conn, notice);
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
	
		// 셀렉트 one by no_no(pk) 하나 가져오는거 -> 사진 -> db쿼리가 notice_image 테이블이랑 join이 이루어져야해!
		// 조인문이 조금 힘들면 일단은 notice테이블에서 no_no로 가져오는것만 해도 99%완성
	public Notice printOnebyNo(int noticeNo) {
		Connection conn = null;
		Notice notice = null;
		
		try {
			conn = factory.createConnection();
			notice = new NoticeDAO().selectOneByNo(conn, noticeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return notice;
	}
	
		// update
	public int updateNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().updateNotice(conn, notice);
			if(result > 0) {
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
	
	// 이거 쓰는게 과연 맞나
	public NoticePageData printSearchList(String search, int currentPage) {
		Connection conn = null;
		NoticePageData pd = new NoticePageData();
		
		try {
			conn = factory.createConnection();
			pd.setNoticeList(new NoticeDAO().selectSearchList(conn, search, currentPage));
			pd.setPageNavi(new NoticeDAO().getsearchPageNavi(conn, search, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pd;	
	}
}
