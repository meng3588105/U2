package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Cart;
import com.dao.bean.Shopping_cart;
import com.dao.dao.Shopping_cartDao;
import com.dao.service.Shopping_cartService;
import com.dao.dao.impl.Shopping_cartDaoImpl;
import java.util.Date;
public class Shopping_cartServiceImpl implements Shopping_cartService {

	Shopping_cartDao dao=new Shopping_cartDaoImpl();
	@Override 
	 public int add(Shopping_cart t) {
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
	 public  List<Shopping_cart> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Shopping_cart findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Shopping_cart t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}




}