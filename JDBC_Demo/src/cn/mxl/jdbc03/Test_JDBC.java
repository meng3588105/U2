package cn.mxl.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * JDBC   查
 * 
 *JDBC 查看表中指定列数据
 * @author .
 *
 */
public class Test_JDBC {

	public static void main(String[] args) {
		Connection conn = null;

		String sql; 
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
			//		    MySQL的JDBC ： jdbc:mysql://主机名称：连接端口/数据库的名称,账号,密码
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","meng","3588105");
			System.out.println("建立连接成功");


			//			Statement是用来向数据库发送要执行的SQL语句的！Statement 
			//			Statement stmt =null;也可以定义全局变量 
			Statement stmt = conn.createStatement();

			//			查询所有表中数据 需要定义一个ResultSet (查看数据)
			//			ResultSet rt = null;也可以定义全局变量 
			ResultSet rt =stmt.executeQuery("select * from student");

			//一次查询一条，可以用循环查询。
			while(rt.next()){
				System.out.println(rt.getString("NO")+"\t"+rt.getString("name"));
				//System.out.println(rt.getString(1)+"\t"+rt.getString(2));
			}

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
