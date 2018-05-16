package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_order;
import com.dao.Easybuy_orderDao;
import com.service.Easybuy_orderService;
import com.dao.impl.Easybuy_orderDaoImpl;
import java.util.Date;
public class Easybuy_orderServiceImpl implements Easybuy_orderService {

	Easybuy_orderDao dao=new Easybuy_orderDaoImpl();
	@Override 
	 public int add(Easybuy_order t) {
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
	 public  List<Easybuy_order> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_order findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_order t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}