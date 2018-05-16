package com.mxl.dao;

import com.mxl.bean.Product;
import com.mxl.bean.Sale;

import java.util.*;
public interface ProductDao{

	/*添加方法*/
	 int add(Product product);
	/*修改方法*/
	 int update(Product product);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Product findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Product> findAll();
	 //查找方法
	 List<Product> chazhao (int num);
	 
	 
	 
		int getTotalCount();

		List<Product> findAlls(int pageNum, int pageSize);

}