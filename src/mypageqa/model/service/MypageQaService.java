package mypageqa.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import mypageqa.model.dao.MypageQaDAO;
import mypageqa.model.vo.MypageQaData;
import mypageqa.model.vo.PageData;
import notice.model.dao.NoticeDAO;

public class MypageQaService {

	private JDBCTemplate factory;

	public MypageQaService() {
		factory = JDBCTemplate.getConnection();
	}

	public PageData printAllList(int currentPage) {
		Connection conn = null;
		PageData pd = new PageData();

		try {
			conn = factory.createConnection();
			pd.setMypageQaList(new MypageQaDAO().selectAllList(conn, currentPage));
			pd.setPageNavi(new MypageQaDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public MypageQaData printOne(int qaNo) {
		Connection conn = null;
		MypageQaData mypageQaData = null;

		try {
			conn = factory.createConnection();
			mypageQaData = new MypageQaDAO().selectOne(conn, qaNo);
//			qnaco = new MypageQaDAO().selectOneByco(conn, qaNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mypageQaData;
	}
	
//	관리자 코멘트
//	public MypageQaData printOnebyco(int qaNo) {
//		Connection conn = null;
//		MypageQaData mypageQaData = null;
//
//		try {
//			conn = factory.createConnection();
//			mypageQaData = new MypageQaDAO().selectOneByco(conn, qaNo);
//			qnaco = new MypageQaDAO().selectOneByco(conn, qaNo);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			JDBCTemplate.close(conn);
//		}
//		return mypageQaData;
//	}

	public int insertMypageQaData(MypageQaData mypageQaData) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new MypageQaDAO().insertMypageQaData(conn, mypageQaData);
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

	public int updateMypageQaData(MypageQaData mypageQaData) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new MypageQaDAO().updateMypageQaData(conn, mypageQaData);
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

	public PageData printSearchList(String search, int currentPage) {
		Connection conn = null;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setMypageQaList(new MypageQaDAO().selectSearchList(conn, search, currentPage));
			pd.setPageNavi(new MypageQaDAO().getSearchPageNavi(conn, search, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		System.out.println(pd);
		return pd;
	}

}
