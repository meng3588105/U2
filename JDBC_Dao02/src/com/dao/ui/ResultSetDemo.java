package com.dao.ui;

import java.util.List;
import java.util.Scanner;

import com.dao.bean.Easybuy_order_detail;
import com.dao.bean.User;
import com.dao.dao.Easybuy_order_detailDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.Easybuy_order_detailDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.UserService;
import com.dao.service.impl.UserServiceImpl;

public class ResultSetDemo {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		showtam();

		/*
		 * Easybuy_order_detailDao a =new Easybuy_order_detailDaoImpl();
		 * 
		 * List<Easybuy_order_detail> all =a.fundAll(); for (Easybuy_order_detail
		 * easybuy_order_detail : all) {
		 * 
		 * System.out.println(easybuy_order_detail); }
		 */

		// UserDao userDaoImpl =new UserDaoImpl();

		/*
		 * 用户用指定id查询 User user =userDaoImpl.findById(1); System.out.println(user);
		 */

		/*
		 * 用户查询所有 List<User> all = userDaoImpl.fundAll(); for (User user : all) {
		 * System.out.println(user); }
		 */

	}

	/**
	 * 一级菜单
	 */
	private static void showtam() {
		System.out.println("欢迎进入操作系统");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		System.out.println("1.用户管理");
		int nextInt = input.nextInt();
		switch (nextInt) {
		case 1:
			user();
			break;

		}

	}

	/**
	 * 用户管理菜单
	 */
	private static void user() {
		// 实例化UserService层对象
		UserService userservice = new UserServiceImpl();
		System.out.println("欢迎进入用户管理系统");
		System.out.println("1:登录");
		System.out.println("2:注册");
		System.out.println("3:删除");
		System.out.println("4:修改");
		System.out.println("5:查询所有");
		System.out.println("6:查询指定用户信息");
		System.out.println("7:返回上级目录");
		System.out.println("请您选择：");
		int nextInt = input.nextInt();
		switch (nextInt) {
		case 1:
			// 登录
			usergo(userservice);
			break;
		case 2:
			// 注册
			register(userservice);
			break;
		case 3:
			// 删除
			delete(userservice);
			break;
		case 4:
			// 修改
			update(userservice);
			break;
		case 5:
			// 查询所有
			suoyou(userservice);
			
			break;
		case 6:
			// 查询指定用户信息
			zhiding(userservice);
			break;
		case 7:
			// 返回上级目录
			user();
			break;

		default:
			break;
		}

	}
	/**
	 * 查询指定
	 * @param userservice
	 */
	private static void zhiding(UserService userservice) {
		
		UserDao userDaoImpl =new UserDaoImpl();
		
		System.out.println("请输入要查询的id");
		int id = input.nextInt();
		
		
		
		//用户用指定id查询 
		User user =userDaoImpl.findById(id);
		System.out.println(user);
	}

	/**
	 * 查询所有
	 * @param userservice
	 */
	private static void suoyou(UserService userservice) {
		
		UserDao userDaoImpl =new UserDaoImpl();
				//用户查询所有 
				List<User> all = userDaoImpl.fundAll();
					for (User user : all) {
					  System.out.println(user);
					  }
	}

	/**
	 * 用户修改
	 */
	private static void update(UserService userservice) {
		
		User user =new User();
		
		System.out.println("请输入要修改的登录名loginName");
		String loginName = input.next();
		System.out.println("请输入要修改的密码password");
		String password = input.next();
		
		System.out.println("请修改用户的 id");
		int id = input.nextInt();
		
		user.setLoginName(loginName);
		user.setPassword(password);
		
		user.setId(id);
		//增加参数
			userservice.update(user);
		
		
		
	}

	/**
	 * 用户删除
	 */
	private static void delete( UserService userservice) {
		System.out.println("请输入要删除的用户id");
		int id = input.nextInt();
		
		
		User user =new User();
		
		
		
		//增加参数
		userservice.delete(id);
		
	}

	/**
	 * 用户注册
	 */
	private static void register(UserService userservice) {
		User user =new User();
		System.out.println("注册登录名");
		String loginName = input.next();
		System.out.println("注册用户名");
		String userName = input.next();
		System.out.println("注册密码");
		String password = input.next();
		System.out.println("注册性别(1:男 0：女)");
		int sex = input.nextInt();
		System.out.println("注册身份证号");
		String identityCode = input.next();
		System.out.println("注册邮箱");
		String email = input.next();
		System.out.println("注册手机");
		String mobile = input.next();
		System.out.println("注册类型（1：后台 0:前台）");
		int type = input.nextInt();
	
		// 传入参数  set 
		user.setLoginName(loginName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setSex(sex);
		user.setIdentityCode(identityCode);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setType(type);
		
		
		//增加参数
		userservice.add(user);
	
	
	
	
	}

	/**
	 * 用户登录
	 */
	//传入参数 UserService yserservice
	private static void usergo(UserService userservice) {
		System.out.println("输入用户名");
		String loginName = input.next();
		System.out.println("输入密码");
		String password = input.next();
		
		User login = userservice.login(loginName, password);
		
		System.out.println(login.getId());
		System.out.println(login.getLoginName());
		System.out.println(login.getEmail());
		System.out.println(login.getMobile());
		System.out.println(login.getType());
		
		
		
		
	}

}
