package cn.mxl.jdbc;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuStudent extends jdbcUtil{
	//所有方法都能时候用输入流对象
	public static Scanner input = new Scanner(System.in);
	//主函数方法main
	public static void main(String[] args) {
		//直接进入一级菜单
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
	try {
		System.out.println("请输入用户名");
		String name = input.next();
		System.out.println("请输入密码");
		String pwd = input.next();


		//sql语句
		String sql="SELECT * FROM student WHERE name=? AND password=?";
		Object[] params = {name,pwd};
		rs=myExcuteQuery(sql,params);
		
		if (rs.next()) {//证明有数据
			System.out.println("登录成功");
			two();//二级菜单
		}else {
			System.out.println("请重新登录");
			denglu();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {//释放资源
		closeConnection();
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
		suoyou();
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
 * 查询所有
 */
private static void suoyou() {
	try {
		//创建sql语句
		String sql ="SELECT * FROM student ";
		rs=myExcuteQuery(sql);
		
		System.out.println("ID\t用户名\t密码\t爱好");
		
		//循环获取每一个student对象
		while (rs.next()) {
			System.out.print(rs.getString("NO")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.print(rs.getString("password")+"\t");
			System.out.println(rs.getString("aihao"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		closeConnection();
	}
}
/**
 * 删除用户
 */
private static void Saihao() {
	System.out.println("请输入你要删除的用户");
	String name = input.next();
	try {
		
		String sql ="DELETE  FROM student WHERE `name`=?";
		Object []param= {name};
		int row = myExcuteUpdate(sql,param);
		if (row>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		two();//返回二级菜单
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
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
		//创建sql语句
		String sql = "UPDATE student SET `password`=? WHERE `password`=?";
		Object []param = {pwd,pwd2};
		int row =myExcuteUpdate(sql,param);
		if (row>0) {
			System.out.println("新密码更改成功");
		}else {
			System.out.println("新密码更改失败");
		}
		two();//返回二级菜单
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
/**
 * 注册
 */
	private static void zhuce() {
		System.out.println("请输入ID");
		String ID = input.next();
		System.out.println("请输入用户名");
		String name = input.next();
		System.out.println("请输入密码");
		String pwd = input.next();
		
		try {//加载驱动
			getConnection();
			//需要的sql语句
			String sql="INSERT INTO student(`NO`,`name`,`password`)VALUES (?,?,?);";
			Object [] param = {ID,name,pwd};
			int row = myExcuteUpdate(sql,param);
			
		if (row>0) {
			System.out.println("注册成功");
			one();
		}else {
			System.out.println("注册失败");
			zhuce();//再次注册
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
	}

}
