package cn.mxl.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * 	JDBC   增
 * 
 *	JDBC 增加表中的数据    用SQL语句
 *	
 * 	@author 
 *
 */
public class Test_JDBC {

	public static void main(String[] args) {
		Connection conn =null;
		// 加载驱动
		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，  
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 建立连接
		try {
			//// MySQL的JDBC ： jdbc:mysql://主机名称：连接端口/数据库的名称,账号,密码
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","meng","3588105");
			System.out.println("建立连接成功");
			
//			Statement是用来向数据库发送要执行的SQL语句的！
//			Statement stmt =null;也可以定义全局变量 
			Statement stmt = conn.createStatement();
			
			//增加数据
			String sql ="insert into student(NO,name) values('2002','郭嘉')";
			int ret =stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Mysql操作错误");
			e.printStackTrace();
		}finally {
			// 关闭连接
			if (conn!=null) {
				try {
					conn.close();
					System.out.println("关闭连接成功");
				} catch (SQLException e) {
					System.out.println("关闭连接出现错误");
					e.printStackTrace();
				}
			}
		}
	}

}
