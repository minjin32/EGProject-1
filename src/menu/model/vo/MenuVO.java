package menu.model.vo;

public class MenuVO {
	private int menuNumber;
	private int shopNumber;
	private String name;
	private int price;
	private String bowlSize;
	private String imagePath;
	private String imageName;
	private int imageSize;
	
	public MenuVO() {};
	public int getMenuNumber() {
		return menuNumber;
	}
	public void setMenuNumber(int menuNumber) {
		this.menuNumber = menuNumber;
	}
	public int getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(int shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBowlSize() {
		return bowlSize;
	}
	public void setBowlSize(String bowlSize) {
		this.bowlSize = bowlSize;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getImageSize() {
		return imageSize;
	}
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
	@Override
	public String toString() {
		return "MenuVO [menuNumber=" + menuNumber + ", shopNumber=" + shopNumber + ", name=" + name + ", price=" + price
				+ ", bowlSize=" + bowlSize + ", imagePath=" + imagePath + ", imageName=" + imageName + ", imageSize="
				+ imageSize + "]";
	}
}
