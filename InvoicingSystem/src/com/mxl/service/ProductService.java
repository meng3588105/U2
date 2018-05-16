package com.mxl.service;

import com.mxl.bean.Product;
import com.mxl.util.PageInfo;

import java.io.Serializable;
import java.util.*;
public interface ProductService {

	boolean addNews(Product Product);

	PageInfo<Product> findAlls(int pageNum, int pageSize);

	int getTotalCount();

	List<Product> findAll();

	Product findNewsById(Serializable id);

	boolean updateNews(Product Product);

	boolean deleteNews(Serializable id);
	 //查找方法
	 List<Product> chazhao (int num);
}