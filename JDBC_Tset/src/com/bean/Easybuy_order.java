package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_order implements Serializable {

	private int id;
	private int userId;
	private String loginName;
	private String userAddress;
	private Date createTime;
	private double cost;
	private String serialNumber;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setLoginName(String loginName){
		this.loginName=loginName;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}
	public String getUserAddress(){
		return userAddress;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCost(double cost){
		this.cost=cost;
	}
	public double getCost(){
		return cost;
	}
	public void setSerialNumber(String serialNumber){
		this.serialNumber=serialNumber;
	}
	public String getSerialNumber(){
		return serialNumber;
	}


}