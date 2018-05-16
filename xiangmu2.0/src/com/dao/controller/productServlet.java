package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.bean.Cart;
import com.dao.bean.CartItem;
import com.dao.bean.Easybuy_product;
import com.dao.bean.News;
import com.dao.bean.Shopping_cart;
import com.dao.bean.User;
import com.dao.dao.Shopping_cartDao;
import com.dao.dao.impl.Shopping_cartDaoImpl;
import com.dao.service.Easybuy_productService;
import com.dao.service.Shopping_cartService;
import com.dao.service.impl.Easybuy_productServiceImpl;
import com.dao.service.impl.NewsServiceImpl;
import com.dao.service.impl.Shopping_cartServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	//log4j
		public static Logger logger=Logger.getLogger(NewsServiceImpl.class);
	//实例化
	private Easybuy_productService ps = new Easybuy_productServiceImpl();
	
	private Shopping_cartDao shopping_cartDao = new Shopping_cartDaoImpl();
	private Shopping_cartService shopping_cartService = new Shopping_cartServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			String method = request.getParameter("method");
			System.out.println("method:"+method);
			if (method==null) {
				List<Easybuy_product>products = ps.fundAll();
				request.setAttribute("products", products);
				request.getRequestDispatcher("Product.jsp").forward(request, response);
			}else {
			
			switch (method) {
			case "fundAll"://查所有
				fundAll(request,response);
				break;
			case "findById"://查指定
				findById(request,response);
				break;
			case "add"://添加购物车				
				addCart(request,response);
				break;
			case "findCart"://查询购物车所有商品			
				findCart(request,response);
				break;
			case "del"://查询购物车所有商品			
				del(request,response);
				break;
			}
			}
	}
	
	/**
	 * 删除商品
	 */
	private void del(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(1111);
		String id = request.getParameter("id");
		System.out.println(1111);
		//购物车
		Cart cart = (Cart) request.getSession().getAttribute(id);
		System.out.println(1111);
		ps.delete(id, cart);
		//转发到购物车页面
		System.out.println("+++++++++++"+id);
		try {
			
			request.getRequestDispatcher("BuyCar.jsp").forward(request, response);
			
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询购物车所有商品
	 */
	private void findCart(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
	
/*			System.out.println("进入查询购物车所有商品方法页面");
			request.getRequestDispatcher("BuyCar.jsp").forward(request, response);
			*/
		
		User user = (User) request.getSession().getAttribute("user");
		Cart shopping_cart=null;
		String json = null;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("shopping_cart")) {
					json = cookie.getValue();
					System.out.println("tttttttt"+json);
				}
			}
		}

		System.out.println(json);
		// 获取输出流对象
		PrintWriter writer = null;
		try {
			
			writer = response.getWriter();
			writer.print(json); // 返回数据给前台
			
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		
	}

	/**
	 * 把商品加入购物车
	 */
	private void addCart(HttpServletRequest request, HttpServletResponse response) {
//		商品id
//		User user = (User) request.getSession().getAttribute("uid");
		
		
		String uid = request.getParameter("uid");
		String id = request.getParameter("id");
		
		Cart cart = null;
		Shopping_cart shopping_cart=null;
		Gson gson=new Gson();
		Cookie[] cookies = request.getCookies();
		

		
		if (cookies != null) {
			for (Cookie cookie : cookies) {	
				if (cookie.getName().equals("shopping_cart")) {
					shopping_cart = gson.fromJson(cookie.getValue(), Shopping_cart.class);
				}
			}
		}
		if (null == cart) {
			System.out.println("第一次购物");
			System.out.println(id);
			shopping_cart = new Shopping_cart(uid, id, 0);
		}
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print("true");

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (uid==null) {
			String json = gson.toJson(shopping_cart);
			System.out.println(json);
			Cookie cookie = new Cookie("shopping_cart", json);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			
			
		}else {
			
			huiyuan(uid,id,0,shopping_cart,response);
			
		}

		
		
	}
	private void huiyuan(String uid, String id, int i, Shopping_cart shopping_cart, HttpServletResponse response) {
		System.out.println("dddd");
		System.out.println(uid);
		System.out.println(id);
		
		
	}


	/**
	 * 
	 * @param uid
	 * @param id
	 * @param i
	 */


	/**
	 * 查询指定商品
	 */
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		
		String id =request.getParameter("id");
		//根据id查询
		Easybuy_product product=ps.findById(id);
		//保存在request作用域
		request.setAttribute("product", product);
		try {
			//跳转到查询指定
			logger.debug("进入了查询id方法");
			request.getRequestDispatcher("Product.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 所有商品
	 */
	private void fundAll(HttpServletRequest request, HttpServletResponse response) {
		//把对象传入List集合
		List<Easybuy_product> fundAll = ps.fundAll();
		//实例化Gson
		Gson gs = new Gson();
		
		String json = gs.toJson(fundAll);
		System.out.println(json);
		PrintWriter Writer;
		try {
			Writer = response.getWriter();
			Writer.print(json);
			Writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}


}
