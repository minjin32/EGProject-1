package notice.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Notice {
	
	private int noticeNo;
	private String subject;
	private String userId;
	private String contents;
	private Date regDate;
	private int no_status;
	private String image_name;
	private String image_path;
	private long image_size;
	
	
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

	public int getNo_status() {
		return no_status;
	}

	public void setNo_status(int no_status) {
		this.no_status = no_status;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public long getImage_size() {
		return image_size;
	}

	public void setImage_size(long image_size) {
		this.image_size = image_size;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", subject=" + subject + ", userId=" + userId + ", contents=" + contents
				+ ", regDate=" + regDate + ", no_status=" + no_status + ", image_name=" + image_name + ", image_path="
				+ image_path + ", image_size=" + image_size + "]";
	}

}