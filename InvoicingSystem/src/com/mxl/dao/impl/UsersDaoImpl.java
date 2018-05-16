package com.mxl.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mxl.bean.Users;
import com.mxl.dao.UsersDao;
import com.mxl.util.JdbcUtil;
import com.mxl.util.ResultSetUtil;
import java.util.Date;
public class UsersDaoImpl extends JdbcUtil implements UsersDao {

	@Override 
	 public int add(Users t) {
		 String sql = "insert into users(userName,password,realName) values(?,?,?)";
		 Object[] params = { t.getUserName(),t.getPassword(),t.getRealName()};
		 int reNum=0;
		 try {
			 reNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return reNum;
	}	@Override 
	 public int delete(Serializable id) {
		 String sql = "delete from users where id=?";
		 Object[] params={id};
		 int reNum=0;
		 try {
			 reNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return reNum;
	}	@Override 
	 public  List<Users> findAll() {
		 String sql = "select * from  users ";
		 List<Users> users=new ArrayList<Users>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 users=ResultSetUtil.findAll(rs, Users.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return users;
	}	@Override 
	 public Users findbyid(Serializable id) {
		 String sql = "select * from  users where id=?";
		   Object[] params = { id };
		 Users  users=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 users=ResultSetUtil.finById(rs, Users.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return users;
	}	@Override 
	 public int update(Users t) {
		 String sql = "update users set userName=?,password=?,realName=?  where id=?";
		 Object[] params={t.getUserName(),t.getPassword(),t.getRealName(),t.getId()};
		 int reNum=0;
		 try {
			 reNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return reNum;
	}
	
	/**
	 * 登陆方法
	 */
	@Override
	public Users login(String userName, String password) {
		
		String sql = "select * from users where userName=? and password=?";
		// 给参数赋值
		Object[] params = { userName, password };
		Users users = null;
		try {

			rs = myExcuteQuery(sql, params);
			users=ResultSetUtil.finById(rs, Users.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}

		return users;
	
	}

}