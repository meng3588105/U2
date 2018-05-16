package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User;

/**
 * 用户     逻辑层增删改查接口
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日上午11:25:26
 */
public interface UserService {
	/**
	 *   用户类独有的  登录功能
	 */
	User login(String loginName,String password);
	
		/**
		 * 新增
		 */
		void add(User t);
		/**
		 * 删除
		 */
		void delete(Serializable id);
		/**
		 * 修改
		 */
		void update(User t);
		/**
		 * 查询所有 
		 */
		List<User> fundAll();
		
		/**
		 * 根据ID查询指定的信息
		 */
		User findById(Serializable id);
		
}
