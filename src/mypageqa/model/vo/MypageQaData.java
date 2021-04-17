package mypageqa.model.vo;

import java.sql.Date;

public class MypageQaData {

	private int qaNo;
	private String mbId;
	private String qaTitle;
	private String qaContent;
	private Date qaDateTime;

	public MypageQaData() {
	}

	public int getQaNo() {
		return qaNo;
	}

	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public Date getQaDateTime() {
		return qaDateTime;
	}

	public void setQaDateTime(Date qaDateTime) {
		this.qaDateTime = qaDateTime;
	}

	@Override
	public String toString() {
		return "MypageQaData [qaNo=" + qaNo + ", mbId=" + mbId + ", qaTitle=" + qaTitle + ", qaContent=" + qaContent
				+ ", qaDateTime=" + qaDateTime + "]";
	}

}
