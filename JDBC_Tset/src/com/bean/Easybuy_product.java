package com.bean;

import java.io.Serializable;
import java.util.Date;
public class Easybuy_product implements Serializable {

	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private int categoryLevel1Id;
	private int categoryLevel2Id;
	private int categoryLevel3Id;
	private String fileName;
	private int isDelete;
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
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice(){
		return price;
	}
	public void setStock(int stock){
		this.stock=stock;
	}
	public int getStock(){
		return stock;
	}
	public void setCategoryLevel1Id(int categoryLevel1Id){
		this.categoryLevel1Id=categoryLevel1Id;
	}
	public int getCategoryLevel1Id(){
		return categoryLevel1Id;
	}
	public void setCategoryLevel2Id(int categoryLevel2Id){
		this.categoryLevel2Id=categoryLevel2Id;
	}
	public int getCategoryLevel2Id(){
		return categoryLevel2Id;
	}
	public void setCategoryLevel3Id(int categoryLevel3Id){
		this.categoryLevel3Id=categoryLevel3Id;
	}
	public int getCategoryLevel3Id(){
		return categoryLevel3Id;
	}
	public void setFileName(String fileName){
		this.fileName=fileName;
	}
	public String getFileName(){
		return fileName;
	}
	public void setIsDelete(int isDelete){
		this.isDelete=isDelete;
	}
	public int getIsDelete(){
		return isDelete;
	}


}