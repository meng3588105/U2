package com.mxl.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mxl.bean.Sale;
import com.mxl.dao.SaleDao;
import com.mxl.util.JdbcUtil;
import com.mxl.util.ResultSetUtil;
import java.util.Date;
public class SaleDaoImpl extends JdbcUtil implements SaleDao {

	@Override 
	 public int add(Sale t) {
		 String sql = "insert into sale(price,quantity,totaLprice,saleDate,userId,productId) values(?,?,?,?,?,?)";
		 Object[] params = { t.getPrice(),t.getQuantity(),t.getTotaLprice(),t.getSaleDate(),t.getUserId(),t.getProductId()};
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
		 String sql = "delete from sale where id=?";
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
	 public  List<Sale> findAll() {
		 String sql = "select * from  sale ";
		 List<Sale> sale=new ArrayList<Sale>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 sale=ResultSetUtil.findAll(rs, Sale.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return sale;
	}	@Override 
	 public Sale findbyid(Serializable id) {
		 String sql = "select * from  sale where id=?";
		   Object[] params = { id };
		 Sale  sale=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 sale=ResultSetUtil.finById(rs, Sale.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return sale;
	}	@Override 
	 public int update(Sale t) {
		 String sql = "update sale set price=?,quantity=?,totaLprice=?,saleDate=?,userId=?,productId=?  where id=?";
		 Object[] params={t.getPrice(),t.getQuantity(),t.getTotaLprice(),t.getSaleDate(),t.getUserId(),t.getProductId(),t.getId()};
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
		String sql = "select count(*) as count from sale";
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
	public List<Sale> findAlls(int pageNum, int pageSize) {
		String sql = "select * from sale limit ?,?";
		// 创建一个集合来保存所有的用户
		List<Sale> newss = new ArrayList<>();
		Object[] params = { pageNum, pageSize };
		try {
			rs = myExcuteQuery(sql, params);
			newss = ResultSetUtil.findAll(rs, Sale.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return newss;
	}

}