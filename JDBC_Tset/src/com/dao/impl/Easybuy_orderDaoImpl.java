package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_order;
import com.dao.Easybuy_orderDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_orderDaoImpl extends JdbcUtil implements Easybuy_orderDao {

	@Override 
	 public int add(Easybuy_order t) {
		 String sql = "insert into easybuy_order(userId,loginName,userAddress,createTime,cost,serialNumber) values(?,?,?,?,?,?)";
		 Object[] params = { t.getUserId(),t.getLoginName(),t.getUserAddress(),t.getCreateTime(),t.getCost(),t.getSerialNumber()};
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
		 String sql = "delete from easybuy_order where id=?";
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
	 public  List<Easybuy_order> findAll() {
		 String sql = "select * from  easybuy_order ";
		 List<Easybuy_order> easybuy_order=new ArrayList<Easybuy_order>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_order=ResultSetUtil.findAll(rs, Easybuy_order.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_order;
	}	@Override 
	 public Easybuy_order findbyid(Serializable id) {
		 String sql = "select * from  easybuy_order where id=?";
		   Object[] params = { id };
		 Easybuy_order  easybuy_order=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_order=ResultSetUtil.findById(rs, Easybuy_order.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_order;
	}	@Override 
	 public int update(Easybuy_order t) {
		 String sql = "update easybuy_order set userId=?,loginName=?,userAddress=?,createTime=?,cost=?,serialNumber=?  where id=?";
		 Object[] params={t.getUserId(),t.getLoginName(),t.getUserAddress(),t.getCreateTime(),t.getCost(),t.getSerialNumber(),t.getId()};
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