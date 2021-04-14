package shop.model.vo;

import java.util.ArrayList;

public class ShopPageData {
	ArrayList<Shop> shopList;
	String pageNavi;
	
	public ShopPageData() {}

	public ArrayList<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(ArrayList<Shop> list) {
		this.shopList = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "ShopPageData [shopList=" + shopList + ", pageNavi=" + pageNavi + "]";
	}
}
