package com.blog.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blog.db.DbConnection;
import com.blog.db.DbRelease;

/**
 * @description 该类是用于执行所有添加操作
 * @author Zesystem
 * @date 2019-8-15
 */
public class Insert{
	
	/**
	 * 用户用户注册
	 * @param username  用户名 
	 * @param password	密码
	 * @param phone		手机号
	 * @param email		邮箱
	 * @param signature 个性签名
	 * @return 
	 */
	public static int insertRegister(String username,String password,String phone,String email,String signature){
		Connection conn = DbConnection.getConnection();
		System.out.println(username+" "+password+" "+phone+" "+email+" "+signature);
		String sql = "insert into t_user values(null,?,?,?,?,?,\"\",\"\",\"\")";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,phone);
			ps.setString(4,email);
			ps.setString(5,signature);
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.closeConn(conn);
			DbRelease.closePs(ps);
		}
		return result;
	}
	
	/**
	 * 插入博客的信息。
	 */
	public static int insertMessage(String title,String desc,String content,int uid,Date time){
		Connection conn = DbConnection.getConnection();
		String sql = "insert into t_message values(null,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try{
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, desc);
			ps.setInt(4, uid);
			ps.setDate(5,time);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
	            id = rs.getInt(1);
	        }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return id;
	}
	/**
	 * 该类用于添加分类
	 * @param fen
	 * @param uid
	 * @return
	 */
	public static int insertFen(String fen,int uid) {
		Connection conn = DbConnection.getConnection();
		String sql = "insert into t_totalclass values(null,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try{
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fen);
			ps.setInt(2, uid);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
	            id = rs.getInt(1);
	        }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return id;
		
	}
	/**
	 *  插入中间表
	 * @param mid
	 * @param cid
	 */
	public static void insertMiddle(int mid,int cid) {
		Connection conn = DbConnection.getConnection();
		String sql = "insert into t_middle values(null,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			ps.setInt(2, cid);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
	}
	/**
	 * 验证分类是否存在以及是否为空
	 * @param 分类
	 * @return 返回一个flag
	 */
	
	public static void insertFenDemo(String fen,int mid,int uid) {
		int fid = Select.findIsFen(fen,uid);
		//如果分类为空，就直接返回
		if(fen.equals("")||fen == null) {
			return ;
		}else if(fid != -1){
			//fid为查询后的id，如果不为-1，说明表中含有分类。直接插入中间表
			Insert.insertMiddle(mid,fid);
		} else{
			//如果分类表中没有，那么就直接输出当前分类不存在。
			System.out.println("分类不存在");
			return ;
		}
	}
	
}
