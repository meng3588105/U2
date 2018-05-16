package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_user_address;
import com.dao.Easybuy_user_addressDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_user_addressDaoImpl extends JdbcUtil implements Easybuy_user_addressDao {

	@Override 
	 public int add(Easybuy_user_address t) {
		 String sql = "insert into easybuy_user_address(userId,address,createTime,isDefault,remark) values(?,?,?,?,?)";
		 Object[] params = { t.getUserId(),t.getAddress(),t.getCreateTime(),t.getIsDefault(),t.getRemark()};
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
		 String sql = "delete from easybuy_user_address where id=?";
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
	 public  List<Easybuy_user_address> findAll() {
		 String sql = "select * from  easybuy_user_address ";
		 List<Easybuy_user_address> easybuy_user_address=new ArrayList<Easybuy_user_address>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_user_address=ResultSetUtil.findAll(rs, Easybuy_user_address.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_user_address;
	}	@Override 
	 public Easybuy_user_address findbyid(Serializable id) {
		 String sql = "select * from  easybuy_user_address where id=?";
		   Object[] params = { id };
		 Easybuy_user_address  easybuy_user_address=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_user_address=ResultSetUtil.findById(rs, Easybuy_user_address.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_user_address;
	}	@Override 
	 public int update(Easybuy_user_address t) {
		 String sql = "update easybuy_user_address set userId=?,address=?,createTime=?,isDefault=?,remark=?  where id=?";
		 Object[] params={t.getUserId(),t.getAddress(),t.getCreateTime(),t.getIsDefault(),t.getRemark(),t.getId()};
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