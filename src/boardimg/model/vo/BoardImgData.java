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
		return imageNo;
	}



	public void setImageNo(String imageNo) {
		this.imageNo = imageNo;
	}



	public String getBoNo() {
		return boNo;
	}



	public void setBoNo(String boNo) {
		this.boNo = boNo;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public long getImageSize() {
		return imageSize;
	}



	public void setImageSize(long imageSize) {
		this.imageSize = imageSize;
	}



	public Timestamp getUploadTime() {
		return uploadTime;
	}



	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}



	@Override
	public String toString() {
		return "FileData [imageNo=" + imageNo + ", boNo=" + boNo + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + ", uploadTime=" + uploadTime + "]";
	}


	
}


