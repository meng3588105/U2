package com.mxl.dao;

import com.mxl.bean.Product;
import com.mxl.bean.Sale;
import java.util.*;
public interface SaleDao {

	/*添加方法*/
	 int add(Sale sale);
	/*修改方法*/
	 int update(Sale sale);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Sale findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Sale> findAll();


	int getTotalCount();

	List<Sale> findAlls(int pageNum, int pageSize);
}