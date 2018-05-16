package com.mxl.bean;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable{
	private int id;//记录id
	private float price;//销售单价
	private int quantity;//总价
	private float totaLprice;//总价
	private Date saleDate;//销售日期
	private int userId;//销售员id
	private int productId;//商品id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotaLprice() {
		return totaLprice;
	}
	public void setTotaLprice(float totaLprice) {
		this.totaLprice = totaLprice;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Sale(int id, float price, int quantity, float totaLprice, Date saleDate, int userId, int productId) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.totaLprice = totaLprice;
		this.saleDate = saleDate;
		this.userId = userId;
		this.productId = productId;
	}
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", price=" + price + ", quantity=" + quantity + ", totaLprice=" + totaLprice
				+ ", saleDate=" + saleDate + ", userId=" + userId + ", productId=" + productId + "]";
	}
	
	
	
	
	
	


	
}
