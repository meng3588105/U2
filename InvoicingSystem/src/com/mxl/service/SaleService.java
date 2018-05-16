package com.mxl.service;

import com.mxl.bean.Sale;
import com.mxl.util.PageInfo;

import java.io.Serializable;
import java.util.*;
public interface SaleService {

	boolean addNews(Sale Sale);

	PageInfo<Sale> findAlls(int pageNum, int pageSize);

	int getTotalCount();

	List<Sale> findAll();

	Sale findNewsById(Serializable id);

	boolean updateNews(Sale Product);

	boolean deleteNews(Serializable id);


}