package eventimg.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import eventimg.model.vo.EventImgData;

public class EventImgDAO {

	public int insertFileInfo(Connection conn, EventImgData eventImgData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SHOP_IMAGE VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eventImgData.getImageNo());
			pstmt.setString(2, eventImgData.getEvNo());
			pstmt.setString(3, eventImgData.getImageName());
			pstmt.setString(4, eventImgData.getImagePath());
			pstmt.setLong(5, eventImgData.getImageSize());
			pstmt.setTimestamp(6, eventImgData.getUploadTime());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateFile(Connection conn, String imagePath, String imageName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM SHOP_IMAGE WHERE(?,EVNO_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, imagePath);
			pstmt.setString(2, imageName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


}
