package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_order_detail;
import com.dao.Easybuy_order_detailDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_order_detailDaoImpl extends JdbcUtil implements Easybuy_order_detailDao {

	@Override 
	 public int add(Easybuy_order_detail t) {
		 String sql = "insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?)";
		 Object[] params = { t.getOrderId(),t.getProductId(),t.getQuantity(),t.getCost()};
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
		 String sql = "delete from easybuy_order_detail where id=?";
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
	 public  List<Easybuy_order_detail> findAll() {
		 String sql = "select * from  easybuy_order_detail ";
		 List<Easybuy_order_detail> easybuy_order_detail=new ArrayList<Easybuy_order_detail>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_order_detail=ResultSetUtil.findAll(rs, Easybuy_order_detail.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_order_detail;
	}	@Override 
	 public Easybuy_order_detail findbyid(Serializable id) {
		 String sql = "select * from  easybuy_order_detail where id=?";
		   Object[] params = { id };
		 Easybuy_order_detail  easybuy_order_detail=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_order_detail=ResultSetUtil.findById(rs, Easybuy_order_detail.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_order_detail;
	}	@Override 
	 public int update(Easybuy_order_detail t) {
		 String sql = "update easybuy_order_detail set orderId=?,productId=?,quantity=?,cost=?  where id=?";
		 Object[] params={t.getOrderId(),t.getProductId(),t.getQuantity(),t.getCost(),t.getId()};
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