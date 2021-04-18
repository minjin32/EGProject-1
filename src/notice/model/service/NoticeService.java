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

	// ����Ʈ �� (����Ʈ ) ��ü ���� �������� �޼ҵ�
	public NoticePageData printAllList(int currentPage) {
		Connection conn = null;
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
	
		// ����Ʈ one by no_no(pk) �ϳ� �������°� -> ���� -> db������ notice_image ���̺��̶� join�� �̷��������!
		// ���ι��� ���� ����� �ϴ��� notice���̺��� no_no�� �������°͸� �ص� 99%�ϼ�
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
	
	// �̰� ���°� ���� �³�
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
