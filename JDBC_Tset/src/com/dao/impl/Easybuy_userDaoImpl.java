package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_user;
import com.dao.Easybuy_userDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_userDaoImpl extends JdbcUtil implements Easybuy_userDao {

	@Override 
	 public int add(Easybuy_user t) {
		 String sql = "insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile,type) values(?,?,?,?,?,?,?,?)";
		 Object[] params = { t.getLoginName(),t.getUserName(),t.getPassword(),t.getSex(),t.getIdentityCode(),t.getEmail(),t.getMobile(),t.getType()};
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
		 String sql = "delete from easybuy_user where id=?";
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
	 public  List<Easybuy_user> findAll() {
		 String sql = "select * from  easybuy_user ";
		 List<Easybuy_user> easybuy_user=new ArrayList<Easybuy_user>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_user=ResultSetUtil.findAll(rs, Easybuy_user.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_user;
	}	@Override 
	 public Easybuy_user findbyid(Serializable id) {
		 String sql = "select * from  easybuy_user where id=?";
		   Object[] params = { id };
		 Easybuy_user  easybuy_user=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_user=ResultSetUtil.findById(rs, Easybuy_user.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_user;
	}	@Override 
	 public int update(Easybuy_user t) {
		 String sql = "update easybuy_user set loginName=?,userName=?,password=?,sex=?,identityCode=?,email=?,mobile=?,type=?  where id=?";
		 Object[] params={t.getLoginName(),t.getUserName(),t.getPassword(),t.getSex(),t.getIdentityCode(),t.getEmail(),t.getMobile(),t.getType(),t.getId()};
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

}