package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_news implements Serializable {

	private int id;
	private String title;
	private String content;
	private Date createTime;
	private String img;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setImg(String img){
		this.img=img;
	}
	public String getImg(){
		return img;
	}


}