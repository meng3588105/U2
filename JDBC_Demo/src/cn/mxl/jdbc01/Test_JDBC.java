package cn.mxl.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 1.JDBC连接数据库
 * 2.创建表和向表插入数据
 * 
 * 
 * @author 
 *
 */

public class Test_JDBC {
	// 出现异常用LOG4J记录异常信息
	// private static Logger logger =Logger.getLogger(Test_JDBC.class.getName());
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
	
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
			//在这里写操作数据库的SQL代码
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等  
            stmt = conn.createStatement();
            //定义表结构
            String sql = "create table student(NO char(20),name varchar(20),primary key(NO))";  
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功  
            if (result != -1) {  
                System.out.println("创建数据表成功");
                //sql语句插入数据
                sql = "insert into student(NO,name) values('2012001','陶伟基')";  
                result = stmt.executeUpdate(sql);  
                //sql语句插入数据
                sql = "insert into student(NO,name) values('2012002','周小俊')";  
                result = stmt.executeUpdate(sql); 
                //sql语句插入数据
                sql = "insert into student(NO,name) values('2012003','急急急')";  
                result = stmt.executeUpdate(sql);
                
                //查看表中所有信息 ResultSet
                sql = "select * from student";  
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值  
                System.out.println("学号\t姓名");  
                while (rs.next()) {  
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()  
                }  
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}












