package com.dao.service;

import com.dao.bean.Cart;
import com.dao.bean.Shopping_cart;
import java.util.*;
import java.util.Date;
public interface Shopping_cartService {

	/*添加方法*/
	 int add(Shopping_cart shopping_cart);
	/*修改方法*/
	 int update(Shopping_cart shopping_cart);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Shopping_cart findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Shopping_cart> findAll();



}