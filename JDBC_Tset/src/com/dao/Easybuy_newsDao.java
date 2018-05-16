package com.dao;

import com.bean.Easybuy_news;
import java.util.*;
import java.util.Date;
public interface Easybuy_newsDao {

	/*添加方法*/
	 int add(Easybuy_news easybuy_news);
	/*修改方法*/
	 int update(Easybuy_news easybuy_news);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_news findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_news> findAll();


}