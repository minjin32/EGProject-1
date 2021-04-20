package notice.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Notice {
	
	private int noticeNo;
	private String subject;
	private String userId;
	private String contents;
	private Date regDate;
	private int noStatus;
	private String imageName;
	private String imagePath;
	private long imageSize;
	
	public Notice() {};
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", subject=" + subject + ", userId=" + userId + ", contents=" + contents
				+ ", regDate=" + regDate + ", noStatus=" + noStatus + ", imageName=" + imageName + ", imagePath="
				+ imagePath + ", imageSize=" + imageSize + "]";
	}
	
	

}