package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User;
import com.dao.dao.UserDao;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.UserService;

/**
 * service 逻辑层 
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日上午10:45:37
 */

public class UserServiceImpl implements UserService {
	
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	UserDao userdao = new UserDaoImpl();
	
	
	/**
	 * 登录
	 */
	@Override
	public User login(String loginName, String password) {
		User login = userdao.login(loginName, password);
		if (login ==null) {
			
			System.out.println("登录失败");
			return null;
		}else {
			System.out.println("登录成功");
			return login;
		}
	
	}
	/**
	 * 新增
	 */
	@Override
	public void add(User t) {
		
		int rowNum=userdao.add(t);
		
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
		int rowNum=userdao.delete(id);
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
	public void update(User t) {
		
		int rowNum =userdao.update(t);
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
	public List<User> fundAll() {
		
		return userdao.fundAll();
	}
	/**
	 * 查询指定id
	 */
	@Override
	public User findById(Serializable id) {
		
		return userdao.findById(id);
	}

}
