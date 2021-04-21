package test;

import java.util.ArrayList;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

public class NoticeTest {

	public static void main(String[] args) {
		
		Notice notice = new Notice();
//		notice.setNoticeNo(0);
		int currentPage = 1;
		NoticePageData noticepagedata = new NoticePageData();
		NoticePageData noPageData = new NoticeService().printAllList(currentPage);
		ArrayList<Notice> nList = noPageData.getNoticeList();
		String pageNavi = noPageData.getPageNavi();
		System.out.println(nList);
		System.out.println(pageNavi);
	}

}
