package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.bean.Shopping_cart;
import com.dao.dao.Shopping_cartDao;

import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

import java.util.Date;
public class Shopping_cartDaoImpl extends jdbcUtil implements Shopping_cartDao {

	@Override 
	 public int add(Shopping_cart t) {
		 String sql = "insert into shopping_cart(userId,orderId,orderNum) values(?,?,?)";
		 Object[] params = { t.getUserId(),t.getOrderId(),t.getOrderNum()};
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
		 String sql = "delete from shopping_cart where id=?";
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
	 public  List<Shopping_cart> findAll() {
		 String sql = "select * from  shopping_cart ";
		 List<Shopping_cart> shopping_cart=new ArrayList<Shopping_cart>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 shopping_cart=ResultSetUtil.findAll(rs, Shopping_cart.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return shopping_cart;
	}	@Override 
	 public Shopping_cart findbyid(Serializable id) {
		 String sql = "select * from  shopping_cart where id=?";
		   Object[] params = { id };
		 Shopping_cart  shopping_cart=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 shopping_cart=ResultSetUtil.finById(rs, Shopping_cart.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return shopping_cart;
	}	@Override 
	 public int update(Shopping_cart t) {
		 String sql = "update shopping_cart set userId=?,orderId=?,orderNum=?  where id=?";
		 Object[] params={t.getUserId(),t.getOrderId(),t.getOrderNum()};
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
	@Override
	public void findbyid(String uid, String id) {
		
		
	}

}