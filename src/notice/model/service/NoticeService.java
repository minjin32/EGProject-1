package notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticePageData;

public class NoticeService {
	
	private JDBCTemplate factory;
	
	public NoticeService() {
		factory = JDBCTemplate.getConnection();
	}

	// 공지사항 전체 리스트
	public NoticePageData printAllList(int currentPage) {
		
		Connection conn = null;
		NoticePageData noticepagedata = new NoticePageData();
		
		try {
			conn = factory.createConnection();
			noticepagedata.setNoticeList(new NoticeDAO().selectAllList(conn, currentPage));
			noticepagedata.setPageNavi(new NoticeDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return noticepagedata;
	}
	
	// 공지사항 작성
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
	
	// 공지사항 정보 확인
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
	
	// 공지사항 검색
	public NoticePageData printSearchList(String searchKeword, String searchOption,int currentPage) {
		Connection conn = null;
		NoticePageData pd = new NoticePageData();
		
		try {
			conn = factory.createConnection();
			pd.setNoticeList(new NoticeDAO().selectSearchList(conn, searchKeword, searchOption, currentPage));
			pd.setPageNavi(new NoticeDAO().getsearchPageNavi(conn, searchKeword, searchOption, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pd;	
	}

	// 댓글 등록
	public int registerNoticeCommnet(NoticeComment noComment) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new NoticeDAO().insertNoticeCommnet(conn, noComment);
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

	// 댓글 수정
	public int modifyNoticeComment(NoticeComment noComment) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new NoticeDAO().updateNoticeComment(conn, noComment);
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
	
	// update
	public int updateNotice(Notice notice) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new NoticeDAO().updateNotice(conn, notice);
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

	public int deleteNotice(int noticeNo) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new NoticeDAO().deleteNotice(conn, noticeNo);
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

	public ArrayList<NoticeComment> printByComentList(int noticeNo) {
		Connection conn = null;
		ArrayList<NoticeComment> cList = null;
		try {
			conn = factory.createConnection();
			cList = new NoticeDAO().selectListComent(conn, noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return cList;
	}
}