package com.mxl.dao;

import com.mxl.bean.Sale;
import com.mxl.bean.Users;
import com.mxl.bean.Users;
import com.mxl.bean.Users;
import java.util.*;
public interface UsersDao{
	//用户类独有的  登录功能
		Users login(String userName,String password);
		/*添加方法*/
		 int add(Users users);
		/*修改方法*/
		 int update(Users users);
		/*通过ID删除方法*/
		 int delete(java.io.Serializable id);
		/*通过ID得到信息方法*/
		 Users findbyid(java.io.Serializable id);
		/*添加方法*/
		 List<Users> findAll();



}