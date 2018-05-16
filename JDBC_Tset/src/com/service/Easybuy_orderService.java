package com.service;

import com.bean.Easybuy_order;
import java.util.*;
import java.util.Date;
public interface Easybuy_orderService {

	/*添加方法*/
	 int add(Easybuy_order easybuy_order);
	/*修改方法*/
	 int update(Easybuy_order easybuy_order);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_order findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_order> findAll();


}