package boardimg.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import boardimg.model.vo.BoardImgData;
import common.JDBCTemplate;

public class BoardImgDAO {

	public int insertFileInfo(Connection conn, BoardImgData boardImgData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOARD_IMAGE VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boardImgData.getImageNo());
			pstmt.setString(2, boardImgData.getBoNo());
			pstmt.setString(3, boardImgData.getImageName());
			pstmt.setString(4, boardImgData.getImagePath());
			pstmt.setLong(5, boardImgData.getImageSize());
			pstmt.setTimestamp(6, boardImgData.getUploadTime());
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
		String query = "DELETE FROM BOARD_IMAGE WHERE(?,BONO_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		
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
