package board.model.vo;

import java.util.ArrayList;

public class BoardPageData {
	private ArrayList<Board> boardList;
	private String pageNavi;
	
	public BoardPageData() {} // ��� �����ھ�!
	
	public ArrayList<Board> getBoardList(){
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
