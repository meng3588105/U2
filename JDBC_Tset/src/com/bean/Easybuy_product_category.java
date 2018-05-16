package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_product_category implements Serializable {

	private int id;
	private String name;
	private int parentId;
	private int type;
	private String iconClass;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setParentId(int parentId){
		this.parentId=parentId;
	}
	public int getParentId(){
		return parentId;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getType(){
		return type;
	}
	public void setIconClass(String iconClass){
		this.iconClass=iconClass;
	}
	public String getIconClass(){
		return iconClass;
	}


}