package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class JdbcUtil {

	protected static Connection connection = null; // 便于我们释放资源
	protected static PreparedStatement statement = null;
	protected static ResultSet rs = null; // 查询数据返回的结果集

	public static boolean getConnection() throws ClassNotFoundException, SQLException {
		try {
			
			//通过反射机制获取数据库驱动包
			Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));
			//通过DriverManager获取Conncetion连接对象
			connection=DriverManager.getConnection(ConfigManager.getInstance().getValue("jdbc.url"),
					ConfigManager.getInstance().getValue("jdbc.userName"),
					ConfigManager.getInstance().getValue("jdbc.passWord"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void closeConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int myExcuteUpdate(String sql, Object... param) throws ClassNotFoundException, SQLException {
		int rowNum = 0;
		if (getConnection()) {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				statement.setObject(i + 1, param[i]);
			}
			rowNum = statement.executeUpdate();

		}
		closeConnection();
		return rowNum;
	}

	public static ResultSet myExcuteQuery(String sql, Object... param) throws ClassNotFoundException, SQLException {
		if (getConnection()) {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				statement.setObject(i + 1, param[i]);
			}
			rs = statement.executeQuery();
		}
		return rs;
	}

}