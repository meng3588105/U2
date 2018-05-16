package com.xdf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateServlet")
public class ValidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//乱码问题
		req.setCharacterEncoding("utf-8");
		//获取前台form输入的用户名
		String name = req.getParameter("userName");
		//定义个标记  默认false
		boolean flag = false;
		//判断是否存在
		if ("admin".equals(name)) {
			flag = true; // 证明数据库中存在
		}
		//传送到前端form
		PrintWriter writer = resp.getWriter();
		//输出
		writer.print(flag);
		//关闭流
		writer.close();

	}

}
