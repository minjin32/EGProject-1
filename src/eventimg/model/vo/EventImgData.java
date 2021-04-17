package eventimg.model.vo;

import java.sql.Timestamp;

public class EventImgData {

	private String imageNo;
	private String evNo;
	private String imageName;
	private String imagePath;
	private long imageSize;
	private Timestamp uploadTime;

	public EventImgData() {
	}

	public String getImageNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEvNo() {
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
		return "EventImgData [imageNo=" + imageNo + ", evNo=" + evNo + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + ", uploadTime=" + uploadTime + "]";
	}

}
