package com.blog.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.db.DbConnection;
import com.blog.db.DbRelease;
import com.blog.enity.Clazz;
import com.blog.enity.Message;
import com.blog.enity.User;
/**
 * @description 该类是用于执行所有查询操作
 * @author Zesystem
 * @date 2019-8-15
 */
public class Select {
	/**
	 * 根据用户名查询密码,验证登陆
	 * @param username 用户名
	 * @return
	 */
	public static User loginUser(String username){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_user where username=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String pwd = rs.getString("password");
				String ph = rs.getString("phone");
				String em = rs.getString("email");
				String si = rs.getString("signature");
				String name = rs.getString("name");
				String github = rs.getString("github");
				String logoSrc = rs.getString("logoSrc");
				user = new User(id,username,pwd,ph,em,si,name,github,logoSrc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return user;
	}
	/**
	 * 根据uid查询用户。
	 * @param uid 用户的id
	 * @return 返回User
	 */
	public static User SelectUserByUid(String uid){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_user where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,uid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String pwd = rs.getString("password");
				String ph = rs.getString("phone");
				String em = rs.getString("email");
				String si = rs.getString("signature");
				String name = rs.getString("name");
				String github = rs.getString("github");
				String logoSrc = rs.getString("logoSrc");
				user = new User(id,username,pwd,ph,em,si,name,github,logoSrc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return user;
	}
	/**
	 * 查询博客信息
	 * @return
	 */
	public static List<Message> selectMessages(int uid,int pageIndex){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_message where uid=? limit "+(pageIndex - 1)*10+",10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String desc = rs.getString("descrip");
				
				java.sql.Date time = rs.getDate("time");
				list.add(new Message(id,title,content,desc,uid,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return list;
	}
	/**
	 * 查询对应的详情页面
	 * @param uid
	 * @param mid
	 * @return
	 */
	public static Message selectMessagesByUidAndMid(String uid,String mid){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_message where uid=? and id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, mid);
			rs = ps.executeQuery();
			if(rs.next()){
				String title = rs.getString("title");
				String content = rs.getString("content");
				String desc = rs.getString("descrip");
				java.sql.Date time = rs.getDate("time");
				return new Message(Integer.parseInt(mid),title,content,desc,Integer.parseInt(uid),time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return null;
	}
	/**
	 * @return 返回数据库中数据的总条数
	 */
	public static int countMessageAll(int id) {
		Connection conn = DbConnection.getConnection();
		String sql = "select count(*) from t_message where uid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * @return 返回数据库中数据的总条数
	 */
	public static int countMessageAll() {
		Connection conn = DbConnection.getConnection();
		String sql = "select count(*) from t_message";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 用于查询分类是显示出对应的分类页面的信息总数
	 * @param uid 
	 * @param cid
	 * @return
	 */
	public static int countMessageAll(int uid,int cid) {
		Connection conn = DbConnection.getConnection();
		String sql = "SELECT COUNT(*) FROM t_totalclass c,t_middle md,t_message ms WHERE ms.uid=? AND md.cid = c.id AND md.mid=ms.id  AND md.cid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, cid);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 用于显示详情页面
	 * @param mid 对应信息的id
	 * @return 返回对应的信息
	 */
	public static Message findMessage(String mid) {
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_message where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message msg = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String desc = rs.getString("descrip");
				int uid = rs.getInt("uid");
				java.sql.Date time = rs.getDate("time");
				msg = new Message(id,title,content,desc,uid,time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 查询分类表中是否含有要添加的分类
	 * @param fid 分类的id
	 * @return 返回flag
	 */
	public static int findIsFen(int fid) {
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_totalclass where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			while(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 查询分类表中是否含有要添加的分类
	 * @param fen 分类名
	 * @return 返回flag
	 */
	public static int findIsFen(String fen,int uid) {
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_totalclass where clazz=? and uid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fen);
			ps.setInt(2, uid);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 查询所有的分类
	 * @return 返回所有分类，渲染首页页面
	 */
	public static List<Clazz> selectClass(int uid){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_totalclass where uid=?  limit 0,20";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Clazz> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String clazz = rs.getString("clazz");
				list.add(new Clazz(id,clazz,uid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return list;
	}
	public static Clazz selectLinClass(int uid,int cid){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_totalclass where uid=? and id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, cid);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String clazz = rs.getString("clazz");
				return new Clazz(id,clazz,uid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return null;
	}
	/**
	 * 查询对应信息的分类列表
	 * @param mid 对应博客的信息id
	 * @return 返回所有的分类列表
	 */
	public static List<Clazz> selectMessageClass(String mid){
		Connection conn = DbConnection.getConnection();
		String sql = "SELECT c.* FROM t_totalclass c,t_middle md,t_message ms WHERE md.cid = c.id AND md.mid=ms.id  AND md.mid =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Clazz> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,mid);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String clazz = rs.getString("clazz");
				int uid = rs.getInt("uid");
				list.add(new Clazz(id,clazz,uid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return list;
	}
	/**
	 * 查询某个类下面的所有信息列表
	 * @param cid 分类的id
	 * @param uid 用户的id
	 * @return 返回对应信息列表
	 */
	public static List<Message> selectClassMessage(String cid,int uid,int pageIndex) {
		Connection conn = DbConnection.getConnection();
		String sql = "SELECT ms.* FROM t_totalclass c,t_middle md,t_message ms WHERE ms.uid=? AND md.cid = c.id AND md.mid=ms.id  AND md.cid = ?  order by time desc limit "+(pageIndex - 1)*10+",10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,uid);
			ps.setString(2,cid);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String desc = rs.getString("descrip");
				java.sql.Date time = rs.getDate("time");
				list.add(new Message(id,title,content,desc,uid,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return list;
	}
	/**
	 * 查询中间表信息
	 * @param cid 类的id
	 * @param uid 用户id
	 * @return 如果为1就是含有，为0就是没有
	 */
	public static int selectAllMiddleByCid(String cid) {
		Connection conn = DbConnection.getConnection();
		String sql = "SELECT * from t_middle where cid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,cid);
			rs = ps.executeQuery();
			if(rs.next())
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return 0;
	}
	/**
	 * 查询出所有的信息
	 * @return
	 */
	public static List<Message> selectAllMessages(int pageIndex){
		Connection conn = DbConnection.getConnection();
		String sql = "select * from t_message  order by time desc limit "+(pageIndex - 1)*10+",10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String desc = rs.getString("descrip");
				int uid = rs.getInt("uid");
				java.sql.Date time = rs.getDate("time");
				list.add(new Message(id,title,content,desc,uid,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return list;
	}
	/**
	 * 添加信息的作者名字
	 * @param uid
	 * @return
	 */
	public static String addMessageName(int uid){
		Connection conn = DbConnection.getConnection();
		String sql = "select name from t_user where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("name");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbRelease.release(conn, rs, ps);
		}
		return "";
	}
}
