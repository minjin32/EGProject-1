package eventimg.model.vo;

import java.sql.Date;

public class Event {

	private int eventNo;
	private String memberId;
	private String eventTitle;
	private Date eventWriteDate;
	private Date eventStartDate;
	private Date eventEndDate;
	private String fileDir;
	private String eventContent;
	private String ImageName;
	private String ImagePath;
	private long ImageSize;
	public int getEventNo() {
		return eventNo;
	}
	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public Date getEventWriteDate() {
		return eventWriteDate;
	}
	public void setEventWriteDate(Date eventWriteDate) {
		this.eventWriteDate = eventWriteDate;
	}
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public long getImageSize() {
		return ImageSize;
	}
	public void setImageSize(long imageSize) {
		ImageSize = imageSize;
	}
	@Override
	public String toString() {
		return "EventImgData [eventNo=" + eventNo + ", memberId=" + memberId + ", eventTitle=" + eventTitle
				+ ", eventWriteDate=" + eventWriteDate + ", eventStartDate=" + eventStartDate + ", eventEndDate="
				+ eventEndDate + ", fileDir=" + fileDir + ", eventContent=" + eventContent + ", ImageName=" + ImageName
				+ ", ImagePath=" + ImagePath + ", ImageSize=" + ImageSize + "]";
	}
	
	
	
	}


