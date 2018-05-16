package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_order_detail;
import com.dao.Easybuy_order_detailDao;
import com.service.Easybuy_order_detailService;
import com.dao.impl.Easybuy_order_detailDaoImpl;
import java.util.Date;
public class Easybuy_order_detailServiceImpl implements Easybuy_order_detailService {

	Easybuy_order_detailDao dao=new Easybuy_order_detailDaoImpl();
	@Override 
	 public int add(Easybuy_order_detail t) {
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
	 public  List<Easybuy_order_detail> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_order_detail findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_order_detail t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}