package eventimg.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import eventimg.model.vo.Event;

public class EventDAO {

	public int inserEvent(Connection conn,Event event) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		String query = "INSERT INTO EVENT VALUES(SEQ_EVENT.NEXTVAL,?,?,SYSDATE,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,event.getMemberId());
			pstmt.setString(2, event.getEventTitle());
			pstmt.setDate(3, event.getEventStartDate());
			pstmt.setDate(4, event.getEventEndDate());
			pstmt.setString(5, event.getFileDir());
			pstmt.setString(6, event.getEventContent());
			pstmt.setString(7, event.getImageName());
			pstmt.setString(8, event.getImagePath());
			pstmt.setLong(9, event.getImageSize());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
		
//		public ArrayList<Event> selectAllList(Connection conn) {
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			ArrayList<Event> eList = null;
//			String query = 
//							
//			return ;
			

		
}


	


