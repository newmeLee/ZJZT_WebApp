package com.zjzt.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * ���ݿ�������
 * 
 * @author ������
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
	 * ��ȡMySQL���ݿ������
	 * @param sql
	 */
	public DBHelper(String sql) {
		try {
			Class.forName(name);// ָ����������
			conn = (Connection) DriverManager.getConnection(url);// ��ȡ����
			pst = (PreparedStatement) conn.prepareStatement(sql);// ׼��ִ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ر��������
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
