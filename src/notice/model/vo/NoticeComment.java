package notice.model.vo;

public class NoticeComment {
	private String memberId;
	private int boardNo;
	private int coParentNo;
	private String coContents;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCoParentNo() {
		return coParentNo;
	}
	public void setCoParentNo(int coParentNo) {
		this.coParentNo = coParentNo;
	}
	public String getCoContents() {
		return coContents;
	}
	public void setCoContents(String coContent) {
		this.coContents = coContent;
	}
	@Override
	public String toString() {
		return "NoticeComment [memberId=" + memberId + ", boardNo=" + boardNo + ", coParentNo=" + coParentNo
				+ ", coContents=" + coContents + "]";
	}
}
