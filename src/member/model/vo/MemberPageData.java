package member.model.vo;

import java.util.ArrayList;

public class MemberPageData {
	
	private ArrayList<Member> memberList;
	private String pageNavi;
	
	public MemberPageData() {}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}