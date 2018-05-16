package com.ui;

import java.util.List;

import com.bean.Easybuy_user;
import com.dao.Easybuy_userDao;
import com.dao.impl.Easybuy_userDaoImpl;

public class Test {

	public static void main(String[] args) {
		 Easybuy_userDao Easybuy_userDaoImpl =new Easybuy_userDaoImpl();

				/*
				 * 用户用指定id查询 User user =userDaoImpl.findById(1); System.out.println(user);
				 */

				
				 List<Easybuy_user> all = Easybuy_userDaoImpl.findAll();
				 
				 
				 for (Easybuy_user user : all) {
				  System.out.println(user); }
				 

	}
	
	
}
