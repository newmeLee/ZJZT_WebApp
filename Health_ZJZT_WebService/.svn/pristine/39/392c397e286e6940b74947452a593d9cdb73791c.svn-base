package com.zjzt.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 数据库连接类
 * 
 * @author 黎玉敏
 * 
 */
public class DBHelper {
	// public static final String url = "jdbc:mysql://localhost:3306/student";
	// public static final String name = "com.mysql.jdbc.Driver";
	// public static final String user = "root";
	// public static final String password = "1234567";
	public static final String url = "jdbc:mysql://106.14.30.183:3306/zjzt_health?"
			+ "user=root&password=zjzt@200603&useUnicode=true&characterEncoding=UTF8";
	public static final String name = "com.mysql.jdbc.Driver";
	public Connection conn = null;
	public PreparedStatement pst = null;

	/**
	 * 获取MySQL数据库的连接
	 * @param sql
	 */
	public DBHelper(String sql) {
		try {
			Class.forName(name);// 指定连接类型
			conn = (Connection) DriverManager.getConnection(url);// 获取连接
			pst = (PreparedStatement) conn.prepareStatement(sql);// 准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭相关连接
	 */
	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
