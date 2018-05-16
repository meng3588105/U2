package com.mxl.service.impl;

import java.io.Serializable;
import java.util.List;

import com.mxl.bean.Users;
import com.mxl.dao.UsersDao;
import com.mxl.service.UsersService;
import com.mxl.dao.impl.UsersDaoImpl;
import java.util.Date;
public class UsersServiceImpl implements UsersService {

	UsersDao dao=new UsersDaoImpl();
	@Override 
	 public int add(Users t) {
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
	 public  List<Users> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Users findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Users t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}
	@Override
	public Users login(String userName, String password) {
		Users login = dao.login(userName, password);
		if (login == null) {

			return null;
		} else {
			return login;
		}


	}


}