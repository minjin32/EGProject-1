package shop.model.vo;

public class Product {
	private int prNo;
	private int shNo;
	private String prName;
	private String prDescription;
	private int prPrice;
	private String prStatus;
	private int prPlug;
	public int getPrNo() {
		return prNo;
	}
	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}
	public int getShNo() {
		return shNo;
	}
	public void setShNo(int shNo) {
		this.shNo = shNo;
	}
	public String getPrName() {
		return prName;
	}
	public void setPrName(String prName) {
		this.prName = prName;
	}
	public String getPrDescription() {
		return prDescription;
	}
	public void setPrDescription(String prDescription) {
		this.prDescription = prDescription;
	}
	public int getPrPrice() {
		return prPrice;
	}
	public void setPrPrice(int prPrice) {
		this.prPrice = prPrice;
	}
	public String getPrStatus() {
		return prStatus;
	}
	public void setPrStatus(String prStatus) {
		this.prStatus = prStatus;
	}
	public int getPrPlug() {
		return prPlug;
	}
	public void setPrPlug(int prPlug) {
		this.prPlug = prPlug;
	}
	@Override
	public String toString() {
		return "Product [prNo=" + prNo + ", shNo=" + shNo + ", prName=" + prName + ", prDescription=" + prDescription
				+ ", prPrice=" + prPrice + ", prStatus=" + prStatus + ", prPlug=" + prPlug + "]";
	}

}
