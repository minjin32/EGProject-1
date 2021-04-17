package mypageqa.model.vo;

import java.util.ArrayList;

public class PageData {

	private ArrayList<MypageQaData> qaList;
	private String pageNavi;
	
	public PageData() {}
	
	public ArrayList<MypageQaData> getQaList() {
		return qaList;
	}
	public void setMypageQaList(ArrayList<MypageQaData> qaList) {
		this.qaList = qaList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
