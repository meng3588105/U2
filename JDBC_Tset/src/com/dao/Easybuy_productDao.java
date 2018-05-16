package com.dao;

import com.bean.Easybuy_product;
import java.util.*;
import java.util.Date;
public interface Easybuy_productDao {

	/*添加方法*/
	 int add(Easybuy_product easybuy_product);
	/*修改方法*/
	 int update(Easybuy_product easybuy_product);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_product findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_product> findAll();


}