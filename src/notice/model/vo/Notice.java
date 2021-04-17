package notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private String subject;
	private String userId;
	private String contents;
	private Date regDate;
	private int no_status;
	// 멤버변수에서 접근제한자가 private인 이유? -> 캡슐화!
	
	
	public Notice() {}
	// 생성자, 객체를 생성하면서 멤버변수를 초기화한다


	// 게터, 세터
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

	// toString
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", subject=" + subject + ", userId=" + userId + ", contents=" + contents
				+ ", regDate=" + regDate + ", no_status=" + no_status + "]";
	}
}