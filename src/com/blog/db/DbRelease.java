package com.blog.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @description 该类是数据库释放资源类。用于释放资源。
 * @author Zesystem
 * @date 2019-8-15
 */
public class DbRelease {
	public static void release(Connection conn,ResultSet rs,PreparedStatement ps) {
		closeRs(rs);
		closeConn(conn);
		closePs(ps);
	}
	public static void closeRs(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
	}
	public static void closeConn(Connection conn) {
		try {
			if( conn != null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
	}
	public static void closePs(PreparedStatement ps) {
		try {
			if(ps != null)
				ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ps = null;
		}
	}
}
