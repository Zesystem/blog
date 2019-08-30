package com.blog.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * @description 该类是数据库连接类，用于创建数据库的连接。
 * @author Zesystem
 * @date 2019-8-15
 */
public class DbConnection {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static Connection conn = null;
	
	static{
		Properties prop = new Properties();
		InputStream in = DbConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(in);
			driver = prop.getProperty("driveClass");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			if(conn != null&&!conn.isClosed())
				return conn;
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
