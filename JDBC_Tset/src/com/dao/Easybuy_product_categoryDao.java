package com.dao;

import com.bean.Easybuy_product_category;
import java.util.*;
import java.util.Date;
public interface Easybuy_product_categoryDao {

	/*添加方法*/
	 int add(Easybuy_product_category easybuy_product_category);
	/*修改方法*/
	 int update(Easybuy_product_category easybuy_product_category);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_product_category findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_product_category> findAll();


}