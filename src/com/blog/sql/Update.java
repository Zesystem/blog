package com.blog.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blog.db.DbConnection;

/**
 * @description 该类是用于执行所有修改操作
 * @author Zesystem
 * @date 2019-8-15
 */
public class Update {
	/**
	 * 更新博客信息
	 * @param title 标题
	 * @param desc 简介
	 * @param content 文章内容
	 * @param mid 文章的id
	 */
	public static void updateMessage(String title,String desc,String content,String mid){
		Connection conn = DbConnection.getConnection();
		String sql = "update t_message set title=?,content=?,descrip=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, desc);
			ps.setString(4, mid);
			ps.executeUpdate();
			//if(result > 0)
				//System.out.println("更新成功！！！");
			//else
				//System.out.println("更新失败！！！");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * 更新用户资料
	 * @param id 用户id
	 * @param password 密码
	 * @param phone	手机号
	 * @param email 邮箱
	 * @param signature	个性签名
	 * @param name 博主名字
	 * @param github 账户
	 */
	public static void updateUser(String id,String password,String phone,
			String email,String signature,String name,String github){
		Connection conn = DbConnection.getConnection();
		String sql = "update t_user set password=?,phone=?,email=?,signature=?,name=?,github=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, signature);
			ps.setString(5, name);
			ps.setString(6, github);
			ps.setString(7, id);
			ps.executeUpdate();
			//if(result > 0)
				//System.out.println("更新成功！！！");
			//else
				//System.out.println("更新失败！！！");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * 更新分类信息
	 * @param clazz 这个是要更新的类
	 */
	public static void updateFen(String fen,String fid){
		Connection conn = DbConnection.getConnection();
		String sql = "update t_totalclass set clazz=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fen);
			ps.setString(2, fid);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void updateLogo(String logoSrc,int id){
		Connection conn = DbConnection.getConnection();
		String sql = "update t_user set logoSrc=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, logoSrc);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
