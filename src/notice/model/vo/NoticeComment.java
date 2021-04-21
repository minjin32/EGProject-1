package notice.model.vo;

import java.sql.Date;

public class NoticeComment {

	private int commentNo;
	private String memberId;
	private int noticeNo;
	private int coParentNo;
	private String coContent;
	private Date coDatetime;
	
	// 생성자
	public NoticeComment() {
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getCoParentNo() {
		return coParentNo;
	}

	public void setCoParentNo(int coParentNo) {
		this.coParentNo = coParentNo;
	}

	public String getCoContent() {
		return coContent;
	}

	public void setCoContent(String coContent) {
		this.coContent = coContent;
	}
	
	public Date getCoDatetime() {
		return coDatetime;
	}

	public void setCoDatetime(Date coDatetime) {
		this.coDatetime = coDatetime;
	}
	
	@Override
	public String toString() {
		return "NoticeComment [commentNo=" + commentNo + ", memberId=" + memberId + ", noticeNo=" + noticeNo
				+ ", coParentNo=" + coParentNo + ", coContent=" + coContent + ", coDatetime=" + coDatetime + "]";
	}
}