package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_order_detail implements Serializable {

	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private double cost;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
	public int getOrderId(){
		return orderId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}
	public int getProductId(){
		return productId;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public int getQuantity(){
		return quantity;
	}
	public void setCost(double cost){
		this.cost=cost;
	}
	public double getCost(){
		return cost;
	}


}