package event.model.vo;

import java.sql.Date;

public class Event {

	private int eventNo;
	private String eventTitle;
	private Date eventWriteDate;
	private Date eventEndDate;
	private String ImageName;
	private String ImagePath;
	private long ImageSize;
	
	
	private void Event() {
		
	}
	
	public int getEventNo() {
		return eventNo;
	}
	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
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
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventWriteDate=" + eventWriteDate
				+ ", eventEndDate=" + eventEndDate + ", ImageName=" + ImageName + ", ImagePath=" + ImagePath
				+ ", ImageSize=" + ImageSize + "]";
	}

	
	
	
	}


