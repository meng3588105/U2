package cn.mxl.jdbc;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	public static Scanner input = new Scanner(System.in);
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
/**
 * 主方法函数
 * @param args
 */
	public static void main(String[] args) {
		one();
	}
/**
 * 一级菜单
 */
	private static void one() {

		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.退出");
	    int num = input.nextInt();
		switch (num) {
		case 1://注册
			zhuce();
			break;
		case 2://登录
			denglu();
			break;
		case 3://退出
			
			break;
		default:
			System.out.println("输入错误重新输入");
			one();
			break;
		}
		
	}
/**
 * 登录
 */
private static void denglu() {

	System.out.println("请输入用户名");
	String name = input.next();
	System.out.println("请输入密码");
	String pwd = input.next();

	try {//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
		String sql="SELECT * FROM student WHERE name=? AND password=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		rs=ps.executeQuery();
		
		if (rs.next()) {
			System.out.println("登录成功");
			two();
		}else {
			System.out.println("请重新登录");
			denglu();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		yichang();
	}
}
/**
 * 异常处理
 */
private static void yichang() {
	if (ps!=null) {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	if (rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/**
 * 二级菜单
 */
private static void two() {
	System.out.println("请选择序号输入");
	System.out.println("1.查询所有爱好");
	System.out.println("2.修改密码");
	System.out.println("3.删除用户");
	int num = input.nextInt();
	switch (num) {
	case 1:
		//查询所有爱好
		Caihao();
		break;
	case 2:
		//修改密码
		Xaihao();
		break;
	case 3:
		//删除用户
		Saihao();
		break;
	default:
		System.out.println("输入错误重新输入");
		two();
		break;
	}
}
/**
 * 查询所有爱好
 */
private static void Caihao() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
		
		String sql ="SELECT * FROM student ";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		System.out.println("所有人的爱好");
		while (rs.next()) {
			System.out.println(rs.getString("aihao"));
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		yichang();
		two();//返回二级菜单
	}
}
/**
 * 删除用户
 */
private static void Saihao() {
	System.out.println("请输入你要删除的用户");
	String name = input.next();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
		String sql ="DELETE  FROM student WHERE `name`=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		int delete = ps.executeUpdate();
		if (delete>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//关闭资源
		yichang();
	}
	
}
/**
 * 修改密码
 */
private static void Xaihao() {
	System.out.println("请输入账号");
	String name=input.next();
	System.out.println("请输入原密码");
	String pwd = input.next();
	System.out.println("请输入新密码");
	String pwd2 = input.next();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
		String sql = "UPDATE student SET `password`=? WHERE `password`=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, pwd2);
		ps.setString(2, pwd);
		int xinmima=ps.executeUpdate();
		if (xinmima>0) {
			System.out.println("新密码更改成功");
		}else {
			System.out.println("新密码更改失败");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//关闭资源
		yichang();
		two();//返回二级菜单
	}
}
/**
 * 注册
 */
	private static void zhuce() {
		int UPdate=0;
		System.out.println("请输入ID");
		String ID = input.next();
		System.out.println("请输入用户名");
		String name = input.next();
		System.out.println("请输入密码");
		String pwd = input.next();
		
		try {//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "meng", "3588105");
			//需要的sql语句
			String sql="INSERT INTO student(`NO`,`name`,`password`)VALUES ('"+ID+"','"+name+"','"+pwd+"');";
			ps=conn.prepareStatement(sql);
			UPdate=ps.executeUpdate();
		if (UPdate>0) {
			System.out.println("注册成功");
			one();
		}else {
			System.out.println("注册失败");
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			yichang();

		}
		
			
	}

}
