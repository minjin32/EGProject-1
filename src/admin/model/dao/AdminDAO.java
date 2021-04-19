package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import mypageqa.model.vo.MypageQaData;

public class AdminDAO {

	public int selectQnACount(Connection conn) {
		int result = 0;
		ArrayList<MypageQaData> qList = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "SELECT COUNT(*) AS AMOUNT FROM QNA";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery(query);
			if(rset.next()) {
				result = Integer.parseInt(rset.getString("AMOUNT"));
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
