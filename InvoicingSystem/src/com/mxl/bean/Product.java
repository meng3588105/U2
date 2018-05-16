package com.mxl.bean;

import java.io.Serializable;

public class Product implements Serializable{
	private int id ;//商品id
	private String productName;//商品名称
	private int  quantity;//库存量
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(int id, String productName, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
	
	
	
}
