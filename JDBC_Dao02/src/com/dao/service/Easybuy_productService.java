package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_product;

/**
 * 商品   增删改查 接口
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日下午3:05:39
 */

public interface Easybuy_productService {
	/**
	 * 新增
	 */
	void add(Easybuy_product t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(Easybuy_product t);
	/**
	 * 查询所有 
	 */
	List<Easybuy_product> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	Easybuy_product findById(Serializable id);
}

