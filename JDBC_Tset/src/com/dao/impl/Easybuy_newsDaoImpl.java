package com.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Easybuy_news;
import com.dao.Easybuy_newsDao;
import com.util.JdbcUtil;
import com.util.ResultSetUtil;
import java.util.Date;
public class Easybuy_newsDaoImpl extends JdbcUtil implements Easybuy_newsDao {

	@Override 
	 public int add(Easybuy_news t) {
		 String sql = "insert into easybuy_news(title,content,createTime,img) values(?,?,?,?)";
		 Object[] params = { t.getTitle(),t.getContent(),t.getCreateTime(),t.getImg()};
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
		 String sql = "delete from easybuy_news where id=?";
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
	 public  List<Easybuy_news> findAll() {
		 String sql = "select * from  easybuy_news ";
		 List<Easybuy_news> easybuy_news=new ArrayList<Easybuy_news>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 easybuy_news=ResultSetUtil.findAll(rs, Easybuy_news.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_news;
	}	@Override 
	 public Easybuy_news findbyid(Serializable id) {
		 String sql = "select * from  easybuy_news where id=?";
		   Object[] params = { id };
		 Easybuy_news  easybuy_news=null;
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 easybuy_news=ResultSetUtil.findById(rs, Easybuy_news.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return easybuy_news;
	}	@Override 
	 public int update(Easybuy_news t) {
		 String sql = "update easybuy_news set title=?,content=?,createTime=?,img=?  where id=?";
		 Object[] params={t.getTitle(),t.getContent(),t.getCreateTime(),t.getImg(),t.getId()};
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