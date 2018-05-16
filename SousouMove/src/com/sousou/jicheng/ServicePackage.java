package com.sousou.jicheng;
/**
 * TalkPackage/
 * NetPackage/
 * SuperPackage/
 * 的父类
 * @author Administrator
 *
 */
public abstract class ServicePackage {
	private double price;//套餐月资费


	public ServicePackage(double price) {
		super();
		this.price = price;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServicePackage [price=" + price + "]";
	}


	public abstract void showInfo();




	
	
}
