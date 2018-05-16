package com.mxl.service.impl;

import java.io.Serializable;
import java.util.List;
import com.mxl.bean.Product;
import com.mxl.dao.ProductDao;
import com.mxl.service.ProductService;
import com.mxl.util.PageInfo;
import com.mxl.dao.impl.ProductDaoImpl;
import java.util.Date;
public class ProductServiceImpl implements ProductService {

	ProductDao dao=new ProductDaoImpl();

	@Override
	public boolean addNews(Product Product) {
		int add = dao.add(Product);
		if (add > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Product> findAlls(int pageNum, int pageSize) {
		PageInfo<Product> pageInfo = new PageInfo<>();
		// 给pageInfo对象的list集合赋值
		pageInfo.setList(dao.findAlls(pageNum, pageSize));
		return pageInfo;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return dao.getTotalCount();
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product findNewsById(Serializable id) {
		// TODO Auto-generated method stub
		return dao.findbyid(id);
		
	}

	@Override
	public boolean updateNews(Product Product) {
		if (dao.update(Product) > 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteNews(Serializable id) {
		if (dao.delete(id) > 0) {
			return true;
		}
		return false;
	}
/**
 * 查找方法
 */
	@Override
	public List<Product> chazhao(int num) {	
		
		return dao.chazhao(num);
	}
	
	
	
	
	
	
}