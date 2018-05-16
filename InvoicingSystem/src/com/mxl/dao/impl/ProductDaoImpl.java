package com.mxl.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mxl.bean.Product;
import com.mxl.dao.ProductDao;
import com.mxl.util.JdbcUtil;
import com.mxl.util.ResultSetUtil;
import java.util.Date;
public class ProductDaoImpl extends JdbcUtil implements ProductDao {

	@Override 
	 public int add(Product t) {
		 String sql = "insert into product(productName,quantity) values(?,?)";
		 Object[] params = { t.getProductName(),t.getQuantity()};
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
		 String sql = "delete from product where id=?";
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
	 public  List<Product> findAll() {
		 String sql = "select * from  product ";
		 List<Product> product=new ArrayList<Product>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 product=ResultSetUtil.findAll(rs, Product.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return product;
	}	@Override 
	 public Product findbyid(Serializable id) {
		 String sql = "select * from  product where id=?";
		   Object[] params = { id };
		 Product  product=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 product=ResultSetUtil.finById(rs, Product.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return product;
	}	@Override 
	 public int update(Product t) {
		 String sql = "update product set productName=?,quantity=?  where id=?";
		 Object[] params={t.getProductName(),t.getQuantity(),t.getId()};
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
	public int getTotalCount() {
		String sql = "select count(*) as count from product";
		int count = 0;
		try {
			rs = myExcuteQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}
	@Override
	public List<Product> findAlls(int pageNum, int pageSize) {
		String sql = "select * from product limit ?,?";
		// 创建一个集合来保存所有的用户
		List<Product> newss = new ArrayList<>();
		Object[] params = { pageNum, pageSize };
		try {
			rs = myExcuteQuery(sql, params);
			newss = ResultSetUtil.findAll(rs, Product.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return newss;
	}
	@Override
	public List<Product> chazhao(int num) {
		String sql ="select * from product where id=?";
		List <Product> findAll=null;
		Object [] params = {num};
		try {
			rs=myExcuteQuery(sql, params);
			findAll = ResultSetUtil.findAll(rs, Product.class);
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return findAll;
	}

}