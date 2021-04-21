package notice.model.vo;

import java.util.ArrayList;

public class NoticePageData {
	private ArrayList<Notice> noticeList;
	private String pageNavi;
	
	public NoticePageData() {}
	
	public ArrayList<Notice> getNoticeList(){
		return noticeList;
	}
	
	public void setNoticeList(ArrayList<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
	public String getPageNavi() {
		return pageNavi;
	}
	
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
