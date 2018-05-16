package com.dao.bean;

import java.io.Serializable;
import java.util.Date;
public class Shopping_cart implements Serializable {

	private String userId;
	private String orderId;
	private int orderNum;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public Shopping_cart(String userId, String orderId, int orderNum) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.orderNum = orderNum;
	}
	public Shopping_cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shopping_cart [userId=" + userId + ", orderId=" + orderId + ", orderNum=" + orderNum + "]";
	}

	
	
}