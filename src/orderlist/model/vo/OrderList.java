package orderlist.model.vo;

import java.sql.Date;

public class OrderList {

	private int orderNo;
	private int shopNo;
	private String memberId;
	private int orderPrice;
	private int orderStatus;
	private String shopName;
	private Date shopDateTime;
	private String orderReject;
	private String shopRuntime;
	
	private void orderList() {
		
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getShopDateTime() {
		return shopDateTime;
	}

	public void setShopDateTime(Date shopDateTime) {
		this.shopDateTime = shopDateTime;
	}

	public String getOrderReject() {
		return orderReject;
	}

	public void setOrderReject(String orderReject) {
		this.orderReject = orderReject;
	}

	public String getShopRuntime() {
		return shopRuntime;
	}

	public void setShopRuntime(String shopRuntime) {
		this.shopRuntime = shopRuntime;
	}

	@Override
	public String toString() {
		return "OrderList [orderNo=" + orderNo + ", shopNo=" + shopNo + ", memberId=" + memberId + ", orderPrice="
				+ orderPrice + ", orderStatus=" + orderStatus + ", shopName=" + shopName + ", shopDateTime="
				+ shopDateTime + ", orderReject=" + orderReject + ", shopRuntime=" + shopRuntime + "]";
	}

	
	
}
