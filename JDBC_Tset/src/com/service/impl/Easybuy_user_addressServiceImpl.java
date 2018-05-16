package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_user_address;
import com.dao.Easybuy_user_addressDao;
import com.service.Easybuy_user_addressService;
import com.dao.impl.Easybuy_user_addressDaoImpl;
import java.util.Date;
public class Easybuy_user_addressServiceImpl implements Easybuy_user_addressService {

	Easybuy_user_addressDao dao=new Easybuy_user_addressDaoImpl();
	@Override 
	 public int add(Easybuy_user_address t) {
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
	 public  List<Easybuy_user_address> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_user_address findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_user_address t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}