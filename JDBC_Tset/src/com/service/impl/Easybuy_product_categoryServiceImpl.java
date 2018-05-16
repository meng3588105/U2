package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_product_category;
import com.dao.Easybuy_product_categoryDao;
import com.service.Easybuy_product_categoryService;
import com.dao.impl.Easybuy_product_categoryDaoImpl;
import java.util.Date;
public class Easybuy_product_categoryServiceImpl implements Easybuy_product_categoryService {

	Easybuy_product_categoryDao dao=new Easybuy_product_categoryDaoImpl();
	@Override 
	 public int add(Easybuy_product_category t) {
		 int renum=dao.add(t);
		  if(renum>0){
			  System.out.println("添加成功！");
		 }else{ 
			  System.out.println("添加失败！");
		 }
		 return renum;
	
}
	@Override 
	 public int delete(Serializable id) {
		 int renum=dao.delete(id);
		  if(renum>0){
			  System.out.println("删除成功！");
		 }else{ 
			  System.out.println("删除失败！");
		 }
		 return renum;
	
}
	@Override 
	 public  List<Easybuy_product_category> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_product_category findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_product_category t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}