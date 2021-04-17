package board.model.vo;

import java.util.ArrayList;

public class BoardPageData {
	private ArrayList<Board> boardList;
	private String pageNavi;
	
	public BoardPageData() {} // 얘는 생성자야!
	
	public ArrayList<Board> getNoticeList(){
		return boardList;
	}
	
	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	
	public String getPageNavi() {
		return pageNavi;
	}
	
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
