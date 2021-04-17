package boardimg.model.vo;

import java.sql.Timestamp;

public class BoardImgData {
	
	private String imageNo;
	private String boNo;
	private String imageName;
	private String imagePath;
	private long imageSize;
	private Timestamp uploadTime;
	
	public BoardImgData() {}

	public String getImageNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBoNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImageName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImagePath() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getImageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Timestamp getUploadTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "FileData [imageNo=" + imageNo + ", boNo=" + boNo + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + ", uploadTime=" + uploadTime + "]";
	}
	
}


