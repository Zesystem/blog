package com.blog.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blog.db.DbConnection;
import com.blog.db.DbRelease;

/**
 * @description 该类是用于执行所有删除操作
 * @author Zesystem
 * @date 2019-8-15
 */
public class Delete {
	/**
	 * 用于删除一条博客信息
	 * @param mid 信息的id
	 */
	public static void deleteMessage(String mid){
		//首先删除中间表的内容
		deleteMiddle(mid);
		Connection conn = DbConnection.getConnection();
		String sql = "delete from t_message where id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			int result = ps.executeUpdate();
			showDeleteInfo(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
	}
	/**
	 * 用于删除中间表
	 * @param mid 根据信息的id查询删除
	 */
	public static void deleteMiddle(String mid) {
		Connection conn = DbConnection.getConnection();
		String sql = "delete from t_middle where mid = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			int result = ps.executeUpdate();
			showDeleteInfo(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
	}
	/**
	 * 用于删除中间表
	 * @param mid 根据信息的id查询删除
	 */
	public static void deleteMiddleByMidAndCid(String mid,String cid) {
		Connection conn = DbConnection.getConnection();
		String sql = "delete from t_middle where mid=? and cid=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, cid);
			int result = ps.executeUpdate();
			showDeleteInfo(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
	}
	/**
	 * 用于删除中间表
	 * @param mid 根据分栏的id查询删除
	 */
	public static void deleteMiddleByCid(String cid) {
		Connection conn = DbConnection.getConnection();
		String sql = "delete from t_middle where cid = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			int result = ps.executeUpdate();
			showDeleteInfo(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
	}
	/**
	 * 在没有属于该分类的博客时，就删除。
	 * @param cid
	 */
	public static void deleteFen(int cid,int uid) {
		Connection conn = DbConnection.getConnection();
		String sql = "delete from t_totalclass where id = ? and uid=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, uid);
			int result = ps.executeUpdate();
			showDeleteInfo(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
	}
	public static void showDeleteInfo(int result) {
		if(result > 0)
			System.out.println("Delete:deleteFen:删除成功！！！");
		else
			System.out.println("Delete:deleteFen:删除失败！！！");
	}
}
