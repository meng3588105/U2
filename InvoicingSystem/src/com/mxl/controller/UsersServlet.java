package com.mxl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mxl.bean.Users;
import com.mxl.service.UsersService;
import com.mxl.service.impl.UsersServiceImpl;
import com.mxl.bean.Users;
import com.mxl.service.UsersService;
import com.mxl.service.impl.UsersServiceImpl;

@WebServlet("/Login")
public class UsersServlet extends HttpServlet{
	//log4j
			public static Logger logger=Logger.getLogger(UsersServiceImpl.class);
			private UsersService service = new UsersServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method =req.getParameter("method");
		switch (method) {
		case "Login":
			Login(req,resp);
			break;

		default:
			break;
		}
		
		
	}

	private void Login(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
		//获取前台用户登录输入
		System.out.println("进来了吗？12222");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		Cookie c1 = new Cookie("userName", URLEncoder.encode(userName, "utf-8"));
		Cookie c2 = new Cookie("password", password);

		// 设置cookie时效
		c1.setMaxAge(10); // 60*60 是1小时
		c2.setMaxAge(10);
		resp.addCookie(c1);
		resp.addCookie(c2);

		// 调用servlrt层代码
		UsersService userservice = new UsersServiceImpl();
		Users users = userservice.login(userName, password);

		if (users != null) {
			System.out.println("进来了吗？111");
			req.getSession().setAttribute("users", users);
			resp.sendRedirect("main.jsp");

		} else {
			resp.sendRedirect("Login.jsp");
		}
		
		
		
		
	}
	
}
