package com.mxl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mxl.bean.Product;
import com.mxl.service.ProductService;
import com.mxl.service.impl.ProductServiceImpl;
@WebServlet("/Product")
public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String method =req.getParameter("method");
			switch (method) {
			case "chazhao":
				chazhao(req,resp);
				break;

			default:
				break;
			}
	
	
	
	
	
	}

	private void chazhao(HttpServletRequest req, HttpServletResponse resp) {
		
		ProductService service = new ProductServiceImpl();
		
		List<Product> list=service.findAll();
		System.out.println(list.toString());
		if(list.size()!=0){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		System.out.println("======>"+json);
		
		
		
		
		
		PrintWriter writer;
		
		
		
		
		try {
			writer = resp.getWriter();
			writer.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
		
		
		
		
	}
	
	
	
	
}
