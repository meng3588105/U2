package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_user;
import com.dao.Easybuy_userDao;
import com.service.Easybuy_userService;
import com.dao.impl.Easybuy_userDaoImpl;
import java.util.Date;
public class Easybuy_userServiceImpl implements Easybuy_userService {

	Easybuy_userDao dao=new Easybuy_userDaoImpl();
	@Override 
	 public int add(Easybuy_user t) {
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
	 public  List<Easybuy_user> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_user findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_user t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}