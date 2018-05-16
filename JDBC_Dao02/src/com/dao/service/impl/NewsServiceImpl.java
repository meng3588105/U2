package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;
import com.dao.dao.NewsDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.NewsDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.NewsService;
	/**
	 * 新闻  逻辑层增删改查接口
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日上午11:27:07
	 */
public class NewsServiceImpl implements NewsService {
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	NewsDao Newsdao = new NewsDaoImpl();
	
	
	/**
	 * 新增
	 */
	@Override
	public void add(News t) {
		int rowNum=Newsdao.add(t);
		
		if (rowNum>0) {
			System.out.println("新增成功");
		}else {
			System.out.println("新增失败");
		}
		
		
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(Serializable id) {
		int rowNum =Newsdao.delete(id);
		
		if (rowNum>0) {
			System.out.println("删除成功");
		}else {
			System.err.println("删除失败");
		}
		
		
	}
	/**
	 * 修改
	 */
	@Override
	public void update(News t) {
		
		int rowNum =Newsdao.update(t);
		if (rowNum>0) {
			System.err.println("修改成功");
		}else {
			System.out.println("修改失败");
		}

	}
	/**
	 * 查询所有新闻
	 */
	@Override
	public List<News> fundAll() {
		
		return Newsdao.fundAll();
	}
	/**
	 * 查询指定
	 */
	@Override
	public News findById(Serializable id) {
		
		return Newsdao.findById(id);
	}

}
