package shopimg.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import shopimg.model.vo.ShopImgData;

public class ShopImgDAO {

	public int insertFileInfo(Connection conn, ShopImgData shopImgData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SHOP_IMAGE VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, shopImgData.getImageNo());
			pstmt.setString(2, shopImgData.getMenuNo());
			pstmt.setString(3, shopImgData.getImageName());
			pstmt.setString(4, shopImgData.getImagePath());
			pstmt.setLong(5, shopImgData.getImageSize());
			pstmt.setTimestamp(6, shopImgData.getUploadTime());
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
		String query = "DELETE FROM SHOP_IMAGE WHERE(?,IMAGENO_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		
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
