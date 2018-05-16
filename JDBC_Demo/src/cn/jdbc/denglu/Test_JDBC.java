package cn.jdbc.denglu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test_JDBC {
	/**
	 * jdbc通过数据库进行账号密码验证。
	 * @param args
	 */

	public static void main(String[] args) {
		Connection conn =null;
		//Statement stmt =null;
		PreparedStatement stmt = null;
		ResultSet rt = null;
		
		Scanner input = new Scanner(System.in);
		System.out.println("\t宠物主人登录");
		System.out.println("请输入姓名：");
		String name=input.next();
		System.out.println("请输入密码：");
		String password =input.next();
	
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//建立连接
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
			//用？占位符 代表
			String sql ="select * from student where name=?and password=?"; 
			
			stmt = conn.prepareStatement(sql);
			//两个参数，1是第一个？是第二个？ 第二个参数 是 输入的值
			stmt.setObject(1, name);
			stmt.setObject(2, password);
			rt=stmt.executeQuery();
			if (rt.next()) {
				System.out.println("登录成功!!!");
			}else {
				System.out.println("登录失败，重新输入。");
			}
		
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
	
		
		//关闭连接
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rt!=null) {
			try {
				rt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	}

}
