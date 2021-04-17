package shop.model.vo;

public class Menu {
	
	private int menuNo;
	private int shNo;
	private String menuName;
	private int menuPrice;
	private int bowlSize;
	private String menuPlug;
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getShNo() {
		return shNo;
	}
	public void setShNo(int shopNo) {
		this.shNo = shopNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getBowlSize() {
		return bowlSize;
	}
	public void setBowlSize(int bowlSize) {
		this.bowlSize = bowlSize;
	}
	public String getMenuPlug() {
		return menuPlug;
	}
	public void setMenuPlug(String menuPlug) {
		this.menuPlug = menuPlug;
	}
	
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", shNo=" + shNo + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", bowlSize=" + bowlSize + ", menuPlug=" + menuPlug + "]";
	}

}
