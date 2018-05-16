package com.mxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxl.User.User;

@WebServlet("/aa")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//获取用户输入的用户名和密码
				String userName = req.getParameter("userName");
				String password = req.getParameter("password");
		//放入session
				
				req.getSession().setAttribute("user",new User(userName,password) );

		//重定向页面显示 用户名 和密码
				System.out.println("=============");
				resp.sendRedirect("lala.jsp");
				
	
		
		
		
		
	}
	
}
