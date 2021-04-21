package mypageqa.model.vo;

import java.sql.Date;

public class MypageQaData {

	private int qaNo;
	private String mbId;
	private String qaTitle;
	private String qaContent;
	private Date qaDateTime;
	private String image_name;
	private String image_path;
	private long image_size;
	private boolean answered = false;
	private Date answeredDateTime;
	private String answerContent;

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

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean commented) {
		this.answered = commented;
	}

	public Date getAnsweredDateTime() {
		return answeredDateTime;
	}

	public void setAnsweredDateTime(Date answeredDateTime) {
		this.answeredDateTime = answeredDateTime;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	@Override
	public String toString() {
		return "MypageQaData [qaNo=" + qaNo + ", mbId=" + mbId + ", qaTitle=" + qaTitle + ", qaContent=" + qaContent
				+ ", qaDateTime=" + qaDateTime + ", image_name=" + image_name + ", image_path=" + image_path
				+ ", image_size=" + image_size + "]";
	}

}
