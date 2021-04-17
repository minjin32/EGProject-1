package shopimg.model.vo;

import java.sql.Timestamp;

public class ShopImgData {

	private String imageNo;
	private String menuNo;
	private String imageName;
	private String imagePath;
	private long imageSize;
	private Timestamp uploadTime;

	public ShopImgData() {
	}

	public String getImageNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMenuNo() {
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
		return "ShopImgData [imageNo=" + imageNo + ", menuNo=" + menuNo + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + ", uploadTime=" + uploadTime + "]";
	}

}
