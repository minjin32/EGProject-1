package shop.model.vo;

import java.sql.Date;

public class Shop {
	private int shopNumber;
	private String memberId;
	private String shopName;
	private String shopBusinessNumber;
	private String shopAddress;
	private String shopAddress1;
	private String shopAddress2;
	private String shopAddress3;
	private String shopPhone;
	private String shopOwner;
	private Date shopOpenTime;
	private Date shopCloseTime;
	private String shopIntroduce;
	private String shopOrigin;
	private int shopType;
	private String imagePath1;
	private String imagePath2;
	
	public int getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(int shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopBusinessNumber() {
		return shopBusinessNumber;
	}
	public void setShopBusinessNumber(String shopBusinessNumber) {
		this.shopBusinessNumber = shopBusinessNumber;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopAddress1() {
		return shopAddress1;
	}
	public void setShopAddress1(String shopAddress1) {
		this.shopAddress1 = shopAddress1;
	}
	public String getShopAddress2() {
		return shopAddress2;
	}
	public void setShopAddress2(String shopAddress2) {
		this.shopAddress2 = shopAddress2;
	}
	public String getShopAddress3() {
		return shopAddress3;
	}
	public void setShopAddress3(String shopAddress3) {
		this.shopAddress3 = shopAddress3;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public String getShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}
	public Date getShopOpenTime() {
		return shopOpenTime;
	}
	public void setShopOpenTime(Date shopOpenTime) {
		this.shopOpenTime = shopOpenTime;
	}
	public Date getShopCloseTime() {
		return shopCloseTime;
	}
	public void setShopCloseTime(Date shopCloseTime) {
		this.shopCloseTime = shopCloseTime;
	}
	public String getShopIntroduce() {
		return shopIntroduce;
	}
	public void setShopIntroduce(String shopIntroduce) {
		this.shopIntroduce = shopIntroduce;
	}
	public String getShopOrigin() {
		return shopOrigin;
	}
	public void setShopOrigin(String shopOrigin) {
		this.shopOrigin = shopOrigin;
	}
	public int getShopType() {
		return shopType;
	}
	public void setShopType(int shopType) {
		this.shopType = shopType;
	}
	public String getImagePath1() {
		return imagePath1;
	}
	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}
	public String getImagePath2() {
		return imagePath2;
	}
	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}
	@Override
	public String toString() {
		return "Shop [shopNumber=" + shopNumber + ", memberId=" + memberId + ", shopName=" + shopName
				+ ", shopBusinessNumber=" + shopBusinessNumber + ", shopAddress=" + shopAddress + ", shopAddress1="
				+ shopAddress1 + ", shopAddress2=" + shopAddress2 + ", shopAddress3=" + shopAddress3 + ", shopPhone="
				+ shopPhone + ", shopOwner=" + shopOwner + ", shopOpenTime=" + shopOpenTime + ", shopCloseTime="
				+ shopCloseTime + ", shopIntroduce=" + shopIntroduce + ", shopOrigin=" + shopOrigin + ", shopType="
				+ shopType + "]";
	}
	
	
}
