package cn.jdbc.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_JDBC {

	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt =null;
		ResultSet rt = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//建立连接
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceshi", "meng", "3588105");
			stmt = conn.createStatement();
			rt = stmt.executeQuery("SELECT * FROM `v_shitu`");
			System.out.println("学号\t姓名\t教师编号\t教师姓名\t课程编号\t课程名称\t成绩");
			while (rt.next()) {
				System.out.println(rt.getString(1)+"\t"+rt.getString(2)+"\t"+rt.getString(3)
				+"\t"+rt.getString(4)+"\t"+rt.getString(5)+"\t"+rt.getString(6)+"\t"+rt.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
