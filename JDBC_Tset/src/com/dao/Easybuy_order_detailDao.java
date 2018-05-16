package com.dao;

import com.bean.Easybuy_order_detail;
import java.util.*;
import java.util.Date;
public interface Easybuy_order_detailDao {

	/*添加方法*/
	 int add(Easybuy_order_detail easybuy_order_detail);
	/*修改方法*/
	 int update(Easybuy_order_detail easybuy_order_detail);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_order_detail findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_order_detail> findAll();


}