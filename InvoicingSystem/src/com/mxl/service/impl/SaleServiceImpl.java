package com.mxl.service.impl;

import java.io.Serializable;
import java.util.List;

import com.mxl.bean.Product;
import com.mxl.bean.Sale;
import com.mxl.dao.SaleDao;
import com.mxl.service.SaleService;
import com.mxl.util.PageInfo;
import com.mxl.dao.impl.SaleDaoImpl;
import java.util.Date;
public class SaleServiceImpl implements SaleService {

	SaleDao dao=new SaleDaoImpl();

	@Override
	public boolean addNews(Sale Sale) {
		int add = dao.add(Sale);
		if (add > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Sale> findAlls(int pageNum, int pageSize) {
		PageInfo<Sale> pageInfo = new PageInfo<>();
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
	public List<Sale> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Sale findNewsById(Serializable id) {
		// TODO Auto-generated method stub
		return dao.findbyid(id);
	}

	@Override
	public boolean updateNews(Sale sale) {
		if (dao.update(sale) > 0) {
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

	
	


}