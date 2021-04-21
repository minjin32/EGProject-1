package notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int num;
	private String mbId;
	private String noTitle;
	private String noContent;
	private Date noDatetime;
	private int noStatus;
	private String imageName;
	private String imagePath;
	private long imageSize;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNoNo() {
		return noNo;
	}
	public void setNoNo(int noNo) {
		this.noNo = noNo;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public String getNoTitle() {
		return noTitle;
	}
	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}
	public String getNoContent() {
		return noContent;
	}
	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}
	public Date getNoDatetime() {
		return noDatetime;
	}
	public void setNoDatetime(Date noDatetime) {
		this.noDatetime = noDatetime;
	}
	public int getNoStatus() {
		return noStatus;
	}
	public void setNoStatus(int noStatus) {
		this.noStatus = noStatus;
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
	
	private int noNo;
	@Override
	public String toString() {
		return "Notice ["+ num +"noNo=" + noNo + ", mbId=" + mbId + ", noTitle=" + noTitle + ", noContent=" + noContent
				+ ", noDatetime=" + noDatetime + ", noStatus=" + noStatus + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + "]";
	}

}