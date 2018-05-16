package com.mxl.bean;

import java.io.Serializable;

public class Users implements Serializable {
	
	private int id;//用户id
	private  String userName;//登录用账号
	private  String password;//登录用密码
	private  String realName;//登录后显示用户名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Users(int id, String userName, String password, String realName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", realName=" + realName + "]";
	}
	
	
	
	
}
