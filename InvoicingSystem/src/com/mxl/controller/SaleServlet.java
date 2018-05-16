package com.mxl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxl.bean.Sale;
import com.mxl.service.SaleService;
import com.mxl.service.impl.SaleServiceImpl;
@WebServlet("/sale")
public class SaleServlet extends HttpServlet{
	private SaleService service = new SaleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		switch (method) {
		case "getAllNews":
			findAllNews(req, resp); // 查询所有的方法
			break;

		default:
			break;
		}
		
		
		
	}

	private void findAllNews(HttpServletRequest req, HttpServletResponse resp) {
		List<Sale> findAll = service.findAll();
		
		//把集合保存在request作用域
				req.setAttribute("findAll", findAll);
				System.out.println("的顶顶顶顶顶"+findAll);
				
				//转发到主页面
				try {
					req.getRequestDispatcher("xiaoshouxinxi.jsp").forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
	}
	
	
	
	
	
	
}
