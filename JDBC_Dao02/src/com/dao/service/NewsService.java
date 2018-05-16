package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;

public interface NewsService {
	
	/**
	 * 新增
	 */
	void add(News t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(News t);
	/**
	 * 查询所有 
	 */
	List<News> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	News findById(Serializable id);
	
}
