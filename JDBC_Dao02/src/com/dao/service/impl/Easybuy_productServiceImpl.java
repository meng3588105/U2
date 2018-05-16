package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_product;
import com.dao.dao.Easybuy_productDao;

import com.dao.dao.impl.Easybuy_productDaoImpl;
import com.dao.service.Easybuy_productService;


	/**
	 * 商品的逻辑层   service
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日下午3:05:06
	 */
public class Easybuy_productServiceImpl implements Easybuy_productService {
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	Easybuy_productDao easybuy_productdao = new Easybuy_productDaoImpl();
	
	
	
	/**
	 * 新增
	 */
	@Override
	public void add(Easybuy_product t) {
		int rowNum=easybuy_productdao.add(t);
		
		if (rowNum>0) {
			System.out.println("新增成功");
		}else {
			System.out.println("新增失败");
		}
	}
	/**
	 *	删除
	 */
	@Override
	public void delete(Serializable id) {
		int rowNum=easybuy_productdao.delete(id);
		if (rowNum>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	/**
	 * 修改
	 */
	@Override
	public void update(Easybuy_product t) {
		int rowNum =easybuy_productdao.update(t);
		if (rowNum>0) {
			System.err.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<Easybuy_product> fundAll() {
		
		return easybuy_productdao.fundAll();
	}
	/**
	 * 查询指定
	 */
	@Override
	public Easybuy_product findById(Serializable id) {
		
		return easybuy_productdao.findById(id);
	}

}
