package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_product;
import com.dao.Easybuy_productDao;
import com.service.Easybuy_productService;
import com.dao.impl.Easybuy_productDaoImpl;
import java.util.Date;
public class Easybuy_productServiceImpl implements Easybuy_productService {

	Easybuy_productDao dao=new Easybuy_productDaoImpl();
	@Override 
	 public int add(Easybuy_product t) {
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
	 public  List<Easybuy_product> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_product findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_product t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}