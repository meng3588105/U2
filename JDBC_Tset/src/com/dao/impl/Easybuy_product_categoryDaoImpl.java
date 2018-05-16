package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_product_category;
import com.dao.Easybuy_product_categoryDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_product_categoryDaoImpl extends JdbcUtil implements Easybuy_product_categoryDao {

	@Override 
	 public int add(Easybuy_product_category t) {
		 String sql = "insert into easybuy_product_category(name,parentId,type,iconClass) values(?,?,?,?)";
		 Object[] params = { t.getName(),t.getParentId(),t.getType(),t.getIconClass()};
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
		 String sql = "delete from easybuy_product_category where id=?";
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
	 public  List<Easybuy_product_category> findAll() {
		 String sql = "select * from  easybuy_product_category ";
		 List<Easybuy_product_category> easybuy_product_category=new ArrayList<Easybuy_product_category>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_product_category=ResultSetUtil.findAll(rs, Easybuy_product_category.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_product_category;
	}	@Override 
	 public Easybuy_product_category findbyid(Serializable id) {
		 String sql = "select * from  easybuy_product_category where id=?";
		   Object[] params = { id };
		 Easybuy_product_category  easybuy_product_category=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_product_category=ResultSetUtil.findById(rs, Easybuy_product_category.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_product_category;
	}	@Override 
	 public int update(Easybuy_product_category t) {
		 String sql = "update easybuy_product_category set name=?,parentId=?,type=?,iconClass=?  where id=?";
		 Object[] params={t.getName(),t.getParentId(),t.getType(),t.getIconClass(),t.getId()};
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