package event.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import event.model.vo.Event;

public class EventDAO {

	public int inserEvent(Connection conn,Event event) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		String query = "INSERT INTO EVENT VALUES(EVENT_SEQ.NEXTVAL,?,SYSDATE,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getImageName());
			pstmt.setString(3, event.getImagePath());
			pstmt.setLong(4, event.getImageSize());
			pstmt.setDate(5, event.getEventEndDate());
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Event> printAllList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Event> list = null;
		String query = "SELECT * FROM EVENT";
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				list = new ArrayList<Event>();
				while(rset.next()) {
					Event event = new Event();
					event.setEventTitle(rset.getString("EV_TITLE"));
					event.setImageName(rset.getString("IMAGE_NAME"));
					event.setImagePath(rset.getString("IMAGE_PATH"));
					event.setImageSize(rset.getInt("IMAGE_SIZE"));
					event.setEventEndDate(rset.getDate("EV_ENDDATE"));
					list.add(event);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(stmt);
			}
		return list;
	

		// TODO Auto-generated method stub
	}
		 

			

		
}


	


