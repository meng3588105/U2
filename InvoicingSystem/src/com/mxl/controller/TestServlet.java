package com.mxl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mxl.bean.Sale;
import com.mxl.service.SaleService;
import com.mxl.service.impl.SaleServiceImpl;
import com.mxl.util.PageInfo;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SaleService service = new SaleServiceImpl();
		PageInfo<Sale> news = service.findAlls(
		Integer.parseInt(req.getParameter("pageNum")), 3);
		news.setTotal(service.getTotalCount());
		System.out.println("pageNum=====>" + req.getParameter("pageNum"));
		news.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		System.out.println("总记录数===》" + news.getTotal());
		Gson gson = new Gson();
		String json = gson.toJson(news);
		System.out.println(json);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
	}

}
