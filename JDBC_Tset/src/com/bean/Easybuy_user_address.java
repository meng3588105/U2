package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_user_address implements Serializable {

	private int id;
	private int userId;
	private String address;
	private Date createTime;
	private int isDefault;
	private String remark;
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
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setIsDefault(int isDefault){
		this.isDefault=isDefault;
	}
	public int getIsDefault(){
		return isDefault;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}


}