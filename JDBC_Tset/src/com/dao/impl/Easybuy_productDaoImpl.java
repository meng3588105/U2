package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_product;
import com.dao.Easybuy_productDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_productDaoImpl extends JdbcUtil implements Easybuy_productDao {

	@Override 
	 public int add(Easybuy_product t) {
		 String sql = "insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
		 Object[] params = { t.getName(),t.getDescription(),t.getPrice(),t.getStock(),t.getCategoryLevel1Id(),t.getCategoryLevel2Id(),t.getCategoryLevel3Id(),t.getFileName(),t.getIsDelete()};
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
		 String sql = "delete from easybuy_product where id=?";
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
	 public  List<Easybuy_product> findAll() {
		 String sql = "select * from  easybuy_product ";
		 List<Easybuy_product> easybuy_product=new ArrayList<Easybuy_product>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_product=ResultSetUtil.findAll(rs, Easybuy_product.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_product;
	}	@Override 
	 public Easybuy_product findbyid(Serializable id) {
		 String sql = "select * from  easybuy_product where id=?";
		   Object[] params = { id };
		 Easybuy_product  easybuy_product=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_product=ResultSetUtil.findById(rs, Easybuy_product.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_product;
	}	@Override 
	 public int update(Easybuy_product t) {
		 String sql = "update easybuy_product set name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=?  where id=?";
		 Object[] params={t.getName(),t.getDescription(),t.getPrice(),t.getStock(),t.getCategoryLevel1Id(),t.getCategoryLevel2Id(),t.getCategoryLevel3Id(),t.getFileName(),t.getIsDelete(),t.getId()};
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