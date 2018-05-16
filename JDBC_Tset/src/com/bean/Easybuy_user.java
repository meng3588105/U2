package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_user implements Serializable {

	private int id;
	private String loginName;
	private String userName;
	private String password;
	private int sex;
	private String identityCode;
	private String email;
	private String mobile;
	private int type;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setLoginName(String loginName){
		this.loginName=loginName;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setIdentityCode(String identityCode){
		this.identityCode=identityCode;
	}
	public String getIdentityCode(){
		return identityCode;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	public String getMobile(){
		return mobile;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getType(){
		return type;
	}
	public Easybuy_user(int id, String loginName, String userName, String password, int sex, String identityCode,
			String email, String mobile, int type) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}
	public Easybuy_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Easybuy_user [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password="
				+ password + ", sex=" + sex + ", identityCode=" + identityCode + ", email=" + email + ", mobile="
				+ mobile + ", type=" + type + "]";
	}

	
	

}